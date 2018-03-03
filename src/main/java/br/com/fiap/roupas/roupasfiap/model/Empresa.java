package br.com.fiap.roupas.roupasfiap.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Empresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -204217697635435448L;
	@Id
	@GeneratedValue
	private Long id; 
	private String incricaoEstadual; 
	private String inscricaoMunicipal;
	private String cpnj;
	private String nome; 
	private String endereco;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the incricaoEstadual
	 */
	public String getIncricaoEstadual() {
		return incricaoEstadual;
	}
	/**
	 * @param incricaoEstadual the incricaoEstadual to set
	 */
	public void setIncricaoEstadual(String incricaoEstadual) {
		this.incricaoEstadual = incricaoEstadual;
	}
	/**
	 * @return the inscricaoMunicipal
	 */
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	/**
	 * @param inscricaoMunicipal the inscricaoMunicipal to set
	 */
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	/**
	 * @return the cpnj
	 */
	public String getCpnj() {
		return cpnj;
	}
	/**
	 * @param cpnj the cpnj to set
	 */
	public void setCpnj(String cpnj) {
		this.cpnj = cpnj;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	} 
	
	

}
