package com.kert.compute.filter;

import com.kert.compute.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    private final UserService userService;
    public LoginInterceptor(UserService userService){
        this.userService=userService;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
            System.out.println("====================================================preHandle");
          userService.verify(request.getHeader("Authorization"));
           return true;
    }
}
