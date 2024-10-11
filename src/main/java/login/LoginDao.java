package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class LoginDao {

	public boolean validate(String userName, String password) {
		boolean status = false;

		try {
			String sql = "select * from librarian where userName=? && password=?";
			Util util = new Util();
			Connection connection = util.getConnection();
			PreparedStatement pd = connection.prepareStatement(sql);
			pd.setString(1, userName);
			pd.setString(2, password);

			ResultSet r = pd.executeQuery();

			if (r.next()) {
				status = true;
			} else {
				status = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}
}