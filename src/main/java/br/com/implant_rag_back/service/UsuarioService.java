package br.com.implant_rag_back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.implant_rag_back.domain.Usuario;
import br.com.implant_rag_back.repository.UsuarioRepository;

@Service
public class UsuarioService {

	 private final UsuarioRepository usuarioRepository;

	    @Autowired
	    public UsuarioService(UsuarioRepository usuarioRepository) {
	        this.usuarioRepository = usuarioRepository;
	    }

	    public Usuario salvar(Usuario usuario) {
	        return usuarioRepository.save(usuario);
	    }
	    
	    public List<Usuario> validarUsuario(@PathVariable String nome) {
	        return usuarioRepository.usuario(nome);
	    }
	    
	    public List<Usuario> validarSenha(@PathVariable String senha) {
	        return usuarioRepository.senha(senha);
	    }
}
