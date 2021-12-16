package br.com.implant_rag_back.dto;

import br.com.implant_rag_back.domain.Cliente;

public class ClienteDTO {

	private Integer codigo;
	
    private String nomeEmpresa;

    private Boolean status;
    
   

    public ClienteDTO() {

    }

    public ClienteDTO(Long id, String nomeEmpresa, Boolean status, int codigo) {
        this.nomeEmpresa = nomeEmpresa;
        this.status = status;
        this.codigo = codigo;
    }

   

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public Cliente transformaParaObjetoCliente() {
    		return new Cliente( this.nomeEmpresa, this.status, this.codigo);
    }

}
