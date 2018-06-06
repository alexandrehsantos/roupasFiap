package br.com.fiap.roupas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roupas.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
