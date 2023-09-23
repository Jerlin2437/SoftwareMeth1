public class EventCalendar {
    private Event [] events;
    private int numEvents;
    private int find(Event event){
        for (int x = 0; x < numEvents; x++){
            if (events[x].equals(event))
                return x;
        }
        return -1;
    }

    public EventCalendar(Event[] events, int numEvents) {
        this.events = events;
        this.numEvents = numEvents;
    }

    private void grow() {
        this.events = new Event[this.events.length + 4];
    }
    public boolean add(Event event){
        return false;
    }
    public boolean remove(Event event){
        return false;
    }
    public boolean contains(Event event){
        return false;
    }
    public void print(){}
    public void printByDate(){}
    public void printByCampus(){}
    public void printByDepartment(){}
}
