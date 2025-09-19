package hospitalmanagmentsys;

public class HospitalManagmentSys {
    public static void main(String[] args) {
        Dao dao = new DaoImplementaion();
        Patient p1 = new Patient();
        p1.setPatientAge(10);
        p1.setPatientGender("male");
        p1.setPatientName("Rahul");
        dao.addPatient(p1);
        dao.viewPatients();
    }
}

