package com.conferenceManagement.controller;

import com.conferenceManagement.data.dao.LectureDao;

import javax.servlet.http.HttpServletRequest;

public class LectureController implements Controller {
    private final LectureDao lectureDao;

    public LectureController(LectureDao lectureDao) {
        this.lectureDao = lectureDao;
    }

    public String showList(HttpServletRequest request) {
        request.setAttribute("dataList", lectureDao.getAll());
        return "/lectures/lectureList.jsp";
    }
}
