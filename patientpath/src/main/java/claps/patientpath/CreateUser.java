package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import claps.persistence.User;
import claps.persistence.UserDAO;

@SuppressWarnings("serial")
public class CreateUser extends VerticalLayout implements View {
	
	int actualUserID;
	int confirmedUserID;

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

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("WELCOME");
		//confirmedUserID = Integer.valueOf(VaadinService.getCurrentRequest().getWrappedSession().getAttribute("myValue").toString());
	}
	
	Label titel = new Label("Neuen Benutzer Eingeben"); 

		TextField patIDField = new TextField("eHealthID");

		TextField userNameField = new TextField("Name");

		TextField passwordField = new TextField("Passwort");

	
	private Button saveButton() {
		Button button = new Button("Speichern", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				UserDAO userDAO = new UserDAO();
				User actualUser = new User();
				actualUser.setUserID(Integer.valueOf(patIDField.getValue()));
				actualUser.setUserName(userNameField.getValue());
				actualUser.setPassword(passwordField.getValue());
				
				

				if (userDAO.returnAllUserIDs().contains(Integer.valueOf(patIDField.getValue()))) {
					Notification.show("eHealthID schon vergeben!");
				} else { 
					userDAO.addUser(actualUser);
					getUI().getNavigator().navigateTo(MyUI.HOME);
					}	
				}
				
				
			
		});
		return button;
	}

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