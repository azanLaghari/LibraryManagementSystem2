package booksOut;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Util;

//import booksOut.BookOutDao;
//import booksOut.BooksOutModel;


public class BookOutDao {
		 
		public void addBooksOut( BooksOutModel book) {
			try {
				
				Util util = new Util();
				Connection connection =  util.getConnection();
				PreparedStatement pd = connection.prepareStatement("INSERT INTO `booksOut` (bookId, memberId, authorId,dateOfOut,dateOfReturn,librarianId) VALUES (?, ?, ? ,? ,? ,?)"); 

				pd.setString(1, book.getBookId());
				pd.setString(2, book.getMemberId());
				pd.setString(3, book.getAuthorId());
				pd.setString(4, book.getDateOfOut());
				pd.setString(5, book.getDateOfReturn());
				pd.setString(6, book.getLibrarianId());
				pd.executeUpdate();
				
			}catch(Exception ex) {
				ex.getMessage();
			}
		}
		public BooksOutModel selectBooksOutById(int id) {
			BooksOutModel book = null;
		
			try {
				String sql = "SELECT * FROM booksOut WHERE id = ?";
				Util util = new Util();
				Connection connection =  util.getConnection();
				PreparedStatement pd = connection.prepareStatement(sql);
				pd.setInt(1,id);
				
				ResultSet r = pd.executeQuery();
				
				if (r.next()) {
					
				String bookId=r.getString("bookId");
				String memberId=r.getString("memberId");
				String authorId=r.getString("authorId");
				String dateOfOut=r.getString("dateOfOut");
				String dateOfReturn=r.getString("dateOfReturn");
				String librarianId=r.getString("librarianId");
				
				book = new BooksOutModel(id,bookId,memberId,authorId,dateOfOut,dateOfReturn,librarianId);
				 return book;
				
				}else {
					System.out.print("booksOut not found with id"+id);
				}
			}catch(Exception ex) {
				ex.getMessage();
	     	}
			return book;
		}
		
		public List<BooksOutModel> getAllBooksOut() { 

			List<BooksOutModel> books = new ArrayList<BooksOutModel>();
			try {
				Util util = new Util();
				Connection connection =  util.getConnection();
				  PreparedStatement pd  = connection.prepareStatement("select * from booksOut");   
				  ResultSet resultSet  = pd.executeQuery(); 
				  
				  while (resultSet.next()) { 
					  BooksOutModel book = new BooksOutModel();
					  book.setId(resultSet.getInt("id"));
					  book.setBookId(resultSet.getString("bookId")); 
					  book.setMemberId(resultSet.getString("memberId"));
					  book.setAuthorId(resultSet.getString("authorId"));
					  book.setDateOfOut(resultSet.getString("dateOfOut"));
					  book.setDateOfReturn(resultSet.getString("dateOfReturn")); 
					  book.setLibrarianId(resultSet.getString("librarianId"));
			            
					  books.add(book); 
				  }    
				
			}catch(Exception ex) {
				ex.getMessage();
				return null;
	      		}
	        return  books;
			
		}
		
		 public boolean deleteBooksOut(int id) throws SQLException {
		        boolean rowDeleted = false;
		        try {
		        
		        	Util util = new Util();
					Connection connection =  util.getConnection();
		        PreparedStatement pd = connection.prepareStatement("delete from booksOut where id=?");
		        pd.setInt(1, id);
		        rowDeleted = (pd.executeUpdate() > 0);
		        }catch(Exception ex) {
		        	ex.getMessage();
		        }
		        return rowDeleted;
		    }
		 
		 public int updateBooksOut(BooksOutModel book) throws SQLException {
		        int status = 0;
		        try {
		        	
		        	Util util = new Util();
					Connection connection = util.getConnection();
		        PreparedStatement pd = connection.prepareStatement("update booksOut set bookId=?,memberId=?,authorId=?,dateOfOut=?,dateOfReturn=?,librarianId=? where id=?");
		        pd.setInt(7,book.getId());
		        pd.setString(1,book.getBookId());
		        pd.setString(2,book.getMemberId());  
		        pd.setString(3,book.getAuthorId());  
		        pd.setString(4,book.getDateOfOut()); 
		        pd.setString(5,book.getDateOfReturn());  
		        pd.setString(6,book.getLibrarianId());  
		       
		        
		        status=pd.executeUpdate();  
		        System.out.println(status);
		        
		        }catch(Exception ex) {
		        	ex.getMessage();
		        }
		        return status;
		    }
			
	}
