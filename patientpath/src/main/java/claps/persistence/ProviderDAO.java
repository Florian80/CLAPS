package claps.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProviderDAO {
			Connection connection = null;
			PreparedStatement ptmt = null;
			ResultSet resultSet = null;

			public ProviderDAO() {

			}

			private Connection getConnection() throws SQLException {
				Connection conn;
				conn = PathConnect.getInstance().getConnection();
				return conn;
			}

			public void addProvider(Provider provider) {
				try {
					String queryString = "INSERT INTO provider(providerinfoID, providerName) VALUES(?,?)";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setInt(1, provider.getProviderinfoID());
					ptmt.setString(2, provider.getProviderName());
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

			public void updateProvider(Provider provider) {

				try {
					String queryString = "UPDATE user SET providerinfoID=? providerName=? WHERE providerID=?";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setInt(1, provider.getProviderinfoID());
					ptmt.setString(2, provider.getProviderName());
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

			public void deleteProvider(int providerID) {

				try {
					String queryString = "DELETE FROM provider WHERE providerID=?";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setInt(1, providerID);
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

			public void findAllProvider() {
				try {
					String queryString = "SELECT * FROM provider";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					resultSet = ptmt.executeQuery();
					while (resultSet.next()) {
						System.out.println("providerID " + resultSet.getInt("providerID")
								+ ", providerinfoID " + resultSet.getString("providerinfoID") + ", providerName "
								+ resultSet.getString("providerName"));
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
