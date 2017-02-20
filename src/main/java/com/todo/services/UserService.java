package com.todo.services;

import com.todo.models.User;

/**
 * Created by masud on 2/20/17.
 */

public interface UserService {

    public User findByEmail(String email);

}
