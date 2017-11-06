package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;


@SuppressWarnings("serial")
public class Home extends VerticalLayout implements View {

	private Label labelVersions = new Label("Mockup Versionen");

	public Home() {
		setSizeFull();
		setSpacing(true);
		addComponent(labelVersions);
		addComponent(viewOneButton());
		addComponent(viewTwoButton());
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("WELCOME");
	}
	
	private Button viewOneButton() {
		Button viewOneButton = new Button("Version 1", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.VERSIONONE);
			}
		});
		return viewOneButton;
	}
	
	private Button viewTwoButton() {
		Button viewTwoButton = new Button("Version 2", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.VERSIONTWO);
			}
		});
		return viewTwoButton;
	}
	
}