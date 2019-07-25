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

    @Override
    public void add(Conference conference) {
        if (conference.getId() == null){
            Integer maxId = conferences.stream().map(Conference::getId).max(Integer::compareTo).orElse(0);
            conference.setId(maxId);
        }
        conferences.add(conference);
    }
}
