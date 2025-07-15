package com.eduardafbz.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eduardafbz.model.Task;
import com.eduardafbz.service.TaskService;

@RestController
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> add(@RequestBody Task tsk) {
        Task taskCriada = taskService.add(tsk);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(taskCriada.getId()).toUri();

        return ResponseEntity.created(uri).body(taskCriada);
    }

    @GetMapping
    public ResponseEntity<List<Task>> read() {
        List<Task> list  = taskService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody String novaDescricao) {
        Task taskAtualizada = taskService.update(id, novaDescricao);
        return ResponseEntity.ok(taskAtualizada);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Task> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

}