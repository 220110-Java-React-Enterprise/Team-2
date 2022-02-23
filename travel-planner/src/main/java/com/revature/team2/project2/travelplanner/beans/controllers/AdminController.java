package com.revature.team2.project2.travelplanner.beans.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.revature.team2.project2.travelplanner.beans.models.Admin;
import com.revature.team2.project2.travelplanner.beans.repositories.AdminRepository;

import java.util.List;
import java.util.Optional;

/**
 * Acts as a servlet for HTTP requests
 */
@RestController // @Response and @Controller are implied by @RestController
@RequestMapping("/admins")
public class AdminController {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // GET all administrators
    @RequestMapping(method = RequestMethod.GET)
    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }

    // GET an administrator by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Admin> getAdminById(@PathVariable Integer id){

        return adminRepository.findById(id);
    }

    // POST and administrator
    @RequestMapping(method = RequestMethod.POST)
    public void postAdmin(@RequestBody Admin admin){
        adminRepository.save(admin);
    }

    // DELETE an administrator by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAdminById(@PathVariable Integer id){
        adminRepository.deleteById(id);
    }
}
