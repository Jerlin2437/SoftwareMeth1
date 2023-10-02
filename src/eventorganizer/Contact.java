package eventorganizer;

/**
 * This class represents a contact that provides a corresponding department and email address.
 * There is a method to determine the validity of the email format and associated department given input.
 * @author Jerlin Yuen, Jason Lei
 */

public class Contact {
    private Department department;
    private String email;

    /**
     * Getter method (accessor)
     * @return department
     * @author Jason Lei
     */
    public Department getDepartment() {
        return department;
    }
    /**
     * Parameterized constructor
     * @param department - specific department
     * @param email - specific email
     * @author Jerlin Yuen
     */
    public Contact(Department department, String email) {
        this.department = department;
        this.email = email;
    }
    /**
     * Checks validity of department name and email
     * @return true if department name and email is valid, false otherwise
     * @author Jerlin Yuen
     */
    public boolean isValid(){
        int length = email.length();
        String domainName = email.substring(length-12,length);
        String departmentName = department.getAcronym();
        boolean isDepartmentNameValid = departmentName.equals("CS") || departmentName.equals("ITI") || departmentName.equals("BAIT") || departmentName.equals("MATH") || departmentName.equals("EE");
        return isDepartmentNameValid && domainName.equals("@rutgers.edu");
    }
    /**
     * Returns textual representation of department and email
     * @return department and email in text format
     * @author Jason Lei
     */
    @Override
    public String toString(){
        return department + ", " + email;
    }
}
