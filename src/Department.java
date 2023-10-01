/**
 * This enum class provides a list of specified departments containing a corresponding acronym
 * and the full name of the department.
 * @author Jerlin Yuen
 * @author Jason Lei
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
     * Description
     * @param
     * @return
     * @author
     */
    Department(String acronym, String fullName) {
        this.acronym = acronym;
        this.fullName = fullName;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public String getAcronym(){
        return acronym;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public String getFullName() {
        return fullName;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    @Override
    public String toString() {
        return fullName;
    }
}