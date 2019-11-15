package entity;

import java.sql.Date;

public class Borrow {
	private String book_id;
	private int user_id;
	private Date borrow_date;
	
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(Date borrow_date) {
		this.borrow_date = borrow_date;
	}
	public Borrow(String book_id, int user_id, Date borrow_date) {
		super();
		this.book_id = book_id;
		this.user_id = user_id;
		this.borrow_date = borrow_date;
	}
	
	public Borrow() {
		
	}
}
