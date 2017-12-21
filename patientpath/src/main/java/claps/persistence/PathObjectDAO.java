package claps.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import claps.persistence.PathObject;


public class PathObjectDAO {
		Connection connection = null;
		PreparedStatement ptmt = null;
		ResultSet resultSet = null;

		public PathObjectDAO() {

			}

		private Connection getConnection() throws SQLException {
				Connection conn;
				conn = PathConnect.getInstance().getConnection();
				return conn;
			}

		public void addPathObject(PathObject pathObject) {
				try {
					String queryString = "INSERT INTO pathObject(pathObjectinfoID, pathObjectName) VALUES(?,?)";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setInt(1, pathObject.getPathObjectinfoID());
					ptmt.setString(2, pathObject.getPathObjectName());
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

		public void updatePathObject(PathObject pathObject) {

				try {
					String queryString = "UPDATE pathObject SET pathObjectinfoID=? pathObjectName=? WHERE pathObjectID=?";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setInt(1, pathObject.getPathObjectID());
					ptmt.setString(2, pathObject.getPathObjectName());
					ptmt.setInt(3, pathObject.getPathObjectID());
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

		public void deletePathObject(int pathObjectID) {

				try {
					String queryString = "DELETE FROM pathObject WHERE pathObjectID=?";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setInt(1, pathObjectID);
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

			public PathObject findPathObject(int pathObjectID) {
				PathObject pathObject = new PathObject();
				try {
					String queryString = "SELECT FROM pathObject WHERE pathObjectID=?";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setInt(1, pathObjectID);
					resultSet = ptmt.executeQuery();
					while (resultSet.next()) {
						pathObject.setPathObjectID(resultSet.getInt("pathObjectID"));
						pathObject.setPathObjectinfoID(resultSet.getInt("pathObjectinfoID"));
						pathObject.setPathObjectName(resultSet.getString("pathObjectName"));
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
				return pathObject;
			}
			
			/** Deactivated, please dont't delete, necessary for further updates/development, returns all PaathObjects from DB
			 * 
			public void findAllPathObject() {
				try {
					String queryString = "SELECT * FROM pathObject";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					resultSet = ptmt.executeQuery();
					while (resultSet.next()) {
						System.out.println("pathObjectID " + resultSet.getInt("pathObjectID")
								+ ", pathObjectinfoID " + resultSet.getInt("pathObjectinfoID") + ", pathObjectName "
								+ resultSet.getString("pathObjectName"));
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
}
