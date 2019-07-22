package com.conferenceManagement;

import com.conferenceManagement.controller.Controller;
import com.conferenceManagement.controller.LectureController;
import com.conferenceManagement.controller.UserController;
import com.conferenceManagement.data.converter.DateConverter;
import com.conferenceManagement.data.dao.LectureDao;
import com.conferenceManagement.data.dao.UserDao;
import com.conferenceManagement.data.model.Lecture;
import com.conferenceManagement.data.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Initializer {
    private final Map<Class, Controller> controllerMap = new HashMap<>();

    public Initializer() {
        DateConverter dateConverter = new DateConverter();

        List<User> users = new ArrayList<>();
        users.add(new User(1, "David", "Speaker"));
        users.add(new User(2, "Aider", "Speaker"));
        users.add(new User(2, "Odysseus", "Speaker"));
        UserDao userDao = new UserDao(users);

        List<Lecture> lectures = new ArrayList<>();
        lectures.add(new Lecture(1, "Business", "David", "hall n.1", dateConverter.convert("05/05/1995"), "11:00"));
        lectures.add(new Lecture(2, "Starcraft Theory and Strategy", "Aider", "hall n.1", dateConverter.convert("05/05/1995"), "12:30"));
        lectures.add(new Lecture(3, "Business", "David", "hall n.2", dateConverter.convert("05/06/1995"), "11:00"));
        LectureDao lectureDao = new LectureDao(lectures);

        UserController userController = new UserController(userDao);
        LectureController lectureController = new LectureController(lectureDao);

        controllerMap.put(userController.getClass(), userController);
        controllerMap.put(lectureController.getClass(), lectureController);
    }

    public <T> T getController(Class<T> type) {
        return (T) controllerMap.get(type);
    }
}
