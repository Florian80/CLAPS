package claps.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//The class which connects to the database/which creates the connection to the database
public class PathConnect {

	//The connection name (vm:region:database instance)
    String instanceConnectionName = "patientpathdb:europe-west1:patientpathdb001";

    //The database from which to list tables
    String databaseName = "ppdb002a";

    //The user name of the database user
    String username = "patientpath";

    //The password for the database user
    String password = "patientpath";

    //Automated jdbcURL generator class, deactivated for performance reasons (it doesn't work properly)
    /*
    String jdbcUrl = String.format(
        "jdbc:mysql://google/%s?cloudSqlInstance=%s&"
            + "socketFactory=com.google.cloud.sql.mysql.SocketFactory",
        databaseName,
        instanceConnectionName);
  	*/
    
    String jdbcUrl = "jdbc:mysql://google/ppdb002a?socketFactory=com.google.cloud.sql.mysql.SocketFactory&cloudSqlInstance=patientpathdb:europe-west1:patientpathdb001";
    
    private static PathConnect pathConnect = null;
	
    	//Unused method, for connection checks during development and updates, for Java-jdbc-Driver-Bug
		public PathConnect() throws IOException, SQLException {

			   try {
		            // The newInstance() call is a work around for some
		            // broken Java implementations
		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		        } catch (Exception ex) {
		        	System.out.println("Database Driver Work-Around not working!");
		        }
		}
		
		//The method to make the connection to the database
		public Connection getConnection() throws SQLException {
					Connection conn = null;
					conn = DriverManager.getConnection(jdbcUrl, username, password);
					return conn;
		}

		//This method to make the connection to the instance (VM), where the database is located.
		public static PathConnect getInstance() {
					if (pathConnect == null) {
					try {pathConnect = new PathConnect();}
					catch (Exception ex) {
					System.out.println("No connection to database possible, check IP!");}}
					return pathConnect;
		}

}


