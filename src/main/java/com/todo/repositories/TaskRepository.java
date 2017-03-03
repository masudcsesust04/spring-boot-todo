package com.todo.repositories;

import com.todo.models.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by masud on 2/18/17.
 */
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

}
