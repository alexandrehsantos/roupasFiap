package br.com.fiap.roupas.queue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.roupas.roupasfiap.filter.EmpresaFilter;
import br.com.fiap.roupas.roupasfiap.filter.ItemFilter;
import br.com.fiap.roupas.roupasfiap.filter.PedidoFilter;
import br.com.fiap.roupas.roupasfiap.model.Empresa;
import br.com.fiap.roupas.roupasfiap.model.Item;
import br.com.fiap.roupas.roupasfiap.model.Pedido;
import br.com.fiap.roupas.roupasfiap.repository.EmpresaRepository;
import br.com.fiap.roupas.roupasfiap.repository.ItemRepository;
import br.com.fiap.roupas.roupasfiap.repository.PedidoRepository;

public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	public Pedido save(PedidoFilter pedidoFilter) {

		Pedido pedidoEntity = new Pedido();

		List<Item> itemEntityList = new ArrayList<>();

		EmpresaFilter empresa = pedidoFilter.getEmpresa();

		// Empresa empresaEntity = empresaRepository.findOne(empresa.getId());

//		List<ItemFilter> itemList = pedidoFilter.getItemList();

//		for (ItemFilter itemFilter : itemList) {
//			Item item = itemRepository.findOne(itemFilter.getId());
//			// itemEntityList.add(item);
//		}

		// pedidoEntity.setProdutoList(produtoList);

		return pedidoRepository.save(pedidoEntity);
	}

}
