package br.com.implant_rag_back.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	private Integer codigo;

    @Column(name="nomeempresa")
    private String nomeEmpresa;

    private Boolean status;
   

    public Cliente() {

    }

    public Cliente(String nomeEmpresa, Boolean status, int codigo) {
        super();
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

}
