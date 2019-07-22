package com.conferenceManagement.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter("/*")
public class UrlFilter implements Filter {
    private final List<String> resolveDirection = Arrays.asList("/mvn/.*", "/");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestUri = httpRequest.getRequestURI().replace(httpRequest.getContextPath() + "", "");

        if (resolveDirection.stream().noneMatch(requestUri::matches)) {
            request.getRequestDispatcher("/mvn" + requestUri).forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
