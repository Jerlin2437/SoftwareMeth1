public class Date implements Comparable<Date>{
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
    public boolean isValid(){

        return false;
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

    public static void main(String[] args){
//test
    }
}
