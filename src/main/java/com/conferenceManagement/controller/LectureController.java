package com.conferenceManagement.controller;

import com.conferenceManagement.data.Place;
import com.conferenceManagement.data.Role;
import com.conferenceManagement.data.converter.LectureConverter;
import com.conferenceManagement.data.dao.LectureDao;
import com.conferenceManagement.data.dao.UserDao;
import com.conferenceManagement.data.model.Lecture;
import com.conferenceManagement.servlet.annotation.GetMapping;
import com.conferenceManagement.servlet.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LectureController implements Controller {
    private final LectureDao lectureDao;
    private final LectureConverter lectureConverter;
    private final UserDao userDao;

    public LectureController(LectureDao lectureDao, UserDao userDao, LectureConverter lectureConverter) {
        this.lectureDao = lectureDao;
        this.userDao = userDao;
        this.lectureConverter = lectureConverter;
    }

    @GetMapping("/lectures")
    public String showList(HttpServletRequest request) {
        request.setAttribute("dataList", lectureDao.getAll());
        return "/lectures/lectureList.jsp";
    }

    @GetMapping("/lectures/add")
    public String showAdd(HttpServletRequest request) {
        request.setAttribute("lecture", new Lecture());
        request.setAttribute("places", Arrays.asList(Place.values()));
        request.setAttribute("speakers", userDao.getAllByRole(Role.SPEAKER));
        return "/lectures/lectureAdd.jsp";
    }

    @PostMapping("/lectures/add")
    public String add(HttpServletRequest request) {
        Lecture lecture = lectureConverter.convert(request);
        lectureDao.add(lecture);
        return "redirect:/lectures";
    }
}
