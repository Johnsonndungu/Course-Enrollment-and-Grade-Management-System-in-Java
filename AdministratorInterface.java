import java.util.Scanner;

public class AdministratorInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    enrollStudent();
                    break;
                case 3:
                    assignGrade();
                    break;
                case 4:
                    calculateOverallGrade();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Administrator Interface");
        System.out.println("1. Add a new course");
        System.out.println("2. Enroll students");
        System.out.println("3. Assign grades");
        System.out.println("4. Calculate overall course grades");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
        return choice;
    }

    private static void addCourse() {
        System.out.println("Enter course code:");
        String code = scanner.nextLine();
        System.out.println("Enter course name:");
        String name = scanner.nextLine();
        System.out.println("Enter maximum capacity:");
        int capacity = Integer.parseInt(scanner.nextLine());
        CourseManagement.addCourse(code, name, capacity);
        System.out.println("Course added successfully.");
    }

    private static void enrollStudent() {
        System.out.println("Enter student name:");
        String name = scanner.nextLine();
        System.out.println("Enter student ID:");
        int id;
        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
        System.out.println("Enter student age:");
        int age;
        while (true) {
            try {
                age = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
        System.out.println("Enter student grade:");
        double grade;
        while (true) {
            try {
                grade = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
        Student student = new Student(name, id, age, grade);
        System.out.println("Enter course code to enroll the student:");
        String code = scanner.nextLine();
        Course course = findCourse(code);

        if (course != null) {
            // Call CourseManagement.enrollStudent(student, course) here
            // CourseManagement.enrollStudent(student, course);
            System.out.println("Student enrolled successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    private static void assignGrade() {
        System.out.println("Enter student name:");
        String name = scanner.nextLine();
        System.out.println("Enter course code:");
        String code = scanner.nextLine();
        Course course = findCourse(code);

        if (course != null) {
            System.out.println("Enter grade:");
            double grade = Double.parseDouble(scanner.nextLine());
            Student student = new Student(name, 0, 0, 0); // Dummy student with minimum details
            CourseManagement.assignGrade(student, course, grade);
        } else {
            System.out.println("Course not found.");
        }
    }

    private static void calculateOverallGrade() {
        System.out.println("Enter student name:");
        String name = scanner.nextLine();
        Student student = new Student(name, 0, 0, 0); // Dummy student with minimum details
        double overallGrade = CourseManagement.calculateOverallGrade(student);
        System.out.println("Overall grade for student " + name + ": " + overallGrade);
    }


        for (Course course : CourseManagement.getCourse()) {
            if (course.getCourseCode().equals(code)) {
                return course;
            }
        }
        return null;
    }}
