package br.com.fiap.roupas.roupasfiap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.roupas.roupasfiap.filter.PedidoFilter;
import br.com.fiap.roupas.roupasfiap.model.Pedido;
import br.com.fiap.roupas.roupasfiap.repository.PedidoRepository;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> gerarPedido(@RequestBody PedidoFilter pedidoFilter) {
		Pedido pedido = new Pedido();
		return new ResponseEntity<>(pedidoRepository.save(pedido), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Pedido>> getPedido() {
		List<Pedido> findAll = pedidoRepository.findAll();
		return new ResponseEntity<>(findAll, HttpStatus.OK);
	}

}
