package com.revature.team2.project2.travelplanner.beans.controllers;

import com.revature.team2.project2.travelplanner.beans.models.Admin;
import com.revature.team2.project2.travelplanner.beans.repositories.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller to guide requests related to Admins.
 */
@RestController
@RequestMapping("/admins")
public class AdminController {
    private final AdminRepository adminRepository;

    /**
     * Retrieve access to the AdminRepository from Spring.
     * 
     * @param adminRepository
     */
    @Autowired
    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    /**
     * GET all Admins.
     * 
     * @return List of all existing Admins
     */
    @GetMapping()
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    /**
     * GET an Admin by id.
     * 
     * @param id
     * @return the Admin based on id
     */
    @GetMapping(value = "/{id}")
    public Optional<Admin> getAdminById(@PathVariable Integer id) {
        return adminRepository.findById(id);
    }

    /**
     * POST an Admin.
     * 
     * @param admin
     */
    @PostMapping
    public void postAdmin(@RequestBody Admin admin) {
        adminRepository.save(admin);
    }

    /**
     * DELETE an Admin by id.
     * 
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    public void deleteAdminById(@PathVariable Integer id) {
        adminRepository.deleteById(id);
    }
}
