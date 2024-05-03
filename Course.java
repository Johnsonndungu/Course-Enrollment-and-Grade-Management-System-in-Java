import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private static int totalEnrolledStudents = 0;
    private List<Student> enrolledStudents;

    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        enrolledStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }

    // Method to enroll a student
    public void enrollStudent(Student student) {
        if (enrolledStudents.size() < maxCapacity) {
            enrolledStudents.add(student);
            totalEnrolledStudents++;
            System.out.println("Student " + student.getName() + " enrolled in course " + courseCode);
        } else {
            System.out.println("Course " + courseCode + " is already at maximum capacity.");
        }
    }

    // Method to assign grade to a student
    public void assignGrade(Student student, double grade) {
        student.setGrade(grade);
        System.out.println("Grade " + grade + " assigned to student " + student.getName() + " for course " + courseCode);
    }
}
