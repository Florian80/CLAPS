package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import claps.persistence.Info;
import claps.persistence.Provider;

@SuppressWarnings("serial")
public class CreateProvider extends VerticalLayout implements View {
	
	Provider newProvider = new Provider();
	Info newInfo = new Info();

	public CreateProvider() {
	
		setSizeFull();
		setSpacing(true);
		addComponent(titel);
		addComponent(patID);
		addComponent(userName);
		addComponent(password);
		addComponent(save);
		addComponent(back);
	
		}

	Label titel = new Label("Neuen Benutzer Eingeben"); 
	
	TextField patID = new TextField("eHealthID");

	TextField userName = new TextField("Name");
	
	TextField password = new TextField("Passwort");
	
	Button save = new Button("Speichern") {
		
	};
	
	Button back = new Button("Zurück/Verwerfen") {
		
	};
}
