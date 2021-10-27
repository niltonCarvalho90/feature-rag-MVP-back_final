package br.com.implant_rag_back.dto;

import br.com.implant_rag_back.domain.Cliente;
import br.com.implant_rag_back.domain.Usuario;

public class UsuarioDTO {

	private String nome;
    private String email;
    private String telefone;
    private String senha;
    private Boolean status;
    private Cliente cliente;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario transformaParaObjeto(){
        return new Usuario(this.nome, this.email, this.telefone, this.senha, this.status, this.cliente);
    }
}
