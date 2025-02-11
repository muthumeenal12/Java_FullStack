package library;
import java.util.*;
public class User {
	//User attributes
	private String name;
	private String userID;
	private List<Book> borrowedBooks;
	public  final  int MAX_BOOK_ALLOWED=3;
	
	@Override
	public String toString() {
		return "User [name=" + name + ", userID=" + userID + ", borrowedBooks=" + borrowedBooks + "]";
	}
	//Constructor
	public User(String name, String userID, List<Book> borrowedBooks) {
		super();
		this.name = name;
		this.userID = userID;
		this.borrowedBooks = borrowedBooks;
	}
	//Getters and setters for all the private attributes of this class
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}
	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
	
}
