package com.conferenceManagement.data.dao;

import com.conferenceManagement.data.Role;
import com.conferenceManagement.data.model.Conference;
import com.conferenceManagement.data.model.Lecture;
import com.conferenceManagement.data.model.User;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ConferenceDaoTest {
    private List<Conference> conferences;
    private ConferenceDao conferenceDao;

    @Before
    public void init() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        List<User> users = new ArrayList<>();
        users.add(new User(1, "David", Role.SPEAKER));
        users.add(new User(2, "Aider", Role.SPEAKER));
        users.add(new User(3, "Odysseus", Role.MODERATOR));
        users.add(new User(4, "Andrey", Role.USER));
        users.add(new User(5, "Dmitriy", Role.USER));
        users.add(new User(6, "Andre", Role.MODERATOR));

        List<Lecture> lectures = new ArrayList<>();
        lectures = new ArrayList<>();
        lectures.add(new Lecture(1, "Business", users.get(0), simpleDateFormat.parse("05/05/1995")));
        lectures.add(new Lecture(2, "Starcraft Theory and Strategy", users.get(1), simpleDateFormat.parse("05/05/1995")));

        conferences = new ArrayList<>();
        conferences.add(new Conference(1, "About Business", "hall n.1", simpleDateFormat.parse("05/05/1995 10:00"), users.get(2),
                lectures.stream().filter(lecture -> lecture.getId() == 1 || lecture.getId() == 3).collect(Collectors.toList()),
                users.stream().filter(user -> user.getRole().equals(Role.USER)).collect(Collectors.toList()),
                35));
        conferences.add(new Conference(2, "About games", "hall n.2", simpleDateFormat.parse("05/06/1995 11:00"), users.get(2),
                lectures.stream().filter(lecture -> lecture.getId() == 2).collect(Collectors.toList()),
                users.stream().filter(user -> user.getRole().equals(Role.USER)).collect(Collectors.toList()),
                35));

        conferenceDao = new ConferenceDao(conferences);

    }

    @Test
    public void getAll() {
        assertArrayEquals(conferences.toArray(), conferenceDao.getAll().toArray());
    }

    @Test
    public void findById() {
        assertEquals(conferences.get(0), conferenceDao.findById(1));
    }
}