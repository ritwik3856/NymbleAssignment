import java.util.ArrayList;
import java.util.List;

/**
 * Represents a travel package that includes destinations and activities for passengers.
 */
public class TravelPackage {
    private String name; // Name of the travel package.
    private int passengerCapacity; // Maximum number of passengers allowed in the travel package.
    private List<Destination> itinerary; // List of destinations in the travel package.
    private List<Passenger> passengers; // List of passengers enrolled in the travel package.

    /**
     * Constructor to initialize a TravelPackage object with provided details.
     *
     * @param name             Name of the travel package.
     * @param passengerCapacity Maximum number of passengers allowed in the travel package.
     */
    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    /**
     * Method to print the itinerary of the travel package.
     */
    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            List<Activity> activities = destination.getActivities();
            for (Activity activity : activities) {
                System.out.println("Activity: " + activity.getName());
                System.out.println("Description: " + activity.getDescription());
                System.out.println("Cost: " + activity.getCost());
                System.out.println("Capacity: " + activity.getCapacity());
            }
        }
    }

    /**
     * Method to print the list of passengers enrolled in the travel package.
     */
    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("Name: " + passenger.getName() + ", Number: " + passenger.getPassengerNumber());
        }
    }

    /**
     * Method to print available activities in the travel package.
     */
    public void printAvailableActivities() {
        System.out.println("Travel Package: " + name);
        System.out.println("Available Activities:");
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                if (activity.hasAvailableSpace()) {
                    int availableSpaces = activity.getCapacity() - activity.getSignedUpPassengers().size();
                    System.out.println("Destination: " + destination.getName() + ", Activity: " + activity.getName() + ", Description: " + activity.getDescription() + ", Cost: " + activity.getCost() + ", Spaces Available: " + availableSpaces);
                }
            }
        }
    }

    /**
     * Method to add a passenger to the travel package.
     *
     * @param passenger The passenger to be added.
     */
    public void addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
        } else {
            System.out.println("Travel package is at full capacity.");
        }
    }

    /**
     * Method to remove a passenger from the travel package.
     *
     * @param passenger The passenger to be removed.
     */
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }


    /**
    *  Getter and setter methods 
    */
    public String getName() {
        return name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void setItinerary(List<Destination> itinerary) {
        this.itinerary = itinerary;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
