package com.revature.team2.project2.travelplanner.beans.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.team2.project2.travelplanner.beans.models.User_Itinerary;


@Repository
public interface UserItineraryRepository extends JpaRepository<User_Itinerary, Integer> {

}
