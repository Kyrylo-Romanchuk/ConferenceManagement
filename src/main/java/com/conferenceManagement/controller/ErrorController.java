package com.conferenceManagement.controller;

import com.conferenceManagement.servlet.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

public class ErrorController implements Controller {

    @GetMapping("/400")
    public String show400 (HttpServletRequest request){
        return "/errors/400.jsp";
    }

    @GetMapping("/500")
    public String show500 (HttpServletRequest request){
        return "/errors/500.jsp";
    }
}
