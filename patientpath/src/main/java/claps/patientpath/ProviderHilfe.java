package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class ProviderHilfe extends VerticalLayout implements View {


	public ProviderHilfe() {
		
		
		Label labelHeader = new Label("Liste aller Provider");
		
		
		// A container with a defined width.
        Panel panel = new Panel("Beschreibung zu deinen Providern");


        Panel panel2= new Panel("Beim Hausarzt fängt die ganze" +
   	             " Behandlung an. Sie werden von" +
   	             " ihrem Hausarzt untersucht, um" +
   	             " danach einen Termin beim"+
   	             " Spezialisten zu erlangen. Hier"+" werden nur die Erstuntersuchungen"+ 
   	             " durchgeführt." + " Hier sind alle vorhandenen Provider"+
   	              " aufgeführt, für mehr Infos einfach anklicken.");
        
        panel2.setWidth("300px");
        panel2.setHeight("300px");
		setSizeFull();
		setSpacing(true);
	
        /*
		 * Here everything is geschirbene what should appear in the GUI and how it appears in order
		 */
        addComponent(backButton());
		addComponent(labelHeader);
		addComponent(panel);
		addComponent(panel2);
		
	  }
	
	private Button backButton() {
		Button HomeButton = new Button("Zurück", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.PROVIDER);
			}
		});
		return HomeButton;
	}
	
}