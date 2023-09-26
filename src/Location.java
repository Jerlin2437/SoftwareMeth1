public enum Location {
    HLL114("Hill Center", "Busch"),
    ARC103("Allison Road Classroom", "Busch"),
    BE_AUD("Beck Hall", "Livingston"),
    TIL232("Tillett Hall", "Livingston"),
    AB2225("Academic Building", "College Ave"),
    MU302("Murray Hall", "College Ave");

    private final String classroom;
    private final String campus;
    Location(String classroom, String campus){
        this.classroom = classroom;
        this.campus = campus;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getCampus() {
        return campus;
    }

    @Override
    public String toString() {
        return classroom + ", " +campus;
    }
}
