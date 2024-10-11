package login;

public class LoginModel {
	
	private int loginId;
	private String userName;
	private String password;
	
	
	public LoginModel() {}

	public LoginModel(int loginId2, String userName2, String password2 ) {
		
		
		this.password = password2;
		this.userName = userName2;
		this.loginId = loginId2;
	}

		
	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
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

	
	}



