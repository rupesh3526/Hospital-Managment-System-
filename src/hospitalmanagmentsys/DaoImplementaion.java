package hospitalmanagmentsys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DaoImplementaion implements Dao{
    Connection connection= JdbcInjection.getConnection();
    void printResultSet(ResultSet resultSet)throws SQLException {
        while (resultSet.next()){
            System.out.println(resultSet.getInt("Id")+" "+resultSet.getString("Name")
                    +" "+ resultSet.getInt("Age") +" "+ resultSet.getString("gender"));
        }
    };
    public boolean isResultAvaliable(ResultSet resultSet) {
       try{ if (resultSet.next()){
            return true;
        }else {
            return false;
        }} catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }



    @Override
    public void addPatient(Patient patient) {
      String query ="Insert into Patient(name , age , gender) values(?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, patient.getPatientName());
            ps.setInt(2,patient.getPatientAge());
            ps.setString(3, patient.getPatientGender());
           int affectedRow= ps.executeUpdate();
           if (affectedRow>0){
            System.out.println("Successfully added Patient");}
           else{
               System.out.println("Failed to addPatient");
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }

    @Override
    public void viewPatients() {
        String querry ="Select * from Patient";
        ResultSet resultSet;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(querry);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt("Id")+" "+resultSet.getString("Name")
                +" "+ resultSet.getInt("Age") +" "+ resultSet.getString("gender"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public ResultSet getPatientById(int id) {
        String querry = "Select * from patient where id = ? ";
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1, id);
           return resultSet = preparedStatement.executeQuery();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void removePatient(int id) {
        String querry ="Delete from Patient where id = ?";
        try{
            PreparedStatement preparedStatement=connection.prepareStatement(querry);
            preparedStatement.setInt(1,id);
            int result=preparedStatement.executeUpdate();
            if(result>0){
                System.out.println("Successfully Deleted");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void viewDoctors(){
        String querry ="Select * from Doctors";
        ResultSet resultSet;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(querry);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt("Id")+" "+resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public boolean getDoctorById(int id){
        String querry = "Select * from Doctors where id = ? ";
        ResultSet resultSet=null;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(querry);
            preparedStatement.setInt(1,id);
            resultSet= preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    public  void bookAppoinment(Dao dao ,Scanner scanner){
        try {
            connection.setAutoCommit(false); // Start transaction

            System.out.println("Enter Patient Id");
            int p_Id = scanner.nextInt();
            System.out.println("Enter Doctor Id");
            int d_Id = scanner.nextInt();
            if (dao.isResultAvaliable(dao.getPatientById(p_Id)) && dao.getDoctorById(d_Id)) {

                String querry = "Insert into appointments(patient_id,doctor_id) values(?,?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(querry)) {
                    preparedStatement.setInt(1, p_Id);
                    preparedStatement.setInt(2, d_Id);
                    preparedStatement.executeUpdate();
                    connection.commit();
                }
            } else {
                System.out.println("Either Doctor or Patient does not exist.");
                connection.rollback();}


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
            connection.setAutoCommit(true);
        } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
