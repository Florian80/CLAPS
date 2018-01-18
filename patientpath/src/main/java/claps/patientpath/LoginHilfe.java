package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

//This Page is a simple Help Page to the Login Page with a short Text and a Button to Navigate 
//Back (Still open issue: Navigation to first Page (Login) illegal, -> navigates to home
//Label "zurück" on Button is misleading -> partial unresolved issue...
//(Back Button on Browser works better / can navigate to Login)

@SuppressWarnings("serial")
public class LoginHilfe extends VerticalLayout implements View {
   

		public LoginHilfe() {

			Image imageLogo = new Image();
			
			imageLogo.setSource(new ClassResource("/PatientPath_Logo.png"));
			imageLogo.setHeight("100px");
			
			setSizeFull();
			setSpacing(true);

			Panel panel = new Panel("Hilfe");
			Panel panel2 = new Panel("Um dich in PatientPath einzulogen"+
					                " verwendest du den von deinem Arzt"+
					                " zugewiesenen Benutzername und das"+
					                " entsprechende Password"+
					                " Falls du noch kein Login hast, kannst"+ 
					                " du bei einem angeschlossenen Arzt einen"+
					               " Account erstellen lassen oder dich selber"+
					                " Registrieren, als ID benutzt du bitte deine"+
					               " eHealth Id (auf deiner Versichertenkarte)");
			
			panel.setWidth("300px");
			panel.setHeight("300px");
			panel.setContent(panel2);
			addComponent(imageLogo);
			addComponent(panel);
			addComponent(zuruck());
		
		}
		
		private Button zuruck() {
			Button zuruck = new Button("Zurück", new Button.ClickListener() {
				@Override
			
				public void buttonClick(ClickEvent event) {
					getUI().getNavigator().navigateTo(MyUI.HOME);
					
				}
			});
			return zuruck;
		}

}