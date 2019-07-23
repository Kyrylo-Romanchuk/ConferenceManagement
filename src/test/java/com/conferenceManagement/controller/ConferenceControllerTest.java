package com.conferenceManagement.controller;

import com.conferenceManagement.data.dao.ConferenceDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ConferenceControllerTest {

    @Mock
    private ConferenceDao conferenceDao;

    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private ConferenceController conferenceController;

    @Test
    public void showList() {
        assertEquals("/conferences/conferenceList.jsp", conferenceController.showList(request));
        verify(request).setAttribute("dataList", conferenceDao.getAll());
    }
}