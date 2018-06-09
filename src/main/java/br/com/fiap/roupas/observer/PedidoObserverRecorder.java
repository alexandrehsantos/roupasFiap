package br.com.fiap.roupas.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.roupas.model.Pedido;
import br.com.fiap.roupas.service.PedidoService;

@Service
public class PedidoObserverRecorder implements PedidoObserver {

	@Autowired
	private PedidoService pedidoService;

	@Override
	public void executa(Pedido pedido) {
		pedidoService.save(pedido);
	}

}
