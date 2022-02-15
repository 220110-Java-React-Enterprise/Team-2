package com.revature.team2.project2.travelplanner.beans.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    @GetMapping("/ping")
    public String ping() {
        return "pong!";
    }
}
