package com.ruv.FirstRestApi;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskServices service;
    TaskController(TaskServices service){
        this.service = service;
    }

    @GetMapping
    public List<Task> getAll() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getOne(@PathVariable Long id){
        return service.getTaskById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create( @Validated @RequestBody Task task){
        return service.createTask(task);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id , @Validated  @RequestBody Task updated){
        return service.updateTask(id,updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.deleteTask(id);
    }
}
