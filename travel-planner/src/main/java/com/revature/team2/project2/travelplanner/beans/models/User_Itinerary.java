package com.revature.team2.project2.travelplanner.beans.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users_itineraries")
public class User_Itinerary {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_user_id")
    private Integer user_user_id;

    @Column(name = "itineraries_itinerary_id")
    private String itineraries_itinerary_id;

 // bi-directional many-to-one association to User
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_user_id", insertable = false, updatable = false)
    private User user;
    
    // bi-directional many-to-one association to Itinerary
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "itineraries_itinerary_id", insertable = false, updatable = false)
    private Itinerary itinerary;
    
    
}
