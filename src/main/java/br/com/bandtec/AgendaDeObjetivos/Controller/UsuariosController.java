package br.com.bandtec.AgendaDeObjetivos.Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.jni.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuariosController {
	
	private List<Usuario> usuarios;
	
	public UsuariosController() {
		this.usuarios = obterTodosUsuarios();
	}
	
	@GetMapping("/usuarios/nome/{nomeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorNome
	(@PathVariable("nomeDoUsuario") String nome){
		List<Usuario> usuariosPorNome = new ArrayList<Usuario>();
		for (Usuario u : usuarios) {
			if (u.getNome().equals(nome)) {
				usuariosPorNome.add(u);
			}
		}
		if(usuariosPorNome.isEmpty()) {
		return ResponseEntity.noContent().build();}
		return ResponseEntity.ok(usuariosPorNome);
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
		this.usuarios.add(usuario);
		return ResponseEntity.ok(usuario);
		
	}
}
