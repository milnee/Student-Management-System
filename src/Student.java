public class Student {

    private String studentID;
    private String name;
    private String email;
    private String course;
    private int year;
    private double grade;

    public Student(String id, String name, String email, String course, int year, double grade) {
        this.studentID = id.toUpperCase();
        this.name = name;
        this.email = email;
        this.course = course;
        this.year = year;
        this.grade = grade;
    }

    public String getId() { return studentID; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public int getYear() { return year; }
    public double getGrade() { return grade; }
    
public void setStudentID(String studentID) { this.studentID = studentID.toUpperCase(); }
public void setName(String name) { this.name = name.trim(); }
public void setEmail(String email) { this.email = email.toLowerCase(); }
public void setCourse(String course) { this.course = course; }
public void setYear(int year) { this.year = year; }
public void setGrade(double grade) { this.grade = grade; }


@Override
public String toString() {
    return String.format("ID: %s | Name: %s | Email: %s | Course: %s | Year: %d | Grade: %.2f",
    studentID, name, email, course, year, grade);
}
}