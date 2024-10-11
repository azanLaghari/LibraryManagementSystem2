package booksOut;

public class BooksOutModel {
	private  int id;
	private String bookId;
	private String memberId;
	private String authorId;
	private String dateOfOut;
	private String dateOfReturn;
	private String librarianId;
	
	public  BooksOutModel() {}

	public  BooksOutModel(int id2, String bookId2, String memberId2, String authorId2 , String dateOfOut2, String dateOfReturn2,String librarianId2 ) {
		
		
		this.librarianId = librarianId2;
		this.dateOfReturn = dateOfReturn2;
		this.dateOfOut = dateOfOut2;
		this.authorId = authorId2;
		this.memberId = memberId2;
		this.bookId = bookId2;
		this.id = id2;
	}
		
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getDateOfOut() {
		return dateOfOut;
	}

	public void setDateOfOut(String dateOfOut) {
		this.dateOfOut = dateOfOut;
	}

	public String getDateOfReturn() {
		return dateOfReturn;
	}

	public void setDateOfReturn(String dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}

	public String getLibrarianId() {
		return librarianId;
	}

	public void setLibrarianId(String librarianId) {
		this.librarianId = librarianId;
	}


	
}

