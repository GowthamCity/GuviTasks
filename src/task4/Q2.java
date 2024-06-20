package task4;

class InvalidAgeException extends Exception {
 public InvalidAgeException(String message) {
     super(message);
 }
}

class Voter {
 private int voterId;
 private String name;
 private int age;
 
 public Voter(int voterId, String name, int age) throws InvalidAgeException {
     if (age < 18) {
         throw new InvalidAgeException("Invalid age for voter");
     }
     this.voterId = voterId;
     this.name = name;
     this.age = age;
 }
 
 public void displayDetails() {
     System.out.println("Voter ID: " + voterId);
     System.out.println("Name: " + name);
     System.out.println("Age: " + age);
 }
}

public class Q2 {
 public static void main(String[] args) {
     try {
         Voter voter1 = new Voter(1, "Alice", 25);
         voter1.displayDetails();
         
         Voter voter2 = new Voter(2, "Bob", 16);
         voter2.displayDetails(); 
     } catch (InvalidAgeException e) {
         System.out.println("Exception caught: " + e.getMessage());
     }
 }
}
