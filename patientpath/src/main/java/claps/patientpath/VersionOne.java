package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class VersionOne extends VerticalLayout implements View {

	private Label labelHeader = new Label("Version 1");
	
	public VersionOne() {
		setSizeFull();
		setSpacing(true);
		addComponent(labelHeader);
		addComponent(calendarLabel);
	}
	
	private Label calendarLabel = new Label("Calendar goes here");
}