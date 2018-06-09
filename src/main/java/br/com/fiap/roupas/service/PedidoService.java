package br.com.fiap.roupas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.roupas.model.Pedido;
import br.com.fiap.roupas.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public Pedido findById(Long id) {

		return pedidoRepository.findOne(id);
	}

}
