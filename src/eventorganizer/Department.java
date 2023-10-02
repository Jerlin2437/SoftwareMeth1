package eventorganizer;

/**
 * This enum class provides a list of specified departments containing a corresponding acronym
 * and the full name of the department.
 * @author Jerlin Yuen, Jason Lei
 */

public enum Department {
    CS("CS", "Computer Science"),
    EE("EE", "Electrical Engineering"),
    ITI("ITI", "Information Technology and Informatics"),
    MATH("MATH", "Mathematics"),
    BAIT("BAIT", "Business Analytics and Information Technology");

    private final String acronym;
    private final String fullName;

    /**
     * Parameterized constructor
     * @param acronym - department acronym
     * @param fullName - full name of department
     * @author Jerlin Yuen
     */
    Department(String acronym, String fullName) {
        this.acronym = acronym;
        this.fullName = fullName;
    }
    /**
     * Getter method (accessor)
     * @return acronym
     * @author Jerlin Yuen
     */
    public String getAcronym(){
        return acronym;
    }
    /**
     * Getter method (accessor)
     * @return full name of department
     * @author Jason Lei
     */
    public String getFullName() {
        return fullName;
    }
    /**
     * Returns textual representation of a department's full name
     * @return full name of department in text format
     * @author Jerlin Yuen
     */
    @Override
    public String toString() {
        return fullName;
    }
}