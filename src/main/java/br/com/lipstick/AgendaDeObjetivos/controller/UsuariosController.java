package br.com.lipstick.AgendaDeObjetivos.controller;

import br.com.lipstick.AgendaDeObjetivos.model.TodosUsuarios;
import br.com.lipstick.AgendaDeObjetivos.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UsuariosController{

    List<Usuario> usuarios = new ArrayList<>();
    TodosUsuarios todosUsuarios;

    @Autowired
    public UsuariosController(TodosUsuarios todosUsuarios) {
        this.todosUsuarios = todosUsuarios;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuario usuario){
        todosUsuarios.save(usuario);
        return ResponseEntity.ok().body("Cadastrado com sucesso");
    }

    @GetMapping("/usuarios/idade/{idadeDoUsuario}")
    public ResponseEntity<List<Usuario>> obterPorIdade(@PathVariable("idadeDoUsuario") Integer idade){
        List<Usuario> usuariosIdade = new ArrayList<Usuario>();

        for (Usuario u : usuarios) {
        }
        if (usuariosIdade.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuariosIdade);
    }
}
