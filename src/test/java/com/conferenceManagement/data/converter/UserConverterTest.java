package com.conferenceManagement.data.converter;

import com.conferenceManagement.data.Role;
import com.conferenceManagement.data.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserConverterTest {
    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private UserConverter userConverter;

    @Test
    public void convert() {
        User user = new User();
        user.setName("test");
        user.setRole(Role.MODERATOR);

        when(request.getParameter("name")).thenReturn("test");
        when(request.getParameter("role")).thenReturn("MODERATOR");
        assertEquals(user.getName(), userConverter.convert(request).getName());
        assertEquals(user.getRole(), userConverter.convert(request).getRole());
    }
}