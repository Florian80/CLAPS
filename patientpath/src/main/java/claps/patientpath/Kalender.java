package claps.patientpath;

import claps.persistence.EventDAO;
import claps.persistence.PathConnect;
import claps.persistence.UserDAO;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar.MenuItem;

@SuppressWarnings("serial")
public class Kalender extends HorizontalLayout implements View {
	
	HorizontalLayout TitleLayout;
	Label title;
	//DateField date;
	Button logout;
	
	VerticalLayout sample;
	
	//VerticalLayout verticalLayout = new VerticalLayout();
	
	public Kalender() {
		//setSizeFull();
		//setSpacing(true);
		//layout.setWidth("400px");
		
		//HorizontalLayout horizontalLayout = new HorizontalLayout();
		
		Label label = new Label("Logo");
		
		//horizontalLayout.addComponent(label);
		
		//Horizontal Versuch
        sample = new VerticalLayout();
        sample.addStyleName("outlined");
        sample.setSpacing(false);
        sample.setMargin(false);
        sample.setSizeFull();
 
        /*for (int i = 0; i < 3; i++) {
            final Component childComponent = new LayoutSampleUtil.LayoutChildComponent(sample);
            sample.addComponent(childComponent);
        }*/
        Label label1 = new Label("Logo1");
        Label label2 = new Label("Logo2");
		
        sample.addComponent(label1);
        sample.addComponent(label2);
		
		
		// Title
				TitleLayout = new HorizontalLayout();
				title = new Label("Patienten Schedule");

				//date = new DateField();
				//date.setValue(new Date());
				//date.setDateFormat("dd.MM.yyyy");

				logout = new Button("Logout");

				TitleLayout.addComponent(title);
				//TitleLayout.addComponent(date);
				TitleLayout.addComponent(logout);
				
				TitleLayout.setMargin(true);
				TitleLayout.setSpacing(true);
		
		
		
		//MenuBar
		MenuBar uebersichtMenu = new MenuBar();
			MenuItem uebersicht = uebersichtMenu.addItem("Übersicht", null, null);
			    MenuItem kalender = uebersicht.addItem("Kalender", null, null);
			    MenuItem akteure = uebersicht.addItem("Akteure", null, null);
				MenuItem logout = uebersicht.addItem("Logout", null, null);
		
		//Label kalenderLabel = new Label("Kalender");
		//TextField username = new TextField("Username");
		//TextField password = new TextField("Password");
		
		//addComponent(label);
		//horizontalLayout.addComponent(kalenderLabel);
		addComponent(uebersichtMenu);
		/*addComponent(username);
		addComponent(password);
		addComponent(loginButton());
		addComponent(selection);
		addComponent(myGrid());
		
		//VerticalLayout vertical = new VerticalLayout ();
		//vertical.addComponent(new TextField("Name"));
		//vertical.addComponent(new TextField("Street address"));
		//vertical.addComponent(new TextField("Postal code"));
		//layout.addComponent(vertical);
		
		
	}

	//Test Notification
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome! Please log in.");
	}
	
	private Button loginButton() {
		Button button = new Button("Übersicht", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				UserDAO user = new UserDAO();
				user.findAllUser();
				getUI().getNavigator().navigateTo(MyUI.HOME);
			}
		});
		return button;
	}

	MenuBar.Command mycommand = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        selection.setValue("Ordered a " +
	                           selectedItem.getText() +
	                           " from menu.");
	    }
	};
	
	final Label selection = new Label("-");
	
	
private Grid<claps.persistence.Event> myGrid() {
		
		EventDAO eventDAO = new EventDAO();
		
		Grid<claps.persistence.Event> myGrid = new Grid();
		myGrid.setSelectionMode(SelectionMode.NONE);
		myGrid.addColumn(claps.persistence.Event::getEventName).setCaption("Name");
		myGrid.addColumn(claps.persistence.Event::getEventDateTime).setCaption("Date");
		myGrid.setItems(eventDAO.findAllEvent());

		return myGrid;*/
	}
	
}