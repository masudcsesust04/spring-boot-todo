package com.todo.controllers;

import com.todo.config.Route;
import com.todo.models.Task;
import com.todo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by masud on 2/17/17.
 */

@Controller
public class TasksController {

    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = Route.TASKS_INDEX, method = RequestMethod.GET)
    public String index(Model model) {

        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);

        return "tasks/index";
    }

    @RequestMapping(value = Route.TASKS_NEW, method = RequestMethod.GET)
    public String newTask(Model model) {

        Task task = new Task();
        task.setStatus("In progress");

        model.addAttribute(task);

        return "tasks/new";
    }

    @RequestMapping(value = Route.TASKS_CREATE, method = RequestMethod.POST)
    public String create(@Valid Task task, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "/tasks/new";
        } else {
            task.setCreatedAt(new Date());
            task.setUpdatedAt(new Date());
            taskRepository.save(task);

            return "redirect:/tasks";
        }
    }

    @RequestMapping(value = Route.TASKS_SHOW, method = RequestMethod.GET)
    public String show(@PathVariable long id, Model model) {

        model.addAttribute("task", taskRepository.findOne(id));

        return "tasks/show";
    }

    @RequestMapping(value = Route.TASKS_EDIT, method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model) {

        Task task = taskRepository.findOne(id);
        model.addAttribute("task", task);

        return "tasks/edit";
    }

    @RequestMapping(value = Route.TASKS_UPDATE, method = RequestMethod.POST)
    public String update(@Valid Task task, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "tasks/edit";
        } else {

            Task updateTask = taskRepository.findOne(task.getId());
            updateTask.setSummary(task.getSummary());
            updateTask.setDescription(task.getDescription());
            updateTask.setStatus(task.getStatus());
            updateTask.setUpdatedAt(new Date());
            taskRepository.save(updateTask);

            return ("redirect:/tasks");
        }
    }

    @RequestMapping(value = Route.TASKS_DELETE, method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {

        taskRepository.delete(id);

        return new ModelAndView("redirect:/tasks");
    }
}
