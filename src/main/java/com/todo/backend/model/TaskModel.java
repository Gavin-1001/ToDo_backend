package com.todo.backend.model;

import lombok.Data;

import java.util.Date;

@Data
public class TaskModel {

    private Long id;
    private String text;
    private String date;
    private boolean reminder;
    private Date date_created;

}
