import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourseEnrollment ce = new CourseEnrollment();

        while (true) {

            System.out.println("\n===== COURSE ENROLLMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Status");
            System.out.println("4. Delete Student");
            System.out.println("5. Search by Course");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {

                case 1:
                    ce.addStudent(sc);
                    break;

                case 2:
                    ce.viewStudents();
                    break;

                case 3:
                    ce.updateStatus(sc);
                    break;

                case 4:
                    ce.deleteStudent(sc);
                    break;

                case 5:
                    ce.searchCourse(sc);
                    break;

                case 6:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}