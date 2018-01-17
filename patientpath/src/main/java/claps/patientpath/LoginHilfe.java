package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/*
 * This class contains the help text for the login page
 */

@SuppressWarnings("serial")
public class LoginHilfe extends VerticalLayout implements View {
   


		public LoginHilfe() {
			
			/*
			 * This code is responsible for the small image in the app. He forms the logo of this app
			 */
			Image imageLogo = new Image();
			
			imageLogo.setSource(new ClassResource("/PatientPath_Logo.png"));
			imageLogo.setHeight("100px");
			
			setSizeFull();
			setSpacing(true);
			
	/*
	 * This code is responsible for the text. It allows to see the text without editing or changing it
	 */
		
			Panel panel = new Panel("Hilfe");
			Panel panel2 = new Panel("Um dich in PatientPath einzulogen"+
					                " verwendest du den von deinem Arzt"+
					                " zugewiesenen Benutzername und das"+
					                " entsprechende Password"+
					                " Falls du noch kein Login hast, kannst"+ 
					                " du bei einem angeschlossenen Arzt einen"+
					               " Account erstellen lassen");
			
			
			panel.setWidth("300px");
			panel.setHeight("300px");
		
		
			
			panel.setContent(panel2);
			 addComponent(imageLogo);
			 addComponent(panel);
			addComponent(zuruck());
		
		}
		
		/*
		 *This method allows the user to go back to the previous page by clicking on the button 
		 */
		
		
		private Button zuruck() {
			Button zuruck = new Button("Zurück", new Button.ClickListener() {
				@Override
			
				public void buttonClick(ClickEvent event) {
					
					getUI().getNavigator().navigateTo(MyUI.LOGIN);
					
				}
			});
			return zuruck;
		}

}