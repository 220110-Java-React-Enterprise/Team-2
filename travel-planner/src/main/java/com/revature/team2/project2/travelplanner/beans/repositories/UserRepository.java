package com.revature.team2.project2.travelplanner.beans.repositories;

import java.util.Optional;

import com.revature.team2.project2.travelplanner.beans.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Data persistence for User.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * JpaRepository creates a concrete implementation for you based on the naming
     * scheme of the function itself.
    */

    
    /**
     * Retrieve a User by their email.
     * 
     * @param email
     * @return a User object associated with email
     */
    Optional<User> findByEmail(String email);

    /**
     * Delete a User by their email.
     * 
     * @param email
     */
    void deleteByEmail(String email);
}
