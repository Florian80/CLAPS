package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings("serial")
public class ProviderTest extends VerticalLayout implements View {

	//Under construction
	private Label labelHeader = new Label("Provider");
	
	public ProviderTest() {
	    
		setSizeFull();
		setSpacing(true);
		addComponent(labelHeader);
	    
	  }

}