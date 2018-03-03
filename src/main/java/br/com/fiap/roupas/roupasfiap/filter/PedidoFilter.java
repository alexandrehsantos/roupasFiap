package br.com.fiap.roupas.roupasfiap.filter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fiap.roupas.roupasfiap.model.Cliente;
import br.com.fiap.roupas.roupasfiap.model.Empresa;
import br.com.fiap.roupas.roupasfiap.model.Item;

public class PedidoFilter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8506397010883513665L;
	private EmpresaFilter empresa;
	private List<ItemFilter> itemList;
	private BigDecimal valorTotal;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPedido;
	private Cliente cliente;
	private Long cco;

	public EmpresaFilter getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaFilter empresa) {
		this.empresa = empresa;
	}

	public List<ItemFilter> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemFilter> itemList) {
		this.itemList = itemList;
	}

	/**
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal the valorTotal to set
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
	 * @param dataPedido the dataPedido to set
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
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the cco
	 */
	public Long getCco() {
		return cco;
	}

	/**
	 * @param cco the cco to set
	 */
	public void setCco(Long cco) {
		this.cco = cco;
	}

}
