import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        students = SaveInfo.loadStudents();


        int choice;
        do {

        showMenu();
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> addStudent();
            case 2 -> viewStudents();
            case 3 -> searchStudent();
            case 4 -> updateGrade();
            case 5 -> { 
                SaveInfo.saveStudents(students);
                System.out.println("Exiting program...");
                break;
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }

        } while (choice != 5);

    }

    private static void showMenu() {
        System.out.println("Student Management System");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Update Grade");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // add a student
    private static void addStudent() {

        System.out.println("Enter student ID: ");
        String studentID = scanner.nextLine();

        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("Enter email: ");
        String email = scanner.nextLine();

        System.out.println("Enter course: ");
        String course = scanner.nextLine();

        System.out.println("Enter year: ");
        int year = scanner.nextInt();

        System.out.println("Enter grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine();

        Student student = new Student(studentID, name, email, course, year, grade);
        students.add(student);
        SaveInfo.saveStudents(students);
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println(student);
        System.out.println("✅ Student added successfully.");
        System.out.println("--------------------------------");
        System.out.println();
    }
    // view all students
    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("❌ No students found.");
            System.out.println("--------------------------------");
            System.out.println();
            return;
        }
        System.out.println("Students List:");
        for (Student student : students) {
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Course: " + student.getCourse());
            System.out.println("Year: " + student.getYear());
            System.out.println("Grade: " + student.getGrade());
            System.out.println("--------------------------------");
            System.out.println();
        }
    }

    // search a student by ID

    private static void searchStudent() {
        System.out.println("Enter student ID: ");
        String searchID = scanner.nextLine();

        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(searchID)) {
                System.out.println();
                System.out.println("--------------------------------");
                System.out.println("✅ Student found: \n");
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Email: " + student.getEmail());
                System.out.println("Course: " + student.getCourse());
                System.out.println("Year: " + student.getYear());
                System.out.println("Grade: " + student.getGrade());
                System.out.println("--------------------------------");
                System.out.println();
                return;
            }
        }
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("❌ Student not found.");
        System.out.println("--------------------------------");
        System.out.println();
    }
    // UPDATE A STUDENT'S GRADE

    private static void updateGrade() {

        System.out.println("Enter student ID to update grade: ");
        String updateID = scanner.nextLine();

        for (Student student : students) {

        if (student.getId().equalsIgnoreCase(updateID)) {
            System.out.println("Enter new grade: ");
            double newGrade = scanner.nextDouble();
            scanner.nextLine();
            student.setGrade(newGrade);
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("✅ Grade updated successfully.");
            System.out.println("--------------------------------");
            System.out.println();
            SaveInfo.saveStudents(students);
            return;
        }
    }
    System.out.println();
    System.out.println("--------------------------------");
    System.out.println("❌ Student not found.");
    System.out.println("--------------------------------");
    System.out.println();
}
}

