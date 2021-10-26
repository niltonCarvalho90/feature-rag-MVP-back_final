package br.com.implant_rag_back.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="estabelecimento")
public class Estabelecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idOperadora")
	private Operadora operadora;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idFilial")
	private Filial filial;
	
	
	private String codFilialOperadora;
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public String getCodFilialOperadora() {
		return codFilialOperadora;
	}

	public void setCodFilialOperadora(String codFilialOperadora) {
		this.codFilialOperadora = codFilialOperadora;
	}
	

	
	
}
