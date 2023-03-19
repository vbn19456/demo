package com.kert.compute.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public ArrayList<Object> index(){
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("dada");
        return objects;
    }
}
