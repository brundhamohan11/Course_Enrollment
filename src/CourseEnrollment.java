import java.sql.*;
import java.util.Scanner;

public class CourseEnrollment {

    Connection con = DBConnection.getConnection();

    // Add Student
    public void addStudent(Scanner sc) {

        try {
            System.out.print("Enter Student Name: ");
            String student = sc.nextLine();

            System.out.print("Enter Course Name: ");
            String course = sc.nextLine();

            System.out.print("Enter Duration: ");
            String duration = sc.nextLine();

            System.out.print("Enter Status: ");
            String status = sc.nextLine();

            String query = "INSERT INTO enrollment(student_name, course_name, duration, status) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, student);
            ps.setString(2, course);
            ps.setString(3, duration);
            ps.setString(4, status);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Enrolled Successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Students
    public void viewStudents() {

        try {

            String query = "SELECT * FROM enrollment";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("\n------------------------------------------------------------");
            System.out.println("ID\tStudent\t\tCourse\t\tDuration\tStatus");
            System.out.println("------------------------------------------------------------");

           while (rs.next()) {

    System.out.println("-------------------------------------");
    System.out.println("Student ID   : " + rs.getInt("id"));
    System.out.println("Student Name : " + rs.getString("student_name"));
    System.out.println("Course       : " + rs.getString("course_name"));
    System.out.println("Duration     : " + rs.getString("duration"));
    System.out.println("Status       : " + rs.getString("status"));
    System.out.println("-------------------------------------");
}

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Status
    public void updateStatus(Scanner sc) {

        try {

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Status: ");
            String status = sc.nextLine();

            String query = "UPDATE enrollment SET status=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, status);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Status Updated Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Student
    public void deleteStudent(Scanner sc) {

        try {

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            String query = "DELETE FROM enrollment WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search by Course
    public void searchCourse(Scanner sc) {

        try {

            System.out.print("Enter Course Name: ");
            String course = sc.nextLine();

            String query = "SELECT * FROM enrollment WHERE course_name=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, course);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("student_name") + " | " +
                        rs.getString("course_name") + " | " +
                        rs.getString("duration") + " | " +
                        rs.getString("status"));
            }

            if (!found) {
                System.out.println("Course Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}