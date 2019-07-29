package com.conferenceManagement.controller;

import com.conferenceManagement.data.Role;
import com.conferenceManagement.data.converter.UserConverter;
import com.conferenceManagement.data.dao.UserDao;
import com.conferenceManagement.data.model.User;
import com.conferenceManagement.servlet.annotation.GetMapping;
import com.conferenceManagement.servlet.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class UserController implements Controller {
    private final UserDao userDao;
    private final UserConverter userConverter;

    public UserController(UserDao userDao, UserConverter userConverter) {
        this.userDao = userDao;
        this.userConverter = userConverter;
    }

    @GetMapping("/users")
    public String showList(HttpServletRequest request) {
        request.setAttribute("dataList", userDao.getAll());
        return "/users/userList.jsp";
    }

    @GetMapping("/users/add")
    public String showAdd(HttpServletRequest request) {
        request.setAttribute("user", new User());
        request.setAttribute("roles", Arrays.asList(Role.values()));
        return "/users/userAdd.jsp";
    }

    @PostMapping("/users/add")
    public String add(HttpServletRequest request) {
        User user = userConverter.convert(request);
        userDao.add(user);
        return "redirect:/users";
    }
}
