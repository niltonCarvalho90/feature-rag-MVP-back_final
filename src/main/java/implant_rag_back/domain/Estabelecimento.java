package implant_rag_back.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Estabelecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstabelecimento;
	
	
	@OneToMany
	@JoinColumn(name="idOperadora")
	private Operadora idOperadora = new Operadora();
	
	
	@OneToMany
	@JoinColumn(name="idFilial")
	private Filial idFilial = new Filial();
	
	
	private String codFilialOperadora;


	public Long getIdEstabelecimento() {
		return idEstabelecimento;
	}


	public void setIdEstabelecimento(Long idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}


	public Operadora getIdOperadora() {
		return idOperadora;
	}


	public void setIdOperadora(Operadora idOperadora) {
		this.idOperadora = idOperadora;
	}


	public Filial getIdFilial() {
		return idFilial;
	}


	public void setIdFilial(Filial idFilial) {
		this.idFilial = idFilial;
	}


	public String getCodFilialOperadora() {
		return codFilialOperadora;
	}


	public void setCodFilialOperadora(String codFilialOperadora) {
		this.codFilialOperadora = codFilialOperadora;
	}
	
	
	
}
