package br.com.implant_rag_back.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.implant_rag_back.domain.Cliente;
import br.com.implant_rag_back.domain.Estabelecimento;
import br.com.implant_rag_back.domain.Filial;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilialDTO {

	private Long id;

	public void setId(Long id) {
		this.id = id;
	}

	private String razaoSocial;

	private String cnpj;

	private String apelidoLoja;

	private Estabelecimento estabelecimento;

	private int codErp;

	private Cliente cliente;

	public FilialDTO() {
	}

	public FilialDTO(Filial filial) {

		this.razaoSocial = filial.getRazaoSocial();
		this.cnpj = filial.getCnpj();
		this.apelidoLoja = filial.getCnpj();
		this.codErp = filial.getCodErp();
		this.cliente = filial.getCliente();
		this.estabelecimento = filial.getEstabelecimento();

	}

	public Filial transformarTodosEmFilial() {
		return new Filial(razaoSocial, cnpj, apelidoLoja, codErp, cliente);
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	@Override
	public String toString() {
		return "FilialDto [razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", apelidoLoja=" + apelidoLoja + ", codErp="
				+ codErp + "]";
	}

	public String getApelidoLoja() {
		return apelidoLoja;
	}

	public void setApelidoLoja(String apelidoLoja) {
		this.apelidoLoja = apelidoLoja;
	}

	public int getCodErp() {
		return codErp;
	}

	public void setCodErp(int codErp) {
		this.codErp = codErp;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

}
