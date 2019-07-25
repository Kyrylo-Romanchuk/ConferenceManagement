package com.conferenceManagement.data.dao;

import com.conferenceManagement.data.model.User;

import java.util.List;

public class UserDao implements Dao<User> {
    private final List<User> users;

    public UserDao(List<User> users) {
        this.users = users;
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User findById(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void add(User user) {
        if (user.getId() == null){
            Integer maxId = users.stream().map(User::getId).max(Integer::compareTo).orElse(0);
            user.setId(maxId);
        }
        users.add(user);
    }
}
