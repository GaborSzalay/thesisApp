package com.university.thesisapp.dao.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gábor on 2015.07.25..
 */
public class DatabaseInitializerInterceptor extends HandlerInterceptorAdapter {
    Logger logger = LoggerFactory.getLogger(DatabaseInitializerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Megjott az interceptor!! :)");
        return true;
    }
}
