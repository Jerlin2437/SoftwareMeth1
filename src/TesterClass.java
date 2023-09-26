public class TesterClass {
        public static void main(String[] args){
            Date newDate = new Date(2023, 10, 24);
            Date compareDate = new Date(2022, 2, 24);
            Contact newContact = new Contact(Department.CS, "cs@rutgers.edu");

            Event newEvent = new Event(newDate, Timeslot.AFTERNOON, Location.AB2225, newContact, 60);
//            Event compareEvent = new Event(compareDate, Timeslot.AFTERNOON, Location.HLL114, newContact, 50);
            Event compareEvent = new Event(newDate, Timeslot.AFTERNOON, Location.AB2225, newContact, 60);

            System.out.println(newEvent.compareTo(compareEvent));
            System.out.println(newEvent.toString());
            System.out.println(compareEvent.toString());
            System.out.println(newEvent.equals(compareEvent));


        }


}
