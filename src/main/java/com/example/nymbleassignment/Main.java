package com.example.nymbleassignment;


import com.example.nymbleassignment.Passenger.*;


import com.example.nymbleassignment.Passenger.GoldPassenger;
import com.example.nymbleassignment.Passenger.PremiumPassenger;
import com.example.nymbleassignment.Passenger.StandardPassenger;

public class Main {
    public static void main(String[] args) {
        // Created a travel package
        TravelPackage travelPackage = createTravelPackage();

        // Add passengers to the travel package
        addPassengers(travelPackage);

        // Print itinerary
        printSectionHeader("Itinerary of the travel package");
        travelPackage.printItinerary();
        System.out.println();

        // Print passenger list
        printSectionHeader("Passenger list of the travel package");
        travelPackage.printPassengerList();
        System.out.println();

        // Perform sign-up for activities
        performActivitySignUp(travelPackage);

        // Print details after sign-up
        printSectionHeader("Details of individual passengers after sign-up");
        printPassengerDetails(travelPackage);

        // Print details of available activities
        printSectionHeader("Details of available activities");
        travelPackage.printAvailableActivities();
    }

    private static TravelPackage createTravelPackage() {
        TravelPackage travelPackage = new TravelPackage("Adventures Vacation", 20);

        // Create destinations
        Destination manali = new Destination("Manali");
        Destination shimla = new Destination("Shimla");

        // Create activities
        Activity templeVisit = new Activity("Temples Visit", "visit different temples", 300.0, 5, manali);
        Activity skiing = new Activity("Skiing", "Skiing between the moutains", 500.0, 8, shimla);

        // Add activities to destinations
        manali.addActivity(templeVisit);
        shimla.addActivity(skiing);

        // Add destinations to the travel package
        travelPackage.addDestination(manali);
        travelPackage.addDestination(shimla);

        return travelPackage;
    }

    private static void addPassengers(TravelPackage travelPackage) {
        // Create passengers
        StandardPassenger standardPassenger = new StandardPassenger("Ritwik", 1, 1500.0);
        GoldPassenger goldPassenger = new GoldPassenger("Rohit", 2, 2000.0);
        PremiumPassenger premiumPassenger = new PremiumPassenger("Rahul", 3);

        // Add passengers to the travel package
        travelPackage.addPassenger(standardPassenger);
        travelPackage.addPassenger(goldPassenger);
        travelPackage.addPassenger(premiumPassenger);
    }

    private static void performActivitySignUp(TravelPackage travelPackage) {
        // Perform sign-up for activities
        StandardPassenger standardPassenger = (StandardPassenger) travelPackage.getPassengers().get(0);
        GoldPassenger goldPassenger = (GoldPassenger) travelPackage.getPassengers().get(1);
        PremiumPassenger premiumPassenger = (PremiumPassenger) travelPackage.getPassengers().get(2);

        standardPassenger.signUpForActivity(travelPackage.getItinerary().get(0).getActivities().get(0));
        goldPassenger.signUpForActivity(travelPackage.getItinerary().get(1).getActivities().get(0));
        premiumPassenger.signUpForActivity(travelPackage.getItinerary().get(0).getActivities().get(0));
    }

    private static void printPassengerDetails(TravelPackage travelPackage) {
        for (Passenger passenger : travelPackage.getPassengers()) {
            passenger.printDetails();
            System.out.println();
        }
    }

    private static void printSectionHeader(String header) {
        System.out.println("----------------- " + header + " ----------------------");
    }
}



