package br.com.fiap.roupas.filter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class PedidoFilter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8506397010883513665L;
	private EmpresaFilter empresa;
	private List<ItemFilter> itemList;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPedido;
	private ClienteFilter cliente;
	private Long coo;

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
	 * @return the cliente
	 */
	public ClienteFilter getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(ClienteFilter cliente) {
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

}
