/**
 * This enum class provides a list of specified timeslots with methods to convert
 * and change time durations.
 * @author Jerlin Yuen
 * @author Jason Lei
 */

public enum Timeslot {
    MORNING(10,30),
    AFTERNOON(2,0),
    EVENING(6,30);
    private final int hour;
    private final int minute;
    private int duration;
    private int endHour;
    private int endMinute;

    /**
     * Description
     * @param
     * @return
     * @author
     */
    Timeslot(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    /**
     * Description
     * @param
     * @return
     * @author
     */
    public int getHour() {
        return hour;
    }

    /**
     * Description
     * @param
     * @return
     * @author
     */
    public int getMinute() {
        return minute;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public int getEndHour(){
        return endHour;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public int getEndMinute(){
        return endMinute;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public void setDuration(int duration){

    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    @Override
    public String toString(){
        if (minute == 0){
            return hour + ":" + minute + "0";
        }
        return hour + ":" + minute;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
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
