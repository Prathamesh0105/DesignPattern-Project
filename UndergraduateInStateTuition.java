package university_enrollment_system;

import java.util.List;

public class UndergraduateInStateTuition implements TuitionStrategy {
    private static final double CREDIT_COST = 300.0;

    @Override
    public double calculateTuition(List<Course> courses) {
        int totalCredits = courses.stream()
                .mapToInt(Course::getTotalCredits)
                .sum();
        return totalCredits * CREDIT_COST;
    }
}
