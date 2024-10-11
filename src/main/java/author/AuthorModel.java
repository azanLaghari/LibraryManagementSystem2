package author;

public class AuthorModel {
	
	private int authorId;
	private String authorName;
	private String authorDateofBirth;
	private String authorReview;
	
	
	
	
	public AuthorModel() {}

	public AuthorModel(int authorId2, String authorName2, String authorDateofBirth2, String authorReview2 ) {
		
		
		
		this.authorReview = authorReview2;
		this.authorDateofBirth = authorDateofBirth2;
		this.authorName = authorName2;
		this.authorId = authorId2;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorDateofBirth() {
		return authorDateofBirth;
	}

	public void setAuthorDateofBirth(String authorDateofBirth) {
		this.authorDateofBirth = authorDateofBirth;
	}

	public String getAuthorReview() {
		return authorReview;
	}

	public void setAuthorReview(String authorReview) {
		this.authorReview = authorReview;
	}
	
	}	
		




