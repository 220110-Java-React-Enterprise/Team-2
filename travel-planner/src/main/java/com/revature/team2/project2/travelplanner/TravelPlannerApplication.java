package com.revature.team2.project2.travelplanner;

import com.revature.team2.project2.travelplanner.beans.models.Admin;
import com.revature.team2.project2.travelplanner.beans.models.Itinerary;
import com.revature.team2.project2.travelplanner.beans.models.User;
import com.revature.team2.project2.travelplanner.beans.models.User_Itinerary;
import com.revature.team2.project2.travelplanner.beans.repositories.AdminRepository;
import com.revature.team2.project2.travelplanner.beans.repositories.ItineraryRepository;
import com.revature.team2.project2.travelplanner.beans.repositories.UserItineraryRepository;
import com.revature.team2.project2.travelplanner.beans.repositories.UserRepository;
import com.revature.team2.project2.travelplanner.beans.utils.ApplicationContextProvider;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.revature.team2.project2.travelplanner.beans")
public class TravelPlannerApplication {

  public static void main(String[] args) {
    SpringApplication.run(TravelPlannerApplication.class, args);

    // ! TESTING STUFF
    ApplicationContext context = ApplicationContextProvider.getApplicationContext();

    AdminRepository adminRepository = context.getBean(AdminRepository.class);
    UserRepository userRepository = context.getBean(UserRepository.class);
    ItineraryRepository itineraryRepository = context.getBean(ItineraryRepository.class);
    UserItineraryRepository userItineraryRepository = context.getBean(UserItineraryRepository.class);
    // userItineraryRepository = context.getBean(UserItineraryRepository.class);

    adminRepository.save(new Admin("jon", "gons", "jons", "pass"));

    userRepository.save(new User("billy", "bob", "bobilly@billy.bob", "yllibob"));

    itineraryRepository.save(new Itinerary("Marshall, TX", "Airplane", 1500));

    User steve = new User("steve", "steve", "steve@steve.steve", "steve");
    userRepository.save(steve);
    steve.addItinerary(itineraryRepository.getById(1));
    userRepository.save(steve);

    // localhost:8080/api/convert?want=EUR&have=USD&amount=5

    ArrayList<User> L = (ArrayList<User>) userRepository.findAll();

    for (int l = 0; l < L.size(); l++) {
      User u = L.get(l);
      System.out.println(u);
      log(u.getUser_id());
    }

    log("_");
    Itinerary a = itineraryRepository.getById(1);
    log("_");
    ArrayList<Itinerary> I = (ArrayList<Itinerary>) itineraryRepository.findAll();

    for (int i = 0; i < I.size(); i++) {
      Itinerary u = I.get(i);
      System.out.println(u);
      log(u.getDestination());
    }

    ArrayList<User_Itinerary> U = (ArrayList<User_Itinerary>) userItineraryRepository.findAll();
    log(U.size());
    for (int i = 0; i < U.size(); i++) {
      User_Itinerary u = U.get(i);
      System.out.println(u);
      log(u.getItineraries_itinerary_id() + "   " + u.getUser_user_id());
      log(u.getUser());
      log(u.getItinerary());
      log("" + u.getItinerary().getItinerary_id() + "  " + (a.getItinerary_id()));
      log(">>> " + u.getItinerary().equals(itineraryRepository.getById(1)));
      log(u.getItinerary());
      log(">>" + u.getUser().equals(steve));
    }
  }

  public static void log(String msg) {
    System.out.println(msg);
  }

  public static void log(Object o) {
    System.out.println(o.toString());
  }

}
