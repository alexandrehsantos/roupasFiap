package br.com.fiap.roupas.roupasfiap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Empresa {

	@Id
	@GeneratedValue
	private Long id; 
	private String incricaoEstadual; 
	private String inscricaoMunicipal;
	private String cpnj;
	private String nome; 
	private String endereco; 
	
	
	public Empresa() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIncricaoEstadual() {
		return incricaoEstadual;
	}


	public void setIncricaoEstadual(String incricaoEstadual) {
		this.incricaoEstadual = incricaoEstadual;
	}


	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}


	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getCpnj() {
		return cpnj;
	}


	public void setCpnj(String cpnj) {
		this.cpnj = cpnj;
	}

}
