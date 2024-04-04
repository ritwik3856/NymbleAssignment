package com.example.nymbleassignment;

import lombok.Data;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a destination with a name and a list of activities available at that destination.
 */
@Data
public class Destination {
    private String name;
    private List<Activity> activities;

    /**
     * Constructs a new Destination with the specified name.
     *
     * @param name the name of the destination
     */
    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    /**
     * Retrieves the available activities at this destination.
     *
     * @return a list of available activities
     */
    public List<Activity> getAvailableActivities() {
        List<Activity> availableActivities = new ArrayList<>();
        for (Activity activity : activities) {
            if (activity.getCapacity() > 0) {
                availableActivities.add(activity);
            }
        }
        return availableActivities;
    }

    /**
     * Adds an activity to the list of activities available at this destination.
     *
     * @param activity the activity to add
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * Subtracts the capacity of the given activity from the destination's available capacity.
     *
     * @param activity the activity for which capacity needs to be subtracted
     */
    public void subtractCapacity(Activity activity) {
        Activity targetActivity = findActivity(activity.getName());
        if (targetActivity != null && targetActivity.getCapacity() > 0) {
            targetActivity.subtractCapacity();
        }
    }

    /**
     * Finds and returns the activity with the specified name.
     *
     * @param activityName the name of the activity to find
     * @return the activity if found, null otherwise
     */
    private Activity findActivity(String activityName) {
        for (Activity activity : activities) {
            if (activity.getName().equals(activityName)) {
                return activity;
            }
        }
        return null;
    }

    /**
     * Prints the list of activities available at this destination.
     */
    public void printActivities() {
        System.out.println("Activities at " + name + ":");
        for (Activity activity : activities) {
            System.out.println("  - " + activity.getName());
        }
    }
}
