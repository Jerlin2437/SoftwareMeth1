public enum Department {
    CS("Computer Science"),
    EE("Electrical Engineering"),
    ITI("Information Technology and Informatics"),
    MATH("Mathematics"),
    BAIT("Business Analytics and Information Technology");

    private final String fullName;

    Department(String fullName) {
        this.fullName = fullName;
    }
    @Override
    public String toString() {
        return fullName;
    }
}
