package com.conferenceManagement.servlet;

import com.conferenceManagement.Initializer;
import com.conferenceManagement.controller.LectureController;
import com.conferenceManagement.controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@WebServlet("/mvc/*")
public class Servlet extends HttpServlet {
    private final Map<String, Function<HttpServletRequest, String>> getMapper = new HashMap<>();
    private final Initializer initializer = new Initializer();

    @Override
    public void init(){
        LectureController lectureController = initializer.getController(LectureController.class);
        UserController userController = initializer.getController(UserController.class);
        getMapper.put("/lectures", lectureController::showList);
        getMapper.put("/users", userController::showList);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        followLink(request, response, getMapper);
    }

    private void followLink(HttpServletRequest request, HttpServletResponse response,
                            Map<String, Function<HttpServletRequest, String>> mapper) throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String requestUri = request.getRequestURI().replace(contextPath + "/mvc", "");
        if (mapper.containsKey(requestUri)){
            String targetURL = mapper.get(requestUri).apply(request);
            targetURL = "/WEB-INF/jsp" + targetURL;
            request.getRequestDispatcher(targetURL).forward(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }


}
