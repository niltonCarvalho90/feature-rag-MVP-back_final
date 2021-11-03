package br.com.implant_rag_back.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.implant_rag_back.domain.Usuario;
import br.com.implant_rag_back.dto.UsuarioDTO;
import br.com.implant_rag_back.service.UsuarioService;


@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {
    @Autowired
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

      @PostMapping("/salvar") 
        public ResponseEntity<Usuario> salvar(@RequestBody UsuarioDTO userDTO) {
            Usuario usuario1 = usuarioService.salvar(userDTO.transformaParaObjeto());
            return new ResponseEntity<>(usuario1, HttpStatus.CREATED);
        }
      @GetMapping("/listar")
        @ResponseBody
        public ResponseEntity<List<Usuario>> listarTodos() {

            List<Usuario> lista = usuarioService.listar();

            return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);

        }
      @GetMapping("/{id}")
        public Usuario buscar(@PathVariable Long id) {

                  Usuario lista = usuarioService.buscarPorCodigo(id);

                return lista;
    }
      
  //    @GetMapping("/logar")
    //  @


}
