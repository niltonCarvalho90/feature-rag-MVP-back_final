package br.com.implant_rag_back.dto;

import br.com.implant_rag_back.domain.Operadora;

public class OperadoraDTO {
	
	public OperadoraDTO() {
	}
	
	private String nome;
	private String termo;

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
		return new Operadora();
	}

}
