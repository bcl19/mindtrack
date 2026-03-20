package com.bernardo.mindtrackapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")

public class HomeController {
    @RequestMapping("/welcome2")
    public String welcome() {
        return "Welcome to the MindTrack";
    }
}
