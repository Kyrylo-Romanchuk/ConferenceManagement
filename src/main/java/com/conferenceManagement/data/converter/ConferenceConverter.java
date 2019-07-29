package com.conferenceManagement.data.converter;

import com.conferenceManagement.data.dao.LectureDao;
import com.conferenceManagement.data.dao.UserDao;
import com.conferenceManagement.data.model.Conference;
import com.conferenceManagement.data.model.Lecture;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConferenceConverter implements Converter<HttpServletRequest, Conference> {
    private final DateConverter dateConverter;
    private final UserDao userDao;
    private final IntegerConverter integerConverter;
    private final LectureDao lecturesDao;

    public ConferenceConverter(DateConverter dateConverter, IntegerConverter integerConverter, UserDao userDao, LectureDao lecturesDao) {
        this.dateConverter = dateConverter;
        this.integerConverter = integerConverter;
        this.userDao = userDao;
        this.lecturesDao = lecturesDao;
    }

    @Override
    public Conference convert(HttpServletRequest request) {
        Conference conference = new Conference();
        conference.setDate(dateConverter.convert(request.getParameter("date")));
        Integer userId = integerConverter.convert(request.getParameter("moderator"));
        conference.setModerator(userDao.findById(userId));
        conference.setName(request.getParameter("name"));
        String[] lecturesId = request.getParameterValues("lectures");
        if (lecturesId != null){
            List<Lecture> lectures = Arrays.stream(lecturesId)
                    .map(integerConverter::convert)
                    .map(lecturesDao::findById)
                    .collect(Collectors.toList());
            conference.setLectures(lectures);
        }
        conference.setSeats(integerConverter.convert(request.getParameter("seats")));
        return conference;
    }
}
