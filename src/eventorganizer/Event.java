package eventorganizer;

/**
 * This class represents an event with attributes including: date, timeslot, location,
 * contact information, and duration. This class contains methods for comparing events
 * based on these attributes using the equals() and compareTo() methods.
 * @author Jason Lei, Jerlin Yuen
 */

public class Event implements Comparable<Event>{
    private Date date; //event date
    private Timeslot startTime;
    private Location location;
    private Contact contact; //includes department name and email
    private int duration; //in minutes

    /**
     * Default constructor; no-args constructor
     * @author Jason Lei
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
     * Parameterized constructor
     * @param date - event date
     * @param startTime - starting time
     * @param location - classroom and campus
     * @author Jerlin Yuen
     */
    public Event(Date date, Timeslot startTime, Location location) {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
    }

    /**
     * Overloading constructor
     * @param date - event date
     * @param startTime - starting time
     * @param location - classroom and campus
     * @param contact - department and email
     * @param duration - time in minutes
     * @author Jason Lei
     */
    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration){
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }

    /**
     * Getter method (accessor)
     * @return date
     * @author Jason Lei
     */
    public Date getDate() {
        return date;
    }

    /**
     * Getter method (accessor)
     * @return startTime
     * @author Jason Lei
     */
    public Timeslot getStartTime() {
        return startTime;
    }

    /**
     * Getter method (accessor)
     * @return location
     * @author Jason Lei
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Getter method (accessor)
     * @return contact
     * @author Jason Lei
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * The equals() method determines if two dates, timeslots and locations of an event are equal.
     * @param obj - event
     * @return true, if two dates, timeslots, and locations are equal; false otherwise
     * @author Jason Lei
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

    /**
     * The compareTo() method first compares the dates of two events, then the timeslots if the dates are the same
     * @param event - specific event
     * @return 0 if the dates and timeslots are the same, 1 if a date/timeslot is larger than the other, -1 if a date/timeslot is smaller than the other
     * @author Jerlin Yuen
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
     * toString() returns a textual representation of an event
     * @return event in specific textual format
     * @author Jason Lei, Jerlin Yuen
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
     * Testbed main, as the driver to test public methods
     * @param args - input
     * @author Jason Lei
     */
    public static void main(String[] args) {
        testDiffDate();
        testDiffTime();
        testDiffLocation();
        testDiffDateTime();
        testAllEqual();
        testDiffDateLoc();
        testCompareTo();
    }

    /**
     * Test case #1 - two dates are different/not equal
     * @author Jason Lei
     */

    private static void testDiffDate(){
        Date date1 = new Date(2023, 11, 14);
        Date date2 = new Date(2023, 12, 15);
        Contact newContact = new Contact(Department.CS, "cs@rutgers.edu");
        Contact newContact2 = new Contact(Department.CS, "cs@rutgers.edu");

        Event event1 = new Event(date1, Timeslot.MORNING, Location.AB2225, newContact, 60);
        Event event2 = new Event(date2, Timeslot.MORNING, Location.AB2225, newContact2, 60);

        boolean expectedOutput = false;
        boolean actualOutput = event1.equals(event2);
        System.out.println("**Test case #1: two dates are different/not equal");
        testResult(event1, expectedOutput, actualOutput);
    }

    /**
     * Test case #2 - two timeslots are different/not equal
     * @author Jason Lei
     */

    private static void testDiffTime(){
        Date date1 = new Date(2023, 12, 15);
        Date date2 = new Date(2023, 12, 15);
        Contact newContact = new Contact(Department.CS, "cs@rutgers.edu");
        Contact newContact2 = new Contact(Department.CS, "cs@rutgers.edu");

        Event event1 = new Event(date1, Timeslot.MORNING, Location.AB2225, newContact, 60);
        Event event2 = new Event(date2, Timeslot.AFTERNOON, Location.AB2225, newContact2, 60);

        boolean expectedOutput = false;
        boolean actualOutput = event1.equals(event2);
        System.out.println("**Test case #2: two timeslots are different/not equal");
        testResult(event1, expectedOutput, actualOutput);
    }

    /**
     * Test case #3 - two locations are different/not equal
     * @author Jason Lei
     */

    private static void testDiffLocation(){
        Date date1 = new Date(2023, 12, 15);
        Date date2 = new Date(2023, 12, 15);
        Contact newContact = new Contact(Department.CS, "cs@rutgers.edu");
        Contact newContact2 = new Contact(Department.CS, "cs@rutgers.edu");

        Event event1 = new Event(date1, Timeslot.MORNING, Location.HLL114, newContact, 60);
        Event event2 = new Event(date2, Timeslot.MORNING, Location.AB2225, newContact2, 60);

        boolean expectedOutput = false;
        boolean actualOutput = event1.equals(event2);
        System.out.println("**Test case #3: two locations are different/not equal");
        testResult(event1, expectedOutput, actualOutput);
    }

    /**
     * Test case #4 - two dates and two timeslots are different/not equal
     * @author Jason Lei
     */

    private static void testDiffDateTime(){
        Date date1 = new Date(2023, 12, 15);
        Date date2 = new Date(2023, 11, 14);
        Contact newContact = new Contact(Department.CS, "cs@rutgers.edu");
        Contact newContact2 = new Contact(Department.CS, "cs@rutgers.edu");

        Event event1 = new Event(date1, Timeslot.MORNING, Location.AB2225, newContact, 60);
        Event event2 = new Event(date2, Timeslot.EVENING, Location.AB2225, newContact2, 60);

        boolean expectedOutput = false;
        boolean actualOutput = event1.equals(event2);
        System.out.println("**Test case #4: two dates and two timeslots are different/not equal");
        testResult(event1, expectedOutput, actualOutput);
    }

    /**
     * Test case #5 - two dates, two timeslots, and two locations are the same/equal
     * @author Jason Lei
     */
    private static void testAllEqual(){
        Date date1 = new Date(2023, 12, 15);
        Date date2 = new Date(2023, 12, 15);
        Contact newContact = new Contact(Department.CS, "cs@rutgers.edu");
        Contact newContact2 = new Contact(Department.CS, "cs@rutgers.edu");

        Event event1 = new Event(date1, Timeslot.MORNING, Location.AB2225, newContact, 60);
        Event event2 = new Event(date2, Timeslot.MORNING, Location.AB2225, newContact2, 60);

        boolean expectedOutput = true;
        boolean actualOutput = event1.equals(event2);
        System.out.println("**Test case #5: checks if two dates, timeslots, and locations are equal");
        testResult(event1, expectedOutput, actualOutput);
    }

    /**
     * Test case #6 - two dates and two locations are different/not equal
     */
    private static void testDiffDateLoc(){
        Date date1 = new Date(2023, 6, 23);
        Date date2 = new Date(2023, 4, 27);
        Contact newContact = new Contact(Department.CS, "cs@rutgers.edu");
        Contact newContact2 = new Contact(Department.CS, "cs@rutgers.edu");

        Event event1 = new Event(date1, Timeslot.MORNING, Location.AB2225, newContact, 60);
        Event event2 = new Event(date2, Timeslot.MORNING, Location.ARC103, newContact2, 60);

        boolean expectedOutput = false;
        boolean actualOutput = event1.equals(event2);
        System.out.println("**Test case #6: two dates and two locations are different/not equal");
        testResult(event1, expectedOutput, actualOutput);
    }

    /**
     * Test case #6 - compares dates, then compares timeslots if the dates are the same
     * @author Jason Lei
     */
    private static void testCompareTo(){
        Date date1 = new Date(2023, 12, 12);
        Date date2 = new Date(2023, 11, 12);
        Contact newContact = new Contact(Department.CS, "cs@rutgers.edu");
        Contact newContact2 = new Contact(Department.EE, "ee@rutgers.edu");

        Event event1 = new Event(date1, Timeslot.MORNING, Location.AB2225, newContact, 60);
        Event event2 = new Event(date2, Timeslot.MORNING, Location.AB2225, newContact2, 60);
        int expectedOutput = 1;
        int actualOutput = event1.compareTo(event2);
        System.out.println("**Test case #6: compares dates, then the timeslots if the dates are the same");
        testResult(event1, expectedOutput, actualOutput);
    }

    /**
     * testResult() overloaded method to test equals() method
     * @param event - specific event
     * @param expectedOutput - intended result
     * @param actualOutput - actual result
     * @author Jason Lei
     */
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
     * testResult() overloaded method to test compareTo() method
     * @param event - specific event
     * @param expectedOutput - intended result
     * @param actualOutput - actual result
     * @author Jason Lei
     */
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
