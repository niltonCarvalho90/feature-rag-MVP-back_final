package br.com.implant_rag_back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.implant_rag_back.domain.Usuario;
import br.com.implant_rag_back.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> listar() {

		return usuarioRepository.findAll();
	}

	public Boolean validandoLogin(String email, String senha) {

		List<Usuario> listLog = usuarioRepository.findAll();

		Boolean validarLogin = true;
		for (int i = 0; i < listLog.size(); i++) {

			boolean validaEmail = listLog.get(i).getEmail().equalsIgnoreCase(email);
			boolean validaSenha = listLog.get(i).getSenha().equalsIgnoreCase(senha);   
			
			
			if (validaEmail == true && validaSenha == true) {
				validarLogin = true;
				
			} else {
				validarLogin =  false;
			}
		}

		return validarLogin;
	}

}
