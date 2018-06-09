package br.com.fiap.roupas.observer;

import br.com.fiap.roupas.model.Pedido;

public interface PedidoObserver {

	public void executa(Pedido pedido);

}
