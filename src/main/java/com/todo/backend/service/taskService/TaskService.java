package com.todo.backend.service.taskService;

import com.todo.backend.entity.Task;

import java.util.List;
import java.util.UUID;


public interface TaskService {

    List<Task> findAllTasks();

    Task addTask(Task task);

    Task updateTask(Task task);

    void deleteTask(String id);

}

