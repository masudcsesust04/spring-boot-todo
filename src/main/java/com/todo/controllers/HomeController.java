package com.todo.controllers;

import com.todo.config.Route;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by masud on 2/19/17.
 */

@Controller
public class HomeController {

    @RequestMapping(value = Route.ROOT, method = RequestMethod.GET)
    public String index(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        model.addAttribute("username", username);

        return "welcome";
    }
}
