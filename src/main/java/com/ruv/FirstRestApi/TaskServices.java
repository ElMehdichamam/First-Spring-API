
package com.ruv.FirstRestApi;
import java.util.List;

public class TaskServices {
    private final TaskRepository repo ;
    TaskServices(TaskRepository repo){
        this.repo = repo;
    }
    public List<Task> getAllTasks(){
        return repo.findAll();
    }
    public Task getTaskById(Long id){
        return repo.findById(id).orElseThrow();
    }

    public Task createTask(Task task){
        return repo.save(task);
    }
    public Task updateTask(Long id , Task updatedTask){
        Task exsitingTask = repo.findById(id).orElseThrow();
        exsitingTask.setTitle(updatedTask.getTitle());
        exsitingTask.setStatus(updatedTask.getStatus());
        exsitingTask.setDueDate(updatedTask.getDueDate());
        return  repo.save(exsitingTask);
    }
    public void deleteTask(Long id){
        repo.deleteById(id);
    }
}
