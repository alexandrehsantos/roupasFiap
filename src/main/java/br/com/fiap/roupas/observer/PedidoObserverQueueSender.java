package br.com.fiap.roupas.observer;

import java.io.IOException;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.roupas.model.Pedido;
import br.com.fiap.roupas.queue.Produce;

@Service
public class PedidoObserverQueueSender implements PedidoObserver {

	@Autowired
	private Produce produce;

	@Override
	public void executa(Pedido pedido) {
		try {
			produce.produceMessage(pedido);
		} catch (JMSException | IOException e) {
			e.printStackTrace();
		}
	}

}
