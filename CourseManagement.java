import java.util.*;

class Course {
    int id;
    String name;
    double fee;
    String instructor;

    Course(int id, String name, double fee, String instructor) {
        this.id = id;
        this.name = name;
        this.fee = fee;
        this.instructor = instructor;
    }

    public String toString() {
        return "ID: " + id + " | Course: " + name + " | Fee: " + fee + " | Instructor: " + instructor;
    }
}

public class CourseManagement {
    static List<Course> courses = new ArrayList<>();
    static int courseId = 1;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Course  2. View Courses  3. Update Course  4. Delete Course  5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1: addCourse(); break;
                case 2: viewCourses(); break;
                case 3: updateCourse(); break;
                case 4: deleteCourse(); break;
                case 5: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    static void addCourse() {
        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Fee: ");
        double fee = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Instructor: ");
        String instructor = scanner.nextLine();

        courses.add(new Course(courseId++, name, fee, instructor));
        System.out.println("Course Added!");
    }

    static void viewCourses() {
        if (courses.isEmpty()) System.out.println("No courses available.");
        else for (Course c : courses) System.out.println(c);
    }

    static void updateCourse() {
        System.out.print("Enter Course ID to Update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Course c : courses) {
            if (c.id == id) {
                System.out.print("New Name: "); c.name = scanner.nextLine();
                System.out.print("New Fee: "); c.fee = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("New Instructor: "); c.instructor = scanner.nextLine();
                System.out.println("Course Updated!");
                return;
            }
        }
        System.out.println("Course ID Not Found!");
    }

    static void deleteCourse() {
        System.out.print("Enter Course ID to Delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        courses.removeIf(c -> c.id == id);
        System.out.println("Course Deleted!");
    }
}