# University Enrollment System

## Overview
This project is a **University Enrollment System** built in Java, implementing key **design patterns** to enhance the system's architecture and maintainability. The system allows for the management of students, courses, tuition fees, and department-related functionality. The use of design patterns such as **Factory**, **Observer**, and **Strategy** ensures that the system is modular, scalable, and flexible for future enhancements.

## Design Patterns Used
The following design patterns were implemented in the project to improve code structure:

1. **Factory Pattern** 
   - Used for creating different types of students (Graduate, Undergraduate) and their corresponding tuition fee objects.
   
2. **Singleton Pattern**  
   - Ensures that only one instance of the **UniversityEnrollmentSystem** class is created to manage the entire enrollment process.
   
3. **Strategy Pattern**  
   - Used to define different tuition strategies (In-State, Out-of-State) for both Graduate and Undergraduate students, making it easy to change tuition calculation methods.
   
4. **Observer Pattern**  
   - Allows the system to notify relevant components (e.g., departments or students) when certain events (like enrollment status changes) occur, promoting loose coupling.

## Project Components

- **AcademicComponent.java**  
   The base class for various academic components in the system (e.g., departments, courses).
   
- **Course.java**  
   Represents a course in the university, including course details and enrollment information.
   
- **Department.java**  
   Manages departments in the university and handles student enrollments within a department.
   
- **GraduateInStateTuition.java**  
   Implements the strategy for calculating in-state tuition fees for graduate students.
   
- **GraduateOutStateTuition.java**  
   Implements the strategy for calculating out-of-state tuition fees for graduate students.
   
- **GraduateStudent.java**  
   Represents a graduate student and implements the common behavior of a student.
   
- **Observer.java**  
   Defines the observer interface used to notify interested parties about changes in the system.
   
- **Student.java**  
   Represents a student and includes functionality for enrollment and tuition calculation.
   
- **StudentFactory.java**  
   A factory class for creating students (both graduate and undergraduate) based on specific criteria.
   
- **TuitionStrategy.java**  
   The strategy interface used to calculate tuition fees for students.
   
- **UndergraduateInStateTuition.java**  
   Implements the strategy for calculating in-state tuition fees for undergraduate students.
   
- **UndergraduateOutStateTuition.java**  
   Implements the strategy for calculating out-of-state tuition fees for undergraduate students.
   
- **UndergraduateStudent.java**  
   Represents an undergraduate student and implements the common behavior of a student.
   
- **UniversityEnrollmentSystem.java**  
   The core class of the system that integrates all components and manages the enrollment process.

## How to Run the Project
1. Clone this repository to your local machine.
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Compile and run the **UniversityEnrollmentSystem.java** class.
4. Follow the prompts in the console to simulate student enrollment and tuition fee calculations.

## Future Enhancements
- **User Interface**: Implement a GUI for better interaction.
- **Database Integration**: Connect to a database to store student and course information.
- **Additional Design Patterns**: Incorporate more design patterns to enhance the system further.
