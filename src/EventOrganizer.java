import java.util.Scanner;
import java.util.StringTokenizer;

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
        EventCalendar eventCalendar = new EventCalendar();
        scan(eventCalendar);
        System.out.println("Event Organizer Terminated");

    }

    public void scan(EventCalendar eventCalendar) {
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
                if (token.equals("A")) {
                    addEvent(token, eventCalendar);
                } else if (token.equals("R")) {
                    cancelEvent(token, eventCalendar);
                } else if (token.equals("P")) {

                } else if (token.equals("PE")) {

                } else if (token.equals("PC")) {

                } else if (token.equals("PD")) {
                }
            }
        }
    }

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
        }
    }

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
    }

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

    public static void errorMessages() {

    }

    public static void main(String[] args) {
    }

}
