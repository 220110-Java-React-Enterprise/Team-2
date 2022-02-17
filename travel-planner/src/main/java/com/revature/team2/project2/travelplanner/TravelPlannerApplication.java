package com.revature.team2.project2.travelplanner;

import com.revature.team2.project2.travelplanner.beans.models.Admin;
import com.revature.team2.project2.travelplanner.beans.models.Thing;
import com.revature.team2.project2.travelplanner.beans.repositories.AdminRepository;
import com.revature.team2.project2.travelplanner.beans.repositories.UsersRepository;
import com.revature.team2.project2.travelplanner.beans.utils.ApplicationContextProvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.revature.team2.project2.travelplanner.beans")
public class TravelPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelPlannerApplication.class, args);


		//! TESTING STUFF
		Thing thing = new Thing();
		System.out.println("thing's id: " + thing.getId());

		ApplicationContext context = ApplicationContextProvider.getApplicationContext();

		AdminRepository adminRepository = context.getBean(AdminRepository.class);
		UsersRepository usersRepository = context.getBean(UsersRepository.class);

		adminRepository.save(new Admin("jon", "gons", "jons", "pass"));
	}

}
