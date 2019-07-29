package com.conferenceManagement.controller;

import com.conferenceManagement.data.Place;
import com.conferenceManagement.data.Role;
import com.conferenceManagement.data.converter.LectureConverter;
import com.conferenceManagement.data.dao.LectureDao;
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
public class LectureControllerTest {

    @Mock
    private LectureDao lectureDao;

    @Mock
    private UserDao userDao;

    @Mock
    private LectureConverter lectureConverter;

    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private LectureController lectureController;

    @Test
    public void showList() {
        assertEquals("/lectures/lectureList.jsp", lectureController.showList(request));
        verify(request).setAttribute("dataList", lectureDao.getAll());
    }

    @Test
    public void showAdd() {
        assertEquals("/lectures/lectureAdd.jsp", lectureController.showAdd(request));
        verify(request).setAttribute("speakers", userDao.getAllByRole(Role.SPEAKER));
        verify(request).setAttribute("places", Arrays.asList(Place.values()));
    }

    @Test
    public void add() {
        assertEquals("redirect:/lectures", lectureController.add(request));
    }
}