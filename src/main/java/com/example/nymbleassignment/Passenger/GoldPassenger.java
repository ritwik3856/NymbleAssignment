package com.example.nymbleassignment.Passenger;

import com.example.nymbleassignment.Activity;

/**
 * GoldPassenger represents a type of passenger with additional benefits, such as discounts on activities.
 */
public class GoldPassenger extends PassengerImpl {

    /**
     * Constructs a new GoldPassenger with the specified name, passenger number, and balance.
     *
     * @param name           the name of the gold passenger
     * @param passengerNumber the unique passenger number assigned to the gold passenger
     * @param balance        the current balance of the gold passenger
     */
    public GoldPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber, balance);
    }

    /**
     * Signs up the gold passenger for an activity with a discount applied.
     * <p>
     * Gold Passengers receive a 10% discount on activity costs.
     *
     * @param activity the activity to sign up for
     */
    public void signUpForActivity(Activity activity) {
        // Applying 10% discount
        double discountedCost = activity.getCost() * 0.9;
        if (getBalance() >= discountedCost) {
            super.signUpForActivity(activity);
            deductBalance(discountedCost);
        } else {
            System.out.println("Cannot sign up for " + activity.getName() + ". Insufficient balance.");
        }
    }
}
