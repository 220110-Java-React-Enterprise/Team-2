package com.revature.team2.project2.travelplanner;

import com.revature.team2.project2.travelplanner.beans.models.Thing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.revature.team2.project2.travelplanner.beans")
public class TravelPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelPlannerApplication.class, args);


		//! TESTING STUFF
		Thing thing = new Thing();
		System.out.println("thing's id: " + thing.getId());
	}

}
