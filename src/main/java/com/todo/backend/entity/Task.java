package com.todo.backend.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
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

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //removes the property from the response, can write only
    private String id;


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
