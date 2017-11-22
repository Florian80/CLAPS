package claps.patientpath;

import claps.persistence.PathConnect;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class VersionTwo extends VerticalLayout implements View {
	
	public VersionTwo() {
		setSizeFull();
		setSpacing(true);
		addComponent(labelHeader);
	}
	
	private Label labelHeader = new Label("Version 2");
}