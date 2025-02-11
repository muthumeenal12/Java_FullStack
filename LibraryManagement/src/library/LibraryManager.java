package library;
import util.print;
public class LibraryManager extends LibrarySystem {

	@Override
	public void borrowBook(String ISBN, String userID)
			throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException {
		// TODO Auto-generated method stub
		//Find address of the book
		Book bookToBorrow =findBook(ISBN);
		if (bookToBorrow == null) {
			throw new BookNotFoundException(print.ISBN + ISBN + print.NOT_FOUND);
		}
		// Find the user by userID
		User user = findUser(userID);
		if (user == null) {
			throw new UserNotFoundException(print.USER_ID + userID + print.NOT_FOUND);
		}
		//Check if book is already borrowed by the user
		boolean alreadyBorrowed = user.getBorrowedBooks().stream().anyMatch(borrowedISBN -> borrowedISBN.equals(ISBN));
		if (alreadyBorrowed) {
			System.out.println(print.ALREADY_BORROWED);
			return;
		}
		// Check if the user has exceeded the borrowing limit
		if (user.getBorrowedBooks().size() >= user.MAX_BOOK_ALLOWED) {
			throw new MaxBooksAllowedException("User " + user.getName() + print.BORROWING_LIMIT);
		}
		//Add book to the borrowed book list
		user.getBorrowedBooks().add(bookToBorrow);
		bookToBorrow.setAvailable(false);
		System.out.println("User " + user.getName() + "{" + user.getUserID() + "}" + " borrowed "
				+ bookToBorrow.getTitle() + " successfully.");

	}

	@Override
	public void returnBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
		// TODO Auto-generated method stub
		//Get the user address
		User user = findUser(userID);
		if (user == null) {
			throw new UserNotFoundException(print.USER_ID + userID + print.NOT_FOUND);
		}
		//Find the book address
		Book bookToReturn = findBook(ISBN);
		if (bookToReturn == null) {
			throw new BookNotFoundException(print.ISBN + ISBN +print.NOT_FOUND);
		}
		//Remove book from the user
		if(user.getBorrowedBooks().contains(bookToReturn)) {
		user.getBorrowedBooks().remove(bookToReturn);
		bookToReturn.setAvailable(true);
		System.out.println("User " + user.getName() + '{' + user.getUserID() + '}' + "Returned "
				+ bookToReturn.getTitle() + " Successfully");}
		else {
			System.out.println("User "+user.getName()+" didn't borrow "+bookToReturn.getTitle());
		}

	}

	@Override
	public void reserveBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
		// TODO Auto-generated method stub
//		Find user address using userID
		User user = findUser(userID);
		if (user == null) {
			throw new UserNotFoundException(print.USER_ID + userID + print.NOT_FOUND);
		}
//		Find book address using ISBN
		Book toReserve = findBook(ISBN);
		if (toReserve == null) {
			throw new BookNotFoundException(print.ISBN + ISBN + print.NOT_FOUND);
		}
//		ReserveBook 
		if (toReserve.isAvailable()) {
			System.out.println("Book available..");

		} else
			System.out.println("Book reserved");

	}
//	Find user address using userID
	public User findUser(String userID) {
		for (User u : users) {
			if (u.getUserID().equals(userID)) {
				return u;
			}
		}
		return null;
	}

	//function to find book address using ISBN
	public Book findBook(String ISBN)
	{
		for (Book b : books) {
			if (b.getISBN().equals(ISBN)) {
				return b;
			}
		}
		return null;
	}
	@Override
//	Search book using title
	public Book searchBook(String title) throws BookNotFoundException {
		// TODO Auto-generated method stub
		for (Book b : books) {
			if (b.getTitle().equals(title)) {
				System.out.println("Book " + title + " is in stock.");
				return b;
			}
		}
		return null;
	}

	@Override
//	Function to add book to book list
	public void addBook(Book book) {
		// TODO Auto-generated method stub
//		Check if book address is not null
		if (book == null) {
			System.out.println("Invalid Entry");
			return;
		}
//		check if the book is already in book list 
		for (Book b : books) {
			if (b.getISBN().equals(book.getISBN())) {
				System.out.println("Already Exist");
				return;
			}
		}
//		Add book
		book.setAvailable(true);
		books.add(book);
		System.out.println("Book " + book.getTitle() + " added");

	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		//check if user address is null or not
		if (user == null) {
			System.out.println("Invalid user entry");
			return;
		}
		//check if user already exist
		for (User u : users) {
			if (u.getUserID().equals(user.getUserID())) {
				System.out.println("User already exists");
				return;
			}
		}
		//if not add user
		users.add(user);
		System.out.println("User " + user.getName() + " successfully added");
	}

}
