package com.revature.team2.project2.travelplanner.beans.controllers;

import com.revature.team2.project2.travelplanner.beans.models.User;
import com.revature.team2.project2.travelplanner.beans.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Acts as a servlet for HTTP requests
 */
@RestController // @Response and @Controller are implied by @RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET all users
    @GetMapping()
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET a user by ID
    @GetMapping(value = "/id")
    public Optional<User> getUserById(@RequestParam Integer id) {
        return userRepository.findById(id);
    }

    // GET a user by email
    //   emails are unique so this should be OK
    @GetMapping(value = "/email")
    public Optional<User> getUserByEmail(@RequestParam String email) {
        return userRepository.findByEmail(email);
    }

    // POST a user
    @PostMapping()
    public void postUser(@RequestBody User user) {
        userRepository.save(user);
    }

    // DELETE a user by ID
    @DeleteMapping(value = "/id")
    public void deleteUserById(@RequestParam Integer id) {
        userRepository.deleteById(id);
    }

}
