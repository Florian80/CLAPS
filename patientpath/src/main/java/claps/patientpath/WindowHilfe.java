package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class WindowHilfe extends VerticalLayout implements View {
   
	//	private Button zuruck = new Button("Zurück");

		public WindowHilfe() {
			setSizeFull();
			setSpacing(true);
			
			 Panel panel = new Panel("Um dich in PatientPath einzulogen"+
		                " verwendest du den von deinem Arzt"+
		                " zugewiesenen Benutzername und das"+
		                " entsprechende Password"+
		                " Falls du noch kein Login hast, kannst"+ 
		                " du bei einem angeschlossenen Arzt einen"+
		                " Account erstellen lassen");
		        
			 addComponent(panel);
			addComponent(zuruck());
		}
		
		private Button zuruck() {
			Button button = new Button("Zurück", new Button.ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
					
					getUI().getNavigator().navigateTo(MyUI.HOME);
					
				}
			});
			return button;
		}

}