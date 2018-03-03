package br.com.fiap.roupas.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fiap.roupas.roupasfiap.model.Empresa;
import br.com.fiap.roupas.roupasfiap.model.Item;

@Entity
public class Pedido {

	@Id
	@GeneratedValue
	private Long id; 
	
	private Empresa empresa;
	@OneToMany
	private List<Item> produtoList;
	private BigDecimal valorTotal;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPedido; 
	

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
	public String toString() {
		return "PedidoBuilder [empresa=" + empresa + ", produtoList=" + getProdutoList() + ", valorTotal=" + valorTotal
				+ ", dataPedido=" + dataPedido + "]";
	}

	public List<Item> getProdutoList() {
		return produtoList;
	}

	public void setProdutoList(List<Item> produtoList) {
		this.produtoList = produtoList;
	}


}
