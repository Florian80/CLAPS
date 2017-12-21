package claps.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import claps.persistence.Info;


	public class InfoDAO {
			Connection connection = null;
			PreparedStatement ptmt = null;
			ResultSet resultSet = null;

			public InfoDAO() {

			}

			private Connection getConnection() throws SQLException {
				Connection conn;
				conn = PathConnect.getInstance().getConnection();
				return conn;
			}

			public void addInfo(Info info) {
				try {
					String queryString = "INSERT INTO info(infoName, infoImageURL, addressLineOne, addressLineTwo, "
							+ "addressLineThree, AddressLineFour, telefon, fax, website, eMail, infoText) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setString(1, info.getInfoName());
					ptmt.setString(2, info.getInfoImageURL());
					ptmt.setString(3, info.getAddressLineOne());
					ptmt.setString(4, info.getAddressLineTwo());
					ptmt.setString(5, info.getAddressLineThree());
					ptmt.setString(6, info.getAddressLineFour());
					ptmt.setString(7, info.getTelefon());
					ptmt.setString(8, info.getFax());
					ptmt.setString(9, info.getWebsite());
					ptmt.setString(10, info.geteMail());
					ptmt.setString(11, info.getInfoText());
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

			public void updateInfo(Info info) {

				try {
					String queryString = "UPDATE info SET infoName=? infoImageURL=? addressLineOne=? addressLineTwo=? addressLineThree=? AddressLineFour=? telefon=? fax=? website=?, eMail=?, infoText=? WHERE infoID=?";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setString(1, info.getInfoName());
					ptmt.setString(2, info.getInfoImageURL());
					ptmt.setString(3, info.getAddressLineOne());
					ptmt.setString(4, info.getAddressLineTwo());
					ptmt.setString(5, info.getAddressLineThree());
					ptmt.setString(6, info.getAddressLineFour());
					ptmt.setString(7, info.getTelefon());
					ptmt.setString(8, info.getFax());
					ptmt.setString(9, info.getWebsite());
					ptmt.setString(10, info.geteMail());
					ptmt.setString(11, info.getInfoText());
					ptmt.setInt(12, info.getInfoID());
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

			public void deleteInfo(int infoID) {

				try {
					String queryString = "DELETE FROM info WHERE infoID=?";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setInt(1, infoID);
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

			public void findAllInfo() {
				try {
					String queryString = "SELECT * FROM info";
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
			
			public Info returnInfo(int infoID) {
				Info info = new Info();	
				try {
					String queryString = "SELECT FROM info WHERE infoID=?";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setInt(1, infoID);
					resultSet = ptmt.executeQuery();
					while (resultSet.next()) {
						info.setInfoName(resultSet.getString("infoName"));
						info.setInfoImageURL(resultSet.getString("infoImageURL"));
						info.setAddressLineOne(resultSet.getString("addressLineOne"));
						info.setAddressLineTwo(resultSet.getString("addressLineTwo"));
						info.setAddressLineThree(resultSet.getString("addressLineThree"));
						info.setAddressLineFour(resultSet.getString("adressLineFour"));
						info.setTelefon(resultSet.getString("telefon"));
						info.setFax(resultSet.getString("fax"));
						info.setWebsite(resultSet.getString("website"));
						info.setWebsite(resultSet.getString("eMail"));
						info.setInfoText(resultSet.getString("infoText"));
						
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
				return info;
			}
}
