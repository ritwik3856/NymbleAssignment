package com.example.nymbleassignment.Passenger;

import com.example.nymbleassignment.Activity;
import com.example.nymbleassignment.Destination;
import org.junit.Test;
import static org.junit.Assert.*;

public class GoldPassengerTest {

    @Test
    public void testSignUpForActivityWithSufficientBalance() {
        GoldPassenger goldPassenger = new GoldPassenger("Ritwik", 4, 150.0);
        Activity activity = new Activity("trekking", "moutanins view", 50.0, 8, new Destination("Manali"));

        goldPassenger.signUpForActivity(activity);

        assertEquals(105.0, goldPassenger.getBalance(), 0.01);
        assertEquals(1, goldPassenger.getSignedUpActivities().size());
    }

    @Test
    public void testSignUpForActivityWithInsufficientBalance() {
        GoldPassenger goldPassenger = new GoldPassenger("Rohit", 3, 40.0);
        Activity expensiveActivity = new Activity("skiing", "skking in the moutanins", 500.0, 2, new Destination("Shimla"));

        goldPassenger.signUpForActivity(expensiveActivity);

        assertEquals(40.0, goldPassenger.getBalance(), 0.01);
        assertEquals(0, goldPassenger.getSignedUpActivities().size());
    }

}

