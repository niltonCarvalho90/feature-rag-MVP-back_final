package br.com.implant_rag_back.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.implant_rag_back.domain.Estabelecimento;
import br.com.implant_rag_back.domain.Filial;
import br.com.implant_rag_back.domain.Operadora;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EstabelecimentoDTO {

	private Operadora operadora;
	private Filial filial;
	private int codFilialOperadora;

	public EstabelecimentoDTO(Estabelecimento estabelecimento) {

		this.operadora = estabelecimento.getOperadora();
		this.filial = estabelecimento.getFilial();
		this.codFilialOperadora = estabelecimento.getCodFilialOperadora();
	}

	public EstabelecimentoDTO() {
	}

	public Estabelecimento TransformarOperadoraFilialEmEstabelecimento() {
		return new Estabelecimento(operadora, filial, codFilialOperadora);
	}

	public Estabelecimento TransformarOperadoraEmEstabelecimento() {
		return new Estabelecimento(operadora, codFilialOperadora);
	}

	public Estabelecimento TransformarEmEstabelecimento() {
		return new Estabelecimento(codFilialOperadora);
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

	public int getCodFilialOperadora() {
		return codFilialOperadora;
	}

	public void setCodFilialOperadora(int codFilialOperadora) {
		this.codFilialOperadora = codFilialOperadora;
	}

}
