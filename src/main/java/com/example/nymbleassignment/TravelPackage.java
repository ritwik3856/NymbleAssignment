package com.example.nymbleassignment;

import com.example.nymbleassignment.Passenger.PassengerImpl;
import lombok.Data;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a travel package that includes destinations, activities, and passengers.
 */
@Data
public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<PassengerImpl> passengers;

    /**
     * Constructs a new TravelPackage with the specified name and passenger capacity.
     *
     * @param name             the name of the travel package
     * @param passengerCapacity the maximum number of passengers allowed in the travel package
     */
    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    /**
     * Adds a destination to the itinerary of the travel package.
     *
     * @param destination the destination to add
     */
    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    /**
     * Adds a passenger to the list of passengers enrolled in the travel package.
     * If the travel package is already full, the passenger cannot be added.
     *
     * @param passenger the passenger to add
     */
    public void addPassenger(PassengerImpl passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
        } else {
            System.out.println("Cannot add passenger. Travel package is full.");
        }
    }

    /**
     * Prints the itinerary of the travel package including destinations and their activities.
     */
    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            destination.printActivities();
        }
    }

    /**
     * Prints the list of passengers enrolled in the travel package.
     * It also includes information about the passenger capacity and the number of passengers enrolled.
     */
    public void printPassengerList() {
        System.out.println("Passenger List for Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        for (PassengerImpl passenger : passengers) {
            System.out.println("Passenger: " + passenger.getName() + " (Number: " + passenger.getPassengerNumber() + ")");
        }
    }

    /**
     * Prints the details of available activities in the travel package.
     * It includes activities at each destination along with the available capacity.
     */
    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                if (activity.getCapacity() > 0) {
                    System.out.println("- " + activity.getName() + " at " + destination.getName() +
                            " (Spaces Available: " + activity.getCapacity() + ")");
                }
            }
        }
    }
}
