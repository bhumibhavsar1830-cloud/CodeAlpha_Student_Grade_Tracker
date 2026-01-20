import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int marks;
    double percentage;
    char grade;
    String status;

    // Constructor
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
        this.percentage = marks;   // marks are out of 100
        this.grade = calculateGrade(marks);
        this.status = calculateStatus(percentage);
    }

    // Grade calculation
    static char calculateGrade(int marks) {
        if (marks >= 90)
            return 'A';
        else if (marks >= 80)
            return 'B';
        else if (marks >= 70)
            return 'C';
        else if (marks >= 60)
            return 'D';
        else
            return 'F';
    }

    // Pass/Fail calculation (below 35 = Fail)
    static String calculateStatus(double percentage) {
        if (percentage >= 35)
            return "Pass";
        else
            return "Fail";
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Summary Report");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter marks (0-100): ");
                    int marks = sc.nextInt();

                    students.add(new Student(name, marks));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    displayReport(students);
                    break;

                case 3:
                    System.out.println("Thank you for using Student Grade Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);

        sc.close();
    }

    // Display report
    static void displayReport(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        int total = 0;
        int highest = students.get(0).marks;
        int lowest = students.get(0).marks;

        System.out.println("\n--- STUDENT SUMMARY REPORT ---");
        System.out.println("Name\tMarks\tPercentage\tGrade\tStatus");

        for (Student s : students) {
            System.out.println(
                s.name + "\t" +
                s.marks + "\t" +
                s.percentage + "%\t\t" +
                s.grade + "\t" +
                s.status
            );

            total += s.marks;
            if (s.marks > highest) highest = s.marks;
            if (s.marks < lowest) lowest = s.marks;
        }

        double average = (double) total / students.size();

        System.out.println("\nTotal Students : " + students.size());
        System.out.println("Average Marks  : " + average);
        System.out.println("Highest Marks  : " + highest);
        System.out.println("Lowest Marks   : " + lowest);
    }
}
