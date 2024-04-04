package com.example.nymbleassignment.Passenger;

import com.example.nymbleassignment.Activity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * The base implementation class of the Passenger interface.
 * <p>
 * This class provides base implementations of common methods required by all types of passengers,
 * reducing redundancy of code across different passenger implementations.
 */
@Data
public class PassengerImpl implements Passenger {
    private String name;
    private int passengerNumber;
    private double balance;
    private List<Activity> signedUpActivities;

    /**
     * Constructs a new Passenger with the specified name, passenger number, and balance.
     *
     * @param name           the name of the passenger
     * @param passengerNumber the unique passenger number assigned to the passenger
     * @param balance        the current balance of the passenger
     */
    public PassengerImpl(String name, int passengerNumber, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.signedUpActivities = new ArrayList<>();
    }

    /**
     * Signs up the passenger for the specified activity.
     *
     * @param activity the activity to sign up for
     */
    @Override
    public void signUpForActivity(Activity activity) {
        if (activity.getCapacity() > 0) {
            signedUpActivities.add(activity);
            activity.getDestination().subtractCapacity(activity);
        } else {
            System.out.println("Cannot sign up for " + activity.getName() + ". Activity is full.");
        }
    }

    /**
     * Prints details of the passenger including name, passenger number, balance, and signed up activities.
     */
    @Override
    public void printDetails() {
        System.out.println("Passenger: " + name + " (Number: " + passengerNumber + ")");
        if (balance >= 0) {
            System.out.println("Balance: Rs" + balance);
        }

        if (!signedUpActivities.isEmpty()) {
            System.out.println("Signed Up Activities:");
            for (Activity activity : signedUpActivities) {
                System.out.println("- " + activity.getName() + " at " + activity.getDestination().getName() +
                        " (Cost: Rs" + activity.getCost() + ")");
            }
        } else {
            System.out.println("No activities signed up.");
        }
    }

    /**
     * Deducts the specified amount from the passenger's balance.
     *
     * @param amount the amount to deduct from the balance
     */
    @Override
    public void deductBalance(double amount) {
        balance -= amount;
    }
}
