package eventorganizer;

import eventorganizer.*;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class represents a user interface to process user input from command lines. This program
 * allows a user to add, cancel and remove, and sort and display events in an event calendar by
 * various criteria such as by event date, campus, and department.
 *
 * @author Jerlin Yuen, Jason Lei
 */

public class EventOrganizer {
    /**
     * Default constructor
     */
    public EventOrganizer() {
    }

    /**
     * Prints running/terminated statements
     * Creates new eventCalendar object and calls scan function
     *
     * @author
     */
    public void run() {
        System.out.println("Event Organizer running....");
        EventCalendar eventCalendar = new EventCalendar();
        scan(eventCalendar);
        System.out.println("Event Organizer Terminated");

    }

    /**
     * Creates new scanner object and cycles through each command line argument.
     * Tokenizes the first command and calls a different function based on each command
     *
     * @param eventCalendar calendar of events
     * @author
     */
    public void scan(EventCalendar eventCalendar) {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("Q")) {
                break;
            }
            Scanner lineScanner = new Scanner(line);
            if (!lineScanner.hasNext())
                continue;
            String token = lineScanner.next();
            if (x == 0) {
                System.out.println(); //formatting
                x++;
            }
            if (token.equals("A")) {
                addEvent(line, eventCalendar);
            } else if (token.equals("R")) {
                cancelEvent(line, eventCalendar);
            } else if (token.equals("P")) {
                System.out.println("* Event calendar *");
                eventCalendar.print();
            } else if (token.equals("PE")) {
                System.out.println("Event calendar by event date and start time");
                eventCalendar.printByDate();
            } else if (token.equals("PC")) {
                System.out.println("* Event calendar by campus and building *");
                eventCalendar.printByCampus();
            } else if (token.equals("PD")) {
                System.out.println("Event calendar by department");
                eventCalendar.printByDepartment();
            } else
                System.out.println(token + " is an invalid command!");
        }
    }

    /**
     * Adds an event to eventCalendar based on commandline input.
     * Cycles through each token and calls other functions to handle each string token before adding to eventCalendar
     *
     * @param line          - event to be inputted into eventCalendar
     * @param eventCalendar - calendar of events
     * @author
     */
    public static void addEvent(String line, EventCalendar eventCalendar) {
        Scanner lineScanner = new Scanner(line);
        lineScanner.next(); // Assuming this is used to skip some initial token (not clear from the context)

        Date date = extractDate(lineScanner.next());
        if (!date.isValid() || !date.isFuture() || !date.isUnder6Months()) {
            return;  // Guard clause
        }

        String timeslotToken = lineScanner.next().toUpperCase();
        Timeslot timeslot = extractTimeslot(timeslotToken);
        if (timeslot == null) {
            return;  // Guard clause
        }

        String locationToken = lineScanner.next().toUpperCase();
        Location location = extractLocation(locationToken);
        if (location == null) {
            return;
        }

        String departmentToken = lineScanner.next().toUpperCase();
        String emailToken = lineScanner.next();
        Contact contact = extractContact(departmentToken, emailToken);
        if (contact == null) {
            return;
        }
        int duration = Integer.parseInt(lineScanner.next());
        if (duration >= 30 && duration <= 120) {
            Event event = new Event(date, timeslot, location, contact, duration);
            if (eventCalendar.add(event)) {
                System.out.println("Event added to the calendar.");
            } else
                System.out.println("The event is already on the calendar.");
        } else
            System.out.println("Event duration must be at least 30 minutes and at most 120 minutes");
    }

    /**
     * Removes an event from eventCalendar based on commandline input.
     * Cycles through each token and calls other functions to handle each string token before adding to eventCalendar
     *
     * @param line          - event to be removed from eventCalendar
     * @param eventCalendar - calendar of events
     * @author
     */
    public static void cancelEvent(String line, EventCalendar eventCalendar) {
        Scanner lineScanner = new Scanner(line);
        lineScanner.next(); // Assuming this is used to skip some initial token (not clear from the context)

        Date date = extractDate(lineScanner.next());

        if (!date.isValid() || !date.isFuture() || !date.isUnder6Months()) {
            return;  // Guard clause
        }

        String timeslotToken = lineScanner.next().toUpperCase();
        Timeslot timeslot = extractTimeslot(timeslotToken);

        if (timeslot == null) {
            return;  // Guard clause
        }

        String locationToken = lineScanner.next().toUpperCase();
        Location location = extractLocation(locationToken);

        if (location != null) {
            Event event = new Event(date, timeslot, location);
            if (eventCalendar.remove(event))
                System.out.println("Event has been removed from the calendar!");
            else
                System.out.println("Cannot remove; event is not in the calendar!");
        }
    }

    /**
     * Returns Contact object and checks for invalid inputs
     *
     * @param departmentCode - string of department acronym to be verified
     * @param emailCode      - email to be verified
     * @return returns a contact object if departmentCode/emailCode is valid or else returns null
     * @author
     */
    public static Contact extractContact(String departmentCode, String emailCode) {
        if (emailCode.endsWith("@rutgers.edu")) {
            switch (departmentCode) {
                case "CS" -> {
                    return new Contact(Department.CS, emailCode);
                }
                case "EE" -> {
                    return new Contact(Department.EE, emailCode);
                }
                case "BAIT" -> {
                    return new Contact(Department.BAIT, emailCode);
                }
                case "ITI" -> {
                    return new Contact(Department.ITI, emailCode);
                }
                case "MATH" -> {
                    return new Contact(Department.MATH, emailCode);
                }
                default -> {
                    System.out.println("Invalid contact information!");
                    return null;
                }
            }
        }
        System.out.println("Invalid contact information!");
        return null;
    }

    /**
     * Returns Location object and checks for invalid input
     *
     * @param locationCode - a string of possible event locations
     * @return returns a Location object if locationCode is valid or else returns null
     * @author
     */
    public static Location extractLocation(String locationCode) {
        switch (locationCode) {
            case "HLL114" -> {
                return Location.HLL114;
            }
            case "ARC103" -> {
                return Location.ARC103;
            }
            case "BE_AUD" -> {
                return Location.BE_AUD;
            }
            case "TIL232" -> {
                return Location.TIL232;
            }
            case "AB2225" -> {
                return Location.AB2225;
            }
            case "MU302" -> {
                return Location.MU302;
            }
            default -> {
                System.out.println("Invalid Location");
                return null;
            }
        }
    }

    /**
     * Returns a Timeslot object and checks for invalid input
     *
     * @param timeslot - a string of possible event timeslots
     * @return returns a Timeslot object if timeslot is valid or else returns null
     * @author
     */
    public static Timeslot extractTimeslot(String timeslot) {
        switch (timeslot) {
            case "MORNING" -> {
                return Timeslot.MORNING;
            }
            case "AFTERNOON" -> {
                return Timeslot.AFTERNOON;
            }
            case "EVENING" -> {
                return Timeslot.EVENING;
            }
            default -> System.out.println("Invalid time slot!");
        }
        return null;
    }

    /**
     * Returns a date object and checks for invalid input
     *
     * @param stringDate - a string of possible event dates
     * @return returns a Date object if date is valid or else returns null
     * @author
     */
    public static Date extractDate(String stringDate) {
        StringTokenizer tokenizer = new StringTokenizer(stringDate, "/");
        int month = Integer.parseInt(tokenizer.nextToken());
        int day = Integer.parseInt(tokenizer.nextToken());
        int year = Integer.parseInt(tokenizer.nextToken());
        Date date = new Date(year, month, day);
        if (!date.isValid())
            System.out.println(date.toString() + ": Invalid calendar date!");
        else if (!date.isFuture())
            System.out.println(date.toString() + ": Event date must be a future date!");
        else if (!date.isUnder6Months())
            System.out.println(date.toString() + ": Event date must be within 6 months!");
        return date;
    }


}
