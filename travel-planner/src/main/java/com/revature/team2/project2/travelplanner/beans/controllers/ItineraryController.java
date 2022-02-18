package com.revature.team2.project2.travelplanner.beans.controllers;

import com.revature.team2.project2.travelplanner.beans.models.Itinerary;
import com.revature.team2.project2.travelplanner.beans.repositories.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Acts as a servlet for HTTP requests
 */
@RestController
@RequestMapping("/itinerary")
public class ItineraryController {
    private final ItineraryRepository itineraryRepository;

    @Autowired
    public ItineraryController(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    // GET itinerary
    @RequestMapping(method = RequestMethod.GET)
    public List<Itinerary> getItinerary(){
        return itineraryRepository.findAll();
    }

    // POST itinerary
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Itinerary postItinerary(Itinerary itinerary, Integer itinerary_id){
        return itineraryRepository.getById(itinerary_id);
    }

    // DELETE itinerary
    @RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
    public void deleteItineraryById(Integer intinerary_id){
        itineraryRepository.deleteById(intinerary_id);
    }
}
