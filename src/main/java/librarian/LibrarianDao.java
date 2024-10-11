package librarian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import librarian.LibrarianModel;
import util.Util;

public class LibrarianDao {
	

	public  void addLibrarian (LibrarianModel librarian) {
		try {
			
			Util util = new Util();
			Connection connection =  util.getConnection();
			PreparedStatement pd = connection.prepareStatement("INSERT INTO `librarian` (name, userName, password,dateOfBirth) VALUES (?, ?, ?,?)");

			pd.setString(1,librarian.getName());
			pd.setString(2,librarian.getUserName());
			pd.setString(3,librarian.getPassword());
			pd.setString(4,librarian.getDateOfBirth());
			pd.executeUpdate();
			
		}catch(Exception ex) {
			ex.getMessage();
		}
	}
	public LibrarianModel selectLibrarianById(int librarianId) {
		LibrarianModel librarian = null;
	
		try {
			String sql = "SELECT * FROM librarian WHERE librarianId = ?";
			Util util = new Util();
			Connection connection =  util.getConnection();
			PreparedStatement pd = connection.prepareStatement(sql);
			pd.setInt(1, librarianId);
			
			ResultSet r = pd.executeQuery();
			
			if (r.next()) {
			String role=r.getString("role");					
			String name=r.getString("name");
			String userName=r.getString("userName");
			String password=r.getString("Password");
			String dateOfBirth=r.getString("dateOfBirth");
			librarian = new LibrarianModel(librarianId,role,name,userName,password,dateOfBirth);
			 return librarian;
			
			}else {
				System.out.print("librarian not found with librarianId"+ librarianId);
			}
		}catch(Exception ex) {
			ex.getMessage();
     	}
		return librarian;
	}
	
	public List<LibrarianModel> getAllLibrarian()  { 

		List<LibrarianModel> librarians = new ArrayList<LibrarianModel>();
		try {
			Util util = new Util();
			Connection connection = util.getConnection();
			  PreparedStatement pd = connection.prepareStatement("select * from librarian");   
			  ResultSet resultSet = pd.executeQuery(); 
			  
			  while (resultSet.next()) {
	                LibrarianModel librarian = new LibrarianModel();
	                librarian.setLibrarianId(resultSet.getInt("librarianId"));
	                librarian.setName(resultSet.getString("name"));
	                librarian.setUserName(resultSet.getString("userName"));
	                librarian.setPassword(resultSet.getString("password"));
	                librarian.setDateOfBirth(resultSet.getString("dateOfBirth"));
	                
	                librarians.add(librarian);
			  }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return librarians;
    }
	
	 public boolean deleteLibrarian(int librarianId) throws SQLException {
	        boolean rowDeleted = false;
	        try {
	        
	        	Util util = new Util();
				Connection connection =  util.getConnection();
	        PreparedStatement pd = connection.prepareStatement("delete from librarian where librarianId=?");
	        pd.setInt(1, librarianId);
	        rowDeleted = (pd.executeUpdate() > 0);
	        }catch(Exception ex) {
	        	ex.getMessage();
	        }
	        return rowDeleted;
	    }
	 
	 public int updateLibrarian(LibrarianModel Librarian) throws SQLException {
	        int status = 0;
	        try {
	        	
	        	Util util = new Util();
				Connection connection =  util.getConnection();
	        PreparedStatement pd = connection.prepareStatement("update librarian set name=?,userName=?,password=?,dateOfBirth=? where librarianId=?");
	        pd.setInt(5,Librarian.getLibrarianId());
	        pd.setString(1,Librarian.getName());  
	        pd.setString(2,Librarian.getUserName());  
	        pd.setString(3,Librarian.getPassword());
	        pd.setString(4,Librarian.getDateOfBirth());
	        
	        status=pd.executeUpdate();  
	        
	        }catch(Exception ex) {
	        	ex.getMessage();
	        }
	        return status;
	    }

	}