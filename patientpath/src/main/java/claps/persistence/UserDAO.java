package claps.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAO {
		Connection connection = null;
		PreparedStatement ptmt = null;
		ResultSet resultSet = null;

		public UserDAO() {

		}

		private Connection getConnection() throws SQLException {
			Connection conn;
			conn = PathConnect.getInstance().getConnection();
			return conn;
		}

		public void addUser(User user) {
			try {
				String queryString = "INSERT INTO user(userName, password) VALUES(?,?)";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setString(1, user.getUserName());
				ptmt.setString(2, user.getPassword());
				ptmt.executeUpdate();
				System.out.println("Data Added Successfully");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (ptmt != null)
						ptmt.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

		public void updateUser(User user) {

			try {
				String queryString = "UPDATE user SET userNmae=? password=? WHERE userID=?";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setString(1, user.getUserName());
				ptmt.setString(2, user.getPassword());
				ptmt.setInt(3, user.getUserID());
				ptmt.executeUpdate();
				System.out.println("Table Updated Successfully");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (ptmt != null)
						ptmt.close();
					if (connection != null)
						connection.close();
				}

				catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		}

		public void deleteUser(int userID) {

			try {
				String queryString = "DELETE FROM user WHERE userID=?";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setInt(1, userID);
				ptmt.executeUpdate();
				System.out.println("Data deleted Successfully");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (ptmt != null)
						ptmt.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

		public void findAllUser() {
			try {
				String queryString = "SELECT * FROM user";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				resultSet = ptmt.executeQuery();
				while (resultSet.next()) {
					System.out.println("userID " + resultSet.getInt("userID")
							+ ", userNmae " + resultSet.getString("userName") + ", password "
							+ resultSet.getString("password"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (resultSet != null)
						resultSet.close();
					if (ptmt != null)
						ptmt.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
}
