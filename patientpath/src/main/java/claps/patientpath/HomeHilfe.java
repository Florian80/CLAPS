package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class HomeHilfe extends VerticalLayout implements View{

//The Help Page to the Home Page, just a short text and a Button to navigate back.

public HomeHilfe() {

Image imageLogo = new Image();
		
		imageLogo.setSource(new ClassResource("/PatientPath_Logo.png"));
		imageLogo.setHeight("100px");
		setSizeFull();
		setSpacing(true);
	
		Panel panel = new Panel("Home Hilfe Anleitung");
		Panel panel2 = new Panel(" Hier finden sie alle Termine im Überblick. Die Termine die schon vorbei sind,"
			 		+ " haben einen anderen Farbton als die Termine die noch bevorstehen. Jeder Termin hat eine Menüansicht,"
			 		+ " bei der verschiedene Möglichkeiten bestehen, den Termin zu bearbeiten. Wenn Sie einen Termin verschieben möchten,"
			 		+ " können sie auf Edit klicken und danach den passenden Termin eingeben."
			 		+ " Bei jedem Termin haben Sie die Möglichkeit für einen Arzt eine Datei hochzuladen. ");
			
			
			panel.setWidth("300px");
			panel.setHeight("300px");
			panel.setContent(panel2);
			
			addComponent(imageLogo);
			addComponent(panel);
			addComponent(HomeButton());
		
	
	}

	private Button HomeButton() {
		Button HomeButton = new Button("Zurück", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOME);
			}
		});
		return HomeButton;
	}
}
