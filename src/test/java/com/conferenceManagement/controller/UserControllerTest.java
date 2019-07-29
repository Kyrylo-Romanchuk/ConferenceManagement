package com.conferenceManagement.controller;

import com.conferenceManagement.data.Role;
import com.conferenceManagement.data.converter.UserConverter;
import com.conferenceManagement.data.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserDao userDao;

    @Mock
    private UserConverter userConverter;

    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private UserController userController;

    @Test
    public void showList() {
        assertEquals("/users/userList.jsp", userController.showList(request));
        verify(request).setAttribute("dataList", userDao.getAll());
    }

    @Test
    public void showAdd() {
        assertEquals("/users/userAdd.jsp", userController.showAdd(request));
        verify(request).setAttribute("roles", Arrays.asList(Role.values()));
    }

    @Test
    public void add() {
        assertEquals("redirect:/users", userController.add(request));
    }
}