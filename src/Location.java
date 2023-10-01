/**
 * This enum class provides a list of specified locations, each with a corresponding
 * classroom and campus.
 * @author Jerlin Yuen
 * @author Jason Lei
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
     * Description
     * @param
     * @return
     * @author
     */
    Location(String classroom, String campus){
        this.classroom = classroom;
        this.campus = campus;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public String getClassroom() {
        return classroom;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public String getCampus() {
        return campus;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    @Override
    public String toString() {
        return classroom + ", " +campus;
    }
}
