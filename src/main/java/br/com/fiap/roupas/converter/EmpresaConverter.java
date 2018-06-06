package br.com.fiap.roupas.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.fiap.roupas.filter.EmpresaFilter;
import br.com.fiap.roupas.model.Empresa;

@Service
public class EmpresaConverter {

	public Empresa filterToEntity(EmpresaFilter empresaFilter) {
		Empresa empresa = new Empresa();
		BeanUtils.copyProperties(empresaFilter, empresa);
		return empresa;
	}

}
