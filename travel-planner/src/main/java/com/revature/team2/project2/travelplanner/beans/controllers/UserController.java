package com.revature.team2.project2.travelplanner.beans.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.team2.project2.travelplanner.beans.models.User;
import com.revature.team2.project2.travelplanner.beans.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

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
        // mapper for json'ing resultString
        ObjectMapper mapper = new ObjectMapper();

        // successful or not?
        Boolean isSaved = true;

        // result string is a failure by default
        String resultString = null;

        try {
            // save the user
            userRepository.save(user);

        } catch (Exception e) {
            log.error("User cannot be registered.", e);

            // User wasn't saved
            isSaved = false;
        }

        // try to map the successful result string
        try {
            if (isSaved) {
                // try to map the successful result string
                resultString = mapper.writeValueAsString(
                        String.format("User %s %s (ID = %d) registered successfully!",
                                user.getFirstName(), user.getLastName(), user.getUser_id()));

            } else {
                // try to map the failure result string
                resultString = mapper.writeValueAsString(
                        String.format("User cannot be registered. The email you entered (%s) may already be in use.",
                                user.getEmail()));
            }
        } catch (Exception e) {
            log.error("Registration string JSON mapping failed.");
        }

        // return the result
        return resultString;
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
    @Transactional
    public String deleteUserByEmail(@RequestParam String email) {
        // mapper for json'ing resultString
        ObjectMapper mapper = new ObjectMapper();

        // string to store result in for parsing
        String resultString = null;

        // try to delete user based on their email
        try {
            userRepository.deleteByEmail(email);
        } catch (Exception e) {
            log.error("Account deletion unsuccessful.", e);
        }

        // map a string for response
        try {
            resultString = mapper.writeValueAsString(resultString);
        } catch (Exception e) {
            log.error("Deletion String JSON mapping failed.", e);
        }

        // return the result
        return resultString;
    }
}
