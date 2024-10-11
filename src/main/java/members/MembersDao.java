package members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class MembersDao {

	public void addMembers(MembersModel member) {
		try {
			
			Util util = new Util();
			Connection connection =  util.getConnection();
			PreparedStatement pd = connection.prepareStatement("INSERT INTO `members` (firstName, lastName, dateOfBirth) VALUES (?, ?, ?)");

			pd.setString(1,member.getFirstName());
			pd.setString(2,member.getLastName());
			pd.setString(3,member.getDateOfBirth());
//			pd.setString(4,member.getMembershipStartDate());
//			pd.setString(5,member.getMemberShipEndDate());
			pd.executeUpdate();
			
		}catch(Exception ex) {
			ex.getMessage();
		}
	}
	public MembersModel selectMembersById(int memberId) {
		MembersModel member = null;
	
		try {
			String sql = "SELECT * FROM members WHERE memberId = ?";
			Util util = new Util();
			Connection connection =  util.getConnection();
			PreparedStatement pd = connection.prepareStatement(sql);
			pd.setInt(1, memberId);
			
			ResultSet r = pd.executeQuery();
			
			if (r.next()) {
				
			String firstName=r.getString("firstName");
			String lastName=r.getString("lastName");
			String dateOfBirth=r.getString("dateOfBirth");
//			String membershipStartDate=r.getString("membershipStartDate");
//			String membershipEndDate=r.getString("membershipEndDate");
			
			 member = new MembersModel(memberId, firstName,lastName,dateOfBirth);
			 return member;
			
			}else {
				System.out.print("members not found with memberId"+ memberId);
			}
		}catch(Exception ex) {
			ex.getMessage();
     	}
		return member;
	}
	
	public List<MembersModel> getAllMembers()  { 

		List<MembersModel> members = new ArrayList<MembersModel>();
		try {
			Util util = new Util();
			Connection connection =  util.getConnection();
			  PreparedStatement pd  = connection.prepareStatement("select * from members");   
			  ResultSet resultSet  = pd.executeQuery(); 
			  
			  while (resultSet.next()) { 
				  MembersModel member = new MembersModel(); 
				  member.setMemberId(resultSet.getInt("memberId")); 
				  member.setFirstName(resultSet.getString("firstName"));
				  member.setLastName(resultSet.getString("lastName"));
				  member.setDateOfBirth(resultSet.getString("dateOfBirth")); 
//				  member.setMembershipStartDate(resultSet.getString("membershipStartDate"));
//				  member.setMemberShipEndDate(resultSet.getString("membershipEndDate")); 
		            
				  members.add(member); 
			  }    
			
		}catch(Exception ex) {
			ex.getMessage();
			return null;
      		}
        
		return members;
		
	}
	
	 public boolean deleteMember( int memberId) throws SQLException {
	        boolean rowDeleted = false;
	        try {
	        
	        	Util util = new Util();
				Connection connection =  util.getConnection();
	        PreparedStatement pd = connection.prepareStatement("delete from members where memberId=?");
	        pd.setInt(1, memberId);
	        rowDeleted = (pd.executeUpdate() > 0);
	        }catch(Exception ex) {
	        	ex.getMessage();
	        }
	        return rowDeleted;
	    }
	 
	 public int updateMember(MembersModel member) throws SQLException {
	        int status = 0;
	        try {
	        	
	        	Util util = new Util();
				Connection connection =  util.getConnection();
	        PreparedStatement pd = connection.prepareStatement("update members set firstName=?,lastName=?,dateOfBirth=? where memberId=?");
	        pd.setInt(4,member.getMemberId());
	        pd.setString(1,member.getFirstName());  
	        pd.setString(2,member.getLastName());  
	        pd.setString(3,member.getDateOfBirth());  
//	        pd.setString(5,member.getMembershipStartDate());  
//	        pd.setString(6,member.getMemberShipEndDate()); 
	        
	        status=pd.executeUpdate();  
	        
	        }catch(Exception ex) {
	        	ex.getMessage();
	        }
	        return status;
	    }
		
	}
	
	
	
	
	
	
	
	

