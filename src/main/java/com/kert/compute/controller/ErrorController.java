package com.kert.compute.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/business")
public class ErrorController {
    @GetMapping("/err")
    public void error(HttpServletRequest request) throws Exception {
      throw (Exception)  request.getAttribute("err");
    }
}
