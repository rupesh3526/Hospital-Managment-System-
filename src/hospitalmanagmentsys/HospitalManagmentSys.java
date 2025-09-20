package hospitalmanagmentsys;

import java.util.Scanner;

public class HospitalManagmentSys {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dao dao = new DaoImplementaion();

        while (true) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Remove Patient");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int num = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline after nextInt()

            switch (num) {
                case 1:
                    Patient p1 = new Patient();
                    System.out.print("Enter Name of Patient: ");
                    p1.setPatientName(scanner.nextLine());

                    System.out.print("Enter Gender: ");
                    p1.setPatientGender(scanner.nextLine());

                    System.out.print("Enter Age: ");
                    p1.setPatientAge(scanner.nextInt());

                    dao.addPatient(p1);
                    break;

                case 2:
                    dao.viewPatients();
                    break;

                case 3:
                    System.out.print("Enter Patient Id to Remove: ");
                    dao.removePatient(scanner.nextInt());
                    break;

                case 4:
                    dao.viewDoctors();
                    break;

                case 5:
                    dao.bookAppoinment(dao, scanner);
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    return; // break the while loop & exit program

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
