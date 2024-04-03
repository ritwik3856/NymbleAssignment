import java.util.ArrayList;
import java.util.List;

/**
 * Represents a passenger who can sign up for activities.
 */
public class Passenger {

    /**
     * Enumeration representing types of passengers.
     */
    public enum PassengerType {
        STANDARD, // Standard passenger type.
        GOLD,     // Gold passenger type.
        PREMIUM   // Premium passenger type.
    }

    private String name;                 // Name of the passenger.
    private int passengerNumber;         // Unique passenger number.
    private PassengerType passengerType; // Type of the passenger.
    private double balance;              // Balance of the passenger.
    private List<Activity> signedUpActivities; // List of activities the passenger is signed up for.

    /**
     * Constructor to initialize a Passenger object with provided details.
     *
     * @param name           Name of the passenger.
     * @param passengerNumber Unique passenger number.
     * @param passengerType  Type of the passenger.
     */
    public Passenger(String name, int passengerNumber, PassengerType passengerType) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.passengerType = passengerType;
        this.signedUpActivities = new ArrayList<>();
    }

    /**
     * Method to sign up the passenger for an activity.
     *
     * @param activity The activity to sign up for.
     * @return True if the sign-up is successful, false otherwise.
     */
    public boolean signUpForActivity(Activity activity) {
        if (passengerType == PassengerType.PREMIUM) {
            signedUpActivities.add(activity);
            return true;
        } else if (passengerType == PassengerType.GOLD || passengerType == PassengerType.STANDARD) {
            double cost = activity.getCost();
            if (passengerType == PassengerType.GOLD) {
                cost -= (cost * 0.10);
            }
            if (balance >= cost) {
                balance -= cost;
                signedUpActivities.add(activity);
                return true;
            } else {
                System.out.println("Failed to sign up for activity due to insufficient balance.");
                return false;
            }
        } else {
            System.out.println("Invalid passenger type.");
            return false;
        }
    }

    /**
     * Method to print details of the passenger.
     */
    public void printDetails() {
        System.out.println("Passenger Name: " + name);
        System.out.println("Passenger Number: " + passengerNumber);
        if (passengerType == PassengerType.STANDARD || passengerType == PassengerType.GOLD) {
            System.out.println("Balance: Rs" + balance);
        }
        System.out.println("Activities Signed Up:");
        for (Activity activity : signedUpActivities) {
            double pricePaid = activity.getCost();
            if (passengerType == PassengerType.GOLD) {
                pricePaid *= 0.90;
            } else if (passengerType == PassengerType.PREMIUM) {
                pricePaid = 0;
            }
            System.out.println("Destination: " + activity.getDestination().getName() + ", Activity: " + activity.getName() + ", Price Paid: Rs" + pricePaid);
        }
    }

    /**
     * Method to cancel sign-up for an activity.
     *
     * @param activity The activity to cancel sign-up for.
     * @return True if cancellation is successful, false otherwise.
     */
    public boolean cancelActivitySignUp(Activity activity) {
        if (signedUpActivities.contains(activity)) {
            if (activity.cancelSignUp(this)) {
                signedUpActivities.remove(activity);
                return true;
            }
        }
        System.out.println("Failed to cancel sign up for activity.");
        return false;
    }

    /**
    *  Getter and setter methods 
    */
    public String getName() {
        return name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public double getBalance() {
        return balance;
    }

    public List<Activity> getSignedUpActivities() {
        return signedUpActivities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setSignedUpActivities(List<Activity> signedUpActivities) {
        this.signedUpActivities = signedUpActivities;
    }

}
