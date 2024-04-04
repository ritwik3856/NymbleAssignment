package com.example.nymbleassignment.Passenger;

import com.example.nymbleassignment.Activity;
import com.example.nymbleassignment.Destination;
import org.junit.Test;
import static org.junit.Assert.*;

public class PremiumPassengerTest {

    @Test
    public void testSignUpForActivity() {
        PremiumPassenger premiumPassenger = new PremiumPassenger("Rahul", 5);
        Activity activity = new Activity("Rafting", "raft through the high waves", 40.0, 10, new Destination("Rishikesh"));

        premiumPassenger.signUpForActivity(activity);

        assertEquals(0.0, premiumPassenger.getBalance(), 0.01);
        assertEquals(1, premiumPassenger.getSignedUpActivities().size());
    }
}

