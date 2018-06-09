package br.com.fiap.roupas.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.roupas.model.Pedido;
import br.com.fiap.roupas.util.GeradorRelatorio;

@Service
public class PedidoObserverCouponGenerator implements PedidoObserver {

	@Autowired
	private GeradorRelatorio geradorRelatorio;

	@Override
	public void executa(Pedido pedido) {
		geradorRelatorio.gerarPdf(pedido);
	}

}
