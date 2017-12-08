package claps.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


public class EventDAO {
			Connection connection = null;
			PreparedStatement ptmt = null;
			ResultSet resultSet = null;

			public EventDAO() {

			}

			private Connection getConnection() throws SQLException {
				Connection conn;
				conn = PathConnect.getInstance().getConnection();
				return conn;
			}

			public void addEvent(Event event) {
				try {
					String queryString = "INSERT INTO event(userID, pathObjectID, providerID, encounterID,\r\n" + 
					" eventinfoID, eventName, eventDateTime, eventDuration) VALUES(?,?,?,?,?,?,?,?)";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setInt(1, event.getUserID());
					ptmt.setInt(2, event.getPathObjectID());
					ptmt.setInt(3, event.getProviderID());
					ptmt.setInt(4, event.getEncounterID());
					ptmt.setInt(5, event.getEventinfoID());
					ptmt.setString(6, event.getEventName());
					ptmt.setTimestamp(7, event.getEventDateTime());
					ptmt.setInt(8, event.getEventDuration());
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

			public void updateEvent(Event event) {

				try {
					String queryString = "UPDATE event SET userID=? pathObjectID=? providerID=? encounterID=? eventinfoID=? eventName=? eventDateTime=? eventDuration=?, WHERE eventID=?";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setInt(1, event.getUserID());
					ptmt.setInt(2, event.getPathObjectID());
					ptmt.setInt(3, event.getProviderID());
					ptmt.setInt(4, event.getEncounterID());
					ptmt.setInt(5, event.getEventinfoID());
					ptmt.setString(6, event.getEventName());
					ptmt.setTimestamp(7, event.getEventDateTime());
					ptmt.setInt(8, event.getEventDuration());
					ptmt.setInt(9, event.getUserID());
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

			public void deleteEvent(int eventID) {

				try {
					String queryString = "DELETE FROM event WHERE eventID=?";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setInt(1, eventID);
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

			public void findAllEvent() {
				try {
					String queryString = "SELECT * FROM event";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					resultSet = ptmt.executeQuery();
					while (resultSet.next()) {
						System.out.println("eventID " + resultSet.getInt("eventID")
								+ ", userID " + resultSet.getInt("userID") + ", pathObjectID "
								+ resultSet.getInt("pathObjectID") + ", providerID " +  resultSet.getInt("providerID")
								+ ", encouterID " + resultSet.getInt("encounterID") + ", eventinfoID "
								+ resultSet.getInt("eventinfoID") + ", eventName " + resultSet.getString("eventName")
								+ ", eventDateTime" + resultSet.getTimestamp("eventDateTime") + ", eventDuration" 
								+ resultSet.getInt("eventDuration"));
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
