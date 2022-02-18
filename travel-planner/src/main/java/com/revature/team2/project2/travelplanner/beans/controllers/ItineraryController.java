package com.revature.team2.project2.travelplanner.beans.controllers;

import com.revature.team2.project2.travelplanner.beans.models.Itinerary;
import com.revature.team2.project2.travelplanner.beans.repositories.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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
    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public Optional<Itinerary> getItineraryByID(@PathVariable Integer itinerary_id){
        return itineraryRepository.findById(itinerary_id);
    }

    // POST itinerary
    @RequestMapping(method = RequestMethod.POST)
    public Itinerary postItinerary(@RequestBody Itinerary itinerary){
        return itineraryRepository.save(itinerary);
    }

    // DELETE itinerary
    @RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
    public void deleteItineraryById(@PathVariable Integer intinerary_id){
        itineraryRepository.deleteById(intinerary_id);
    }
}
