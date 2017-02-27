package com.todo.controllers;

import com.todo.config.Route;
import com.todo.models.Role;
import com.todo.models.User;
import com.todo.repositories.RoleRepository;
import com.todo.repositories.UserRepository;
import com.todo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by masud on 2/21/17.
 */

@Controller
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = Route.USERS_INDEX, method = RequestMethod.GET)
    public String index(Model model) {

        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        return "users/index";
    }

    @RequestMapping(value = Route.USERS_NEW, method = RequestMethod.GET)
    public String newUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("roles", roleRepository.findAll());
        return "users/new";
    }

    @RequestMapping(value = Route.USERS_CREATE, method = RequestMethod.POST)
    public String create(@Valid User user, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "users/new";
        } else {

            user.setCreatedAt(new Date());
            user.setUpdatedAt(new Date());
            userRepository.save(user);

            return "redirect:/users";
        }
    }

    @RequestMapping(value = Route.USERS_SHOW, method = RequestMethod.GET)
    public String show(Model model, @PathVariable long id) {

        User user = userRepository.findOne(id);
        model.addAttribute("user", user);

        return "users/show";
    }

    @RequestMapping(value = Route.USERS_EDIT, method = RequestMethod.GET)
    public String edit(Model model, @PathVariable long id) {

        User user = userRepository.findOne(id);
        model.addAttribute("user", user);

        return "users/edit";
    }

    @RequestMapping(value = Route.USERS_UPDATE, method = RequestMethod.POST)
    public String update(@Valid User user, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "users/edit";
        } else {

            User usr = userRepository.findOne((long) user.getId());
            user.setCreatedAt(usr.getCreatedAt());
            user.setUpdatedAt(new Date());
            userRepository.save(user);

            return "redirect:/users";
        }
    }

    @RequestMapping(value = Route.USERS_DELETE, method = RequestMethod.GET)
    public String delete(@PathVariable long id) {

        userRepository.delete(id);

        return "redirect:/users";
    }

}
