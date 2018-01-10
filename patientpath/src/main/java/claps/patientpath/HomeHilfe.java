package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class HomeHilfe extends VerticalLayout implements View{

	

	//Under Construction
//	private Label labelVersions = new Label("Home hilfe Anleitung");

	public HomeHilfe() {
		
Image imageLogo = new Image();
		
		imageLogo.setSource(new ClassResource("/PatientPath_Logo.png"));
		imageLogo.setHeight("100px");
		setSizeFull();
		setSpacing(true);
		
		
	/**	
		MenuBar.Command myCommandProvider = new MenuBar.Command() {
		    public void menuSelected(MenuItem selectedItem) {
		        getUI().getNavigator().navigateTo(MyUI.PROVIDER);
		    }
		};
		
		MenuBar.Command myMenuHilfe = new MenuBar.Command() {
		    public void menuSelected(MenuItem selectedItem) {
		        getUI().getNavigator().navigateTo(MyUI.MENUHILFE);
		    }
		};
		
		MenuBar.Command myLogout = new MenuBar.Command() {
		    public void menuSelected(MenuItem selectedItem) {
		        getUI().getNavigator().navigateTo(MyUI.LOGIN);
		    }
		};
		MenuBar.Command myKalender = new MenuBar.Command() {
		    public void menuSelected(MenuItem selectedItem) {
		        getUI().getNavigator().navigateTo(MyUI.KALENDER);
		    }
		};
		MenuBar.Command myHome = new MenuBar.Command() {
		    public void menuSelected(MenuItem selectedItem) {
		        getUI().getNavigator().navigateTo(MyUI.HOME);
		    }
		};
		
	//MenuBar
	MenuBar uebersichtMenu = new MenuBar();
//	uebersichtMenu.setWidth(500.0f, Unit.PERCENTAGE);
		MenuItem uebersicht = uebersichtMenu.addItem("Übersicht", null, null);
		 //   MenuItem kalender = uebersicht.addItem("Kalender", null, null);
		   /// MenuItem akteure = uebersicht.addItem("Akteure", null, null);
			//MenuItem logout = uebersicht.addItem("Logout", null, null);			
			
		MenuItem hilfe = uebersicht.addItem("Hilfe", null, myMenuHilfe );
		MenuItem akteure = uebersicht.addItem("Akteure", null, null);
		MenuItem calender = uebersicht.addItem("Kalender", null, myKalender);
		MenuItem provider = uebersicht.addItem("Verzeichnis", null, myCommandProvider);
		MenuItem home = uebersicht.addItem("Home", null, myHome);
		MenuItem logout = uebersicht.addItem("Logout", null, myLogout);
		
		**/
		
		
	   
		 
		 
		 Panel panel = new Panel("Home hilfe Anleitung");
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
			
		 
		 
		 

			addComponent(imageLogo);
			//addComponent(uebersichtMenu);
	//		addComponent(labelVersions);
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
