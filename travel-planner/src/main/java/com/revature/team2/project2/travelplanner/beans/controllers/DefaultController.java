package com.revature.team2.project2.travelplanner.beans.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultController {
    @GetMapping("/ping")
    public String ping() {
        return "pong!";
    }

    @GetMapping("/log")
    public String log() {
        // some of the available logging methods
        log.info("info log");
        log.warn("warn log");
        log.error("error log");

        // one way to catch exceptions
        try {
            throw new Exception("exception thrown");
        } catch (Exception e) {
            // other logging methods can be used, this seems to do stack trace and indicate that an exception was caught
            log.error(e.getMessage(), e);
        }

        return "sample log generated!";
    }
}
