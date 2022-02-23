package com.revature.team2.project2.travelplanner.beans.controllers;

import com.revature.team2.project2.travelplanner.beans.models.Itinerary;
import com.revature.team2.project2.travelplanner.beans.repositories.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller to guide requests related to Itineraries.
 */
@RestController
@RequestMapping("/itinerary")
public class ItineraryController {
    private final ItineraryRepository itineraryRepository;

    /**
     * Retrieve access to the ItineraryRepository from Spring.
     * 
     * @param itineraryRepository
     */
    @Autowired
    public ItineraryController(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    /**
     * GET all Itineraries.
     * 
     * @return List of all existing Itineraries
     */
    @GetMapping()
    public List<Itinerary> getItinerary() {
        return itineraryRepository.findAll();
    }

    /**
     * GET an Itinerary by id.
     * 
     * @param id
     * @return the Itinerary based on id
     */
    @GetMapping(value = "/{id}")
    public Optional<Itinerary> getItineraryByID(@PathVariable Integer id) {
        return itineraryRepository.findById(id);
    }

    /**
     * POST an Itinerary.
     * 
     * @param itinerary
     */
    @PostMapping()
    public void postItinerary(@RequestBody Itinerary itinerary) {
        itineraryRepository.save(itinerary);
    }

    /**
     * DELETE an Itinerary by id.
     * 
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    public void deleteItineraryById(@PathVariable Integer id) {
        itineraryRepository.deleteById(id);
    }
}
