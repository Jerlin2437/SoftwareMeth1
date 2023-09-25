public enum Timeslot {
    MORNING(10,30),
    AFTERNOON(2,0),
    EVENING(6,30);
    private final int hour;
    private final int minute;

    Timeslot(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString(){
        if (minute == 0){
            return hour + ":" + minute + "0";
        }
        return hour + ":" + minute;
    }
}
