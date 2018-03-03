package br.com.fiap.roupas.roupasfiap.filter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fiap.roupas.roupasfiap.model.Empresa;
import br.com.fiap.roupas.roupasfiap.model.Item;

public class PedidoFilter {

	private Empresa empresa;
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
	public List<Item> getProdutoList() {
		return produtoList;
	}
	public void setProdutoList(List<Item> produtoList) {
		this.produtoList = produtoList;
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
	
	
}
