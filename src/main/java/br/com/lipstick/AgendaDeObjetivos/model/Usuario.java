package br.com.lipstick.AgendaDeObjetivos.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Credenciais credenciais;
    
    @JsonProperty
    private String nome;
    @JsonProperty
    private Integer idade;

    public Usuario(String nome, Integer idade){
        super();
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }
}
