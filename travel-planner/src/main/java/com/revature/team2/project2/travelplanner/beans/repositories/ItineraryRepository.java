package com.revature.team2.project2.travelplanner.beans.repositories;

import com.revature.team2.project2.travelplanner.beans.models.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Data persistence for Itinerary.
 */
@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Integer> {

}
