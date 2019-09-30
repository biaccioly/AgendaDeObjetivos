package br.com.lipstick.AgendaDeObjetivos.controller;

import br.com.lipstick.AgendaDeObjetivos.model.Objetivo;
import br.com.lipstick.AgendaDeObjetivos.model.TodosObjetivos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ObjetivosController {

    TodosObjetivos todosObjetivos;

    @Autowired
    public ObjetivosController(TodosObjetivos todosObjetivos) {
        this.todosObjetivos = todosObjetivos;
    }

    @PostMapping("/objetivos")
    public ResponseEntity<String> Objetivos(@RequestBody Objetivo objetivo){
        System.out.println(objetivo.toString());
        todosObjetivos.save(objetivo);
        return ResponseEntity.status(HttpStatus.OK).body("Sucesso");
    }

    @GetMapping("/objetivos/data/{dataMaximaParaExecucao}")
    public ResponseEntity<List<Objetivo>> obterPorData(@PathVariable("dataMaximaParaExecucao") String dataMaximaParaExecucao){
        LocalDate date = LocalDate.parse(dataMaximaParaExecucao);

        if (todosObjetivos.ate(date).isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(todosObjetivos.ate(date));
        }
    }
}
