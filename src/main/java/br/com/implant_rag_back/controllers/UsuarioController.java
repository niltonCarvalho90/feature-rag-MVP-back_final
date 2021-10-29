package br.com.implant_rag_back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.implant_rag_back.domain.Usuario;
import br.com.implant_rag_back.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	private final UsuarioService usuarioService;

	@Autowired
	private UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping(value = "/validarnome")
	@ResponseBody 
	public ResponseEntity<String> usuarioLogin(@RequestParam(name = "nome")String nome) {

		 usuarioService.validarUsuario(nome.trim());
		return new ResponseEntity<String>( HttpStatus.OK);
	}
	
	@GetMapping(value = "/validarsenha")
	public ResponseEntity<List<Usuario>> senhaLogin(String senha) {

		List<Usuario> senhaLog = usuarioService.validarSenha(senha.trim());
		return new ResponseEntity<List<Usuario>>(senhaLog, HttpStatus.OK);
	}

}
