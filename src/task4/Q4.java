package task4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q4 {
    private Map<String, Integer> Q4;

    public Q4() {
        this.Q4 = new HashMap<>();
    }

    // Method to add a new student
    public void addStudent(String name, int grade) {
    	Q4.put(name, grade);
        System.out.println(name + " has been added with grade " + grade);
    }

    // Method to remove a student
    public void removeStudent(String name) {
        if (Q4.containsKey(name)) {
            int grade = Q4.remove(name);
            System.out.println(name + " has been removed with grade " + grade);
        } else {
            System.out.println("Student " + name + " not found");
        }
    }

    // Method to display a student's grade by name
    public void displayGrade(String name) {
        Integer grade = Q4.get(name);
        if (grade != null) {
            System.out.println(name + "'s grade is: " + grade);
        } else {
            System.out.println("Student " + name + " not found");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q4 tracker = new Q4();

        // Adding some initial students
        tracker.addStudent("Alice", 85);
        tracker.addStudent("Bob", 90);
        tracker.addStudent("Charlie", 78);

        // Menu to interact with the tracker
        while (true) {
            System.out.println("\n===== MENU =====\n");
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. Display a student's grade");
            System.out.println("4. Exit");
            System.out.println("\n=======================");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student's name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter student's grade: ");
                    int newGrade = scanner.nextInt();
                    tracker.addStudent(newName, newGrade);
                    break;
                case 2:
                    System.out.print("Enter student's name to remove: ");
                    String removeName = scanner.nextLine();
                    tracker.removeStudent(removeName);
                    break;
                case 3:
                    System.out.print("Enter student's name to display grade: ");
                    String displayName = scanner.nextLine();
                    tracker.displayGrade(displayName);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter again.");
                    break;
            }
        }
    }
}
