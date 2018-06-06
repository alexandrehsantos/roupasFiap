package br.com.fiap.roupas.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.fiap.roupas.filter.ClienteFilter;
import br.com.fiap.roupas.model.Cliente;
@Service
public class ClienteConverter {

	public Cliente filterToEntity(ClienteFilter clienteFilter) {
		Cliente cliente = new Cliente();
		BeanUtils.copyProperties(clienteFilter, cliente);
		return cliente;
	}

}
