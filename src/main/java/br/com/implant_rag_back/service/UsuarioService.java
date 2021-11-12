package br.com.implant_rag_back.service;

import java.util.List;
import java.util.Optional;

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

    public Usuario buscarPorCodigo(Long id) {

        Optional<Usuario> busca = usuarioRepository.findById(id);

        return busca.get();

    }

}