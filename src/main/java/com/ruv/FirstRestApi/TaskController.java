package com.ruv.FirstRestApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController 
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRepository repo;
    TaskController(TaskRepository repo){
        this.repo = repo;
    }

    @GetMapping
    public List<Task> getAll(@RequestParam(required = false) String status) {
        return status == null ? repo.findAll() : repo.findByStatus(status);
    }

    @GetMapping("/{id}")
    public Task getOne(@PathVariable Long id){
        return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody Task task){
        return repo.save(task);
    }


    @PutMapping("/{id}")
    public Task update(@PathVariable Long id , @RequestBody Task updated){
        Task task = getOne(id);
        task.setTitle(updated.getTitle());
        task.setStatus(updated.getStatus());
        task.setDueDate(updated.getDueDate());
        return repo.save(task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        repo.deleteById(id);
    }
}
