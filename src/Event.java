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
        if (obj instanceof Event){
            Event event = (Event) obj;
            return event.date.equals(this.date) && event.startTime.equals(this.startTime)
                    && event.location.equals(this.location);
        }
        return false;
    }
    @Override
    public int compareTo(Event o) {
        return 0;
    }

    /**
     * Parameterized constructor
     * @param date
     * @param startTime
     * @param location
     */
    public Event(Date date, Timeslot startTime, Location location){
        this.date = date;
        this.startTime = startTime;
        this.location = location;
    }
    public static void main(String[] args) {

    }

}
