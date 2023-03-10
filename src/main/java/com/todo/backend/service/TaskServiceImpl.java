package com.todo.backend.service;

import com.todo.backend.entity.Task;
import com.todo.backend.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepo taskRepo;

    public TaskServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }



    @Override
    public List<Task> findAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public Task addTask(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepo.deleteTaskById(id);
    }
}
