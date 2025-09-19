package hospitalmanagmentsys;

public class Patient {
    private int patientId;
    private String patientName;
    private int patientAge;
    private String patientGender;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public Patient( String patientGender, int patientAge, String patientName) {
        this.patientGender = patientGender;
        this.patientAge = patientAge;
        this.patientName = patientName;
    }

    public Patient() {
        super();
    }
}
