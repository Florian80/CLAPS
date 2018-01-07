package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ProviderHilfe extends VerticalLayout implements View {


	public ProviderHilfe() {
		Button button = new Button("Zurück");
		Label labelHeader = new Label("3.12.2017 Hausarzt");
		
		
		// A container with a defined width.
        Panel panel = new Panel("Beschreibung von dem Hausarztbesuch");
        panel.setWidth("300px");

        panel.setContent(
            new Label("Beim Hausarzt fängt die ganze" +
   	             "Behandlung an. Sie werden von" +
   	             "ihrem Hausarzt untersucht, um" +
   	             "danach einen Termin beim"+
   	             "Spezialisten zu erlangen. Hier"+"werden nur die Erstuntersuchungen"+ 
   	             "durchgeführt"));
		
	
	
        addComponent(button);
		addComponent(labelHeader);
		addComponent(panel);
		
	  }
	
	
	
	
}