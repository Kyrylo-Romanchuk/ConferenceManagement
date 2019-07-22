package com.conferenceManagement.controller;

import com.conferenceManagement.data.dao.UserDao;

import javax.servlet.http.HttpServletRequest;

public class UserController implements Controller {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    public String showList(HttpServletRequest request) {
        request.setAttribute("userList", userDao.getAll());
        return "/users/userList.jsp";
    }
}
