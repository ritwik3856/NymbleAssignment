package com.example.nymbleassignment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an activity that can be included in a travel package.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;

    /**
     * Subtracts one from the capacity of the activity.
     * If the capacity is already zero, no action is taken.
     */
    public void subtractCapacity() {
        if (capacity > 0) {
            capacity--;
        }
    }
}
