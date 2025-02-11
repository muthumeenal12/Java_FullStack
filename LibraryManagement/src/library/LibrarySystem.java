package library;
import java.util.*;
public abstract class LibrarySystem implements ILibrary {

	//create books list and users list and functions to add new books or users
	protected List<Book> books = new ArrayList<>();
	protected List<User> users= new ArrayList<>();
	public abstract void addBook(Book book);
	public abstract void addUser(User user);

}
