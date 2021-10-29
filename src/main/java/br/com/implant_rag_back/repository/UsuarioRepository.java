package br.com.implant_rag_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.implant_rag_back.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {

	@Query(value = "select nome from Usuario u where trim(u.nome)")
	List<Usuario> findByusuario(String nome);
	
	@Query(value = "select senha from Usuario u where trim(u.senha)")
	List<Usuario> findBysenha(String senha);
	
}
