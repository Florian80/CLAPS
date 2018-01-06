package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class LoginHilfe extends VerticalLayout implements View {
   
	//	private Button zuruck = new Button("Zurück");

		public LoginHilfe() {
			Image imageLogo = new Image();
			
			imageLogo.setSource(new ClassResource("/PatientPath_Logo.png"));
			imageLogo.setHeight("100px");
			
			setSizeFull();
			setSpacing(true);
			
			 Panel panel = new Panel("Um dich in PatientPath einzulogen"+
		                " verwendest du den von deinem Arzt"+
		                " zugewiesenen Benutzername und das"+
		                " entsprechende Password"+
		                " Falls du noch kein Login hast, kannst"+ 
		                " du bei einem angeschlossenen Arzt einen"+
		                " Account erstellen lassen");
		     
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