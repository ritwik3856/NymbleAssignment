package com.example.nymbleassignment.Passenger;

import com.example.nymbleassignment.Activity;

/**
 * Represents a premium passenger who can sign up for activities without any cost or balance deduction.
 */
public class PremiumPassenger extends PassengerImpl {

    /**
     * Constructs a new PremiumPassenger with the specified name and passenger number.
     *
     * @param name           the name of the premium passenger
     * @param passengerNumber the unique passenger number assigned to the premium passenger
     */
    public PremiumPassenger(String name, int passengerNumber) {
        super(name, passengerNumber, 0); // Premium passengers start with zero balance
    }

    /**
     * Signs up the premium passenger for the specified activity.
     * <p>
     * Premium passengers can sign up for activities free of charge, and there will be no balance deduction.
     *
     * @param activity the activity to sign up for
     */
    @Override
    public void signUpForActivity(Activity activity) {
        super.signUpForActivity(activity); // Calls the base implementation to sign up for the activity
    }
}
