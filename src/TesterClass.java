import java.util.Calendar;
public class TesterClass {
    public static void main(String[] args) {
        Date newDate = new Date(2023, 9, 29);
//            Date compareDate = new Date(2023, 10, 24);
//            Contact newContact = new Contact(Department.CS, "cs@rutgers.edu");
//
//            Event newEvent = new Event(newDate, Timeslot.AFTERNOON, Location.AB2225, newContact, 60);
//            Event compareEvent = new Event(newDate, Timeslot.AFTERNOON, Location.AB2225, newContact, 60);
//
//            System.out.println(newEvent.compareTo(compareEvent));
//            System.out.println(newEvent.toString());
//            System.out.println(compareEvent.toString());
//            System.out.println(newEvent.equals(compareEvent));
//
//            boolean future = compareDate.isFuture();
//            System.out.println(future);
//
//            boolean underSixMonths = newDate.isUnder6Months();
//            System.out.println(underSixMonths);
//
//            boolean validDate = newDate.isValidDate();
//            System.out.println(validDate);

        if(!newDate.isValid())
            System.out.println(newDate + ": Invalid calendar date!");
        else if(!newDate.isFuture())
            System.out.println(newDate + ": Event date must be a future date!");
        else if(!newDate.isUnder6Months())
            System.out.println(newDate + ": Event date must be within 6 months!");
        else
            System.out.println(newDate);

    }
}



