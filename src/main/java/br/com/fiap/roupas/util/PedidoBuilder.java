package br.com.fiap.roupas.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.roupas.converter.PedidoConverter;
import br.com.fiap.roupas.filter.ItemFilter;
import br.com.fiap.roupas.filter.PedidoFilter;
import br.com.fiap.roupas.model.Item;
import br.com.fiap.roupas.model.Pedido;
import br.com.fiap.roupas.observer.PedidoObserver;
import br.com.fiap.roupas.repository.ItemRepository;
import br.com.fiap.roupas.service.PedidoService;

@Service
public class PedidoBuilder {

	@Autowired
	private PedidoConverter pedidoConverter;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private PedidoService pedidoService;

	private List<PedidoObserver> pedidoObserverList;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	public PedidoBuilder() {
		this.pedidoObserverList = new ArrayList<>();
	}

	public Pedido buid(PedidoFilter pedidoFilter) {
		LOGGER.debug("[START] [DEBUG] buid", pedidoFilter);
		Map<Long, BigDecimal> totalPorItem = new HashMap<>();

		Pedido pedido = pedidoConverter.filterToEntity(pedidoFilter);

		setItemValues(pedido);

		difinirCoo(pedido);

		BigDecimal totalPedido = calcularTotal(pedido, pedidoFilter, totalPorItem);
		pedido.setValorTotal(totalPedido);

		executarObserver(pedido);

		LOGGER.debug("[STOP] [DEBUG] buid");
		return pedido;
	}

	private void difinirCoo(Pedido pedido) {
		if (pedidoService.getLastID() == null) {
			pedido.setCoo(1L);
		} else {
			pedido.setCoo(pedidoService.getLastID() + 1);
		}
	}

	private void executarObserver(Pedido pedido) {
		LOGGER.debug("[START] [DEBUG] executarObserver", pedido);
		for (PedidoObserver acao : pedidoObserverList) {
			LOGGER.debug("[START] [DEBUG] inicio processo: ", acao.getClass().toString());
			acao.executa(pedido);
			LOGGER.debug("[STOP] [DEBUG] fim processo: ", acao.getClass().toString());
		}
		LOGGER.debug("[STOP] [DEBUG] executarObserver");

	}

	public void adicionaAcaoPedidoObserver(PedidoObserver pedidoObserver) {
		LOGGER.debug("[START] [DEBUG] adicionaAcaoPedidoObserver", pedidoObserver);
		pedidoObserverList.add(pedidoObserver);
		LOGGER.debug("[STOP] [DEBUG] adicionaAcaoPedidoObserver");
	}

	private void setItemValues(Pedido pedido) {
		Map<Item, Double> produtoList = pedido.getProdutoList();
		for (Entry<Item, Double> entry : produtoList.entrySet()) {
			Item item = itemRepository.findOne(entry.getKey().getId());
			entry.getKey().setId(item.getId());
			entry.getKey().setDescricao(item.getDescricao());
			entry.getKey().setValor(item.getValor());
		}
	}

	private BigDecimal calcularTotal(Pedido pedido, PedidoFilter pedidoFilter, Map<Long, BigDecimal> totalPorItem) {
		Map<Item, Double> produtoList = pedido.getProdutoList();

		for (ItemFilter itemFilter : pedidoFilter.getItemList()) {
			Double quantidade = itemFilter.getQuantidade();

			for (Entry<Item, Double> item : produtoList.entrySet()) {
				if (item.getKey().getId().equals(itemFilter.getId())) {
					BigDecimal valor = item.getKey().getValor();
					BigDecimal total = valor.multiply(new BigDecimal(quantidade));
					totalPorItem.put(item.getKey().getId(), total);
					break;
				}
			}

		}

		BigDecimal totalPedido = totalPorItem.entrySet().stream().map(p -> p.getValue()).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		return totalPedido;
	}

}
