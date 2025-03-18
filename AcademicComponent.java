package university_enrollment_system;

public interface AcademicComponent {
    String getName();
    int getTotalCredits();
    void add(AcademicComponent component);
    void remove(AcademicComponent component);
}

