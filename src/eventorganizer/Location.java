package eventorganizer;

/**
 * This enum class provides a list of specified locations, each with a corresponding
 * classroom and campus.
 *
 * @author Jerlin Yuen, Jason Lei
 */

public enum Location {
    HLL114("Hill Center", "Busch"),
    ARC103("Allison Road Classroom", "Busch"),
    BE_AUD("Beck Hall", "Livingston"),
    TIL232("Tillett Hall", "Livingston"),
    AB2225("Academic Building", "College Ave"),
    MU302("Murray Hall", "College Ave");

    private final String classroom;
    private final String campus;

    /**
     * Parameterized constructor
     *
     * @param classroom - specific classroom
     * @param campus    - specific campus
     * @author Jerlin Yuen
     */
    Location(String classroom, String campus) {
        this.classroom = classroom;
        this.campus = campus;
    }

    /**
     * Getter method (accessor)
     *
     * @return classroom
     * @author Jerlin Yuen
     */
    public String getClassroom() {
        return classroom;
    }

    /**
     * Getter method (accessor)
     *
     * @return campus
     * @author Jason Lei
     */
    public String getCampus() {
        return campus;
    }

    /**
     * Returns textual representation of classroom and campus
     *
     * @return classroom and campus in text format
     * @author Jerlin Yuen
     */
    @Override
    public String toString() {
        return classroom + ", " + campus;
    }
}
