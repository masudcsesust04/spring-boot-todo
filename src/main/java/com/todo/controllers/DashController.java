package com.todo.controllers;

import com.todo.config.Route;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by masud on 2/20/17.
 */

@Controller
public class DashController {

    @RequestMapping(value = Route.DASH, method = RequestMethod.GET)
    public String index(Model model) {

        return "dash/index";
    }
}
