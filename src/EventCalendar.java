public class EventCalendar {
    private Event [] events;
    private int numEvents;

    private final int NOT_FOUND = -1;

    private int capacity = 4;
    private int size = 0;

    private int find(Event event){
        for (int x = 0; x < numEvents; x++){
            if (events[x].equals(event))
                return x;
        }
        return NOT_FOUND;
    }

    public EventCalendar(Event[] events, int numEvents) {
        this.events = events;
        this.numEvents = numEvents;
    }

    private void grow() {
//          this.events = new Event[this.events.length + 4];
        this.capacity += 4;
        Event [] newEvents = new Event[this.capacity];
        for (int i = 0; i < size; i++) {
            newEvents[i] = events[i];
        }
        events = newEvents;
    }

    //array-based, new event is added to the end of the array
    //initial cap of 4, +4 whenever full
    public boolean add(Event event){
        if (size == capacity) {
            grow();
        }
        events[size] = event;
        size++;

        return true; //event added
    }
    public boolean remove(Event event){
        int index = find(event);
        if (index != NOT_FOUND){
            for (int i = index; i < size - 1; i++){
                events[i] = events[i + 1];
            }
            events[size - 1] = null;
            size--;
            return true; //event found and removed
        }
        return false; //event not found
    }
    public boolean contains(Event event){
        return (find(event) != NOT_FOUND);
    }
    public void print(){
        for (Event event : events) {
            System.out.println(event);
        }
    }
    public void printByDate(){
        //sort by date
        for (int i = 0; i < events.length; i++){
            for (int j = i + 1; j < events.length - 1; j++){
                Event temp = null;
                if (events[j].getDate().compareTo(events[i].getDate()) < 0){
                    temp = events[i];
                    events[i] = events[j];
                    events[j] = temp;
                }
            }
        }
        //print by date
        print();
    }
    public void printByCampus(){

    }
    public void printByDepartment(){}
}
