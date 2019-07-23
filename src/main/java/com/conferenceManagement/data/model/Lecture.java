package com.conferenceManagement.data.model;

import java.util.Date;

public class Lecture {
    private Integer id;
    private String topic;
    private User speaker;
    private String place;
    private Date date;

    public Lecture(Integer id, String topic, User speaker, String place, Date date) {
        this.id = id;
        this.topic = topic;
        this.speaker = speaker;
        this.place = place;
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public User getSpeaker() {
        return speaker;
    }

    public void setSpeaker(User speaker) {
        this.speaker = speaker;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
