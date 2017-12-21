package claps.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import claps.persistence.Encounter;


public class EncounterDAO {
			Connection connection = null;
			PreparedStatement ptmt = null;
			ResultSet resultSet = null;

			public EncounterDAO() {

			}

			private Connection getConnection() throws SQLException {
				Connection conn;
				conn = PathConnect.getInstance().getConnection();
				return conn;
			}

			public void addEncounter(Encounter encounter) {
				try {
					String queryString = "INSERT INTO encounter(encounterAll) VALUES(?)";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setString(1, encounter.getEncounterAll());
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

			public void updateEncounter(Encounter encounter) {

				try {
					String queryString = "UPDATE encounter SET encounterAll=? WHERE encounterID=?";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setString(1, encounter.getEncounterAll());
					ptmt.setInt(3, encounter.getEncounterID());
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

			public void deleteEncounter(int encounterID) {

				try {
					String queryString = "DELETE FROM encounter WHERE encounterID=?";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setInt(1, encounterID);
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

			public Encounter returnEncounter(int encounterID) {
				Encounter encounter = new Encounter();
				try {
					String queryString = "SELECT * FROM encounter";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					resultSet = ptmt.executeQuery();
					while (resultSet.next()) {
						encounter.setEncounterID(resultSet.getInt("encounterID"));
						encounter.setEncounterAll(resultSet.getString("encounterAll"));
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
				return encounter;
			}
			
			/** Deactivated, please do not delete, might be usefull for later development
			public void findAllEncounter() {
				try {
					String queryString = "SELECT * FROM encounter";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					resultSet = ptmt.executeQuery();
					while (resultSet.next()) {
						System.out.println("encounterID " + resultSet.getInt("encounterID")
								+ ", encounterName " + resultSet.getString("encounterName"));
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
