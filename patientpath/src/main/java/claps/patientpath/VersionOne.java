package claps.patientpath;

import claps.persistence.PathConnect;
import claps.persistence.UserDAO;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.MenuBar.MenuItem;


@SuppressWarnings("serial")
public class VersionOne extends VerticalLayout implements View {

	//Under Construction
	private Label labelHeader = new Label("Kalender");
	
	public VersionOne() {
	    
		setSizeFull();
		setSpacing(true);
		addComponent(labelHeader);
		addComponent(calendarLabel);
		addComponent(loginButton());
		addComponent(selection);
	    
	  }
	
	private Label calendarLabel = new Label("Calendar goes here");
	
/**
@SuppressWarnings("serial")
public class Login extends VerticalLayout implements View {

	public Login() {
		setSizeFull();
		setSpacing(true);
		
		MenuBar loginmenu = new MenuBar();
		
			MenuItem logout = loginmenu.addItem("EXIT", null, null);
			
				MenuItem exit = logout.addItem("QUIT", null, null);
		
		Label label = new Label("Enter your information below to log in.");
		TextField username = new TextField("Username");
		TextField password = new TextField("Password");
		

		addComponent(loginmenu);
		addComponent(label);
		addComponent(username);
		addComponent(password);
		}
		**/
		


	
	//Test Notification
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome! Please log in.");
	}
	
	private Button loginButton() {
		Button button = new Button("Log In", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOME);
			}
		});
		return button;
	}

	MenuBar.Command mycommand = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        selection.setValue("Ordered a " +
	                           selectedItem.getText() +
	                           " from menu.");
	    }
	};
	
	final Label selection = new Label("-");
	
}