package br.com.bandtec.AgendaDeObjetivos.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.lipstick.AgendaDeObjetivos.model.TodosUsuarios;

@RestController
public class LoginController {

	@PostMapping("/login")
	public ResponseEntity<String> validarLogin(
			@RequestBody Credenciais credenciais) {
		
		if(TodosUsuarios.usuarioIdExiste(credenciais == null) {
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body("Erro");
		}
		return ResponseEntity.ok("sucesso");
//		if(credenciais.getSenha().equals(credenciais.getLogin())){
//			return ResponseEntity.ok("sucesso");
//			}
//		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro");
	}
}
