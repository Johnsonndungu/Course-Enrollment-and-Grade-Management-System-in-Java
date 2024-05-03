import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManagement {

    private String code;
    private String name;
    private int capacity;
    private static final List<Course> course = new ArrayList<>();
    private static Map<Student, Map<Course, Double>> studentGrades = new HashMap<>();

    public static List<Course> getCourse() {
        return CourseManagement.course;
    }

    // Method to add a new course
    public static void addCourse(String courseCode, String courseName, int maxCapacity) {
        Course newCourse = new Course(courseCode, courseName, maxCapacity);
        course.add(newCourse);
    }

    // Method to enroll a student in a course
    public static void enrollStudent(Student student, Course course) {

        course.enrollStudent(student);
    }

    // Method to assign grade to a student for a course
    public static void assignGrade(Student student, Course course, double grade) {
        if (!studentGrades.containsKey(student)) {
            studentGrades.put(student, new HashMap<>());
        }
        studentGrades.get(student).put(course, grade);
        course.assignGrade(student, grade); // Update grade in Course class
    }

    // Method to calculate overall course grade for a student
    public static double calculateOverallGrade(Student student) {
        if (!studentGrades.containsKey(student)) {
            return 0.0; // Return 0 if no grades assigned
        }
        double totalGrade = 0.0;
        int count = 0;
        for (Map.Entry<Course, Double> entry : studentGrades.get(student).entrySet()) {
            totalGrade += entry.getValue();
            count++;
        }
        return totalGrade / count;
    }

    // Getter method for courses (if needed)
    public static List<Course> getCourses() {
        return course;
    }
}
