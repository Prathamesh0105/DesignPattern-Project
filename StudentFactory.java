package university_enrollment_system;

public class StudentFactory {
    public static Student createStudent(String type, String id, String name) {
        return switch (type.toLowerCase()) {
            case "undergraduate" -> new UndergraduateStudent(id, name);
            case "graduate" -> new GraduateStudent(id, name);
            default -> throw new IllegalArgumentException("Invalid student type");
        };
    }
}

