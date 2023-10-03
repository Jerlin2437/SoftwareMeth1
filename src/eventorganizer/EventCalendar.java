package eventorganizer;

/**
 * This class manages a list/calendar of events with methods that allow for the addition,
 * removal, and sorting and printing of the list of events ordered by criteria such as date,
 * campus, and department.
 *
 * @author Jason Lei, Jerlin Yuen
 */

public class EventCalendar {
    private Event[] events;
    private int numEvents;
    private final int NOT_FOUND = -1;
    private int capacity = 4;
    private int size = 0;

    /**
     * Parameterized constructor
     *
     * @param events    - array holding the list of events
     * @param numEvents - current number of events in the array
     * @author Jerlin Yuen
     */
    public EventCalendar(Event[] events, int numEvents) {
        this.events = events;
        this.numEvents = numEvents;
    }

    /**
     * Default constructor; no-args constructor
     *
     * @author Jason Lei
     */
    public EventCalendar() {
        events = new Event[4];
        numEvents = 0;
    }

    /**
     * Searches an event in the list events
     *
     * @param event - specific event
     * @return x, index of the event in the list if specified event is present, NOT_FOUND (-1) if event is not present
     * @author Jerlin Yuen, Jason Lei
     */
    private int find(Event event) {
        for (int x = 0; x < size; x++) {
            if (events[x] != null && events[x].equals(event))
                return x;
        }
        return NOT_FOUND;
    }

    /**
     * Increases the capacity of the events list by 4
     *
     * @author Jason Lei, Jerlin Yuen
     */
    private void grow() {
        this.capacity += 4;
        Event[] newEvents = new Event[this.capacity];
        for (int i = 0; i < size; i++) {
            newEvents[i] = events[i];
        }
        events = newEvents;
    }

    /**
     * Adds an event to events list
     *
     * @param event - specific event
     * @return true if event has been added, false if event already contains the event
     * @author Jason Lei
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
     * Removes an event from events list
     *
     * @param event - specific event
     * @return true if event has been found and removed, false if event was not found
     * @author Jason Lei
     */
    public boolean remove(Event event) {
        int index = find(event);
        if (index != NOT_FOUND) {
            for (int i = index; i < size - 1; i++) {
                events[i] = events[i + 1];
            }
            events[size - 1] = null;
            size--;
            return true; //event found and removed
        }
        return false; //event not found
    }

    /**
     * Checks events list to see if specific event is present
     *
     * @param event - specific event
     * @return true if event is present, false if event is not present
     * @author Jason Lei
     */
    public boolean contains(Event event) {
        return (find(event) != NOT_FOUND);
    }

    /**
     * Checks events list to see if it is empty
     *
     * @return true if events list is empty, false if events list is not empty
     * @author Jason Lei
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Displays "Event calendar is empty" if events list is empty, events list if events list is not empty
     * @author Jason Lei, Jerlin Yuen
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("Event calendar is empty.");
        } else {
            for (int x = 0; x < size; x++) {
                System.out.println(events[x].toString());
            }
            System.out.println("* end of event calendar *");
        }
    }

    /**
     * Displays "Event calendar is empty" if events list is empty, events list ordered by date and timeslot if events list is not empty
     * @author Jason Lei
     */
    public void printByDate() {
        if (isEmpty()) {
            System.out.println("Event calendar is empty.");
        } else {
            //sort by date
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    Event temp = null;
                    if (events[j].getDate().compareTo(events[i].getDate()) < 0) {
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
     * Displays "Event calendar is empty" if events list is empty, events list ordered by campus and building/room if events list is not empty
     * @author Jason Lei
     */
    public void printByCampus() {
        if (isEmpty()) {
            System.out.println("Event calendar is empty.");
        } else {
            //sort by date
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    Event temp = null;
                    if (events[j].getLocation().compareTo(events[i].getLocation()) < 0) {
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
     * Displays each event in the events list, ordered by department
     *"Event calendar is empty" if events list is empty, events list ordered by department if events list is not empty
     * @author Jason Lei
     */
    //order by department
    public void printByDepartment() {
        if (isEmpty()) {
            System.out.println("Event calendar is empty.");
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    Event temp = null;
                    if (events[j].getContact().getDepartment().compareTo(events[i].getContact().getDepartment()) < 0) {
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
     * Testbed main, as the driver to test the public methods
     *
     * @param args - input
     * @author Jason Lei
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


