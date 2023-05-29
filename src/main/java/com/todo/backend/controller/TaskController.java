package com.todo.backend.controller;

import com.todo.backend.entity.Task;
import com.todo.backend.service.taskService.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/task")
@CrossOrigin()
public class TaskController {

    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("/getAllTasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> task = taskService.findAllTasks();
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("/createTask")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        Task newTask = taskService.addTask(task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping("/updateTask/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        Task updateTask = taskService.updateTask(task);
        return new ResponseEntity<>(updateTask, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") String id){
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
