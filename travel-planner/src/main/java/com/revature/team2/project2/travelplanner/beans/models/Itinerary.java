package com.revature.team2.project2.travelplanner.beans.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Setter
@NoArgsConstructor
@Getter
@Entity
@Table(name ="itinerary")
public class Itinerary {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "destination")
    private String destination;

    @Column(name = "travel_mode")
    private String travelMode;

    @Column(name = "travel_distance")
    private Integer travelDistance;

    public Itinerary(String firstName, String lastName, String destination, String travelMode, Integer travelDistance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.destination = destination;
        this.travelMode = travelMode;
        this.travelDistance = travelDistance;
    }
}
