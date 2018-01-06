package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class Akteure extends VerticalLayout implements View{



	

	//Under Construction
	private Label labelVersions = new Label("Mockup Versionen");

	public Akteure() {
		setSizeFull();
		setSpacing(true);
		addComponent(labelVersions);
	}

	
}
