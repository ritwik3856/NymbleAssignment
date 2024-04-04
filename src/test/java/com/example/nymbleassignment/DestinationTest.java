package com.example.nymbleassignment;

import org.junit.Test;
import static org.junit.Assert.*;

public class DestinationTest {

    @Test
    public void testAddActivity() {
        Destination destination = new Destination("Rishikesh");
        Activity activity = new Activity("Giant Swing", "Enjoy with the 200 m swing", 3500.0, 5, destination);
        destination.addActivity(activity);
        assertEquals(1, destination.getActivities().size());
    }

    @Test
    public void testGetAvailableActivities() {
        Destination destination = new Destination("Manali");
        Activity activity1 = new Activity("Skiing", "ski through the moutanins", 200.0, 2, destination);
        Activity activity2 = new Activity("tube ride", "Ride the slope of mountain", 40.0, 0, destination);
        destination.addActivity(activity1);
        destination.addActivity(activity2);
        assertEquals(1, destination.getAvailableActivities().size());
    }
}
