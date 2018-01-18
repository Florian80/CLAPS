package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import claps.persistence.User;
import claps.persistence.UserDAO;

/*
 * Enter a new User or change Name or password of existing User
 */
@SuppressWarnings("serial")
public class CreateUser extends VerticalLayout implements View {

	//The CreateUser Method fills all the Components of the Page
	public CreateUser() {
		
		setSizeFull();
		setSpacing(true);
		
		addComponent(titel);
		addComponent(patIDField);
		addComponent(userNameField);
		addComponent(passwordField);
		addComponent(saveButton());
		addComponent(backButton());
	
		}

	//On enter (page-entry), the user Id, if already existing,
	//is taken threadsave/sessionsave from previous page
	//Tests if ID set, if not: create new user
	//if yes: change existing user
	@Override
	public void enter(ViewChangeEvent event) {
		
		if (VaadinService.getCurrentRequest().getWrappedSession().getAttribute("myValue") != null) {
			patIDField.setValue(VaadinService.getCurrentRequest().getWrappedSession().getAttribute("myValue").toString());
		} 
		
	}
	
	//Simple Fields with Labels or texts for the Users attributes
	Label titel = new Label("Neuen Benutzer Eingeben"); 	

	TextField patIDField = new TextField("eHealthID");

	TextField userNameField = new TextField("Name");

	TextField passwordField = new PasswordField("Passwort");

	//The save Button to save a new user or change an existing one
	private Button saveButton() {
		Button button = new Button("Speichern", new Button.ClickListener() {
			
			//The Click-Event to save new/changed User
			@Override
			public void buttonClick(ClickEvent event) {
				
				//Creates UserDAO for DB access to load/save user
				UserDAO userDAO = new UserDAO();
				
				//Creates User to store values from the actual user 
				User actualUser = new User();
				
				//Sets the actual User to the values from the entered Fields (id, Name, password)
				actualUser.setUserID(Integer.parseInt(patIDField.getValue()));
				actualUser.setUserName(userNameField.getValue());
				actualUser.setPassword(passwordField.getValue());
				
				//Check if this is an existing or a new User
				if (VaadinService.getCurrentRequest().getWrappedSession().getAttribute("myValue") != null && userNameField.getValue() != null && passwordField.getValue() != null) {
					//If this is an existing user, values get Updated, and navigates to Home Page
					userDAO.updateUser(actualUser);
					getUI().getNavigator().navigateTo(MyUI.HOME);
					
				} else if (userDAO.returnAllUserIDs().contains(Integer.valueOf(patIDField.getValue()))) {
					//Checks if new users id is still available, if not gives back message
					Notification.show("eHealthID schon vergeben!");
				} else if (patIDField.getValue() != null) { 
					//Adds a new user and navigates to Home with Id set to the new users Id
					userDAO.addUser(actualUser);
					//Passes user id Thread-Save/Session-Save to next Navigation State (next Page)
					VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", userDAO.returnUserID(actualUser.getUserName()).getUserID());
					getUI().getNavigator().navigateTo(MyUI.HOME);
					}	
				else {Notification.show("Bitte eHealthID eingeben");}
			}
		});
		return button;
	}

	//The return Button to return to previous Page without saving
	private Button backButton() {
		Button button = new Button("Zurück/Verwerfen", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
			
					getUI().getNavigator().navigateTo(MyUI.HOME);
					
				}		
			
		});
		return button;
	}
	
}
