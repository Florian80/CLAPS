package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ClassResource;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import claps.persistence.User;
import claps.persistence.UserDAO;


@SuppressWarnings("serial")
public class Login extends VerticalLayout implements View {

	public Login() {
		
		Image imageLogoLogin = new Image();
		imageLogoLogin.setSource(new ClassResource("/PatientPath_Logo.png"));
		imageLogoLogin.setHeight("100px");
		
		setSizeFull();
		setSpacing(true);	

		
		addComponent(imageLogoLogin);
		addComponent(loginmenu);
		addComponent(username);
		addComponent(password);
		addComponent(loginButton());
		addComponent(loginButton2());
		
		

	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show(Page.getCurrent().getWebBrowser().toString());
		Notification.show("Welcome! Please log in.");
	}
	
//    <<<<<<< HEAD=======
	MenuBar.Command WindowHilfe = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.LOGINHILFE);
	    }
	};
	
//  >>>>>>> branch 'master' of https://github.com/Florian80/CLAPS.git
	MenuBar loginmenu = new MenuBar();
	MenuItem myMenu = loginmenu.addItem("MENU", null, null);
	MenuItem exit = myMenu.addItem("HILFE", null, WindowHilfe);
	
	TextField username = new TextField("Username");
	
	PasswordField password = new PasswordField("Password");
	
	private Button loginButton2() {
		Button button = new Button("Login Demo", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				
				getUI().getNavigator().navigateTo(MyUI.HOME);
				
			}
		});
		return button;
	}

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

}
