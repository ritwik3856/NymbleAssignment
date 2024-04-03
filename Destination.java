import java.util.ArrayList;
import java.util.List;

/**
 * Represents a destination where activities can take place.
 */
public class Destination {
    private String name; // Name of the destination.
    private List<Activity> activities; // List of activities available at the destination.

    /**
     * Constructor to initialize the Destination object with provided name.
     *
     * @param name Name of the destination.
     */
    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>(); // Initialize the list of activities.
    }

    /**
     * Method to add an activity to the destination.
     *
     * @param activity Activity to be added.
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * Method to remove an activity from the destination.
     *
     * @param activity Activity to be removed.
     */
    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     *  Getter and setter methods 
     */
    public String getName() {
        return name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
