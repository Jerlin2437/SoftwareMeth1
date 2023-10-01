import java.util.Objects;

/**
 * This class represents an event with attributes including: date, timeslot, location,
 * contact information, and duration. This class contains methods for comparing events
 * based on these attributes using the equals() and compareTo() methods.
 * @author Jason Lei
 * @author Jerlin Yuen
 */

public class Event implements Comparable<Event>{

    /**
     * Description
     * @param
     * @return
     * @author
     */
    private Date date;
    private Timeslot startTime;
    private Location location;
    private Contact contact;
    private int duration;

    /**
     * Description
     * @param
     * @return
     * @author
     */
    public Event(){
        //set initial values for the instance variables.
        date = null;
        startTime = null;
        location = null;
        contact = null;
        duration = 0;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public Event(Date date, Timeslot startTime, Location location) {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
    }

    /**
     * Description
     * @param
     * @return
     * @author
     */
    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration){
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public Date getDate() {
        return date;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public void setDate(Date date) {
        this.date = date;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public Timeslot getStartTime() {
        return startTime;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public void setStartTime(Timeslot startTime) {
        this.startTime = startTime;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public Location getLocation() {
        return location;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public void setLocation(Location location) {
        this.location = location;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public Contact getContact() {
        return contact;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public int getDuration() {
        return duration;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    //The equals() method returns true if two dates, timeslots and locations are equal.
    /**
     * Description
     * @param
     * @return
     * @author
     */
    @Override
    public boolean equals(Object obj){
        boolean sameDates = false;
        if (obj instanceof Event){
            Event event = (Event) obj;

            if (event.getDate().compareTo(this.date) == 0){
                sameDates = true;
            } else{
                sameDates = false;
            }

            return sameDates && event.getStartTime().equals(this.startTime)
                    && event.getLocation().equals(this.location);
        }
        return false;
    }

    //compare event date and timeslot
    /**
     * Description
     * @param
     * @return
     * @author
     */
    @Override
    public int compareTo(Event event) {
        if ((this.date.compareTo(event.date) > 0)){
            return 1;
        }
        if ((this.date.compareTo(event.date) < 0)){
            return -1;
        }
        if ((this.startTime.compareTo(event.startTime) > 0)){
            return 1;
        }
        if ((this.startTime.compareTo(event.startTime) < 0)){
            return -1;
        }
        return 0;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    @Override
    public String toString() {
        return "[Event Date: " + date + "] " +
                "[Start: " + startTime + "] " +
                "[End: " + startTime.toString(duration) + "] " +
                "@" + location +
                " [Contact: " + contact + "] ";
    }


    /**
     * Description
     * @param
     * @return
     * @author
     */
    public static void main(String[] args) {
        testEquals();
        testCompareTo();
    }

    /**
     * Test case #1
     * @param
     * @return
     * @author
     */

    private static void testEquals(){
        Date date1 = new Date(2023, 12, 15);
        Date date2 = new Date(2023, 12, 15);
        Contact newContact = new Contact(Department.CS, "cs@rutgers.edu");
        Contact newContact2 = new Contact(Department.CS, "cs@rutgers.edu");

        //check this, why false --> b/c dates don't compare right
        Event event1 = new Event(date1, Timeslot.MORNING, Location.AB2225, newContact, 60);
        Event event2 = new Event(date2, Timeslot.MORNING, Location.AB2225, newContact2, 60);

        boolean expectedOutput = true;
        boolean actualOutput = event1.equals(event2);
        System.out.println("**Test case #1: checks if two dates, timeslots, and locations are equal");
        testResult(event1, expectedOutput, actualOutput);
    }

    /**
     * Test case #2
     * @param
     * @return
     * @author
     */
    //The compareTo() method compares the dates first, then the timeslots if the dates are the same.
    private static void testCompareTo(){
        Date date1 = new Date(2023, 12, 12);
        Date date2 = new Date(2023, 11, 12);
        Contact newContact = new Contact(Department.CS, "cs@rutgers.edu");
        Contact newContact2 = new Contact(Department.EE, "ee@rutgers.edu");

        Event event1 = new Event(date1, Timeslot.MORNING, Location.AB2225, newContact, 60);
        Event event2 = new Event(date2, Timeslot.MORNING, Location.AB2225, newContact2, 60);
        int expectedOutput = 1;
        int actualOutput = event1.compareTo(event2);
        System.out.println("**Test case #2: compares dates, then the timeslots if the dates are the same");
        testResult(event1, expectedOutput, actualOutput);
    }

    /**
     * Description
     * @param
     * @return
     * @author
     */
    //to test equals method
    private static void testResult(Event event, boolean expectedOutput, boolean actualOutput){
        System.out.println("Test input: " + event.toString());
        System.out.println("Expected output: " + expectedOutput);
        System.out.println("Actual output: " + actualOutput);
        if (expectedOutput != actualOutput){
            System.out.println(" (FAIL \n");
        } else{
            System.out.println(" (PASS) \n");
        }
    }

    /**
     * Description
     * @param
     * @return
     * @author
     */
    //to test compareTo method
    private static void testResult(Event event, int expectedOutput, int actualOutput){
        System.out.println("Test input: " + event.toString());
        System.out.println("Expected output: " + expectedOutput);
        System.out.println("Actual output: " + actualOutput);
        if (expectedOutput != actualOutput){
            System.out.println(" (FAIL \n");
        } else{
            System.out.println(" (PASS) \n");
        }
    }

}
