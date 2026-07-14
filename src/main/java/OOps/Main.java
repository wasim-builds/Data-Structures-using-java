package OOps;
//21MIS7125
import java.util.Scanner;

interface Student {
    void calculateGrade(int mark1, int mark2, int mark3);

    default void display(String grade) {
        System.out.println("Grade: " + grade);
    }
}

public class Main implements Student {

    @Override
    public void calculateGrade(int mark1, int mark2, int mark3) {
        int average = (mark1 + mark2 + mark3) / 3;
        String grade;

        if (average >= 90 && average <= 100) {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else if (average >= 60) {
            grade = "D";
        } else if (average >= 50) {
            grade = "E";
        } else {
            grade = "F";
        }

        display(grade);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Mark 1: ");
        int mark1 = scanner.nextInt();

        System.out.print("Enter Mark 2: ");
        int mark2 = scanner.nextInt();

        System.out.print("Enter Mark 3: ");
        int mark3 = scanner.nextInt();

        Main student = new Main();
        student.calculateGrade(mark1, mark2, mark3);
    }
}
