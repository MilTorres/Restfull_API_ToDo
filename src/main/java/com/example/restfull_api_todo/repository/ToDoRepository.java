package com.example.restfull_api_todo.repository;

import com.example.restfull_api_todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface ToDoRepository extends JpaRepository<Task, Long> {
}
