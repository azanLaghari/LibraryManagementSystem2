package members;

public class MembersModel {


	private int  memberId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
//	private String memberShipStartDate;
//	private String memberShipEndDate;
	
	public MembersModel() {}

	public MembersModel(int memberId2, String firstName2, String lastName2, String dateOfBirth2) {
	
//		this.memberShipEndDate = memberShipEndDate2;
//		this.memberShipStartDate = memberShipStartDate2;
		this.dateOfBirth = dateOfBirth2;
		this.lastName = lastName2;
		this.firstName = firstName2;
		this.memberId = memberId2;
	}         
	
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

//	public String getMembershipStartDate() {
//		return memberShipStartDate;
//	}
//
//	public void setMembershipStartDate(String membershipStartDate) {
//		this.memberShipStartDate = membershipStartDate;
//	}
//
//	public String getMemberShipEndDate() {
//		return memberShipEndDate;
//	}
//
//	public void setMemberShipEndDate(String memberShipEndDate) {
//		this.memberShipEndDate = memberShipEndDate;
//	}

	}
	
	
	

