package com.revature.team2.project2.travelplanner.beans.repositories;

import java.util.Optional;

import com.revature.team2.project2.travelplanner.beans.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Handles data persistance CRUD
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * JpaRepository creates a concrete implementation for you
     * this is based on the naming sheme of the function itself
     * there are plenty of other options besides this.
     * 
     * @param email the email associated with user to look for
     * @return a User object associated with email if it exists
     */
    Optional<User> findByEmail(String email);
}
