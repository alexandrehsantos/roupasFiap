package br.com.fiap.roupas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
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
	@ManyToOne(cascade = CascadeType.ALL)
	private Empresa empresa;
	@ElementCollection
	@CollectionTable(name = "PEDIDO_PRODUTO_LIST", joinColumns = @JoinColumn(name = "ID"), foreignKey = @ForeignKey (name = "fk_item_id")
			)
	@Column(name = "quantidade")
	@MapKeyJoinColumn(name = "Item", referencedColumnName = "ID")
	private Map<Item, Double> produtoList;
	private BigDecimal valorTotal;
	@Temporal(TemporalType.DATE)
	private Date dataPedido;
	@ManyToOne(cascade = CascadeType.ALL)
	private Cliente cliente;
	/*contatdo de ordem de operações*/
	private Long coo;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa
	 *            the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the produtoList
	 */
	public Map<Item, Double> getProdutoList() {
		return produtoList;
	}

	/**
	 * @param produtoList
	 *            the produtoList to set
	 */
	public void setProdutoList(Map<Item, Double> produtoList) {
		this.produtoList = produtoList;
	}

	/**
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal
	 *            the valorTotal to set
	 */
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return the dataPedido
	 */
	public Date getDataPedido() {
		return dataPedido;
	}

	/**
	 * @param dataPedido
	 *            the dataPedido to set
	 */
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the cco
	 */
	public Long getCoo() {
		return coo;
	}

	/**
	 * @param cco
	 *            the cco to set
	 */
	public void setCoo(Long cco) {
		this.coo = cco;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Pedido))
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", empresa=" + empresa + ", produtoList=" + produtoList + ", valorTotal="
				+ valorTotal + ", dataPedido=" + dataPedido + ", cliente=" + cliente + ", cco=" + coo + "]";
	}

}
