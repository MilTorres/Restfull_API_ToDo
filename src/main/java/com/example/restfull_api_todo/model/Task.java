package com.example.restfull_api_todo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tareas")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;
    @Column
    private String descripcion;


}
