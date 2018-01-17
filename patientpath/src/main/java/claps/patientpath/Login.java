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
/*
 * This is the login page. The user can enter username and password.
 */

@SuppressWarnings("serial")
public class Login extends VerticalLayout implements View {
	
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
	
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome");
		VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", null);
	}
	
	
	/*
	 * This code determines where to go when you click on a menubar.
	 */
	
	MenuBar.Command WindowHilfe = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.LOGINHILFE);
	    }
	};

	
	/*
	 * He will list the whole menubar, what he has for content and in order.
	 */
	MenuBar loginmenu = new MenuBar();
	
	/*
	 * Here a picture is added in the menubar
	 */
	MenuItem myMenu = loginmenu.addItem("MENU",new ThemeResource("patientpath_logo_icon.ico") , null);
	MenuItem exit = myMenu.addItem("HILFE", null, WindowHilfe);
	
	
	TextField username = new TextField("Username");
	
	PasswordField password = new PasswordField("Password");
	
	/*
	 * This code determines where to proceed by clicking on the Login button. In this app, it will go further to the home page. 
	 * This works only with the input of the right passwrot and username
	 */
	
	private Button loginButton() {
		Button button = new Button("Login", new Button.ClickListener() {

			
			@Override
			public void buttonClick(ClickEvent event) {
				
				UserDAO userDAO = new UserDAO();
				User actualUser = new User();
				
				actualUser.setUserName(username.getValue());
				actualUser.setPassword(password.getValue());
				
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
	
	/*
	 * This code determines where to proceed by clicking on the Login button. In this app, it will go further to the home page
	 */
	
	private Button loginButtonDemo() {
		Button button = new Button("Login Demo", new Button.ClickListener() {
			
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
	
	
	/*
	 * This code determines where to proceed by clicking on the Login button. In this app, it will go further to the Registartion page
	 */
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

