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
                "[End: " + startTime + duration + "] " +
                "@" + location +
                " [Contact: " + contact + "] ";
    }
}
