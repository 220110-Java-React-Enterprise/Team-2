package com.revature.team2.project2.travelplanner.beans.models;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

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

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "itineraries")
	@OneToMany
	private List<Itinerary> itineraries = new LinkedList<>();

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public User(String firstName, String lastName, String email, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
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
