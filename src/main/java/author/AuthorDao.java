package author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Util;

public class AuthorDao {

	public void addAuthor(AuthorModel author) {
		try {

			Util util = new Util();
			Connection connection = util.getConnection();
			PreparedStatement pd = connection.prepareStatement(
					"INSERT INTO `Author` (authorName, authorDateofBirth, authorReview) VALUES (?, ?, ?)");

			pd.setString(1, author.getAuthorName());
			pd.setString(2, author.getAuthorDateofBirth());
			pd.setString(3, author.getAuthorReview());
			pd.executeUpdate();

		} catch (Exception ex) {
			ex.getMessage();
		}
	}

	public AuthorModel selectAuthorById(int authorId) {
		AuthorModel author = null;

		try {
			String sql = "SELECT * FROM author WHERE authorId = ?";
			Util util = new Util();
			Connection connection = util.getConnection();
			PreparedStatement pd = connection.prepareStatement(sql);
			pd.setInt(1, authorId);

			ResultSet r = pd.executeQuery();

			if (r.next()) {

				String authorName = r.getString("authorName");
				String authorDateofBirth = r.getString("authorDateofBirth");
				String authorReview = r.getString("authorReview");
				author = new AuthorModel(authorId, authorName, authorDateofBirth, authorReview);
				return author;

			} else {
				System.out.print("Author not found with authorId" + authorId);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return author;
	}

	public List<AuthorModel> getAllAuthors() {

		List<AuthorModel> authors = new ArrayList<AuthorModel>();
		try {
			Util util = new Util();
			Connection connection = util.getConnection();
			PreparedStatement pd = connection.prepareStatement("select * from author");
			ResultSet resultSet = pd.executeQuery();

			while (resultSet.next()) {
				AuthorModel author = new AuthorModel();
				author.setAuthorId(resultSet.getInt("authorId"));
				author.setAuthorName(resultSet.getString("authorName"));
				author.setAuthorDateofBirth(resultSet.getString("authorDateofBirth"));
				author.setAuthorReview(resultSet.getString("authorReview"));
				authors.add(author);
			}

		} catch (Exception ex) {
			ex.getMessage();
			return null;
		}
		return authors;

	}

	public boolean deleteAuthor(int authorId) throws SQLException {
		boolean rowDeleted = false;
		try {

			Util util = new Util();
			Connection connection = util.getConnection();
			PreparedStatement pd = connection.prepareStatement("delete from Author where authorId=?");
			pd.setInt(1, authorId);
			rowDeleted = (pd.executeUpdate() > 0);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return rowDeleted;
	}

	public int updateAuthor(AuthorModel author) throws SQLException {
		int status = 0;
		try {

			Util util = new Util();
			Connection connection = util.getConnection();
			PreparedStatement pd = connection.prepareStatement(
					"update author set authorName=?,authorDateofBirth=?,authorReview=? where authorId=?");
			pd.setInt(4, author.getAuthorId());
			pd.setString(1, author.getAuthorName());
			pd.setString(2, author.getAuthorDateofBirth());
			pd.setString(3, author.getAuthorReview());

			status = pd.executeUpdate();
			System.out.println(status);

		} catch (Exception ex) {
			ex.getMessage();
		}
		return status;
	}
}
