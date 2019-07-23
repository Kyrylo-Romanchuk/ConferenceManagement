package com.conferenceManagement.data.dao;

import com.conferenceManagement.data.model.Conference;

import java.util.List;

public class ConferenceDao implements Dao<Conference> {
    private final List<Conference> conferences;

    public ConferenceDao(List<Conference> conferences) {
        this.conferences = conferences;
    }

    @Override
    public List<Conference> getAll() {
        return conferences;
    }

    @Override
    public Conference findById(Integer id) {
        return conferences.stream().filter(conference -> conference.getId().equals(id)).findFirst().orElse(null);
    }
}
