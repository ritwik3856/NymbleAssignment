package com.example.nymbleassignment.Passenger;

import com.example.nymbleassignment.Activity;


/**
 * The interface defining operations for different types of passengers.
 * <p>
 * Passengers can belong to one of three types:
 * <ol>
 *     <li>Standard Passenger</li>
 *     <li>Gold Passenger</li>
 *     <li>Premium Passenger</li>
 * </ol>
 * Each type of passenger may have different logic for signing up to activities.
 * By defining this interface, common methods for all passenger types can be declared.
 */
public interface Passenger {
    void signUpForActivity(Activity activity);
    void printDetails();
    void deductBalance(double amount);
}
