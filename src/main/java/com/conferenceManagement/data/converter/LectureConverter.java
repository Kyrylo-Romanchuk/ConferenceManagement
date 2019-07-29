package com.conferenceManagement.data.converter;

import com.conferenceManagement.data.Place;
import com.conferenceManagement.data.dao.UserDao;
import com.conferenceManagement.data.model.Lecture;

import javax.servlet.http.HttpServletRequest;

public class LectureConverter implements Converter<HttpServletRequest, Lecture> {
    private final DateConverter dateConverter;
    private final IntegerConverter integerConverter;
    private final UserDao userDao;

    public LectureConverter(DateConverter dateConverter, IntegerConverter integerConverter, UserDao userDao) {
        this.dateConverter = dateConverter;
        this.integerConverter = integerConverter;
        this.userDao = userDao;
    }

    @Override
    public Lecture convert(HttpServletRequest request) {
        Lecture lecture = new Lecture();
        lecture.setTopic(request.getParameter("topic"));
        Integer speakerId = integerConverter.convert(request.getParameter("speaker"));
        lecture.setSpeaker(userDao.findById(speakerId));
        lecture.setPlace(Place.valueOf(request.getParameter("place")));
        lecture.setDate(dateConverter.convert(request.getParameter("date")));
        return lecture;
    }
}
