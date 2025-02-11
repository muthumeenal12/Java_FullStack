package library;

public class Book {
	//Book attributes
	private String title;
	private String author;
	private String ISBN;
	private boolean available ;
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", ISBN=" + ISBN + ", available=" + available
				+ "]";
	}
	//Constructor for Book class
	public Book(String title, String author, String iSBN) {
		super();
		this.title = title;
		this.author = author;
		ISBN = iSBN;
	}
	//To find the availability of the book 
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	//getters and setters for private attributes of this class
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

}
