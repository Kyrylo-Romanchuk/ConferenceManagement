package com.conferenceManagement;

import com.conferenceManagement.controller.*;
import com.conferenceManagement.data.Role;
import com.conferenceManagement.data.converter.DateConverter;
import com.conferenceManagement.data.converter.IntegerConverter;
import com.conferenceManagement.data.converter.UserConverter;
import com.conferenceManagement.data.dao.ConferenceDao;
import com.conferenceManagement.data.dao.LectureDao;
import com.conferenceManagement.data.dao.UserDao;
import com.conferenceManagement.data.model.Conference;
import com.conferenceManagement.data.model.Lecture;
import com.conferenceManagement.data.model.User;
import com.conferenceManagement.servlet.ServletResolver;

import java.util.*;
import java.util.stream.Collectors;

public class Initializer {
    private final Map<Class, Object> components = new HashMap<>();

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
        conferences.add(new Conference(2, "About games", "hall n.2", dateConverter.convert("05/06/1995 11:00"), users.get(2),
                lectures.stream().filter(lecture -> lecture.getId() == 2).collect(Collectors.toList()),
                users.stream().filter(user -> user.getRole().equals(Role.USER)).collect(Collectors.toList()),
                35));
        ConferenceDao conferenceDao = new ConferenceDao(conferences);

        UserConverter userConverter = new UserConverter();

        UserController userController = new UserController(userDao, userConverter);
        LectureController lectureController = new LectureController(lectureDao);
        ConferenceController conferenceController = new ConferenceController(conferenceDao);
        ErrorController errorController = new ErrorController();

        List<Controller> controllers = Arrays.asList(userController, lectureController, conferenceController, errorController);

        ServletResolver servletResolver = new ServletResolver(controllers);
        components.put(ServletResolver.class, servletResolver);
    }

    public <T> T getComponent(Class<T> type) {
        return (T) components.get(type);
    }
}
