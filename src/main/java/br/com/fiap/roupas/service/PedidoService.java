package br.com.fiap.roupas.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.roupas.converter.PedidoConverter;
import br.com.fiap.roupas.filter.ItemFilter;
import br.com.fiap.roupas.filter.PedidoFilter;
import br.com.fiap.roupas.model.Item;
import br.com.fiap.roupas.model.Pedido;
import br.com.fiap.roupas.repository.ItemRepository;
import br.com.fiap.roupas.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PedidoConverter pedidoConverter;

	@Autowired
	private ItemRepository itemRepository;

	public Pedido save(PedidoFilter pedidoFilter) {
		Map<Long, BigDecimal> totalPorItem = new HashMap<>();
		BigDecimal totalPedido = calcularTotal(pedidoFilter, totalPorItem);

		Pedido pedido = pedidoConverter.filterToEntity(pedidoFilter);
		pedido.setValorTotal(totalPedido);

		return pedidoRepository.save(pedido);
	}

	private BigDecimal calcularTotal(PedidoFilter pedidoFilter, Map<Long, BigDecimal> totalPorItem) {
		for (ItemFilter itemFilter : pedidoFilter.getItemList()) {
			Item item = itemRepository.findOne(itemFilter.getId());
			Double quantidade = itemFilter.getQuantidade();
			BigDecimal valor = item.getValor();
			BigDecimal total = valor.multiply(new BigDecimal(quantidade));
			totalPorItem.put(item.getId(), total);
		}

		BigDecimal totalPedido = totalPorItem.entrySet().stream().map(p -> p.getValue()).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		return totalPedido;
	}

}
