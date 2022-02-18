package com.revature.team2.project2.travelplanner;

import com.revature.team2.project2.travelplanner.beans.models.Admin;
import com.revature.team2.project2.travelplanner.beans.models.Itinerary;
import com.revature.team2.project2.travelplanner.beans.models.User;
import com.revature.team2.project2.travelplanner.beans.repositories.AdminRepository;
import com.revature.team2.project2.travelplanner.beans.repositories.ItineraryRepository;
import com.revature.team2.project2.travelplanner.beans.repositories.UserRepository;
import com.revature.team2.project2.travelplanner.beans.utils.ApplicationContextProvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.revature.team2.project2.travelplanner.beans")
public class TravelPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelPlannerApplication.class, args);


		//! TESTING STUFF
		ApplicationContext context = ApplicationContextProvider.getApplicationContext();

		AdminRepository adminRepository = context.getBean(AdminRepository.class);
		UserRepository userRepository = context.getBean(UserRepository.class);
		ItineraryRepository itineraryRepository = context.getBean(ItineraryRepository.class);

		adminRepository.save(new Admin("jon", "gons", "jons", "pass"));
		userRepository.save(new User("billy", "bob", "bobilly", "yllibob"));

		itineraryRepository.save(new Itinerary("Joe", "Smith", "Marshall, TX", "Airplane",   1500));

		User steve = new User("steve", "steve", "steve", "steve");
		steve.addItinerary(itineraryRepository.getById(1));
		userRepository.save(steve);
	}

}

}
