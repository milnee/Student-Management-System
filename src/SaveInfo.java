import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class SaveInfo { 

    private static final String DATA_FILE = "students.txt";


    // load students from file
    public static ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(DATA_FILE);

        if (!file.exists()) { return students; }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String studentID = parts[0].trim();
                    String name = parts[1].trim();
                    String email = parts[2].trim();
                    String course = parts[3].trim();
                    int year = Integer.parseInt(parts[4].trim());
                    double grade = Double.parseDouble(parts[5].trim());
                    students.add(new Student(studentID, name, email, course, year, grade));

                }
            }
        } catch (IOException e) {
            System.out.println("Error loading file " + DATA_FILE + ": " + e.getMessage());
        }
        return students;
    }
    public static void saveStudents(ArrayList<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            for (Student student : students) {
                writer.println(String.join(",",
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse(),
                String.valueOf(student.getYear()),
                String.valueOf(student.getGrade())));
            }
        } catch (IOException e) {
            System.out.println("Error saving students to file " + DATA_FILE + ": " + e.getMessage());
        }
    }
}



