package eventorganizer;

import java.util.Calendar;
/**
 * This class represents a calendar date with methods to determine if input is valid,
 * if a date is in the future, if a date is within six months of the current date,
 * a method for comparing two dates, and methods for testing.
 * @author Jason Lei, Jerlin Yuen
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
     * Parameterized constructor
     * @param year - date's year
     * @param month - date's month
     * @param day - date's day
     * @author Jerlin Yuen
     */
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Determines if a date is a valid calendar date based on different criteria such as the number of days in a month,
     * whether a year is a leap or non-leap year, if the year is a negative value, month is a value less than 1, and if
     * month is a value greater than 12.
     * @return true if the date is a valid calendar date, false otherwise
     * @author Jerlin Yuen
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

    /**
     * Checks to see if an event date is a future date
     * @return true if the date is a future date, false otherwise
     * @author Jason Lei
     */
    public boolean isFuture(){
        Calendar currentDate = Calendar.getInstance();
        Date today = new Date(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH) + 1, currentDate.get(Calendar.DAY_OF_MONTH));

        return this.compareTo(today) > 0;
    }

    /**
     * Checks to see if an event date is no more than 6 months away from the current date
     * @return true if the date is less than or equal to 6 months away from the current date, false otherwise
     * @author Jason Lei
     */
    public boolean isUnder6Months() {
        Calendar currentDate = Calendar.getInstance();
        Calendar eventDate = Calendar.getInstance();
        eventDate.set(year, month, day);

        int numOfMonths1 = currentDate.get(Calendar.YEAR) * 12 + currentDate.get(Calendar.MONTH);
        int numOfMonths2 = eventDate.get(Calendar.YEAR) * 12 + eventDate.get(Calendar.MONTH);

        int diffInMonths = numOfMonths2 - numOfMonths1;

        if (diffInMonths < 6) {
            return true;
        } else if (diffInMonths == 6) {
            int dayDiff = eventDate.get(Calendar.DAY_OF_MONTH) - currentDate.get(Calendar.DAY_OF_MONTH);
            return dayDiff >= 0;  // If the day difference is non-negative, it's within 6 months and 1 day.
        } else {
            return false;
        }
    }
    /**
     * Checks to see if a year is a leap year or a non-leap year
     * @return true if the year is a leap year, false otherwise
     * @author Jerlin Yuen
     */
    private boolean isLeapYear() {
        return (year % QUADRENNIAL == 0 && year % CENTENNIAL != 0) || (year % QUATERCENTENNIAL == 0);
    }
    /**
     * Compares the years, months, and days of two dates
     * @param otherDate - second date to be compared to
     * @return 0 if years, months, and days are the same, -1 if year, months, or days is before the second date, 1 if year, months, or days is after the second date
     * @author Jerlin Yuen
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
     * Returns textual representation of date in Month/Day/Year
     * @return textual representation of date
     * @author Jason Lei
     */
    @Override
    public String toString(){
        return month + "/" + day + "/" + year;
    }
    /**
     * Testbed main, as the driver to test the public methods
     * @param args - input
     * @author Jason Lei
     */
    public static void main(String[] args) {
        testYear_OutOfRange();
        testMonth_OutOfRange();
        testDaysInFeb_Nonleap();
        testDaysInFeb_Leap();
        testDaysInJan();
        testDaysInApril();
        testDaysInSep();
    }

    /**
     * Test case #1 - date cannot have a year before 0.
     * @author Jason Lei
     */
    private static void testYear_OutOfRange(){
        Date date = new Date(-1, 12, 23); //test data --> invalid calendar date
        boolean expectedOutput = false;
        boolean actualOutput = date.isValid();
        System.out.println("**Test case #1: date cannot have a year before 0.");
        testResult(date, expectedOutput, actualOutput);
    }

    /**
     * Test case #2 - # of months in a year is 12, value of month cannot be more than 12.
     * @author Jason Lei
     */
    private static void testMonth_OutOfRange(){
        Date date = new Date(2023, 13, 29); //test data --> invalid calendar date
        boolean expectedOutput = false;
        boolean actualOutput = date.isValid();
        System.out.println("**Test case #2: # of months in a year is 12, month cannot be more than 12.");
        testResult(date, expectedOutput, actualOutput);
    }

    /**
     * Test case #3 - # of days in Feb. in a non-leap year is 28
     * @author Jason Lei
     */
    private static void testDaysInFeb_Nonleap(){
        Date date = new Date(2011, 2, 29); //test data --> invalid calendar date
        boolean expectedOutput = false;
        boolean actualOutput = date.isValid();
        System.out.println("**Test case #3: # of days in Feb. in a non-leap year is 28");
        testResult(date, expectedOutput, actualOutput);
    }

    /**
     * Test case #4 - # of days in Feb. in a leap year is 29
     * @author Jason Lei
     */
    private static void testDaysInFeb_Leap(){
        Date date = new Date(2012, 2, 29); //test data --> invalid calendar date
        boolean expectedOutput = true;
        boolean actualOutput = date.isValid();
        System.out.println("**Test case #4: # of days in Feb. in a leap year is 29");
        testResult(date, expectedOutput, actualOutput);
    }

    /**
     * Test case #5 - # of days in January is 31.
     * @author Jason Lei
     */
    private static void testDaysInJan(){
        Date date = new Date(2023, 1, 31); //test data --> invalid calendar date
        boolean expectedOutput = true;
        boolean actualOutput = date.isValid();
        System.out.println("**Test case #5: # of days in January is 31.");
        testResult(date, expectedOutput, actualOutput);
    }

    /**
     * Test case #6 - # of days in April is 30.
     * @author Jason Lei
     */
    private static void testDaysInApril(){
        Date date = new Date(2012, 4, 31); //test data --> invalid calendar date
        boolean expectedOutput = false;
        boolean actualOutput = date.isValid();
        System.out.println("**Test case #6: # of days in April is 30.");
        testResult(date, expectedOutput, actualOutput);
    }

    /**
     * Test case #7 - # of days in September is 30.
     * @author Jason Lei
     */
    private static void testDaysInSep(){
        Date date = new Date(2023, 9, 31); //test data --> invalid calendar date
        boolean expectedOutput = false;
        boolean actualOutput = date.isValid();
        System.out.println("**Test case #7: # of days in September is 30.");
        testResult(date, expectedOutput, actualOutput);
    }


    /**
     * Testbed output
     * @param date - event date
     * @param expectedOutput - intended result
     * @param actualOutput - expected result
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
