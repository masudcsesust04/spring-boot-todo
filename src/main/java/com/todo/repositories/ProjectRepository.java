package com.todo.repositories;

/**
 * Created by masud on 2/27/17.
 */

import com.todo.models.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
