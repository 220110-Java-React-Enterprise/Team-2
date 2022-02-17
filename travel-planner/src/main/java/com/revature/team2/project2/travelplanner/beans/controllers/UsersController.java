package com.revature.team2.project2.travelplanner.beans.controllers;

import com.revature.team2.project2.travelplanner.beans.models.Users;
import com.revature.team2.project2.travelplanner.beans.respositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Acts as a servlet for HTTP requests
 */
@RestController // @Response and @Controller are implied by @RestController
@RequestMapping("/users")
public class UsersController {
    private UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // GET all users
    @RequestMapping(method = RequestMethod.GET)
    public List<Users> getAllUsers(){
       return usersRepository.findAll();
    }

    // GET a user by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Users getUserById(@PathVariable Integer id){
        return usersRepository.getById(id);
    }

    // POST a user
    @RequestMapping(method = RequestMethod.POST)
    public void postUser(@RequestBody Users user){
        usersRepository.save(user);
    }

    // DELETE a user by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable Integer id){
        usersRepository.deleteById(id);
    }


}
