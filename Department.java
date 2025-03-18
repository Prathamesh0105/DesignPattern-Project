package university_enrollment_system;

import java.util.List;
import java.util.ArrayList;

public class Department implements AcademicComponent {
    private String name;
    private List<AcademicComponent> components = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getTotalCredits() {
        return components.stream()
                .mapToInt(AcademicComponent::getTotalCredits)
                .sum();
    }

    @Override
    public void add(AcademicComponent component) {
        components.add(component);
    }

    @Override
    public void remove(AcademicComponent component) {
        components.remove(component);
    }

    public List<AcademicComponent> getComponents() {
        return components;
    }
}
