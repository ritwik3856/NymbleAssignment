import java.util.ArrayList;
import java.util.List;

public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;
    private List<Passenger> signedUpPassengers;

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        destination.addActivity(this);
        this.signedUpPassengers = new ArrayList<>();
    }

    public boolean signUpPassenger(Passenger passenger) {
        if (hasAvailableSpace()) {
            if (!signedUpPassengers.contains(passenger)) {
                signedUpPassengers.add(passenger);
                return true;
            } else {
                System.out.println("Passenger is already signed up for this activity.");
            }
        } else {
            System.out.println("Activity is at full capacity.");
        }
        return false;
    }

    public boolean cancelSignUp(Passenger passenger) {
        if (signedUpPassengers.contains(passenger)) {
            signedUpPassengers.remove(passenger);
            return true;
        } else {
            System.out.println("Passenger is not signed up for this activity.");
            return false;
        }
    }

    public boolean hasAvailableSpace() {
        return signedUpPassengers.size() < capacity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public Destination getDestination() {
        return destination;
    }

    public List<Passenger> getSignedUpPassengers() {
        return signedUpPassengers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void setSignedUpPassengers(List<Passenger> signedUpPassengers) {
        this.signedUpPassengers = signedUpPassengers;
    }
}
