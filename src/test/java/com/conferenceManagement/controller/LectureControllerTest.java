package com.conferenceManagement.controller;

import com.conferenceManagement.data.dao.LectureDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LectureControllerTest {

    @Mock
    private LectureDao lectureDao;

    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private LectureController lectureController;

    @Test
    public void showList() {
        assertEquals("/lectures/lectureList.jsp", lectureController.showList(request));
        verify(request).setAttribute("dataList", lectureDao.getAll());
    }
}