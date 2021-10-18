package implant_rag_back.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="filial")
public class Filial {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFilial;	
	
	
	private String razaoSocial;
	
	
	private String cnpj;
	
	private String apelidoLoja;
	
	private int codErp;
	
	@Transient
	private Estabelecimento estabelecimento;
	
	
	@OneToMany
	@JoinColumn(name="idCliente")
	private Cliente cliente = new Cliente();
	
	
	public Filial() {
		
		
		
	}


	public Long getIdFilial() {
		return idFilial;
	}


	public void setIdFilial(Long idFilial) {
		this.idFilial = idFilial;
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
	
	
	
	
	
}
