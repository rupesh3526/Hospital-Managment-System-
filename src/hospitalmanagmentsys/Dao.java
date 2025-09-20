package hospitalmanagmentsys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public interface Dao {
    void addPatient(Patient patient);
    void viewPatients();
    ResultSet getPatientById(int id);
 void removePatient(int id);
    void viewDoctors();
    boolean getDoctorById(int id);
    void bookAppoinment(Dao dao , Scanner scanner);
    boolean isResultAvaliable(ResultSet resultSet);
}
