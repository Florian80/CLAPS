package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import claps.persistence.Info;
import claps.persistence.Provider;

/*
 *  In this class new information can be entered or which changes from a Provider
 */
@SuppressWarnings("serial")
public class CreateProvider extends VerticalLayout implements View {
	
	Provider newProvider = new Provider();
	Info newInfo = new Info();

	
	/*
	 * This method defines which button or textfield of the rows should appear
	 */
	public CreateProvider() {
	
		setSizeFull();
		setSpacing(true);
		addComponent(titel1);
		addComponent(titel2);
		addComponent(titel3);
		addComponent(providerName);
		addComponent(infoImageURL);
		addComponent(addressLineOne);
		addComponent(addressLineTwo);
		addComponent(addressLineThree);
		addComponent(addressLineFour);
		addComponent(webSite);
		addComponent(eMail);
		addComponent(telefon);
		addComponent(fax);
		addComponent(text);
		addComponent(saveButton());
		addComponent(backButton());
	
		}

	@Override
	public void enter(ViewChangeEvent event) {
		
	}
	
	Label titel1 = new Label("Neuen Provider anlegen"); 
	Label titel2 = new Label("oder"); 
	Label titel3 = new Label("Provider ändern");  
	
	TextField providerName = new TextField("Name Provider / Anbieter");

	TextField infoImageURL = new TextField("Link zu einem Bild (https//wwww...");
	
	TextField addressLineOne = new TextField("Adresse 1. Zeile");
	
	TextField addressLineTwo = new TextField("Adresse 2. Zeile");
	
	TextField addressLineThree = new TextField("Adresse 3. Zeile");
	
	TextField addressLineFour = new TextField("Adresse 4. Zeile");
	
	TextField webSite = new TextField("Webseite");
	
	TextField eMail = new TextField("E-Mail");
	
	TextField telefon = new TextField("Telefon");
	
	TextField fax = new TextField("Fax");
	
	TextArea text = new TextArea("Beschreibung");
	
	private Button saveButton() {
		Button saveButton = new Button("Speichern", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
			
					getUI().getNavigator().navigateTo(MyUI.PROVIDER);
					
				}
		});
			return saveButton;
	}
	
	private Button backButton() {
		Button backButton = new Button("Zurück/Verwerfen", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
			
					getUI().getNavigator().navigateTo(MyUI.PROVIDER);
					
				}		
			
		});
		return backButton;
	}
	
}

