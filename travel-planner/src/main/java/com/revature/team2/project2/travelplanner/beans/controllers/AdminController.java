package com.revature.team2.project2.travelplanner.beans.controllers;

import com.revature.team2.project2.travelplanner.beans.respositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // GET an administrator by ID

    // POST and administrator

    // DELETE an administrator by ID
}
