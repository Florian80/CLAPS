package claps.patientpath;

import claps.persistence.EventDAO;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;

@SuppressWarnings("serial")
public class Home extends VerticalLayout implements View {

	private Label labelVersions = new Label("Mockup Versionen");

	public Home() {
		setSizeFull();
		setSpacing(true);
		addComponent(labelVersions);
		addComponent(viewOneButton());
		addComponent(viewTwoButton());
		addComponent(viewThreeButton());
		addComponent(myGrid());
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("WELCOME");
	}
	
	private Button viewOneButton() {
		Button viewOneButton = new Button("Version 1 - Liste", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.VERSIONONE);
			}
		});
		return viewOneButton;
	}
	
	private Button viewTwoButton() {
		Button viewTwoButton = new Button("Version 2 - Kalender", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.VERSIONTWO);
			}
		});
		return viewTwoButton;
	}
	
	
	private Button viewThreeButton() {
		Button viewTwoButton = new Button("Version 3 - Provider", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				
				EventDAO myEvent = new EventDAO();
				myEvent.findAllEvent();
				
				getUI().getNavigator().navigateTo(MyUI.VERSIONTHREE);
			}
		});
		return viewTwoButton;
	}
	
	
	private Grid<claps.persistence.Event> myGrid() {
		
		EventDAO eventDAO = new EventDAO();
		
		Grid<claps.persistence.Event> myGrid = new Grid();
		myGrid.setSelectionMode(SelectionMode.NONE);
		myGrid.addColumn(claps.persistence.Event::getEventName).setCaption("Name");
		myGrid.addColumn(claps.persistence.Event::getEventDateTime).setCaption("Date");
		myGrid.setItems(eventDAO.findAllEvent());

		return myGrid;
	}
	

}