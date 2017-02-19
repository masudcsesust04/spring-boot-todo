package com.todo.services;

import com.todo.models.Task;
import com.todo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by masud on 2/19/17.
 */

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

}
