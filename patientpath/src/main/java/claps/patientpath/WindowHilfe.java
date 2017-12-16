package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class WindowHilfe extends VerticalLayout implements View {
    protected void init(VaadinRequest request) {
    

        // Create a sub-window and set the content
        Window subWindow = new Window("Hilfe");
        VerticalLayout subContent = new VerticalLayout();
        subWindow.setContent(subContent);

        // Put some components in it
        subContent.addComponent(new Panel("Um dich in PatientPath einzulogen"+
                "verwendest du den von deinem Arzt"+
                "zugewiesenen Benutzername und das"+
                "entsprechende Password"+
                ""+"Falls du noch kein Login hast, kannst"+ 
                "du bei einem angeschlossenen Arzt einen"+
                "Account erstellen lassen"));
        subContent.addComponent(new Button("Zurück"));

        // Center it in the browser window
        subWindow.center();

        // Open it in the UI
        addWindow(subWindow);
        addComponent(subContent);
     
        Button zuruck = new Button("Zurück");
        Panel panel = new Panel("Um dich in PatientPath einzulogen"+
                "verwendest du den von deinem Arzt"+
                "zugewiesenen Benutzername und das"+
                "entsprechende Password"+
                ""+"Falls du noch kein Login hast, kannst"+ 
                "du bei einem angeschlossenen Arzt einen"+
                "Account erstellen lassen");
        
        
        addComponent(zuruck);
        addComponent(panel);
        
        
        
      
    }

	private void addWindow(Window subWindow) {
		// TODO Auto-generated method stub
		
	}
}