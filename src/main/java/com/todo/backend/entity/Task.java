package com.todo.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Entity
@Data
@Table(name="task")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="text")
    private String text;

    @Column(name="date")
    private String date;

    @Column(name="reminder")
    private boolean reminder;
}
