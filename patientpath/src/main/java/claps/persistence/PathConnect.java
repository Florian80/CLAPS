package claps.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PathConnect {

	 // The instance connection name can be obtained from the instance overview page in Cloud Console
    // or by running "gcloud sql instances describe <instance> | grep connectionName".
    String instanceConnectionName = "patientpathdb:europe-west1:patientpathdb001";

    // The database from which to list tables.
    String databaseName = "ppdb002a";

    String username = "patientpath";

    // This is the password that was set via the Cloud Console or empty if never set
    // (not recommended).
    String password = "patientpath";

    /*
    String jdbcUrl = String.format(
        "jdbc:mysql://google/%s?cloudSqlInstance=%s&"
            + "socketFactory=com.google.cloud.sql.mysql.SocketFactory",
        databaseName,
        instanceConnectionName);
  	*/
    
    String jdbcUrl = "jdbc:mysql://google/ppdb002a?socketFactory=com.google.cloud.sql.mysql.SocketFactory&cloudSqlInstance=patientpathdb:europe-west1:patientpathdb001";
    
    private static PathConnect pathConnect = null;
	
		public PathConnect() throws IOException, SQLException {

			   try {
		            // The newInstance() call is a work around for some
		            // broken Java implementations
		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		        } catch (Exception ex) {
		        	System.out.println("ooops");
		        }
		}
			   
		public Connection getConnection() throws SQLException {
					Connection conn = null;
					conn = DriverManager.getConnection(jdbcUrl, username, password);
					return conn;
		}

				public static PathConnect getInstance() {
					if (pathConnect == null) {
					try {pathConnect = new PathConnect();}
					catch (Exception ex) {
					System.out.println("shitty");}}
					return pathConnect;
				}
			   
				
				/**
			    Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			    
			    try (Statement statement = con.createStatement()) {
			      ResultSet resultSet = statement.executeQuery("SHOW TABLES");
			      while (resultSet.next()) {
			        System.out.println(resultSet.getString(1));
			      }
			      con.close();
			    }

			  }
			  **/
}


