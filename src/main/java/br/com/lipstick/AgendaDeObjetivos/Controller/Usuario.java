package br.com.lipstick.AgendaDeObjetivos.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long Id;

	@JsonProperty
	private String nome;
	
	@JsonProperty
	private Integer idade;
	
	public Usuario(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	} 
	public Usuario() {
		
	}
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", idade=" + idade + "]";
	}
	
	
}
