import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine(); // clear buffer

        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<ArrayList<Integer>> studentGrades = new ArrayList<>();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();
            studentNames.add(name);

            System.out.print("Enter number of grades for " + name + ": ");
            int numGrades = sc.nextInt();
            sc.nextLine(); // clear buffer

            ArrayList<Integer> grades = new ArrayList<>();
            for (int j = 0; j < numGrades; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                grades.add(sc.nextInt());
            }
            sc.nextLine(); // clear buffer
            studentGrades.add(grades);
        }

        // Summary Report
        System.out.println("\n===== STUDENT GRADE REPORT =====");
        for (int i = 0; i < numStudents; i++) {
            ArrayList<Integer> grades = studentGrades.get(i);

            int sum = 0;
            int highest = grades.get(0);
            int lowest = grades.get(0);

            for (int g : grades) {
                sum += g;
                if (g > highest) highest = g;
                if (g < lowest) lowest = g;
            }

            double average = (double) sum / grades.size();

            System.out.println("\nStudent: " + studentNames.get(i));
            System.out.println("Grades: " + grades);
            System.out.println("Average: " + average);
            System.out.println("Highest: " + highest);
            System.out.println("Lowest: " + lowest);
        }

        sc.close();
    }
}
