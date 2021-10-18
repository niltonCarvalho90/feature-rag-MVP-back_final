package implant_rag_back.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	private String nomeEmpresa;
	
	private Boolean statusCliente;
	

public Cliente() {
	
}


public Long getIdCliente() {
	return idCliente;
}
public void setIdCliente(Long idCliente) {
	this.idCliente = idCliente;
}
public String getNomeEmpresa() {
	return nomeEmpresa;
}
public void setNomeEmpresa(String nomeEmpresa) {
	this.nomeEmpresa = nomeEmpresa;
}
public Boolean getStatusCliente() {
	return statusCliente;
}
public void setStatusCliente(Boolean statusCliente) {
	this.statusCliente = statusCliente;
}




	
}
