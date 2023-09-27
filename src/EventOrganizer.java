import java.util.Scanner;

public class EventOrganizer {
    /**
     * All commands
     * R - cancel an event and remove from calendar
     * P - display event calendar with current order
     * PE - display event calendar sorted by event date and timeslot
     * PC - display event calendar sorted by campus and building/room
     * PD - display event calendar sorted by department in contact
     * Q - stop execution and display "Event Organizer terminated."
     */
    public void run() {
        System.out.println("Event Organizer running....");
        scan();
        System.out.println("Event Organizer Terminated");

    }
    public void scan(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("Q")) {
                break;
            }
            Scanner lineScanner = new Scanner(line);
            // Tokenize each line by reading each token
            while (lineScanner.hasNext()) {
                String token = lineScanner.next();
            }

        }
    }
    public void errorMessages(){

    }
    
}
