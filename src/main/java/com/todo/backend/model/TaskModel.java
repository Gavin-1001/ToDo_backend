package com.todo.backend.model;

import lombok.Data;

@Data
public class TaskModel {

    private Long id;
    private String text;
    private String date;
    private boolean reminder;

}
