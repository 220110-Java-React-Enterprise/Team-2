package com.revature.team2.project2.travelplanner;

import com.revature.team2.project2.travelplanner.beans.models.Admin;
import com.revature.team2.project2.travelplanner.beans.models.User;
import com.revature.team2.project2.travelplanner.beans.repositories.AdminRepository;
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

		adminRepository.save(new Admin("jon", "gons", "jons", "pass"));
		userRepository.save(new User("billy", "bob", "bobilly", "yllibob"));
	}

}
