package com.todo.backend.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TaskModel {

    private String id;
    private String text;
    private String date;
    private boolean reminder;
    private Date date_created;

}
