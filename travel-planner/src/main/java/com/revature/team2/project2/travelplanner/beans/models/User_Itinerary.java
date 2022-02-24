package com.revature.team2.project2.travelplanner.beans.models;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import javax.persistence.*;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

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
