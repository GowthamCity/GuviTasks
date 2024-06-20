package task3;
import java.util.Scanner;

//Interface Taxable
interface Taxable {
 double salesTax = 0.07;  // 7%
 double incomeTax = 0.105;  // 10.5%

 double calcTax();
}

//Employee class implementing Taxable
class Employee implements Taxable {
 private int empId;
 private String name;
 private double salary;

 // Constructor
 public Employee(int empId, String name, double salary) {
     this.empId = empId;
     this.name = name;
     this.salary = salary;
 }

 // Method to calculate income tax
 public double calcTax() {
     return salary * incomeTax;
 }
}

//Product class implementing Taxable
class Product implements Taxable {
 private int pid;
 private double price;
 private int quantity;

 // Constructor
 public Product(int pid, double price, int quantity) {
     this.pid = pid;
     this.price = price;
     this.quantity = quantity;
 }

 // Method to calculate sales tax
 public double calcTax() {
     return price * salesTax * quantity;
 }
}

//Main class
public class Q2 {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // Accept employee information
     System.out.println("Enter employee information:");
     System.out.print("Employee ID: ");
     int empId = scanner.nextInt();
     scanner.nextLine();  // Consume newline
     System.out.print("Name: ");
     String name = scanner.nextLine();
     System.out.print("Salary: ");
     double salary = scanner.nextDouble();
     Employee employee = new Employee(empId, name, salary);

     // Accept product information
     System.out.println("\nEnter product information:");
     System.out.print("Product ID: ");
     int pid = scanner.nextInt();
     System.out.print("Price per unit: ");
     double price = scanner.nextDouble();
     System.out.print("Quantity: ");
     int quantity = scanner.nextInt();
     Product product = new Product(pid, price, quantity);

     // Calculate and display taxes
     double incomeTax = employee.calcTax();
     double salesTax = product.calcTax();
     System.out.println("\nIncome Tax for " + name + ": " + incomeTax);
     System.out.println("Sales Tax for Product: " + salesTax);

     scanner.close();
 }
}
