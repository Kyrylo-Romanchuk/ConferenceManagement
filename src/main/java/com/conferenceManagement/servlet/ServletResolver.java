package com.conferenceManagement.servlet;

import com.conferenceManagement.servlet.annotation.GetMapping;
import com.conferenceManagement.servlet.annotation.PostMapping;
import com.conferenceManagement.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class ServletResolver {
    private final Map<String, Function<HttpServletRequest, String>> getMapper = new HashMap<>();
    private final Map<String, Function<HttpServletRequest, String>> postMapper = new HashMap<>();

    public ServletResolver(List<Controller> controllers) {
        for (Controller controller : controllers) {
            Method[] methods = controller.getClass().getDeclaredMethods();
            for (Method method : methods) {
                Optional.ofNullable(method.getAnnotation(GetMapping.class))
                        .ifPresent(a -> getMapper.put(a.value(), request -> invokeController(controller, method, request)));
                Optional.ofNullable(method.getAnnotation(PostMapping.class))
                        .ifPresent(a -> postMapper.put(a.value(), request -> invokeController(controller, method, request)));
            }
        }
    }

    private String invokeController(Controller controller, Method method, HttpServletRequest request) {
        try {
            return (String) method.invoke(controller, request);
        } catch (Exception e) {
            request.setAttribute("exception", e.getCause());
            return "redirect:/500";
        }
    }

    public String resolve(HttpServletRequest request, HttpServletResponse response) {
        String contextPath = request.getContextPath();
        String requestUri = request.getRequestURI().replace(contextPath + "/mvc", "");
        Map<String, Function<HttpServletRequest, String>> mapper = request.getMethod().equals("GET") ? getMapper : postMapper;
        if (mapper.containsKey(requestUri)){
            return mapper.get(requestUri).apply(request);
        }
        return "redirect:/404";
    }
}
