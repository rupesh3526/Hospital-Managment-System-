package hospitalmanagmentsys;

public interface Dao {
    void addPatient(Patient patient);
    void viewPatients();
 void getPatientById(int id);
 void removePatient(int id);
}
