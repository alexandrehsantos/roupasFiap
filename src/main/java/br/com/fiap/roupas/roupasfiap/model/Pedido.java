package br.com.fiap.roupas.roupasfiap.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7437929930523010884L;

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Empresa empresa;
	@ElementCollection
	@CollectionTable(name = "PEDIDO_PRODUTO_LIST")
	@MapKeyColumn(name = "quantidade")
	@Column(name = "quantidade")
	private Map<Item, Double> produtoList;
	private BigDecimal valorTotal;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPedido;
	@ManyToOne
	private Cliente cliente;
	private Long cco;
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + getId() + ", empresa=" + empresa + ", produtoList=" + produtoList + ", valorTotal="
				+ valorTotal + ", dataPedido=" + dataPedido + ", cliente=" + cliente + "]";
	}

	public Long getCco() {
		return cco;
	}

	public void setCco(Long cco) {
		this.cco = cco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<Item, Double> getProdutoList() {
		return produtoList;
	}

	public void setProdutoList(Map<Item, Double> produtoList) {
		this.produtoList = produtoList;
	}

}
