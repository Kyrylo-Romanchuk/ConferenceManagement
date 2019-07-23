package com.conferenceManagement;

import com.conferenceManagement.controller.ConferenceController;
import com.conferenceManagement.controller.Controller;
import com.conferenceManagement.controller.LectureController;
import com.conferenceManagement.controller.UserController;
import com.conferenceManagement.data.Role;
import com.conferenceManagement.data.converter.DateConverter;
import com.conferenceManagement.data.converter.IntegerConverter;
import com.conferenceManagement.data.dao.ConferenceDao;
import com.conferenceManagement.data.dao.LectureDao;
import com.conferenceManagement.data.dao.UserDao;
import com.conferenceManagement.data.model.Conference;
import com.conferenceManagement.data.model.Lecture;
import com.conferenceManagement.data.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Initializer {
    private final Map<Class, Controller> controllerMap = new HashMap<>();

    public Initializer() {
        DateConverter dateConverter = new DateConverter();
        IntegerConverter integerConverter = new IntegerConverter();

        List<User> users = new ArrayList<>();
        users.add(new User(1, "David", Role.SPEAKER));
        users.add(new User(2, "Aider", Role.SPEAKER));
        users.add(new User(3, "Odysseus", Role.MODERATOR));
        users.add(new User(4, "Andrey", Role.USER));
        users.add(new User(5, "Dmitriy", Role.USER));
        users.add(new User(6, "Andre", Role.MODERATOR));
        UserDao userDao = new UserDao(users);

        List<Lecture> lectures = new ArrayList<>();
        lectures.add(new Lecture(1, "Business", users.get(0), dateConverter.convert("05/05/1995 10:00")));
        lectures.add(new Lecture(2, "Starcraft Theory and Strategy", users.get(1), dateConverter.convert("05/05/1995 13:00")));
        lectures.add(new Lecture(3, "Business", users.get(0), dateConverter.convert("05/06/1995 12:00")));
        LectureDao lectureDao = new LectureDao(lectures);

        List<Conference> conferences = new ArrayList<>();
        conferences.add(new Conference(1, "About Business", "hall n.1", dateConverter.convert("05/05/1995 10:00"), users.get(2),
                lectures.stream().filter(lecture -> lecture.getId() == 1 || lecture.getId() == 3).collect(Collectors.toList()),
                users.stream().filter(user -> user.getRole().equals(Role.USER)).collect(Collectors.toList()),
                35));
        conferences.add(new Conference(2, "About games", "hall n.2", dateConverter.convert("05/06/1995 11:00"),users.get(2),
                lectures.stream().filter(lecture -> lecture.getId() == 2).collect(Collectors.toList()),
                users.stream().filter(user -> user.getRole().equals(Role.USER)).collect(Collectors.toList()),
                35));
        ConferenceDao conferenceDao = new ConferenceDao(conferences);

        UserController userController = new UserController(userDao);
        LectureController lectureController = new LectureController(lectureDao);
        ConferenceController conferenceController = new ConferenceController(conferenceDao);

        controllerMap.put(userController.getClass(), userController);
        controllerMap.put(lectureController.getClass(), lectureController);
        controllerMap.put(conferenceController.getClass(), conferenceController);
    }

    public <T> T getController(Class<T> type) {
        return (T) controllerMap.get(type);
    }

//    public <T> List<T> getControllers() {
//        return
//    }
}
