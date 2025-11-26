import java.util.*;
import model.Student;
import service.StudentManager;
import util.FileUtil;

public class MainApp {
    public static void main(String[] args) {

        String file = "students.txt";

        // Load existing students
        List<Student> loaded = FileUtil.readStudents(file);
        StudentManager manager = new StudentManager(loaded);

        System.out.println("Loaded students from file:");
        manager.viewAllStudents();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== Capstone Student Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete by Name");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Save and Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    manager.addStudent(new Student(roll, name, email, course, marks));
                    break;

                case 2:
                    manager.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Name: ");
                    manager.searchByName(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter Name to Delete: ");
                    manager.deleteByName(sc.nextLine());
                    break;

                case 5:
                    manager.sortByMarks();
                    break;

                case 6:
                    FileUtil.writeStudents(file, manager.getStudents());
                    FileUtil.randomAccessDemo(file);
                    System.out.println("Saved and Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
