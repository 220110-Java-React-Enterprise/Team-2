package com.revature.team2.project2.travelplanner.beans.models;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "itineraries")
    @OneToMany
    private List<Itinerary> itineraries = new LinkedList<>();

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public void addItinerary(Itinerary itinerary) {
        itineraries.add(itinerary);
    }

    public void removeItinerary(Itinerary itinerary) {
        itineraries.remove(itinerary);
    }

}
