package br.com.fiap.roupas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roupas.model.Empresa;
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
