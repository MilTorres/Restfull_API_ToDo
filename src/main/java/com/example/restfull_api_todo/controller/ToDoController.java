package com.example.restfull_api_todo.controller;


import com.example.restfull_api_todo.model.Task;
import com.example.restfull_api_todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ToDoController {
    @Autowired
    private ToDoRepository todoRepository;

    @GetMapping(value = "/")
    public String holaMundo() {
        return "HOLA MUNDO!!!";
    }

    @GetMapping(value = "/tasks")
    public List<Task> getTasks() {
        return todoRepository.findAll();
    }

    @PostMapping(value = "/savetasks")
    public String saveTask(@RequestBody Task task) {
        todoRepository.save(task);
        return "save task";
    }

    @PutMapping(value = "/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task){
        Task updateTask = todoRepository.findById(id).get();
        updateTask.setTitulo(task.getTitulo());
        updateTask.setDescripcion(task.getDescripcion());
        todoRepository.save(updateTask);
        return "Se actualizo la tarea correctamente";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTask(@PathVariable long id){
        Task deleteta = todoRepository.findById(id).get();
        todoRepository.delete(deleteta);
        return "Se elimino la tarea correctamente";
    }
}