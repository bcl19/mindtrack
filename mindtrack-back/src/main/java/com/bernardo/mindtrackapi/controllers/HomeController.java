package com.bernardo.mindtrackapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")

public class HomeController {
    @RequestMapping("/welcome")
    public String welcome() {
        return "Welcome to the MindTrack";
    }
}
