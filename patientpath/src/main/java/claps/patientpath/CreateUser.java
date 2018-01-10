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

@SuppressWarnings("serial")
public class CreateUser extends VerticalLayout implements View {

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
		
		if (VaadinService.getCurrentRequest().getWrappedSession().getAttribute("myValue") != null) {
			patIDField.setValue(VaadinService.getCurrentRequest().getWrappedSession().getAttribute("myValue").toString());
		} 
		
	}
	
	Label titel = new Label("Neuen Benutzer Eingeben"); 	

	TextField patIDField = new TextField("eHealthID");

	TextField userNameField = new TextField("Name");

	TextField passwordField = new PasswordField("Passwort");

	
	private Button saveButton() {
		Button button = new Button("Speichern", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				UserDAO userDAO = new UserDAO();
				User actualUser = new User();
				actualUser.setUserID(Integer.parseInt(patIDField.getValue()));
				actualUser.setUserName(userNameField.getValue());
				actualUser.setPassword(passwordField.getValue());
				
				if (VaadinService.getCurrentRequest().getWrappedSession().getAttribute("myValue") != null && userNameField.getValue() != null && passwordField.getValue() != null) {
					userDAO.updateUser(actualUser);
					getUI().getNavigator().navigateTo(MyUI.HOME);
					
				} else if (userDAO.returnAllUserIDs().contains(Integer.valueOf(patIDField.getValue()))) {
					Notification.show("eHealthID schon vergeben!");
				} else if (patIDField.getValue() != null) { 
					userDAO.addUser(actualUser);
					VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", userDAO.returnUserID(actualUser.getUserName()).getUserID());
					getUI().getNavigator().navigateTo(MyUI.HOME);
					}	
				else {Notification.show("Bitte eHealthID eingeben");}
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