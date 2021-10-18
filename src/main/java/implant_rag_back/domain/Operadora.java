package implant_rag_back.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Operadora {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOperadora;	
	
	
	private String nomeOperadora;
	
	private String termoOperadora;
	
	public Operadora() {
		
		
		
	}

	public Long getIdOperadora() {
		return idOperadora;
	}

	public void setIdOperadora(Long idOperadora) {
		this.idOperadora = idOperadora;
	}

	public String getNomeOperadora() {
		return nomeOperadora;
	}

	public void setNomeOperadora(String nomeOperadora) {
		this.nomeOperadora = nomeOperadora;
	}

	public String getTermoOperadora() {
		return termoOperadora;
	}

	public void setTermoOperadora(String termoOperadora) {
		this.termoOperadora = termoOperadora;
	}
	
	
	
	
}
