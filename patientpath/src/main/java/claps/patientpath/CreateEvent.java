package claps.patientpath;

import java.time.LocalDate;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import claps.persistence.Info;
import claps.persistence.PathObject;
import claps.persistence.PathObjectDAO;
import claps.persistence.ProviderDAO;

/*
 * In this class new information can be entered or which changes from a path object
 */

@SuppressWarnings("serial")
public class CreateEvent extends VerticalLayout implements View {
	
	int eventID;
	int infoID;
	//claps.persistence.Event newEvent = new claps.persistence.Event();
	//Info newInfo = new Info();

	
	
	public CreateEvent() {
	
		/*
		 * Here everything is geschirbene what should appear in the GUI and how it appears in order
		 */
		
		setSizeFull();
		setSpacing(true);
		addComponent(titel1);
		addComponent(titel2);
		addComponent(titel3);
		addComponent(eventName);
		addComponent(myDateField());
		addComponent(eventZeit);
		addComponent(eventDauer);
		addComponent(pfadComboBox());
		addComponent(providerComboBox());
		addComponent(infoText);
		addComponent(saveButton());
		addComponent(backButton());
	
		}

	@Override
	public void enter(ViewChangeEvent event) {
		
	}
	
	/*
	 * Here the whole content of the will be changed
	 */
	Label titel1 = new Label("Neuen Termin anlegen"); 
	Label titel2 = new Label("oder"); 
	Label titel3 = new Label("Termin ändern"); 
	
	TextField eventName = new TextField("Kurzbeschrieb / Titel");

	TextField eventDatum = new TextField("Datum");
	
	TextField eventZeit = new TextField("Zeit (Format Bitte: Stunden:Minuten (hh:mm)");
	
	TextField eventDauer = new TextField("Dauer des Termins (in Minuten)");
	
	TextField eventProvider = new TextField("Provider");
	
	TextArea infoText = new TextArea("Informationen / Beschreibung");
	
	DateField myDateField() {
		DateField myDateField = new DateField("Datum");
		myDateField.setValue(LocalDate.now());
		
		return myDateField;
	}
	
	ComboBox<PathObject> pfadComboBox() {
		ComboBox<PathObject> pfadComboBox = new ComboBox<PathObject>("Pfad - Phase");
			
		PathObjectDAO pathObjectDAO = new PathObjectDAO();
		pathObjectDAO.findAllPathObject();
		pfadComboBox.setItems(pathObjectDAO.findAllPathObject());
;
		return pfadComboBox;
	};
	
	ComboBox<Provider> providerComboBox() {
		ComboBox<Provider> providerComboBox = new ComboBox<Provider>("Provider / Anbieter");
		
		return providerComboBox;
	};
	
	/*
	 * This method will bring the content from database and let it appear
	 */
	ComboBox<claps.persistence.Provider> eventComboBox() {
		
		ComboBox<claps.persistence.Provider> eventComboBox = new ComboBox<claps.persistence.Provider>(); {
			
			ProviderDAO providerDAO = new ProviderDAO();
			
			eventComboBox.setItems(providerDAO.findAllProvider());
			
		}
		
		
		
		return eventComboBox;
	};
	
	/*
	 * this method saves the content that has been changed and indicates which page should appear
	 */
	private Button saveButton() {
		Button saveButton = new Button("Speichern", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
			
					getUI().getNavigator().navigateTo(MyUI.HOME);
					
				}
		});
			return saveButton;
	}
	
	Button save = new Button("Speichern") {

	};
	/*
	 * This code determines where to proceed by clicking on the back button. 
	 */
	
	private Button backButton() {
		Button backButton = new Button("Zurück/Verwerfen", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
			
					getUI().getNavigator().navigateTo(MyUI.HOME);
					
				}		
			
		});
		return backButton;
	}
	
}
