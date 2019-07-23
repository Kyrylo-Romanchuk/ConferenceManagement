package com.conferenceManagement.controller;

import com.conferenceManagement.data.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserController userController;

    @Test
    public void showList() {
        assertEquals("/users/userList.jsp", userController.showList(request));
        verify(request).setAttribute("dataList", userDao.getAll());
    }
}