package com.revature.team2.project2.travelplanner.beans.controllers;

import com.revature.team2.project2.travelplanner.beans.models.User;
import com.revature.team2.project2.travelplanner.beans.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Acts as a servlet for HTTP requests
 */
@RestController // @Response and @Controller are implied by @RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET all users
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers(){
       return userRepository.findAll();
    }

    // GET a user by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Integer id){
        return userRepository.getById(id);
    }

    // POST a user
    @RequestMapping(method = RequestMethod.POST)
    public void postUser(@RequestBody User user){
        userRepository.save(user);
    }

    // DELETE a user by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable Integer id){
        userRepository.deleteById(id);
    }


}
