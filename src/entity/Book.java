package entity;

public class Book {
	private String book_id;
	private String book_code;
	private String book_name;
	private String book_author;
	private int book_saving;

	
	public String getBook_id() {
		return book_id;
	}


	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}


	public String getBook_code() {
		return book_code;
	}


	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}


	public String getBook_name() {
		return book_name;
	}


	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}


	public String getBook_author() {
		return book_author;
	}


	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}


	public int getBook_saving() {
		return book_saving;
	}


	public void setBook_saving(int book_saving) {
		this.book_saving = book_saving;
	}


	public Book(String book_id, String book_code, String book_name, String book_author, int book_saving) {
		super();
		this.book_id = book_id;
		this.book_code = book_code;
		this.book_name = book_name;
		this.book_author = book_author;
		this.book_saving = book_saving;
	}


	public Book()
	{
		
	}
}
