package hospitalmanagmentsys;
import java.sql.*;
public class JdbcInjection {
   final static String URL = "jdbc:mysql://localhost:3306/hospital";
    final static  String username = "root";
    final static String password = "Rupesh@123";
    static Connection con;
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.fillInStackTrace();
        }
        try{
             con = DriverManager.getConnection(URL,username,password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    return con;
    }
}
