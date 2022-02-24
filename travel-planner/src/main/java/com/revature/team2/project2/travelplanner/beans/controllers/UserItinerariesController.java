package com.revature.team2.project2.travelplanner.beans.controllers;

import java.util.ArrayList;
import java.util.List;

import com.revature.team2.project2.travelplanner.beans.models.Itinerary;
import com.revature.team2.project2.travelplanner.beans.models.User_Itinerary;
import com.revature.team2.project2.travelplanner.beans.repositories.UserItineraryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/itineraries")
public class UserItinerariesController {
	private final UserItineraryRepository userItineraryRepository;

	@Autowired
	public UserItinerariesController(UserItineraryRepository repo) {
		this.userItineraryRepository = repo;
	}

	// GET itinerary
	@RequestMapping(method = RequestMethod.GET)
	public List<User_Itinerary> getUserItineraries() {
		return userItineraryRepository.findAll();
	}

	// GET itinerary by Id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<Itinerary> getItineraryByID(@PathVariable Integer id) {
		// return userItineraryRepository.findById(id);
		ArrayList<User_Itinerary> U = (ArrayList<User_Itinerary>) userItineraryRepository.findAll();
		ArrayList<Itinerary> I = new ArrayList<Itinerary>();
		// log(U.size());
		for (int i = 0; i < U.size(); i++) {
			if (U.get(i).getUser_user_id() == id)
				I.add(U.get(i).getItinerary());
		}
		return I;
	}

	// DELETE itinerary
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteItineraryById(@PathVariable Integer id) {
		userItineraryRepository.deleteById(id);
	}

}
