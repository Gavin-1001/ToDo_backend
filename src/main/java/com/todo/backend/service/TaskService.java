package com.todo.backend.service;

import com.todo.backend.entity.Task;

import java.util.List;



public interface TaskService {

    List<Task> findAllTasks();

    Task addTask(Task task);

    Task updateTask(Task task);

    void deleteTask(Long id);

}

