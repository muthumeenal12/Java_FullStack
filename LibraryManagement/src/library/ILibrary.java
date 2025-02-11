package library;

public interface ILibrary {
	//Function to borrowBook from library
	public void borrowBook(String ISBN,String userID) throws BookNotFoundException,
	UserNotFoundException,MaxBooksAllowedException;
	//Function to return the borrowed books
	public void returnBook(String ISBN,String userID) throws BookNotFoundException,
	UserNotFoundException;
	//Function to reserve the book 
	public void reserveBook(String ISBN,String userID) throws BookNotFoundException,
	UserNotFoundException;
	//function to search the book
	Book searchBook(String title) throws BookNotFoundException;
}
//Different custom exception classes
class BookNotFoundException extends Exception {
 public BookNotFoundException(String message) {
     super(message);
 }
}

class UserNotFoundException extends Exception {
 public UserNotFoundException(String message) {
     super(message);
 }
}

class MaxBooksAllowedException extends Exception {
 public MaxBooksAllowedException(String message) {
     super(message);
 }
}
