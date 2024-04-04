package com.example.nymbleassignment.Passenger;

import com.example.nymbleassignment.Activity;
import com.example.nymbleassignment.Destination;
import org.junit.Test;
import static org.junit.Assert.*;

public class StandardPassengerTest {

    @Test
    public void testSignUpForActivityWithSufficientBalance() {
        StandardPassenger standardPassenger = new StandardPassenger("Ritwik", 2, 100.0);
        Activity activity = new Activity("Sightseeing", "Mountains", 40.0, 6, new Destination("Shimla"));

        standardPassenger.signUpForActivity(activity);

        assertEquals(60.0, standardPassenger.getBalance(), 0.01);
        assertEquals(1, standardPassenger.getSignedUpActivities().size());
    }

    @Test
    public void testSignUpForActivityWithInsufficientBalance() {
        StandardPassenger standardPassenger = new StandardPassenger("Ritwik", 3, 30.0);
        Activity expensiveActivity = new Activity("Temples", "Different temples visit", 300.0, 4, new Destination("Manali"));

        standardPassenger.signUpForActivity(expensiveActivity);

        assertEquals(30.0, standardPassenger.getBalance(), 0.01);
        assertEquals(0, standardPassenger.getSignedUpActivities().size());
    }
}

