package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("serial")
public class VersionOne extends VerticalLayout implements View {

	private Label labelHeader = new Label("Version 1");
	
	public VersionOne() throws IOException, SQLException {
		
		
		
	    // TODO: fill this in
	    // The instance connection name can be obtained from the instance overview page in Cloud Console
	    // or by running "gcloud sql instances describe <instance> | grep connectionName".
	    String instanceConnectionName = "patientpathdb:europe-west1:patientpathdb001";

	    // TODO: fill this in
	    // The database from which to list tables.
	    String databaseName = "ppdb001a";

	    String username = "patientpath";

	    // TODO: fill this in
	    // This is the password that was set via the Cloud Console or empty if never set
	    // (not recommended).
	    String password = "patientpath";
	    
	    if (instanceConnectionName.equals("<insert_connection_name>")) {
	      System.err.println("Please update the sample to specify the instance connection name.");
	      System.exit(1);
	    }

	    if (password.equals("insert_password")) {
	      System.err.println("Please update the sample to specify the mysql password.");
	      System.exit(1);
	    }

	    /*
	    String jdbcUrl = String.format(
	        "jdbc:mysql://google/%s?cloudSqlInstance=%s&"
	            + "socketFactory=com.google.cloud.sql.mysql.SocketFactory",
	        databaseName,
	        instanceConnectionName);
	  	*/
	    
	    String jdbcUrl = "jdbc:mysql://google/ppdb001a?socketFactory=com.google.cloud.sql.mysql.SocketFactory&cloudSqlInstance=patientpathdb:europe-west1:patientpathdb001";
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
        	System.out.println("ooops");
        }
	    Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
	    
	    try (Statement statement = connection.createStatement()) {
	      ResultSet resultSet = statement.executeQuery("SHOW TABLES");
	      while (resultSet.next()) {
	        System.out.println(resultSet.getString(1));
	      }
	    }
	    
	    
	    
		setSizeFull();
		setSpacing(true);
		addComponent(labelHeader);
		addComponent(calendarLabel);
	    
	  }
	
	private Label calendarLabel = new Label("Calendar goes here");
}