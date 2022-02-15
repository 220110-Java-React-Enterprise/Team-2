package com.revature.team2.project2.travelplanner.beans.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/things")
public class ThingController {
    @GetMapping("/ping")
    // equivalent to:
    //   @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String ping() {
        return "pong-thing!";
    }
}
