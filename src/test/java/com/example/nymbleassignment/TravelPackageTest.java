package com.example.nymbleassignment;

import com.example.nymbleassignment.Passenger.PassengerImpl;
import org.junit.Test;
import static org.junit.Assert.*;

public class TravelPackageTest {

    @Test
    public void testAddDestination() {
        TravelPackage travelPackage = new TravelPackage("Himalayas Trip", 20);
        Destination destination = new Destination("Manali");
        travelPackage.addDestination(destination);
        assertEquals(1, travelPackage.getItinerary().size());
    }

    @Test
    public void testAddPassenger() {
        TravelPackage travelPackage = new TravelPackage("Mountains Adventure", 10);
        PassengerImpl passenger = new PassengerImpl("Ritwik", 1, 2000);
        travelPackage.addPassenger(passenger);
        assertEquals(1, travelPackage.getPassengers().size());
    }

    @Test
    public void testAddPassengerInSufficientCapacity() {
        TravelPackage travelPackage = new TravelPackage("Mountains Adventure", 0);
        PassengerImpl passenger = new PassengerImpl("Ritwik", 1, 2000);
        travelPackage.addPassenger(passenger);
        assertEquals(0, travelPackage.getPassengers().size());
    }
}

