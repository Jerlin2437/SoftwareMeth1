/**
 * This class manages a list/calendar of events with methods that allow for the addition,
 * removal, and sorting and printing of the list of events ordered by criteria such as date,
 * campus, and department.
 * @author Jason Lei
 * @author Jerlin Yuen
 */

public class EventCalendar {
    private Event [] events;
    private int numEvents;

    private final int NOT_FOUND = -1;

    private int capacity = 4;
    private int size = 0;

    /**
     * Description
     * @param
     * @return
     * @author
     */
    public EventCalendar(Event[] events, int numEvents) {
        this.events = events;
        this.numEvents = numEvents;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public EventCalendar() {
        events = new Event[4];
        numEvents = 0;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    private int find(Event event){
        for (int x = 0; x < size; x++){
            if (events[x] != null && events[x].equals(event))
                return x;
        }
        return NOT_FOUND;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    private void grow() {
//          this.events = new Event[this.events.length + 4];
        this.capacity += 4;
        Event [] newEvents = new Event[this.capacity];
        for (int i = 0; i < size; i++) {
            newEvents[i] = events[i];
        }
        events = newEvents;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    //initial cap of 4, +4 whenever full
    public boolean add(Event event) {
        if (contains(event))
            return false;
        else {
            if (size == capacity) {
                grow();
            }
            for (int x = 0; x < capacity; x++) {
                if (events[x] == null) {
                    events[x] = event;
                    size++;
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
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
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public boolean contains(Event event){
        return (find(event) != NOT_FOUND);
    }

    /**
     * Description
     * @param
     * @return
     * @author
     */
    public boolean isEmpty() { return size == 0; }

    /**
     * Description
     * @param
     * @return
     * @author
     */
    public void print(){
        if (isEmpty()){
            System.out.println("Event calendar is empty.");
        } else{
            System.out.println("* Event calendar *");
            for(int x = 0; x < size; x++){
                System.out.println(events[x].toString());
            }
            System.out.println("* end of event calendar *");
        }
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    //double check compareTo, should be right tho (for events - checks date AND timeslot)
    public void printByDate(){
        if (isEmpty()){
            System.out.println("Event calendar is empty.");
        } else{
            //sort by date
            for (int i = 0; i < size; i++){
                for (int j = i + 1; j < size; j++){
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


    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    //order by campus and building/room
    public void printByCampus(){
        if (isEmpty()){
            System.out.println("Event calendar is empty.");
        } else{
            //sort by date
            for (int i = 0; i < size; i++){
                for (int j = i + 1; j < size; j++){
                    Event temp = null;
                    if (events[j].getLocation().compareTo(events[i].getLocation()) < 0){
                        temp = events[i];
                        events[i] = events[j];
                        events[j] = temp;
                    }
                }
            }
            //print by campus and building/room
            print();
        }
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    //order by department
    public void printByDepartment(){
        if (isEmpty()){
            System.out.println("Event calendar is empty.");
        } else{
            for (int i = 0; i < size; i++){
                for (int j = i + 1; j < size; j++){
                    Event temp = null;
                    if (events[j].getContact().getDepartment().compareTo(events[i].getContact().getDepartment()) < 0){
                        temp = events[i];
                        events[i] = events[j];
                        events[j] = temp;
                    }
                }
            }
            //print by department
            print();
        }
    }

    /**
     * Description
     * @param
     * @return
     * @author
     */
    public static void main(String[] args) {
        EventCalendar eventCalendar = new EventCalendar();

        Date newDate = new Date(2023, 9, 29);
        Contact newContact = new Contact(Department.EE, "cs@rutgers.edu");
        Event newEvent = new Event(newDate, Timeslot.AFTERNOON, Location.AB2225, newContact, 60);

        Date newDate2 = new Date(2022, 10, 30);
        Contact newContact2 = new Contact(Department.CS, "cs@rutgers.edu");
        Event newEvent2 = new Event(newDate2, Timeslot.MORNING, Location.HLL114, newContact2, 60);

        eventCalendar.add(newEvent);
        System.out.println(eventCalendar.contains(newEvent2));
        eventCalendar.add(newEvent2);
        eventCalendar.remove(newEvent);
        eventCalendar.printByDepartment();
    }

}


