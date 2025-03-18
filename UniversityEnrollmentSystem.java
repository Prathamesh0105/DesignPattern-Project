package university_enrollment_system;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class UniversityEnrollmentSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Department> departments = new ArrayList<>();

    public static void main(String[] args) {
        initializeDepartments();
        displayMenu();
    }

    private static void initializeDepartments() {
        Department computerScience = new Department("Computer Science");
        Course java101 = new Course("Java Programming", 3);
        Course algorithms = new Course("Algorithms", 4);
        computerScience.add(java101);
        computerScience.add(algorithms);
        departments.add(computerScience);

        Department mathematics = new Department("Mathematics");
        Course calculus = new Course("Calculus I", 4);
        Course algebra = new Course("Linear Algebra", 3);
        mathematics.add(calculus);
        mathematics.add(algebra);
        departments.add(mathematics);
    }

    private static void displayMenu() {
        while (true) {
            System.out.println("\nUniversity Enrollment System");
            System.out.println("1. List Departments");
            System.out.println("2. Enroll Student");
            System.out.println("3. Notify Course Change");
            System.out.println("4. Calculate Tuition");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> listDepartments();
                case 2 -> enrollStudent();
                case 3 -> notifyCourseChange();
                case 4 -> calculateTuition();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void listDepartments() {
        System.out.println("Departments:");
        for (Department department : departments) {
            System.out.println("- " + department.getName() + " (Total Credits: " + department.getTotalCredits() + ")");
            for (AcademicComponent course : department.getComponents()) {
                System.out.println("  - Course: " + course.getName() + " (Credits: " + course.getTotalCredits() + ")");
            }
        }
    }

    private static void enrollStudent() {
        System.out.print("Enter student type (undergraduate/graduate): ");
        String type = scanner.nextLine().trim();
        while (type.isEmpty()) {
            System.out.print("Student type cannot be empty. Enter student type (undergraduate/graduate): ");
            type = scanner.nextLine().trim();
        }

        System.out.print("Enter student ID: ");
        String id = scanner.nextLine().trim();
        while (id.isEmpty()) {
            System.out.print("Student ID cannot be empty. Enter student ID: ");
            id = scanner.nextLine().trim();
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Student name cannot be empty. Enter student name: ");
            name = scanner.nextLine().trim();
        }

        Student student = StudentFactory.createStudent(type, id, name);

        System.out.print("Enter course name to enroll in: ");
        String courseName = scanner.nextLine().trim();
        while (courseName.isEmpty()) {
            System.out.print("Course name cannot be empty. Enter course name to enroll in: ");
            courseName = scanner.nextLine().trim();
        }

        boolean enrolled = false;
        for (Department department : departments) {
            for (AcademicComponent course : department.getComponents()) {
                if (course.getName().equalsIgnoreCase(courseName)) {
                    student.enrollInCourse((Course) course);
                    enrolled = true;
                    System.out.println(student.getName() + " has been enrolled in " + course.getName());
                    break;
                }
            }
            if (enrolled) break;
        }
        if (!enrolled) {
            System.out.println("Course not found.");
        }
    }

    private static void notifyCourseChange() {
        System.out.print("Enter course name for notification: ");
        String courseName = scanner.nextLine().trim();
        while (courseName.isEmpty()) {
            System.out.print("Course name cannot be empty. Enter course name for notification: ");
            courseName = scanner.nextLine().trim();
        }

        System.out.print("Enter notification message: ");
        String message = scanner.nextLine().trim();
        while (message.isEmpty()) {
            System.out.print("Notification message cannot be empty. Enter notification message: ");
            message = scanner.nextLine().trim();
        }

        boolean found = false;
        for (Department department : departments) {
            for (AcademicComponent course : department.getComponents()) {
                if (course.getName().equalsIgnoreCase(courseName)) {
                    ((Course) course).notifyScheduleChange(message);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        if (!found) {
            System.out.println("Course not found.");
        }
    }

    private static void calculateTuition() {
        System.out.print("Enter student ID for tuition calculation: ");
        String id = scanner.nextLine().trim();
        while (id.isEmpty()) {
            System.out.print("Student ID cannot be empty. Enter student ID for tuition calculation: ");
            id = scanner.nextLine().trim();
        }

        for (Department department : departments) {
            for (AcademicComponent course : department.getComponents()) {
                for (Student student : ((Course) course).getEnrolledStudents()) {
                    if (student.getId().equals(id)) {
                        System.out.println("Tuition for " + student.getName() + ": $" + student.calculateTuition());
                        return;
                    }
                }
            }
        }
        System.out.println("Student not found.");
    }
}
