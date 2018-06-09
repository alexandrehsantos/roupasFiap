package br.com.fiap.roupas.repository;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import br.com.fiap.roupas.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Query("SELECT P.id FROM Pedido P ORDER BY P.id DESC")
	@QueryHints(@QueryHint(name = "JDBC_MAX_ROWS", value = "1"))
	public Long getLastId();

}
