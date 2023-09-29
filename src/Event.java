import java.util.Objects;

public class Event implements Comparable<Event>{
    private Date date;
    private Timeslot startTime;
    private Location location;
    private Contact contact;
    private int duration;

    /**
    * default constructor; no-args constructor
    * */
    public Event(){
        //set initial values for the instance variables.
        date = null;
        startTime = null;
        location = null;
        contact = null;
        duration = 0;
    }

    public Event(Date date, Timeslot startTime, Location location) {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
    }

    // A 10/21/2023 afternoon hll114 cs cs@rutgers.edu 60
    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration){
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timeslot getStartTime() {
        return startTime;
    }

    public void setStartTime(Timeslot startTime) {
        this.startTime = startTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Event event){
            return event.getDate().equals(this.date) && event.getStartTime().equals(this.startTime)
                    && event.getLocation().equals(this.location);
        }
        return false;
    }
    //compare event date and timeslot
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

    @Override
    public String toString() {
        return "[Event Date: " + date + "] " +
                "[Start: " + startTime + "] " +
                "[End: " + startTime.toString(duration) + "] " +
                "@" + location +
                " [Contact: " + contact + "] ";
    }

    /**
     * The equals() method returns true if two dates, timeslots and locations are equal.
     * The compareTo() method compares the dates first, then the timeslots if the dates are the same.
     */

    public static void main(String[] args) {
        testEquals();
        testCompareTo();
    }

    /** Test case #1 */
    private static void testEquals(){
        Date date1 = new Date(2023, 12, 12);
        Date date2 = new Date(2023, 12, 12);

        //check this, why false...
        Event event1 = new Event(date1, Timeslot.MORNING, Location.AB2225);
        Event event2 = new Event(date2, Timeslot.MORNING, Location.AB2225);

        boolean expectedOutput = true;
        boolean actualOutput = event1.equals(event2);
        System.out.println("**Test case #1: checks if two dates, timeslots, and locations are equal");
        testResult(event1, expectedOutput, actualOutput);
    }

    /** Test case #2 */
    //The compareTo() method compares the dates first, then the timeslots if the dates are the same.
    private static void testCompareTo(){
        Date date1 = new Date(2023, 12, 12);
        Date date2 = new Date(2023, 12, 12);

        Event event1 = new Event(date1, Timeslot.MORNING, Location.AB2225);
        Event event2 = new Event(date2, Timeslot.MORNING, Location.AB2225);
        int expectedOutput = 0;
        int actualOutput = event1.compareTo(event2);
        System.out.println("**Test case #2: compares dates, then the timeslots if the dates are the same");
        testResult(event1, expectedOutput, actualOutput);
    }

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
