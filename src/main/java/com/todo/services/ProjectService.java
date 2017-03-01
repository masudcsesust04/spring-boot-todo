package com.todo.services;

import com.todo.models.Project;
import com.todo.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by masud on 2/27/17.
 */
@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findOne(long id) {
        return projectRepository.findOne(id);
    }
}
