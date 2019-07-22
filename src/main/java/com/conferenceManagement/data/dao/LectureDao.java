package com.conferenceManagement.data.dao;

import com.conferenceManagement.data.model.Lecture;

import java.util.List;

public class LectureDao implements Dao<Lecture> {
    private final List<Lecture> lectures;

    public LectureDao(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public List<Lecture> getAll() {
        return lectures;
    }
}
