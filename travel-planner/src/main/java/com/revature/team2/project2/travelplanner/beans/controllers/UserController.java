package com.revature.team2.project2.travelplanner.beans.controllers;

import com.revature.team2.project2.travelplanner.beans.models.User;
import com.revature.team2.project2.travelplanner.beans.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

/**
 * Controller to guide requests related to Users.
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserRepository userRepository;

    /**
     * Retrieve access to the UserRepository from Spring.
     * 
     * @param userRepository
     */
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * GET all Users.
     * 
     * @return List of all existing Users
     */
    @GetMapping()
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * GET a User by id.
     * 
     * @param id
     * @return the User based on id
     */
    @GetMapping(value = "/id")
    public Optional<User> getUserById(@RequestParam Integer id) {
        return userRepository.findById(id);
    }

    /**
     * GET a User by email.
     * Emails are unique and should not cause conflicting results.
     * 
     * @param email
     * @return the User based on email
     */
    @GetMapping(value = "/email")
    public Optional<User> getUserByEmail(@RequestParam String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * POST a User.
     * 
     * @param user
     * @return String containing information regarding success or failure.
     */
    @PostMapping()
    public String postUser(@RequestBody User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            log.error("User cannot be registered.", e);

            // inform failed result
            return "User cannot be registered. The email you entered ("
                    + user.getEmail() + ") may already be in use.";
        }

        // inform successful result
        return "User " + user.getFirstName() + user.getLastName() +
                " (ID = " + user.getUser_id() +
                ") registered successfully!";
    }

    /**
     * DELETE a User by id.
     * 
     * @param id
     */
    @DeleteMapping(value = "/id")
    public void deleteUserById(@RequestParam Integer id) {
        userRepository.deleteById(id);
    }

    /**
     * DELETE a User by email.
     * 
     * @param email
     */
    @DeleteMapping(value = "/email")
    public void deleteUserByEmail(@RequestParam String email) {
        userRepository.deleteByEmail(email);
    }
}
