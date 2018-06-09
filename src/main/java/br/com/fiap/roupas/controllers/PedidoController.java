package br.com.fiap.roupas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.roupas.filter.PedidoFilter;
import br.com.fiap.roupas.model.Pedido;
import br.com.fiap.roupas.observer.PedidoObserverCouponGenerator;
import br.com.fiap.roupas.observer.PedidoObserverQueueSender;
import br.com.fiap.roupas.observer.PedidoObserverRecorder;
import br.com.fiap.roupas.service.PedidoService;
import br.com.fiap.roupas.util.PedidoBuilder;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoBuilder pedidoBuilder;
	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private PedidoObserverRecorder pedidoObserverRecorder;
	@Autowired
	private PedidoObserverCouponGenerator pedidoObserverCouponGenerator;
	@Autowired
	private PedidoObserverQueueSender pedidoObserverQueueSender;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> gerarPedido(@RequestBody PedidoFilter pedidoFilter) {

		pedidoBuilder.adicionaAcaoPedidoObserver(pedidoObserverRecorder);
		pedidoBuilder.adicionaAcaoPedidoObserver(pedidoObserverCouponGenerator);
		pedidoBuilder.adicionaAcaoPedidoObserver(pedidoObserverQueueSender);

		Pedido pedido = pedidoBuilder.buid(pedidoFilter);
		return new ResponseEntity<>(pedido, HttpStatus.OK);
	}

	@GetMapping("/pedido/{id}")
	@ResponseBody
	public Pedido getPedidos(@PathVariable Long id) {
		Pedido pedido = pedidoService.findById(id);
		return pedido;
	}

}
