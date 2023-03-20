package com.kert.compute.filter;

import com.kert.compute.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginHandler implements HandlerInterceptor {
    private final UserService userService;
    public LoginHandler(UserService userService){
        this.userService=userService;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
                userService.verify(request.getHeader("Authorization"));
                return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex!=null){
            throw ex;
        }

    }
}
