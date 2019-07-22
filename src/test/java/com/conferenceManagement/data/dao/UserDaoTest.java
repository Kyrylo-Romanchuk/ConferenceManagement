package com.conferenceManagement.data.dao;

import com.conferenceManagement.data.model.User;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class UserDaoTest {
    private List<User> users;
    private UserDao userDao;

    @Before
    public void init() throws ParseException {
        users = new ArrayList<>();
        users.add(new User(1, "David", "Speaker"));
        users.add(new User(2, "Aider", "Speaker"));

        userDao = new UserDao(users);
    }

    @Test
    public void getAll() {
        assertArrayEquals(users.toArray(), userDao.getAll().toArray());
    }

    @Test
    public void findById() {
        assertEquals(users.get(0), userDao.findById(1));
    }
}