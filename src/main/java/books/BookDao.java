package books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class BookDao {

	public void addBooks(BooksModel book) {
		try {

			Util util = new Util();
			Connection connection = util.getConnection();
			PreparedStatement pd = connection.prepareStatement(
					"INSERT INTO `book` (bookName, bookReviews, bookQuantity,publishedDate,authorId) VALUES (?, ?, ?,?,?)");

			pd.setString(1, book.getBookName());
			pd.setString(2, book.getBookReviews());
			pd.setString(3, book.getBookQuantity());
			pd.setString(4, book.getPublishedDate());
			pd.setString(5, book.getAuthorId());
			pd.executeUpdate();

		} catch (Exception ex) {
			ex.getMessage();
		}
	}

	public BooksModel selectBooksById(int bookId) {
		BooksModel book = null;

		try {
			String sql = "SELECT * FROM book WHERE bookId = ?";
			Util util = new Util();
			Connection connection = util.getConnection();
			PreparedStatement pd = connection.prepareStatement(sql);
			pd.setInt(1, bookId);

			ResultSet r = pd.executeQuery();

			if (r.next()) {

				String bookName = r.getString("bookName");
				String bookReviews = r.getString("bookReviews");
				String bookQuantity = r.getString("bookQuantity");
				String publishedDate = r.getString("publishedDate");
				String authorId = r.getString("authorId");
				book = new BooksModel(bookId, bookName, bookReviews, bookQuantity, publishedDate, authorId);
				return book;

			} else {
				System.out.print("book not found with bookid" + bookId);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return book;
	}

	public List<BooksModel> getAllBooks() {

		List<BooksModel> books = new ArrayList<BooksModel>();
		try {
			Util util = new Util();
			Connection connection = util.getConnection();
			PreparedStatement pd = connection.prepareStatement("select * from book");
			ResultSet resultSet = pd.executeQuery();

			while (resultSet.next()) {
				BooksModel book = new BooksModel();
				book.setBookId(resultSet.getInt("bookId"));
				book.setBookName(resultSet.getString("bookName"));
				book.setBookReviews(resultSet.getString("bookReviews"));
				book.setBookQuantity(resultSet.getString("bookQuantity"));
				book.setPublishedDate(resultSet.getString("publishedDate"));
				book.setAuthorId(resultSet.getString("authorId"));

				books.add(book);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return books;
	}

	public boolean deleteBooks(int bookId) throws SQLException {
		boolean rowDeleted = false;
		try {

			Util util = new Util();
			Connection connection = util.getConnection();
			PreparedStatement pd = connection.prepareStatement("delete from book where bookId=?");
			pd.setInt(1, bookId);
			rowDeleted = (pd.executeUpdate() > 0);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return rowDeleted;
	}

	public int updateBooks(BooksModel book) throws SQLException {
		int status = 0;
		try {

			Util util = new Util();
			Connection connection = util.getConnection();
			PreparedStatement pd = connection.prepareStatement(
					"update book set bookName=?,bookReviews=?,bookQuantity=?,publishedDate=?,authorId=? where bookId=?");
			pd.setInt(6, book.getBookId());
			pd.setString(1, book.getBookName());
			pd.setString(2, book.getBookReviews());
			pd.setString(3, book.getBookQuantity());
			pd.setString(4, book.getPublishedDate());
			pd.setString(5, book.getAuthorId());

			status = pd.executeUpdate();

		} catch (Exception ex) {
			ex.getMessage();
		}
		return status;
	}
}