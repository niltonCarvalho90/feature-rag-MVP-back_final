package br.com.implant_rag_back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.implant_rag_back.domain.Usuario;
import br.com.implant_rag_back.dto.UsuarioDTO;
import br.com.implant_rag_back.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final ClienteService clienteService;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, ClienteService clienteService) {
		this.usuarioRepository = usuarioRepository;
		 this.clienteService = clienteService;
	}

	public List<Usuario> listar() {

		return usuarioRepository.findAll();
	}

	public String retornaEmail(String email) {
		List<Usuario> usuariosEmail = this.usuarioRepository.findByEmail(email);
		String emailUsuario = null;
		for(Usuario x: usuariosEmail) {
			emailUsuario = x.getEmail();
		}
		return emailUsuario;
	}
	public String retornaSenha(String senha) {
		List<Usuario> usuariosSenha = this.usuarioRepository.findBySenha(senha);
		String senhaUsuario = null;
		for(Usuario x: usuariosSenha) {
			senhaUsuario = x.getSenha();
		}
		return senhaUsuario;
	}
	
	public Boolean validaLogin(UsuarioDTO usuario, String email, String senha) {
		String emailRecebido = retornaEmail(email);
		String senhaRecebida = retornaSenha(senha);
		
		String emailDigitado = usuario.getEmail();
		String senhaDigitada = usuario.getSenha();
		 
		Boolean validador = false;
		
		if(emailRecebido == null||senhaRecebida == null) {
			validador = false;
		}else if (emailRecebido.equals(emailDigitado) && senhaRecebida.equals(senhaDigitada)){
			validador = true;
		}
		return validador;
	}
	
	public Usuario buscarPorCodigo(Long id) {

        Optional<Usuario> busca = usuarioRepository.findById(id);

        return busca.get();
}
    public String buscarUsuarioEmail (String email) {

           List<Usuario> lista = usuarioRepository.findByEmail(email);
        
           String usuarioEmail = null;
           
           for(Usuario x: lista ) {
               usuarioEmail = x.getEmail();
           }
        
           return usuarioEmail;
       }

    public Usuario salvar(Usuario usuario) {
    	return usuarioRepository.save(usuario);
    }
    
    public int validarUsuario(UsuarioDTO usuario, int codigo, String email) {

        int codClienteBusca = clienteService.buscarClienteCodString(codigo);
        int codCliente = usuario.getCliente().getCodigo();
        
        
        String emailUsuarioBusca = buscarUsuarioEmail(email);
        String emailCliente = usuario.getEmail();
        
        
        if(codClienteBusca == codCliente && emailUsuarioBusca == null ) {
        	
            System.out.println("INSERIDO");
            usuarioRepository.save(usuario.transformaParaObjeto());
            return 0;

        }else if(codClienteBusca != codCliente){
        	
            System.out.println("NÃO EXISTE ESSE CLIENTE");
            return 1;

        }else if(emailUsuarioBusca.equals(emailCliente)) {
        	
            System.out.println("EMAIL INVÁLIDO");
        	return 2;
        }
        
            return 4;
    }


}
