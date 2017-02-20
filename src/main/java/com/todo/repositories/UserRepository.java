package com.todo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.todo.models.User;

/**
 * Created by masud on 2/20/17.
 */

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

}