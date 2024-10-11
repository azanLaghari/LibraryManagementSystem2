package books;

public class BooksModel {
	
	private  int bookId;
	private String bookName;
	private String bookReviews;
	private String bookQuantity;
	private String publishedDate;
	private String authorId;
	
	
	public BooksModel() {}
	
	public BooksModel(int bookId2, String bookName2, String bookReviews2, String bookQuantity2 , String publishedDate2, String  authorId2) {
		
		
		this.authorId = authorId2;
		this.publishedDate = publishedDate2;
		this.bookQuantity = bookQuantity2;
		this.bookReviews = bookReviews2;
		this.bookName = bookName2;
		this.bookId = bookId2;
	}
	
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookReviews() {
		return bookReviews;
	}

	public void setBookReviews(String bookReviews) {
		this.bookReviews = bookReviews;
	}

	public String getBookQuantity() {
		return bookQuantity;
	}

	public void setBookQuantity(String bookQuantity) {
		this.bookQuantity = bookQuantity;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String  getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
}