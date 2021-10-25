package br.com.implant_rag_back.dto;

import br.com.implant_rag_back.domain.Operadora;

class OperadoraRespostaDTO {

	private Long id;
	private String nome;
	private String termo;
	
	public OperadoraRespostaDTO(Long id2, String nome2, String termo2) {
		// TODO Auto-generated constructor stub
	}
	public static OperadoraRespostaDTO transformaEmDTO(Operadora operadora) {
        return new OperadoraRespostaDTO(operadora.getId(), operadora.getNome(), operadora.getTermo());
	
	}
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
	
	

}
