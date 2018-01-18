package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ClassResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Image;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import claps.persistence.User;
import claps.persistence.UserDAO;

//The Login Page
@SuppressWarnings("serial")
public class Login extends VerticalLayout implements View {
	
	//Method to add all Components to Login Page
	public Login() {

		Image imageLogoLogin = new Image();
		imageLogoLogin.setSource(new ClassResource("/PatientPath_Logo.png"));
		imageLogoLogin.setWidth("33%");
		imageLogoLogin.setHeight("33%");
		
		setSizeFull();
		setSpacing(true);	

		addComponent(loginmenu);
		loginmenu.setWidth("100%");
		addComponent(imageLogoLogin);
		addComponent(username);
		addComponent(password);
		addComponent(loginButton());
		addComponent(loginButtonDemo());
		addComponent(registerButton());
		setComponentAlignment(loginmenu, Alignment.TOP_RIGHT);
		setComponentAlignment(imageLogoLogin, Alignment.MIDDLE_CENTER);
		setComponentAlignment(username, Alignment.MIDDLE_CENTER);
		setComponentAlignment(password, Alignment.MIDDLE_CENTER);
		//setComponentAlignment(loginButton(), Alignment.MIDDLE_CENTER);
		//setComponentAlignment(loginButtonDemo(), Alignment.MIDDLE_CENTER);
	}
	
	//On page entry shows Notification "Welcome"
	//Set Session Attribute (To safely(Thread-/Session-Safe) give Values to Home Page when Navigating)
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome");
		VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", null);
	}
	
	
//The Menu Command to the Menu
	MenuBar.Command WindowHilfe = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.LOGINHILFE);
	    }
	};

	//A simple Menu with one SubMenu to access Help for the Login Screen 
	MenuBar loginmenu = new MenuBar();
	MenuItem myMenu = loginmenu.addItem("MENU",new ThemeResource("patientpath_logo_icon.ico") , null);
	MenuItem exit = myMenu.addItem("HILFE", null, WindowHilfe);
	
	//Simple Fields (Name, Password) for Logging in
	
	TextField username = new TextField("Username");
	
	PasswordField password = new PasswordField("Password");
	
//Login Button with checks for entered Name and Password
	private Button loginButton() {
		Button button = new Button("Login", new Button.ClickListener() {

			//The Click event - what happens if Button is clicked
			@Override
			public void buttonClick(ClickEvent event) {
				
				//Creates a new UserDAO to access DB
				UserDAO userDAO = new UserDAO();
				//Creates a new User to store values of fields
				User actualUser = new User();
				
				//Store Values from fields name and password in User
				actualUser.setUserName(username.getValue());
				actualUser.setPassword(password.getValue());
				
				//Checks if the username and the password are correct
				//-> Asks DB for Password of entered username and checks if the password is 
				//the password of this username
				//If so -> navigates to Home and passes userId Thread-/Session-Safe to next page
				//If not so -> Shows Notification "Retry"
				if (actualUser.getPassword().equals(userDAO.returnUserID(actualUser.getUserName()).getPassword())) {

					VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", userDAO.returnUserID(actualUser.getUserName()).getUserID());
					
					getUI().getNavigator().navigateTo(MyUI.HOME);
					
				}
				else {
					
					Notification.show("RETRY");
					
				}
				
			}
		});
		return button;
	}
	
//This Button allows Login without account
	//Username, and ID, will be set to predetermined Value (Here: Frau Brönnimann)
	private Button loginButtonDemo() {
		Button button = new Button("App - Demo", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				UserDAO userDAO = new UserDAO();
				User actualUser = new User();
				
				actualUser.setUserName("test1");
				actualUser.setPassword("test1");
				
				if (actualUser.getPassword().equals(userDAO.returnUserID(actualUser.getUserName()).getPassword())) {

					VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", userDAO.returnUserID(actualUser.getUserName()).getUserID());
					
					getUI().getNavigator().navigateTo(MyUI.HOME);
					
				}
				else {
					
					Notification.show("RETRY");
					
				}
				
			}
		});
		return button;
	}
	
	
	//This Button Navigates to CreateUserPage to create new User
	//To change User Attributes, user has to login first and navigate to 
	//Register Page from Home!
	private Button registerButton() {
		Button button = new Button("Registrieren", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
	
				getUI().getNavigator().navigateTo(MyUI.CREATEUSER);	
				
			}
		});
		return button;
	}

}

