package hospitalmanagmentsys;

import java.util.Scanner;

public class HospitalManagmentSys {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dao dao = new DaoImplementaion();

        Patient p1 = new Patient();
        p1.setPatientAge(10);
        p1.setPatientGender("male");
        p1.setPatientName("Rahul");
       /* dao.addPatient(p1);
        dao.viewPatients();*/
       // dao.getPatientById(2);
       // dao.removePatient(3);
        //dao.viewDoctors();
        dao.bookAppoinment(dao,scanner);
    }


}

