package com.kert.compute.service;

import com.kert.compute.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    String login(User user);

    String flush(String token);

    boolean verify(String token);
}
