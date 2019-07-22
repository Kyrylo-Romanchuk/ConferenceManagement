package com.conferenceManagement.data.dao;

import com.conferenceManagement.data.model.Lecture;

import java.util.List;

public class LectureDao implements Dao<Lecture> {
    private final List<Lecture> lectures;

    public LectureDao(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    @Override
    public List<Lecture> getAll() {
        return lectures;
    }

    @Override
    public Lecture findById(Integer id) {
        return lectures.stream().filter(lecture -> lecture.getId().equals(id)).findFirst().orElse(null);
    }
}
