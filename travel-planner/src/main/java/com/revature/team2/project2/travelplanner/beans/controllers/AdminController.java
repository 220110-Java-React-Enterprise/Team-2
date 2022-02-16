package com.revature.team2.project2.travelplanner.beans.controllers;

import com.revature.team2.project2.travelplanner.beans.models.Admin;
import com.revature.team2.project2.travelplanner.beans.respositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Acts as a servlet for HTTP requests
 */
@RestController // @Response and @Controller are implied by @RestController
@RequestMapping("/admin")
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
    public Admin getAdminById(Integer id){
        return adminRepository.getById(id);
    }

    // POST and administrator
    @RequestMapping(method = RequestMethod.POST)
    public void postAdmin(Admin admin){
        adminRepository.save(admin);
    }

    // DELETE an administrator by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAdminById(Integer id){
        adminRepository.deleteById(id);
    }
}
