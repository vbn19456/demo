package com.kert.compute.controller;

import com.kert.compute.model.entity.User;
import com.kert.compute.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @PostMapping("/login")
    public Object login(@RequestBody User user){
        String token = userService.login(user);
        response.setHeader("Authorization",token);
        return null;
    }
    @PostMapping("/flush")
    public void flush(){
        String token = userService.flush(request.getHeader("Authorization"));
        response.setHeader("Authorization",token);
    }
}
