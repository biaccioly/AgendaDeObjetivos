package br.com.lipstick.AgendaDeObjetivos.controller;

import static org.junit.Assert.assertEquals;

import br.com.lipstick.AgendaDeObjetivos.model.Credenciais;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LoginControllerTest {

	private LoginController controller;

	@Before
	public void setUp(){
		controller = new LoginController();
	}

	@Test
	public void loginComSucesso() {
		ResponseEntity<String> resposta = controller.validarLogin(new Credenciais("igual", "igual"));

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals("Sucesso", resposta.getBody());
	}

	@Test
	public void loginComFalha() {
		Credenciais c = new Credenciais("login", "senha");
		Mockito.when(todosUsuarios.existe(c))
		.thenReturn(null);
		ResponseEntity<String> resposta = 
				controller.validarLogin(c);
				
		ResponseEntity<String> resposta = controller.validarLogin(new Credenciais("login", "senha"));

		assertEquals(HttpStatus.UNAUTHORIZED, resposta.getStatusCode());
		assertEquals("Erro", resposta.getBody());
	}
	
}
