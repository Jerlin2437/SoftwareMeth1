public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;
    public boolean isValid(){

        return false;
    }

    @Override
    public int compareTo(Date o) {
        return 0;
    }
}
