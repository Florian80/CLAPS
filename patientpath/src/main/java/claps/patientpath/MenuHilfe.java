package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class MenuHilfe extends VerticalLayout implements View{

	

	//Under Construction
	private Label labelVersions = new Label("Mockup Versionen");

	public MenuHilfe() {
		setSizeFull();
		setSpacing(true);
		addComponent(labelVersions);
	}
}
