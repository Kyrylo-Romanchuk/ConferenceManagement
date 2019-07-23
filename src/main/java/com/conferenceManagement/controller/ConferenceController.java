package com.conferenceManagement.controller;

import com.conferenceManagement.data.dao.ConferenceDao;

import javax.servlet.http.HttpServletRequest;

public class ConferenceController implements Controller {
    private final ConferenceDao conferenceDao;

    public ConferenceController(ConferenceDao conferenceDao) {
        this.conferenceDao = conferenceDao;
    }

    public String showList (HttpServletRequest request){
        request.setAttribute("dataList", conferenceDao.getAll());
        return "/conferences/conferenceList.jsp";
    }
}
