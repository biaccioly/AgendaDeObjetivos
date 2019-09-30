package br.com.lipstick.AgendaDeObjetivos.model;

import javax.persistence.Embeddable;

@Embeddable
public class Credenciais {

	private String Login;
	private String Senha;

	public Credenciais(String Login, String Senha) {
		this.Login = Login;
		this.Senha = Senha;
	}

	public String getSenha() {
		return Senha;
	};

	public String getLogin() {
		return Login;
	};

}
