import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection{

    static final String URL= "jdbc:mysql://localhost:3306/course_enrollment";
    static final String USER= "your_username";
    static final String PASSWORD= "your_password"; 

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch(Exception e){
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }
        return null;
    }
}
