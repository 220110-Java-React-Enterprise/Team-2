package com.revature.team2.project2.travelplanner.beans.respositories;

import com.revature.team2.project2.travelplanner.beans.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Handles data persistance CRUD
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
}
