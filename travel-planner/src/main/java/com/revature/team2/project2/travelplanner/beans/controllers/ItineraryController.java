package com.revature.team2.project2.travelplanner.beans.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.revature.team2.project2.travelplanner.beans.models.Itinerary;
import com.revature.team2.project2.travelplanner.beans.repositories.ItineraryRepository;

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
    @RequestMapping(method = RequestMethod.GET)
    public List<Itinerary> getItinerary(){
        return itineraryRepository.findAll();
    }

    // GET itinerary by Id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Itinerary> getItineraryByID(@PathVariable Integer id){
        return itineraryRepository.findById(id);
    }

    // POST itinerary
    @RequestMapping(method = RequestMethod.POST)
    public Itinerary postItinerary(@RequestBody Itinerary itinerary){
        return itineraryRepository.save(itinerary);
    }

    // DELETE itinerary
    @RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
    public void deleteItineraryById(@PathVariable Integer id){
        itineraryRepository.deleteById(id);
    }
    

}
