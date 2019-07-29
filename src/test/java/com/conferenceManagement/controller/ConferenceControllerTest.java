package com.conferenceManagement.controller;

import com.conferenceManagement.data.Role;
import com.conferenceManagement.data.converter.ConferenceConverter;
import com.conferenceManagement.data.dao.ConferenceDao;
import com.conferenceManagement.data.dao.LectureDao;
import com.conferenceManagement.data.dao.UserDao;
import com.conferenceManagement.data.model.Conference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ConferenceControllerTest {

    @Mock
    private ConferenceDao conferenceDao;

    @Mock
    private LectureDao lectureDao;

    @Mock
    private UserDao userDao;

    @Mock
    private HttpServletRequest request;

    @Mock
    private ConferenceConverter conferenceConverter;

    @InjectMocks
    private ConferenceController conferenceController;

    @Test
    public void showList() {
        assertEquals("/conferences/conferenceList.jsp", conferenceController.showList(request));
        verify(request).setAttribute("dataList", conferenceDao.getAll());
    }

    @Test
    public void showAdd() {
        assertEquals("/conferences/conferenceAdd.jsp", conferenceController.showAdd(request));
        verify(request).setAttribute("moderators", userDao.getAllByRole(Role.MODERATOR));
        verify(request).setAttribute("lectures", lectureDao.getAll());
    }

    @Test
    public void add() {
        assertEquals("redirect:/conferences", conferenceController.add(request));
    }
}