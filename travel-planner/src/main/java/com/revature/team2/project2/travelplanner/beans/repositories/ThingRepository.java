package com.revature.team2.project2.travelplanner.beans.repositories;

import com.revature.team2.project2.travelplanner.beans.models.Thing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThingRepository extends JpaRepository<Thing, Integer> {
    // Spring does the heavy lifting for methods
}
