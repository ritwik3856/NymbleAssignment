package com.example.nymbleassignment;

import org.junit.Test;
import static org.junit.Assert.*;

public class ActivityTest {

    @Test
    public void testActivityAssociatedWithOneDestination() {
        Destination destination1 = new Destination("City A");
        Destination destination2 = new Destination("City B");

        Activity activity = new Activity("City Tour", "Explore the city", 25.0, 20, destination1);

        assertEquals(destination1, activity.getDestination());

        // Attempt to associate the activity with another destination
        activity.setDestination(destination2);

        // Now, the destination should be the second destination
        assertEquals(destination2, activity.getDestination());
    }

    @Test
    public void testGetName() {
        Destination destination = new Destination("Manali");
        Activity activity = new Activity("City Tour", "Explore the city", 300.0, 10, destination);
        assertEquals("City Tour", activity.getName());
    }

    @Test
    public void testGetCost() {
        Destination destination = new Destination("Shimla");
        Activity activity = new Activity("Snow Mountains", "Hiking on the mountains", 300.0, 20, destination);
        assertEquals(300.0, activity.getCost(), 0.001);
    }

    @Test
    public void testGetCapacity() {
        Destination destination = new Destination("Kedarkantha");
        Activity activity = new Activity("trekking", "Cross the mountains and trek to the peak", 7000.0, 25, destination);
        assertEquals(25, activity.getCapacity());
    }
}

