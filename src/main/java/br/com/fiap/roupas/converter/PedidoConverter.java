package br.com.fiap.roupas.converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.roupas.filter.ItemFilter;
import br.com.fiap.roupas.filter.PedidoFilter;
import br.com.fiap.roupas.model.Cliente;
import br.com.fiap.roupas.model.Item;
import br.com.fiap.roupas.model.Pedido;

@Service
public class PedidoConverter {

	@Autowired
	private ItemConverter itemConverter;

	@Autowired
	private ClienteConverter clienteConverter;

	@Autowired
	private EmpresaConverter empresaConverter;

	public Pedido filterToEntity(PedidoFilter pedidoFilter) {
		Pedido pedido = new Pedido();

		BeanUtils.copyProperties(pedidoFilter, pedido);

		converterItens(pedidoFilter, pedido);

		converterCliente(pedidoFilter, pedido);

		converterEmpresa(pedidoFilter, pedido);

		return pedido;
	}

	private void converterEmpresa(PedidoFilter pedidoFilter, Pedido pedido) {
		pedido.setEmpresa(empresaConverter.filterToEntity(pedidoFilter.getEmpresa()));
	}

	private void converterCliente(PedidoFilter pedidoFilter, Pedido pedido) {
		Cliente cliente = clienteConverter.filterToEntity(pedidoFilter.getCliente());

		pedido.setCliente(cliente);
	}

	private void converterItens(PedidoFilter pedidoFilter, Pedido pedido) {
		List<ItemFilter> itemFilterList = pedidoFilter.getItemList();
		Map<Item, Double> itemList = new HashMap<>();

		for (ItemFilter itemFilter : itemFilterList) {
			Item item = itemConverter.filterToEntity(itemFilter);
			itemList.put(item, itemFilter.getQuantidade());
		}

		pedido.setProdutoList(itemList);
	}

}
