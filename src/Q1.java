package task3;

import java.util.Scanner;

class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void displayBookInfo() {
    	System.out.println("---------------------");
        System.out.println("Book ID: " + bookID);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        String availability = (isAvailable ? "Available" : "Not Available");
        System.out.println("Availability: " +availability );
    }
}


class Library {
    private Book[] books;
    private int numBooks;

    // Constructor
    public Library(int capacity) {
        books = new Book[capacity];
        numBooks = 0;
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        if (numBooks < books.length) {
            books[numBooks] = book;
            numBooks++;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Method to remove a book from the library
    public void removeBook(int bookID) {
        boolean found = false;
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getBookID() == bookID) {
                books[i] = books[numBooks - 1];
                numBooks--;
                found = true;
                System.out.println("Book removed successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Book with ID " + bookID + " not found.");
        }
    }

    // Method to search for a book by ID
    public void searchBook(int bookID) {
        boolean found = false;
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getBookID() == bookID) {
                books[i].displayBookInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book with ID " + bookID + " not found.");
        }
    }

    // Method to display all books in the library
    public void displayBooks() {
        if (numBooks == 0) {
            System.out.println("Library is empty.");
        } else {
            System.out.println("Books in the library:");
            for (int i = 0; i < numBooks; i++) {
                books[i].displayBookInfo();
                System.out.println("---------------------");
            }
        }
    }
}

// Main class to demonstrate library system
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a library with a capacity of 10 books
        Library library = new Library(10);

        // Menu for user interaction
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(bookID, title, author);
                    library.addBook(newBook);
                    break;
                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeID = scanner.nextInt();
                    library.removeBook(removeID);
                    break;
                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchID = scanner.nextInt();
                    library.searchBook(searchID);
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
            
        }
    }
}
