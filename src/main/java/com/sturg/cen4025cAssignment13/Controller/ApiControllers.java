package com.sturg.cen4025cAssignment13.Controller;

import com.sturg.cen4025cAssignment13.Models.Tasks;
import com.sturg.cen4025cAssignment13.Repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private TaskRepo taskRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "Task List Program";
    }

    @GetMapping(value = "/tasks")
    public List<Tasks> getTasks() {
        return taskRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveTask(@RequestBody Tasks tasks) {
        taskRepo.save(tasks);
        return "Saved...";
    }

    @PutMapping(value = "/update/{id}")
    public String updateTask(@PathVariable Integer id, @RequestBody Tasks tasks) {
        Tasks updateTasks = taskRepo.findById(id).get();
        updateTasks.setTask(tasks.getTask());
        taskRepo.save(updateTasks);
        return "Updated...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTask(@PathVariable Integer id) {
        Tasks deleteTasks = taskRepo.findById(id).get();
        taskRepo.delete(deleteTasks);
        return "Delete task with id: " + id;
    }

}
