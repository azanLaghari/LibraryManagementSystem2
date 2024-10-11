package librarian;

public class LibrarianModel {

	private int librarianId;
	private String role;
	private String name;
	private String userName;
	private String password;
	private String dateOfBirth ;
	
	
public LibrarianModel () {}
	
	public LibrarianModel (int librarianId2,String role2, String name2, String userName2, String password2, String dateOfBirth2) {
		
		this.dateOfBirth = dateOfBirth2;
		this.password = password2;
	    this.userName =userName2;
		this.name = name2;
		this.role = role2;
		this.librarianId = librarianId2;
		
	}			
	public int getLibrarianId() {
		return librarianId;
	}
	public void setLibrarianId(int librarianId) {
		this.librarianId = librarianId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}