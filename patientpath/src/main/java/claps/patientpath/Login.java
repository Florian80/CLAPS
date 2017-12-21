package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import claps.persistence.User;
import claps.persistence.UserDAO;


@SuppressWarnings("serial")
public class Login extends VerticalLayout implements View {

	User actualUser = new User();

	public Login() {
		setSizeFull();
		setSpacing(true);
		
		MenuBar loginmenu = new MenuBar();
		
			MenuItem logout = loginmenu.addItem("EXIT", null, null);
			
				MenuItem exit = logout.addItem("QUIT", null, null);
				//Platzhalter für das logo
				// Serve the image from the theme
				Resource res = new ThemeResource("c:\\users\\Dropbox\\\\Klinische Apps für Tablets\\Logo\\PatientPath_Logo.png");

				// Display the image without caption
				Image image = new Image(null, res);
				

		  
		
		addComponent(loginmenu);
		addComponent(image);
		addComponent(label);
		addComponent(username);
		addComponent(password);
		addComponent(WindowHilfe());
		addComponent(loginButton());
		addComponent(selection);
	}

	Label label = new Label("Enter your information below to log in.");
	
	TextField username = new TextField("Username");
	
	TextField password = new TextField("Password");
	
	//Test Notification
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome! Please log in.");
	}
	
	private Button loginButton() {
		Button button = new Button("Login", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {

				getUI().getNavigator().navigateTo(MyUI.HOME);
			}
		});
		return button;
	}

	private Button WindowHilfe() {
		Button button = new Button("Hilfe", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				
				UserDAO userDAO = new UserDAO();
				
				actualUser.setUserName(username.getValue());
				actualUser.setPassword(password.getValue());
				
				
				
				System.out.println(actualUser.getUserName());
				System.out.println(userDAO.returnUser(actualUser.getUserName()).getPassword());
				
				if (actualUser.getPassword() == userDAO.returnUser(actualUser.getUserName()).getPassword()) {
					
					getUI().getNavigator().navigateTo(MyUI.WINDOWHILFE);
					
				}
				else {
					
					Notification.show("RETRY");
					
				}
				
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
