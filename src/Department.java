public enum Department {
    CS("CS", "Computer Science"),
    EE("EE", "Electrical Engineering"),
    ITI("ITI", "Information Technology and Informatics"),
    MATH("MATH", "Mathematics"),
    BAIT("BAIT", "Business Analytics and Information Technology");

    private final String acronym;
    private final String fullName;


    Department(String acronym, String fullName) {
        this.acronym = acronym;
        this.fullName = fullName;
    }

    public String getAcronym(){
        return acronym;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
}