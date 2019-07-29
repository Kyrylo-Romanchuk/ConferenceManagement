package com.conferenceManagement.controller;

import com.conferenceManagement.data.Role;
import com.conferenceManagement.data.converter.ConferenceConverter;
import com.conferenceManagement.data.dao.ConferenceDao;
import com.conferenceManagement.data.dao.LectureDao;
import com.conferenceManagement.data.dao.UserDao;
import com.conferenceManagement.data.model.Conference;
import com.conferenceManagement.servlet.annotation.GetMapping;
import com.conferenceManagement.servlet.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

public class ConferenceController implements Controller {
    private final ConferenceDao conferenceDao;
    private final UserDao userDao;
    private final LectureDao lectureDao;
    private final ConferenceConverter conferenceConverter;

    public ConferenceController(ConferenceConverter conferenceConverter, ConferenceDao conferenceDao, UserDao userDao, LectureDao lectureDao) {
        this.conferenceConverter = conferenceConverter;
        this.conferenceDao = conferenceDao;
        this.userDao = userDao;
        this.lectureDao = lectureDao;
    }

    @GetMapping("/conferences")
    public String showList(HttpServletRequest request) {
        request.setAttribute("dataList", conferenceDao.getAll());
        return "/conferences/conferenceList.jsp";
    }

    @GetMapping("/conferences/add")
    public String showAdd(HttpServletRequest request) {
        request.setAttribute("moderators", userDao.getAllByRole(Role.MODERATOR));
        request.setAttribute("lectures", lectureDao.getAll());
        return "/conferences/conferenceAdd.jsp";
    }

    @PostMapping("/conferences/add")
    public String add(HttpServletRequest request) {
        Conference conference = conferenceConverter.convert(request);
        conferenceDao.add(conference);
        return "redirect:/conferences";
    }
}
