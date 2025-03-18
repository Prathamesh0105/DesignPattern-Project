package university_enrollment_system;

import java.util.List;

public class GraduateInStateTuition implements TuitionStrategy {
    private static final double CREDIT_COST = 400.0;

    @Override
    public double calculateTuition(List<Course> courses) {
        int totalCredits = courses.stream()
                .mapToInt(Course::getTotalCredits)
                .sum();
        return totalCredits * CREDIT_COST;
    }
}
