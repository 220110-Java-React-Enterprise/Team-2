package com.revature.team2.project2.travelplanner.beans.models;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Object for interacting with Users.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	@JsonIgnore
	private Integer user_id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "itineraries")
	@OneToMany
	@JsonIgnore
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

	@Override
	public String toString() {
		return "" + this.getUser_id() + " " + this.getEmail();
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof User) {
			User U = (User) other;
			if (this.user_id != null && this.user_id != -1 && U.user_id != null && U.user_id != -1
					&& this.user_id == U.user_id)
				return true;
		} else
			return false;

		return false;
	}
}
