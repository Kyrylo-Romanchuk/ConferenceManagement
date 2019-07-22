package com.conferenceManagement.data.dao;

import com.conferenceManagement.data.model.Lecture;
import com.conferenceManagement.data.model.User;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LectureDaoTest {
    private List<Lecture> lectures;
    private LectureDao lectureDao;

    @Before
    public void init() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        List<User> users = new ArrayList<>();
        users.add(new User(1, "David", "Speaker"));
        users.add(new User(2, "Aider", "Speaker"));

        lectures = new ArrayList<>();
        lectures.add(new Lecture(1, "Business", users.get(0), "hall n.1", simpleDateFormat.parse("05/05/1995"), "11:00"));
        lectures.add(new Lecture(2, "Starcraft Theory and Strategy", users.get(1), "hall n.1", simpleDateFormat.parse("05/05/1995"), "12:30"));

        lectureDao = new LectureDao(lectures);
    }

    @Test
    public void getAll() {
        assertArrayEquals(lectures.toArray(), lectureDao.getAll().toArray());
    }

    @Test
    public void findById() {
        assertEquals(lectures.get(0), lectureDao.findById(1));
    }
}