package claps.patientpath;

import claps.persistence.PathConnect;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class VersionThree extends VerticalLayout implements View {

	
	//Under Construction
	private Label labelVersions = new Label("Mockup Versionen");

	public VersionThree() {
		setSizeFull();
		setSpacing(true);
		addComponent(labelVersions);
	}
}

