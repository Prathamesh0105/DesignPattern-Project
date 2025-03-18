package university_enrollment_system;

import java.util.List;

public interface TuitionStrategy {
    double calculateTuition(List<Course> courses);
}
