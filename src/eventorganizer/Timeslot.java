package eventorganizer;

/**
 * This enum class provides a list of specified timeslots with methods to convert
 * and change time durations.
 *
 * @author Jerlin Yuen, Jason Lei
 */

public enum Timeslot {
    MORNING(10, 30),
    AFTERNOON(2, 0),
    EVENING(6, 30);
    private final int hour;
    private final int minute;
    private int duration;
    private int endHour;
    private int endMinute;

    /**
     * Parameterized constructor
     *
     * @param hour   - specific hour value
     * @param minute - specific minute value
     * @author Jerlin Yuen
     */
    Timeslot(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    /**
     * Getter method (accessor)
     *
     * @return hour
     * @author Jason Lei
     */
    public int getHour() {
        return hour;
    }

    /**
     * Getter method (accessor)
     *
     * @return minute
     * @author Jason Lei
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Getter method (accessor)
     *
     * @return end time hour
     * @author Jerlin Yuen
     */
    public int getEndHour() {
        return endHour;
    }

    /**
     * Getter method (accessor)
     *
     * @return end time minute
     * @author Jerlin Yuen
     */
    public int getEndMinute() {
        return endMinute;
    }

    public void setDuration(int duration) {

    }

    /**
     * Returns textual representation of hour and minutes in hour:minute format
     *
     * @return hours and minutes in text format
     * @author Jason Lei
     */
    @Override
    public String toString() {
        if (minute == 0) {
            return hour + ":" + minute + "0";
        }
        return hour + ":" + minute;
    }

    /**
     * Overloaded methodm returns textual representation of hour and minutes, including end hour and end minutes for an event's end time
     *
     * @param duration - time in minutes for a specific event
     * @return
     * @author Jerlin Yuen
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
        if (endMinute == 0) {
            return endHour + ":" + endMinute + "0";
        }
        return endHour + ":" + endMinute;
    }
}
