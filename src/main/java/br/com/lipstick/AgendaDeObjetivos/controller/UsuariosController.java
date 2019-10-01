package br.com.lipstick.AgendaDeObjetivos.Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.jni.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.lipstick.AgendaDeObjetivos.model.TodosUsuarios;

@RestController
public class UsuariosController {
	
	private TodosUsuarios todosUsuarios;
	
	@Autowired
	public UsuariosController(TodosUsuarios todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}
	
	@GetMapping("/usuarios/nome/{nomeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorNome
	(@PathVariable("nomeDoUsuario") String nome){
		List<Usuario> usuarios = todosUsuarios.porNome(nome);
		
		if ( usuarios.isEmpty()) {			
			return ResponseEntity.noContent().build();			
		}
		return ResponseEntity.ok(usuarios);	
	}
	
	@GetMapping("/usuarios/idade/{idade}")
	public ResponseEntity<List<Usuario>> obterPorIdade
	(@PathVariable("idade") Integer idade){
		List<Usuario> usuariosPorIdade = new ArrayList<Usuario>();
		for (Usuario u : usuarios) {
			if (u.getIdade().equals(idade)) {
				usuariosPorIdade.add(u);
			}
		}
		if(usuariosPorIdade.isEmpty()) {
		return ResponseEntity.noContent().build();}
		return ResponseEntity.ok(usuariosPorIdade);
	}
	
	
	private List<Usuario> obterTodosUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Rodrigo", 39));
		usuarios.add(new Usuario("Alice", 19));
		usuarios.add(new Usuario("Marcela", 29));
		return usuarios;
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarOsMinino(
			@RequestBody Usuario usuario) {

		todosUsuarios.save(usuario);
		return ResponseEntity.ok(usuario);
		
	}
}
