package com.todo.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.annotations.JdbcTypeCode;

import org.hibernate.type.SqlTypes;


import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Table(name="task")
public class Task implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;


    @Column(name="title")
    private String title;

    @Column(name="text")
    private String text;

    @Column(name="date")
    private String date;

    @Column(name="reminder")
    private boolean reminder;
}
