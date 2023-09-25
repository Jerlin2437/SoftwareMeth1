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

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

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

    private boolean isLeapYear() {
        return (year % QUADRENNIAL == 0 && year % CENTENNIAL != 0) || (year % QUATERCENTENNIAL == 0);
    }

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

    @Override
    public String toString(){
        return month + "/" + day + "/" + year;
    }

    public static void main(String[] args) {
//test
    }
}
