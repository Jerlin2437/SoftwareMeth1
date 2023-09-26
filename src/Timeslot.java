public enum Timeslot {
    MORNING(10,30),
    AFTERNOON(2,0),
    EVENING(6,30);
    private final int hour;
    private final int minute;
    private int duration;
    private int endHour;
    private int endMinute;

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
    public int getEndHour(){
        return endHour;
    }
    public int getEndMinute(){
        return endMinute;
    }
    public void setDuration(int duration){

    }

    @Override
    public String toString(){
        if (minute == 0){
            return hour + ":" + minute + "0";
        }
        return hour + ":" + minute;
    }

    public String toString(int duration) {
        int endHour = hour;
        int endMinute = minute;
        if (duration == 120) {
            endHour += 2;
        } else {
            endMinute += duration;
            if (endMinute >= 60)
                endHour++;
            endMinute = endMinute - 60;
        }
        if (endMinute == 0){
            return endHour + ":" + endMinute + "0";
        }
        return endHour + ":" + endMinute;
    }
    }
