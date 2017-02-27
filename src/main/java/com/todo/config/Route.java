package com.todo.config;

/**
 * Created by masud on 2/17/17.
 */
public class Route {

    public static final String ROOT = "/";

    public static final String LOGIN = "/login";
    public static final String LOGOUT = "/logout";

    public static final String DASH = "/dash";

    public static final String USERS_INDEX = "/users";
    public static final String USERS_NEW = "/users/new";
    public static final String USERS_CREATE = "/users/create";
    public static final String USERS_SHOW = "/users/{id}";
    public static final String USERS_EDIT = "/users/{id}/edit";
    public static final String USERS_UPDATE = "/users/update";
    public static final String USERS_DELETE = "/users/{id}/delete";

    public static final String PROJECTS_INDEX = "projects";
    public static final String PROJECTS_NEW = "projects/new";
    public static final String PROJECTS_CREATE = "projects/create";
    public static final String PROJECTS_SHOW = "projects/{id}";
    public static final String PROJECTS_EDIT = "projects/{id}/edit";
    public static final String PROJECTS_UPDATE = "projects/update";
    public static final String PROJECTS_DELETE = "projects/{id}/delete";

    public static final String TASKS_INDEX = "tasks";
    public static final String TASKS_NEW = "tasks/new";
    public static final String TASKS_CREATE = "tasks/create";
    public static final String TASKS_SHOW = "tasks/{id}";
    public static final String TASKS_EDIT = "tasks/{id}/edit";
    public static final String TASKS_UPDATE = "tasks/update";
    public static final String TASKS_DELETE = "tasks/{id}/delete";
}
