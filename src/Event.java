public class Event implements Comparable<Event>{
    private Date date;
    private Timeslot startTime;
    private Location location;
    private Contact contact;
    private int duration;

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
