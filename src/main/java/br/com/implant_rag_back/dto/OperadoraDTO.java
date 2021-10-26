package br.com.implant_rag_back.dto;

import br.com.implant_rag_back.domain.Operadora;

public class OperadoraDTO {
	
	public OperadoraDTO() {
	}
	
	private Long id;
	private String nome;
	private String termo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTermo() {
		return termo;
	}

	public void setTermo(String termo) {
		this.termo = termo;
	}

	public Operadora transformaParaObjeto() {
		return new Operadora( this.id, this.nome, this.termo);
	}

	
}
