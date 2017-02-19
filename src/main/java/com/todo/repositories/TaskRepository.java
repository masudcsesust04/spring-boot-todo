package com.todo.repositories;

import com.todo.models.Task;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by masud on 2/18/17.
 */
public interface TaskRepository extends CrudRepository<Task, Long> {

}
