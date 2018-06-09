package br.com.fiap.roupas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.roupas.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Query(value = "SELECT p.id FROM Pedido P ORDER BY P.id DESC LIMIT 1", nativeQuery = true)
	public Long getLastId();

}
