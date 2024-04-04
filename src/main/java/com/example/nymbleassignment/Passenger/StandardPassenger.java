package com.example.nymbleassignment.Passenger;

import com.example.nymbleassignment.Activity;

/**
 * Represents a standard passenger who can sign up for activities if they have sufficient balance and the activity has sufficient capacity.
 */
public class StandardPassenger extends PassengerImpl {

    /**
     * Constructs a new StandardPassenger with the specified name, passenger number, and balance.
     *
     * @param name           the name of the standard passenger
     * @param passengerNumber the unique passenger number assigned to the standard passenger
     * @param balance        the current balance of the standard passenger
     */
    public StandardPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber, balance);
    }

    /**
     * Signs up the standard passenger for the specified activity.
     * <p>
     * Standard passengers can sign up for activities if they have sufficient balance and if the activity has sufficient capacity.
     * If the conditions are met, the balance is deducted by the activity cost.
     *
     * @param activity the activity to sign up for
     */
    @Override
    public void signUpForActivity(Activity activity) {
        if (getBalance() >= activity.getCost()) {
            super.signUpForActivity(activity); // Calls the base implementation to sign up for the activity
            deductBalance(activity.getCost()); // Deducts the activity cost from the balance
        } else {
            System.out.println("Cannot sign up for " + activity.getName() + ". Insufficient balance.");
        }
    }
}
