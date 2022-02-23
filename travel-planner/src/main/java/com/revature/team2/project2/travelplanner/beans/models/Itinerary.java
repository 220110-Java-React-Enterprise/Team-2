package com.revature.team2.project2.travelplanner.beans.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@NoArgsConstructor
@Getter
@Entity
@Table(name = "itineraries")
public class Itinerary {

	@Id
	@Column(name = "itinerary_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itinerary_id;

	@Column(name = "destination")
	private String destination;

	@Column(name = "travel_mode")
	private String travelMode;

	@Column(name = "travel_distance")
	private Integer travelDistance;

	public Itinerary(String destination, String travelMode, Integer travelDistance) {
		this.destination = destination;
		this.travelMode = travelMode;
		this.travelDistance = travelDistance;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Itinerary) {
			Itinerary I = (Itinerary) other;
			System.out.print(this.itinerary_id +"< >"+ I.itinerary_id);
			if (this.itinerary_id != null && I.itinerary_id != null && this.itinerary_id == I.itinerary_id)
				return true;
		} else
			return false;

		return false;
	}
	
	@Override
	public String toString()
	{
		return this.itinerary_id+" "+this.destination + " " + this.travelDistance + " " + this.travelMode;
	}

}
