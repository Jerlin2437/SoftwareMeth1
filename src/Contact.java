/**
 * This class represents a contact that provides a corresponding department and email address.
 * There is a method to determine the validity of the email format and associated department given input.
 * @author Jerlin Yuen
 * @author Jason Lei
 */

public class Contact {
    private Department department;
    private String email;

    /**
     * Description
     * @param
     * @return
     * @author
     */
    public Department getDepartment() {
        return department;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public Contact(Department department, String email) {
        this.department = department;
        this.email = email;
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    public boolean isValid(){
        int length = email.length();
        String domainName = email.substring(length-12,length);
        String departmentName = department.getAcronym();
        boolean isDepartmentNameValid = departmentName.equals("CS") || departmentName.equals("ITI") || departmentName.equals("BAIT") || departmentName.equals("MATH") || departmentName.equals("EE");
        return isDepartmentNameValid && domainName.equals("@rutgers.edu");
    }
    /**
     * Description
     * @param
     * @return
     * @author
     */
    @Override
    public String toString(){
        return department + ", " + email;
    }
}
