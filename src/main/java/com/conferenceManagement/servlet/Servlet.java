package com.conferenceManagement.servlet;

import com.conferenceManagement.Initializer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/mvc/*")
public class Servlet extends HttpServlet {
    private final String redirectAttributes = "REDIRECTATTRIBUTES";
    private ServletResolver servletResolver;

    @Override
    public void init() {
        Initializer initializer = new Initializer();
        servletResolver = initializer.getComponent(ServletResolver.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        generateReference(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        generateReference(request, response);
    }

    private void generateReference(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String targetUrl = servletResolver.resolve(request, response);
        removeParameters(request);
        if (targetUrl.startsWith("redirect:")) {
            saveParameters(request);
            response.sendRedirect(request.getContextPath() + targetUrl.substring(9));
        } else if (targetUrl.endsWith(".jsp")) {
            targetUrl = "/WEB-INF/jsp" + targetUrl;
            request.getRequestDispatcher(targetUrl).forward(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void removeParameters(HttpServletRequest request) {
        Map<String, Object> saveAttributes = (Map<String, Object>) request.getSession().getAttribute(redirectAttributes);
        if (saveAttributes != null) {
            saveAttributes.forEach(request::setAttribute);
            request.getSession().removeAttribute(redirectAttributes);
        }
    }

    private void saveParameters(HttpServletRequest request) {
        Map<String, Object> saveAttributes = new HashMap<>();
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            saveAttributes.put(name, request.getAttribute(name));
        }
        request.getSession().setAttribute(redirectAttributes, saveAttributes);
    }
}
