package library;

import java.util.*;

import util.print;

public class Main extends Thread {
    private LibraryManager libManager;

    public Main(LibraryManager libManager) {
        this.libManager = libManager;
    }

    @Override
    public void run() {
        try {
            // Library Operations in Separate Threads
            Thread borrowTask1 = new Thread(() -> {
                try {
                	Thread.sleep(2000);
                    libManager.borrowBook("1234", "0009");
                } catch (BookNotFoundException | UserNotFoundException | MaxBooksAllowedException | InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });

            Thread borrowTask2 = new Thread(() -> {
                try {
                	Thread.sleep(1500);
                    libManager.borrowBook("5678", "1234");
                } catch (BookNotFoundException | UserNotFoundException | MaxBooksAllowedException | InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });

            Thread returnTask1 = new Thread(() -> {
                try {
                	Thread.sleep(2700);
                    libManager.returnBook("1234", "0009");
                } catch (BookNotFoundException | UserNotFoundException | InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });
            Thread returnTask2 = new Thread(() -> {
                try {
                	Thread.sleep(2100);
                    libManager.returnBook("345", "0009");
                } catch (BookNotFoundException | UserNotFoundException | InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });
            Thread searchBook1 = new Thread(() -> {
                try {
                	Thread.sleep(1000);
                    libManager.searchBook("Java");
                } catch (BookNotFoundException | InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });

            // Start threads
            returnTask2.start();
            borrowTask1.start();
            searchBook1.start();           
            borrowTask2.start();
            returnTask1.start();

            // Wait for threads to complete
            borrowTask1.join();
            borrowTask2.join();
            returnTask1.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(print.LIBRARY_OPERATIONS);
    }

    public static void main(String[] args) {
        LibraryManager libManager = new LibraryManager();

        // Add books
        Book book1 = new Book("Harry Potter", "JK Rowling", "1234");
        Book book2 = new Book("Java", "Josh", "5678");
        Book book3 = new Book("Verity", "Colleen Hoover", "8768");
        Book book4 = new Book("The Compound Effect", "Darren Hardy", "345");

        libManager.addBook(book1);
        libManager.addBook(book2);
        libManager.addBook(book3);
        libManager.addBook(book4);
//        borrowed books list for each users
        List<Book> user1BorrowedBooks = new ArrayList<>();
    	user1BorrowedBooks.add(book1);
    	user1BorrowedBooks.add(book2);
    	user1BorrowedBooks.add(book3);

    	List<Book> userBorrowedBooks = new ArrayList<>();
    	userBorrowedBooks.add(book4);
    	userBorrowedBooks.add(book3);
        // Add users
        User user1 = new User("Nick", "0009",user1BorrowedBooks);
        User user2 = new User("John Doe", "1234",userBorrowedBooks);

        libManager.addUser(user1);
        libManager.addUser(user2);
        

        // Run multithreading
        Main mainThread = new Main(libManager);
        mainThread.start();
    }
}
