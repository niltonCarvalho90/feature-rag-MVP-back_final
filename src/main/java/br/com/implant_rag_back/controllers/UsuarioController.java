package br.com.implant_rag_back.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.implant_rag_back.domain.Operadora;
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
    
    @GetMapping(value = "/validarlogin") 
    public ResponseEntity<List<Usuario>> login(String String){ 
    	
    	List<Usuario> usuario = usuarioService.validarUsuario();
        return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
    	
    }
    
 
}
