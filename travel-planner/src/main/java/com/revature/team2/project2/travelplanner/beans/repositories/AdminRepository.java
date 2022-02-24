package com.revature.team2.project2.travelplanner.beans.repositories;

import com.revature.team2.project2.travelplanner.beans.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Data persistence for Admin.
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
