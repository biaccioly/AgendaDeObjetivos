package br.com.lipstick.AgendaDeObjetivos.Controller;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.lipstick.AgendaDeObjetivos.model.Objetivo;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long Id;

	@JsonProperty
	private String nome;
	
	@JsonProperty
	private Integer idade;
	
	@OneToMany(mappedBy = "usuario")
	private List<Objetivo> objetivos;
	
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
