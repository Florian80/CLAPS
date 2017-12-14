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

import claps.persistence.UserDAO;


@SuppressWarnings("serial")
public class Login extends VerticalLayout implements View {

	public Login() {
		setSizeFull();
		setSpacing(true);
		
		MenuBar loginmenu = new MenuBar();
		
			MenuItem logout = loginmenu.addItem("EXIT", null, null);
			
				MenuItem exit = logout.addItem("QUIT", null, null);
				//Blatzhalter für das logo
				// Serve the image from the theme
				Resource res = new ThemeResource("c:\\users\\Dropbox\\\\Klinische Apps für Tablets\\Logo\\PatientPath_Logo.png");

				// Display the image without caption
				Image image = new Image(null, res);
				
		Label label = new Label("Enter your information below to log in.");
		TextField username = new TextField("Username");
		TextField password = new TextField("Password");
		  PopupView popupview = new PopupView(new PopupTextFieldContent());
		
		// A container with a defined width.
	        Panel panel = new Panel("Hilfe");
	        panel.setWidth("900px");
	        panel.setHeight("300px");
	        panel.setContent(
	            new Label("Um dich in PatientPath einzulogen"+
	                    "verwendest du den von deinem Arzt"+
	                    "zugewiesenen Benutzername und das"+
	                    "entsprechende Password"+
	                    ""+"Falls du noch kein Login hast, kannst"+ 
	                    "du bei einem angeschlossenen Arzt einen"+
	                    "Account erstellen lassen"));
		
		addComponent(loginmenu);
		addComponent(label);
		addComponent(username);
		addComponent(password);
		addComponent(popupview);
		addComponent(panel);
		addComponent(loginButton());
		addComponent(selection);
	}


	// Damit das Popup Für die Hilfe beim Klicken darauf erscheint
     static class PopupTextFieldContent implements PopupView.Content {
     private final     HorizontalLayout layout;
     private final  TextField textField = new TextField("Hilfe", "Hilfe");
     private final  Label labelfield = new Label("Um dich in PatientPath einzulogen"+
                "verwendest du den von deinem Arzt"+
               "zugewiesenen Benutzername und das"+
                "entsprechende Password"+
                ""+"Falls du noch kein Login hast, kannst"+ 
                "du bei einem angeschlossenen Arzt einen"+
                "Account erstellen lassen");
     // labelfield.setValue("Stuff in the field");
     
     private PopupTextFieldContent() {
         layout = new HorizontalLayout(labelfield);
     }
  
        @Override
        public final Component getPopupComponent() {
            return layout;
        }
 
        @Override
        public final String getMinimizedValueAsHTML() {
            return textField.getValue();
        }
    }
	
	
	//Test Notification
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome! Please log in.");
	}
	
	private Button loginButton() {
		Button button = new Button("Login", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				UserDAO user = new UserDAO();
				user.findAllUser();
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
