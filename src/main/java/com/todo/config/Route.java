package com.todo.config;

/**
 * Created by masud on 2/17/17.
 */
public class Route {

    public static final String ROOT = "/";

    public static final String LOGIN = "/login";
    public static final String LOGOUT = "/logout";

    public static final String DASH = "/dash";

    public static final String TASKS_INDEX = "tasks";
    public static final String TASKS_NEW = "tasks/new";
    public static final String TASKS_CREATE = "tasks/create";
    public static final String TASKS_SHOW = "tasks/{id}";
    public static final String TASKS_EDIT = "tasks/{id}/edit";
    public static final String TASKS_UPDATE = "tasks/update";
    public static final String TASKS_DELETE = "tasks/{id}/delete";
}
