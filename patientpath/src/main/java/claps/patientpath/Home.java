package claps.patientpath;

import claps.persistence.EventDAO;
import claps.persistence.Info;
import claps.persistence.InfoDAO;
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
import com.vaadin.server.ClassResource;

import com.vaadin.server.ExternalResource;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.SingleSelect;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.renderers.LocalDateRenderer;
import com.vaadin.ui.renderers.LocalDateTimeRenderer;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.MenuBar.MenuItem;

@SuppressWarnings("serial")
public class Home extends VerticalLayout implements View {
	
	private int id;
	private int infoID;
    private VerticalLayout placeHolder = new VerticalLayout();

	public Home() {
		
		Image imageLogo = new Image();
		
		imageLogo.setSource(new ClassResource("/PatientPath_Logo.png"));
		imageLogo.setHeight("100px");
		
		setSizeFull();
		setSpacing(true);
		addComponent(imageLogo);
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
	
	MenuBar.Command myMenuHilfe = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.MENUHILFE);
	    }
	};
	
	MenuBar.Command myLogout = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.LOGIN);
	    }
	};
	MenuBar.Command myKalender = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.KALENDER);
	    }
	};
	
	MenuBar.Command myHome = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.HOME);
	    }
	};
	//Menu in Home
	MenuBar homeMenu = new MenuBar();
	MenuItem myMenu = homeMenu.addItem("Menu", null, null);
		MenuItem hilfe = myMenu.addItem("Hilfe", null, myMenuHilfe );
		MenuItem akteure = myMenu.addItem("Akteure", null, null);
		MenuItem calender = myMenu.addItem("Kalender", null, myKalender);
		MenuItem provider = myMenu.addItem("Verzeichnis", null, myCommandProvider);
		MenuItem home = myMenu.addItem("Home", null, myHome);
		MenuItem logout = myMenu.addItem("Logout", null, myLogout);
		
	private Grid<claps.persistence.Event> myGrid() {
		
		EventDAO eventDAO = new EventDAO();
		
		Grid<claps.persistence.Event> myGrid = new Grid();
		
			myGrid.setSelectionMode(SelectionMode.SINGLE);
			
			SingleSelect<claps.persistence.Event> selection = myGrid.asSingleSelect();
			
			myGrid.addSelectionListener(event -> {
			
				infoID = selection.getValue().getEventinfoID();

				//addWindow(InfoSubWindow());
				UI.getCurrent().addWindow(InfoSubWindow());
				
				});
			
			myGrid.addColumn(claps.persistence.Event::getEventName);
			Column <claps.persistence.Event, LocalDateTime> myColumn = myGrid.addColumn(claps.persistence.Event::getSimpleDateTime, new LocalDateTimeRenderer("dd.MM.yyyy 'um' hh:mm"));
			myGrid.setItems(eventDAO.findAllEvent(id));
			myGrid.sort(myColumn, SortDirection.ASCENDING);
		
		return myGrid;
	}
	
	public Window InfoSubWindow() {
		
		Window subWin = new Window();
		
		GridLayout myGridLayout = new GridLayout(2,8);
		myGridLayout.setWidth("700px");
		myGridLayout.setHeight("100%");
		
		VerticalLayout subContent = new VerticalLayout();
		Info myInfo = new Info();		
		InfoDAO eventDAO = new InfoDAO();
		myInfo = eventDAO.returnInfo(infoID);
		String myImageURL = myInfo.getInfoImageURL();

		Image myImage = new Image();
		myImage.setSource(new ClassResource("/PatientPath_Logo.png"));
		myImage.setWidth("50%");
		
		if(myImageURL != null) {
			ExternalResource resource = new ExternalResource(myInfo.getInfoImageURL());
			Image myOnlineImage = new Image("", resource);
			myOnlineImage.setWidth("80%");
			myOnlineImage.setHeight("80%");
			myImage = myOnlineImage;
		};
		
		Label text = new Label(myInfo.getInfoText());
		text.setWidth("90%");

		myGridLayout.addComponent(new Label("Information"), 0, 0, 1, 0);
		myGridLayout.addComponent(myImage, 0, 1, 0, 4);	
		myGridLayout.addComponent(new Label(myInfo.getAddressLineOne()), 1, 1, 1, 1);	
		myGridLayout.addComponent(new Label(myInfo.getAddressLineTwo()), 1, 2, 1, 2);	
		myGridLayout.addComponent(new Label(myInfo.getAddressLineThree()), 1, 3, 1, 3);	
		myGridLayout.addComponent(new Label(myInfo.getAddressLineFour()), 1, 4, 1, 4);	
		myGridLayout.addComponent(new Label(myInfo.getWebsite()), 0, 5, 0, 5);		
		myGridLayout.addComponent(new Label(myInfo.getEMail()), 0, 6, 0, 6);		
		myGridLayout.addComponent(new Label(myInfo.getTelefon()), 1, 5, 1, 5);		
		myGridLayout.addComponent(new Label(myInfo.getFax()), 1, 6, 1, 6);
		myGridLayout.addComponent(text, 0, 7, 1, 7);
		
        subWin.setContent(subContent);
		subContent.addComponent(myGridLayout);
		return subWin;
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