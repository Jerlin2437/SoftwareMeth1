public class Contact {
    private Department department;
    private String email;

    public Contact(Department department, String email) {
        this.department = department;
        this.email = email;
    }
    public boolean isValid(){
        int length = email.length();
        String domainName = email.substring(length-12,length);
        String departmentName = department.getAcronym();
        boolean isDepartmentNameValid = departmentName.equals("CS") || departmentName.equals("ITI") || departmentName.equals("BAIT") || departmentName.equals("MATH") || departmentName.equals("EE");
        return isDepartmentNameValid && domainName.equals("@rutgers.edu");
    }
}
