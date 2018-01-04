package claps.patientpath;

import claps.persistence.EventDAO;
import claps.patientpath.Login;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
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
	
	private int id;
    private VerticalLayout placeHolder = new VerticalLayout();

	public Home() {
		setSizeFull();
		setSpacing(true);
		addComponent(homeMenu);
		addComponent(placeHolder);
		addComponent(kalenderButton());
		addComponent(viewTwoButton());
		addComponent(viewThreeButton());
		addComponent(viewProviderTestButton());
		addComponent(browserCheckTestButton());

	}
	
	//Test Notification
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("WELCOME");
		Label labelVersions = new Label("Übersicht: " + VaadinService.getCurrentRequest().getWrappedSession().getAttribute("myValue"));
		id = Integer.valueOf(VaadinService.getCurrentRequest().getWrappedSession().getAttribute("myValue").toString());
		System.out.println(id);
		placeHolder.removeAllComponents();
		placeHolder.addComponent(myGrid());
		placeHolder.addComponent(labelVersions);
	}
	
	//Menu in Home
	MenuBar homeMenu = new MenuBar();
	MenuItem myMenu = homeMenu.addItem("MENU", null, null);
	MenuItem exit = myMenu.addItem("QUIT", null, null);
	
	private Grid<claps.persistence.Event> myGrid() {
		
		EventDAO eventDAO = new EventDAO();
		
		Grid<claps.persistence.Event> myGrid = new Grid();
		myGrid.setSelectionMode(SelectionMode.SINGLE);
		myGrid.addColumn(claps.persistence.Event::getEventName).setCaption("Name");
		myGrid.addColumn(claps.persistence.Event::getEventDateTime).setCaption("Date");
		myGrid.setItems(eventDAO.findAllEvent(id));

		return myGrid;
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
	
}