package university_enrollment_system;

public interface Student extends Observer {
    String getId();
    String getName();
    void enrollInCourse(Course course);
    double calculateTuition();
    void setTuitionStrategy(TuitionStrategy strategy);
}
