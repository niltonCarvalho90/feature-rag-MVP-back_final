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

	public String validandoLogin(String email, String senha) {

		List<Usuario> listLog = usuarioRepository.findAll();

		String mensagem = null;
		for (int i = 0; i < listLog.size(); i++) {

			boolean x = listLog.get(i).getEmail().equalsIgnoreCase(email);
			boolean y = listLog.get(i).getSenha().equalsIgnoreCase(senha);
			
			
			if (y == true && x == true) {
				mensagem = "Parabéns, você está cadastrado no Banco";
				
			} else {
				mensagem = "Que pena, você não está cadastrado no Banco";
			}
		}

		return mensagem;
	}

}
