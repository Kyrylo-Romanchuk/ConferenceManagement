package com.conferenceManagement.data.converter;

import com.conferenceManagement.data.Role;
import com.conferenceManagement.data.model.User;

import javax.servlet.http.HttpServletRequest;

public class UserConverter implements Converter<HttpServletRequest, User> {
    @Override
    public User convert(HttpServletRequest request) {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setRole(Role.valueOf(request.getParameter("role")));
        return user;
    }
}
