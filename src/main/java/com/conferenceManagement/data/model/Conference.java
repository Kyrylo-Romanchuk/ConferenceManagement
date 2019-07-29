package com.conferenceManagement.data.model;

import java.util.Date;
import java.util.List;

public class Conference {
    private Integer id;
    private String name;
    private Date date;
    private User moderator;
    private List<Lecture> lectures;
    private List<User> users;
    private Integer seats;

    public Conference() {
    }

    public Conference(Integer id, String name, Date date, User moderator, List<Lecture> lectures, List<User> users, Integer seats) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.moderator = moderator;
        this.users = users;
        this.lectures = lectures;
        this.seats = seats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getModerator() {
        return moderator;
    }

    public void setModerator(User moderator) {
        this.moderator = moderator;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Lecture getLectureById (Integer id){
        return lectures.stream().filter(lecture -> lecture.getId().equals(id)).findFirst().orElse(null);
    }
}
