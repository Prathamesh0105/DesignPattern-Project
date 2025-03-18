package university_enrollment_system;

import java.util.List;
import java.util.ArrayList;

public class GraduateStudent implements Student {
    private String id;
    private String name;
    private List<Course> enrolledCourses = new ArrayList<>();
    private TuitionStrategy tuitionStrategy;

    public GraduateStudent(String id, String name) {
        this.id = id;
        this.name = name;
        this.tuitionStrategy = new GraduateInStateTuition(); // Default strategy
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        course.enrollStudent(this);
    }

    @Override
    public void update(String message) {
        System.out.println("Student " + name + " received notification: " + message);
    }

    @Override
    public double calculateTuition() {
        return tuitionStrategy.calculateTuition(enrolledCourses);
    }

    @Override
    public void setTuitionStrategy(TuitionStrategy strategy) {
        this.tuitionStrategy = strategy;
    }
}
