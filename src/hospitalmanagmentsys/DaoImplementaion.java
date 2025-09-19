package hospitalmanagmentsys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoImplementaion implements Dao{
    Connection connection= JdbcInjection.getConnection();

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
                System.out.println(resultSet.getInt("Id")+""+resultSet.getString("Name")
                +""+ resultSet.getInt("Age") +""+ resultSet.getString("gender"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
