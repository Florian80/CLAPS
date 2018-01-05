package claps.patientpath;

import claps.persistence.EventDAO;
import claps.persistence.Event;
import claps.patientpath.Login;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import com.vaadin.data.provider.GridSortOrder;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.SingleSelect;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.LocalDateRenderer;
import com.vaadin.ui.renderers.LocalDateTimeRenderer;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
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

	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("WELCOME");
		id = Integer.valueOf(VaadinService.getCurrentRequest().getWrappedSession().getAttribute("myValue").toString());
		placeHolder.removeAllComponents();
		placeHolder.addComponent(myGrid());
	}
	
	MenuBar.Command myCommandProvider = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.PROVIDER);
	    }
	};
	
	//Menu in Home
	MenuBar homeMenu = new MenuBar();
	MenuItem myMenu = homeMenu.addItem("Menu", null, null);
		MenuItem hilfe = myMenu.addItem("Hilfe", null, null);
		MenuItem provider = myMenu.addItem("Verzeichnis", null, myCommandProvider);
	
	private Grid<claps.persistence.Event> myGrid() {
		
		EventDAO eventDAO = new EventDAO();
		
		Grid<claps.persistence.Event> myGrid = new Grid();
		
			myGrid.setSelectionMode(SelectionMode.SINGLE);
			SingleSelect<claps.persistence.Event> selection = myGrid.asSingleSelect();
			
			myGrid.addSelectionListener(event -> {
			
				selection.getValue().getEventinfoID();
				System.out.println(selection.getValue().getEventinfoID());
				
			});
			
			myGrid.addColumn(claps.persistence.Event::getEventName);
			Column <claps.persistence.Event, LocalDateTime> myColumn = myGrid.addColumn(claps.persistence.Event::getSimpleDateTime, new LocalDateTimeRenderer("dd.MM.yyyy 'um' hh:mm"));
			myGrid.setItems(eventDAO.findAllEvent(id));
			myGrid.sort(myColumn, SortDirection.ASCENDING);
		
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

	
	private Button viewThreeButton() {
		Button viewThreeButton = new Button("Version 3 - Provider", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.VERSIONTHREE);
			}
		});
		return viewThreeButton;
	}
	
	
	
}