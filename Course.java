package university_enrollment_system;

import java.util.List;
import java.util.ArrayList;

public class Course implements AcademicComponent {
    private String name;
    private int credits;
    private List<Student> enrolledStudents = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getTotalCredits() {
        return credits;
    }

    @Override
    public void add(AcademicComponent component) {
        throw new UnsupportedOperationException("Cannot add to a course");
    }

    @Override
    public void remove(AcademicComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a course");
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        addObserver(student);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyScheduleChange(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
        System.out.println("Notification sent for course " + name + ": " + message);
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
}

