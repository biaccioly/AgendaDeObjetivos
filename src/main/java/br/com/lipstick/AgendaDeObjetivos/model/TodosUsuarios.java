package br.com.lipstick.AgendaDeObjetivos.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, Long> {

    @Query("select from Usuario where .credenciais = :credenciais")
    Usuario existe(@Param("credenciais") Credenciais credenciais);
    
    @Query("select from Usuariol where .nome = :nome")
	public List<Usuario> porNome(@Param("nome") String nome);

	}