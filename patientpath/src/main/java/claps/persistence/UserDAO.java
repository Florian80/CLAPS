package claps.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Data Access Object for User
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
				String queryString = "INSERT INTO user(userID, userName, password) VALUES(?,?,?)";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setInt(1, user.getUserID());
				ptmt.setString(2, user.getUserName());
				ptmt.setString(3, user.getPassword());
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
				String queryString = "UPDATE user SET userName = ?, password = ? WHERE userID = ?";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setString(1, user.getUserName());
				ptmt.setString(2, user.getPassword());
				ptmt.setInt(3, user.getUserID());
				System.out.println(ptmt);
				ptmt.executeUpdate();
				System.out.println("Data Updated Successfully");
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

		/**Deactivated (not used in application), please dont't delete, needed for updates/development
		 * 
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
		**/
		
		public User returnUserID(String challenge) {
			User user = new User();
			try {
				String queryString = "SELECT * FROM user WHERE userName=?";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setString(1, challenge);
				resultSet = ptmt.executeQuery();
				while (resultSet.next()) {
					
					user.setUserID(resultSet.getInt("userID"));
					user.setUserName(resultSet.getString("userName"));
					user.setPassword(resultSet.getString("password"));
					
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
			return user;
		}
		
		public List<Integer> returnAllUserIDs() {
			List<Integer> myIDs = new ArrayList<Integer>();
			try {
				String queryString = "SELECT userID FROM user";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				resultSet = ptmt.executeQuery();
				while (resultSet.next()) {
					
					myIDs.add(resultSet.getInt("userID"));
					
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
			return myIDs;
		}
		
}
