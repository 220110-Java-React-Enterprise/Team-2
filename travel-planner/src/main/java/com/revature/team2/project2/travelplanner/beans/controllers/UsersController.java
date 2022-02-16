package com.revature.team2.project2.travelplanner.beans.controllers;

import com.revature.team2.project2.travelplanner.beans.respositories.UsersRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Acts as a servlet for HTTP requests
 */
@RestController // @Response and @Controller are implied by @RestController
@RequestMapping("/users")
public class UsersController {
    private UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // GET all administrators

    // GET an administrator by ID

    // POST and administrator

    // DELETE an administrator by ID
}
