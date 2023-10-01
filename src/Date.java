import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * This class represents a calendar date with methods to determine if input is valid,
 * if a date is in the future, if a date is within six months of the current date,
 * a method for comparing two dates, and methods for testing.
 * @author Jason Lei
 * @author Jerlin Yuen
 */

public class Date implements Comparable<Date> {
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    private static final int DAYS_31 = 31;
    private static final int DAYS_30 = 30;
    private static final int DAYS_FEB_NORMAL = 28;
    private static final int DAYS_FEB_LEAP = 29;
    private int year;
    private int month;
    private int day;

    /**
     * Description
     * @param
     * @return
     * @author
     */
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //within 6 months...make sure to go over all requirements/prereqs
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public boolean isValid() {

        if (year < 0 || month < 1 || month > 12)
            return false;

        switch (month) {
            /**
             January
             March
             May
             July
             August
             October
             December */
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return day >= 1 && day <= DAYS_31;
            }
            /** April
             June
             September
             November */
            case 4, 6, 9, 11 -> {
                return day >= 1 && day <= DAYS_30;
            }
            // February
            case 2 -> {  // February
                if (isLeapYear()) {
                    return day >= 1 && day <= DAYS_FEB_LEAP;
                } else {
                    return day >= 1 && day <= DAYS_FEB_NORMAL;
                }
            }
            default -> {
                return false;
            }
        }
    }

    //checks if event is a valid calendar date
//    public boolean isValidDate() {
//        Calendar eventDate = Calendar.getInstance();
//        eventDate.set(year, month, day);
//
//        if (year < 0 || month < 1 || month > 12)
//            return false;
//
//        switch (month) {
//            /**
//             January
//             March
//             May
//             July
//             August
//             October
//             December */
//            case 1, 3, 5, 7, 8, 10, 12 -> {
//                return day >= 1 && day <= DAYS_31;
//            }
//            /** April
//             June
//             September
//             November */
//            case 4, 6, 9, 11 -> {
//                return day >= 1 && day <= DAYS_30;
//            }
//            // February
//            case 2 -> {  // February
//                if (isLeapYear()) {
//                    return day >= 1 && day <= DAYS_FEB_LEAP;
//                } else {
//                    return day >= 1 && day <= DAYS_FEB_NORMAL;
//                }
//            }
//            default -> {
//                return false;
//            }
//        }
//    }

    //checks if date is a future date
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public boolean isFuture(){
//        Calendar currentDate = Calendar.getInstance();
//        Calendar eventDate = Calendar.getInstance();
//        eventDate.set(year, month, day);
//
////        return eventDate.compareTo(currentDate) > 0;
//        int yearCompare = Integer.compare(eventDate.get(Calendar.YEAR), currentDate.get(Calendar.YEAR));
//        if (yearCompare > 0) {
//            return true;
//        } else if (yearCompare < 0) {
//            return false;
//        }
//
//        int monthCompare = Integer.compare(eventDate.get(Calendar.MONTH), currentDate.get(Calendar.MONTH));
//        if (monthCompare > 0) {
//            return true;
//        } else if (monthCompare < 0) {
//            return false;
//        }
//
//        int dayCompare = Integer.compare(eventDate.get(Calendar.DAY_OF_MONTH), currentDate.get(Calendar.DAY_OF_MONTH));
//        return dayCompare > 0;

        Calendar currentDate = Calendar.getInstance();
        Date today = new Date(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH) + 1, currentDate.get(Calendar.DAY_OF_MONTH));

        return this.compareTo(today) > 0;
    }

    //checks if no more than 6 months away
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public boolean isUnder6Months(){
        Calendar currentDate = Calendar.getInstance();
        Calendar eventDate = Calendar.getInstance();
        eventDate.set(year, month, day);

        int numOfMonths1 = currentDate.get(Calendar.YEAR) * 12 + currentDate.get(Calendar.MONTH);
        int numOfMonths2 = eventDate.get(Calendar.YEAR) * 12 + eventDate.get(Calendar.MONTH);

        int diffInMonths = Math.abs(numOfMonths2 - numOfMonths1 - 1);

        return diffInMonths <= 6;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    private boolean isLeapYear() {
        return (year % QUADRENNIAL == 0 && year % CENTENNIAL != 0) || (year % QUATERCENTENNIAL == 0);
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    @Override
    public int compareTo(Date otherDate) {
        // Compare years
        int yearComparison = Integer.compare(this.year, otherDate.year);
        if (yearComparison != 0) {
            return yearComparison;
        }

        // Years are equal, compare months
        int monthComparison = Integer.compare(this.month, otherDate.month);
        if (monthComparison != 0) {
            return monthComparison;
        }

        // Months are equal, compare days
        return Integer.compare(this.day, otherDate.day);
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    @Override
    public String toString(){
        return month + "/" + day + "/" + year;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public static void main(String[] args) {
        testDaysInFeb_Nonleap();
        testDaysInFeb_Leap();
        testMonth_OutOfRange();
    }

    /**
     * Test case #1
     * @param
     * @return
     * @author
     */
    private static void testDaysInFeb_Nonleap(){
        Date date = new Date(2011, 2, 29); //test data --> invalid calendar date
        boolean expectedOutput = false;
        boolean actualOutput = date.isValid();
        System.out.println("**Test case #1: # of days in Feb. in a non-leap year is 28");
        testResult(date, expectedOutput, actualOutput);
    }

    /**
     * Test case #2
     * @param
     * @return
     * @author
     */
    private static void testDaysInFeb_Leap(){
        Date date = new Date(2011, 2, 29); //test data --> invalid calendar date
        boolean expectedOutput = true;
        boolean actualOutput = date.isValid();
        System.out.println("**Test case #2: # of days in Feb. in a leap year is 29");
        testResult(date, expectedOutput, actualOutput);
    }

    /**
     * Test case #3
     * @param
     * @return
     * @author
     */
    private static void testMonth_OutOfRange(){
        Date date = new Date(2011, 13, 29); //test data --> invalid calendar date
        boolean expectedOutput = false;
        boolean actualOutput = date.isValid();
        System.out.println("**Test case #3: # of months in a year is 12, month cannot be more than 12.");
        testResult(date, expectedOutput, actualOutput);
    }

    /**
     * Description
     * @param
     * @return
     * @author
     */
    private static void testResult(Date date, boolean expectedOutput, boolean actualOutput){
        System.out.println("Test input: " + date.toString());
        System.out.println("Expected output: " + expectedOutput);
        System.out.println("Actual output: " + actualOutput);
        if (expectedOutput != actualOutput){
            System.out.println(" (FAIL \n");
        } else{
            System.out.println(" (PASS) \n");
        }
    }

}
