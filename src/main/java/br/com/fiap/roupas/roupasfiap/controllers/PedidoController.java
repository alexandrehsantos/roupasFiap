package br.com.fiap.roupas.roupasfiap.controllers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.roupas.roupasfiap.filter.PedidoFilter;
import br.com.fiap.roupas.roupasfiap.model.Pedido;
import br.com.fiap.roupas.roupasfiap.repository.PedidoRepository;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	@PostMapping
	public ResponseEntity<PedidoFilter> gerarPedido(@RequestBody PedidoFilter pedidoFilter){
		
		Pedido pedido = new Pedido();
		
		BeanUtils.copyProperties(pedidoFilter, pedido);
		
		pedidoRepository.save(pedido);
		
		return null;
	}
	
	
	
}
