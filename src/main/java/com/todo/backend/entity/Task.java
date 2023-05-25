package com.todo.backend.entity;

import javax.persistence.*;
import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import java.io.Serializable;

import java.sql.Types;
import java.util.Date;
import java.util.UUID;

import static java.sql.Types.*;

@Entity
@Data
@Table(name="task")
public class Task implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    @Id
    @GeneratedValue
    private UUID id;


    @Column(name="title")
    private String title;

    @Column(name="text")
    private String text;

    @Column(name="date_completed")
    private String date;

    @Column(name="reminder")
    private boolean reminder;

    @CreationTimestamp
    @Column(name="date_created")
    private Date dateCreated;
}
