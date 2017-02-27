package com.todo.controllers;

import com.todo.config.Route;
import com.todo.models.Project;
import com.todo.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by masud on 2/27/17.
 */

@Controller
public class ProjectsController {

    @Autowired
    private ProjectRepository projectRepository;

    @RequestMapping(value = Route.PROJECTS_INDEX, method = RequestMethod.GET)
    public String index(Model model) {

        Iterable<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        return "projects/index";
    }

    @RequestMapping(value = Route.PROJECTS_NEW, method = RequestMethod.GET)
    public String newProject(Model model) {

        Project project = new Project();
        project.setIsActive(true);

        model.addAttribute(project);

        return "projects/new";
    }

    @RequestMapping(value = Route.PROJECTS_CREATE, method = RequestMethod.POST)
    public String create(@Valid Project project, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "/projects/new";
        } else {
            project.setCreatedAt(new Date());
            project.setUpdatedAt(new Date());
            projectRepository.save(project);

            return "redirect:/projects";
        }
    }

    @RequestMapping(value = Route.PROJECTS_SHOW, method = RequestMethod.GET)
    public String show(@PathVariable long id, Model model) {

        model.addAttribute("project", projectRepository.findOne(id));

        return "projects/show";
    }

    @RequestMapping(value = Route.PROJECTS_EDIT, method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model) {

        Project project = projectRepository.findOne(id);
        model.addAttribute("project", project);

        return "projects/edit";
    }

    @RequestMapping(value = Route.PROJECTS_UPDATE, method = RequestMethod.POST)
    public String update(@Valid Project project, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "projects/edit";
        } else {

            Project updateProject = projectRepository.findOne(project.getId());
            updateProject.setName(project.getName());
            updateProject.setDescription(project.getDescription());
            updateProject.setUrl(project.getUrl());
            updateProject.setIsActive(project.getIsActive());
            updateProject.setUpdatedAt(new Date());
            projectRepository.save(updateProject);

            return ("redirect:/projects");
        }
    }

    @RequestMapping(value = Route.PROJECTS_DELETE, method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {

        projectRepository.delete(id);

        return new ModelAndView("redirect:/projects");
    }
}
