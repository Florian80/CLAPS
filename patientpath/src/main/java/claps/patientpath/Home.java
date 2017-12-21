package claps.patientpath;

import claps.persistence.EventDAO;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar.MenuItem;

@SuppressWarnings("serial")
public class Home extends VerticalLayout implements View {

	private Label labelVersions = new Label("Übersicht");
	HorizontalLayout sample;
	
	public Home() {
		setSizeFull();
		setSpacing(true);
		addComponent(labelVersions);
		addComponent(kalenderButton());
		addComponent(viewTwoButton());
		addComponent(viewThreeButton());
		addComponent(viewProviderTestButton());
		addComponent(browserCheckTestButton());
		addComponent(myGrid());
		
		/*
		//Horizontal Versuch
		sample = new HorizontalLayout();
	    sample.addStyleName("outlined");
	    sample.setSpacing(false);
	    sample.setMargin(false);
	    sample.setSizeFull();

	    //for (int i = 0; i < 3; i++) {
	        //final Component childComponent = new LayoutSampleUtil.LayoutChildComponent(sample);
	        //sample.addComponent(childComponent);
	    //}
	    Label label1 = new Label("Logo1");
	    Label label2 = new Label("Logo2");
		
	    sample.addComponent(label1);
	    sample.addComponent(label2);*/
		
		
	}
	
	//Test Notification
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("WELCOME");
	}
	
	private Button kalenderButton() {
		Button kalenderButton = new Button("Kalender", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.KALENDER);
			}
		});
		return kalenderButton;
	}
	
	private Button viewTwoButton() {
		Button viewTwoButton = new Button("Stammdaten", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.VERSIONTWO);
			}
		});
		return viewTwoButton;
	}
	
	private Button viewProviderTestButton() {
		Button viewProviderTestButton = new Button("ProviderTest", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.PROVIDERTEST);
			}
		});
		return viewProviderTestButton;
	}
	
	private Button viewThreeButton() {
		Button viewThreeButton = new Button("Version 3 - Provider", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.VERSIONTHREE);
			}
		});
		return viewThreeButton;
	}
	
	private Button browserCheckTestButton() {
		Button browserCheckTestButton = new Button("BrowserCheck", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.BROWSERCHECKTEST);
			}
		});
		return browserCheckTestButton;
	}
	
	
	private Grid<claps.persistence.Event> myGrid() {
		
		EventDAO eventDAO = new EventDAO();
		
		Grid<claps.persistence.Event> myGrid = new Grid();
		myGrid.setSelectionMode(SelectionMode.NONE);
		myGrid.addColumn(claps.persistence.Event::getEventName).setCaption("Name");
		myGrid.addColumn(claps.persistence.Event::getEventDateTime).setCaption("Date");
		myGrid.setItems(eventDAO.findAllEvent(1));

		return myGrid;
	}

}