package br.com.fiap.roupas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.roupas.filter.PedidoFilter;
import br.com.fiap.roupas.model.Pedido;
import br.com.fiap.roupas.repository.PedidoRepository;
import br.com.fiap.roupas.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private PedidoRepository pedidoRepository;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> gerarPedido(@RequestBody PedidoFilter pedido) {
		return new ResponseEntity<>(pedidoService.save(pedido), HttpStatus.OK);
	}

	// @GetMapping
	// public ResponseEntity<List<Pedido>> getPedido() {
	// List<Pedido> findAll = pedidoRepository.findAll();
	// return new ResponseEntity<>(findAll, HttpStatus.OK);
	// }

}
