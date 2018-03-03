package br.com.fiap.roupas.roupasfiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roupas.roupasfiap.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
