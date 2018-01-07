package claps.patientpath;

import claps.persistence.EventDAO;
import claps.persistence.Info;
import claps.persistence.InfoDAO;

import java.time.LocalDateTime;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ClassResource;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.SingleSelect;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.renderers.LocalDateTimeRenderer;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.SelectionMode;
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
		imageLogo.setHeight("10%");
		imageLogo.setWidth("10%");
		
		setSizeFull();
		setSpacing(true);
		addComponent(homeMenu);
		addComponent(imageLogo);
		addComponent(placeHolder);
		setComponentAlignment(homeMenu, Alignment.TOP_RIGHT);
		setComponentAlignment(imageLogo, Alignment.TOP_RIGHT);
		setComponentAlignment(placeHolder, Alignment.MIDDLE_CENTER);
		homeMenu.setWidth("100%");

	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("WELCOME");
		id = Integer.valueOf(VaadinService.getCurrentRequest().getWrappedSession().getAttribute("myValue").toString());
		placeHolder.removeAllComponents();
		placeHolder.addComponent(myGrid());
	}
	
	MenuBar.Command myCommandMenuHilfe = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.HOMEHILFE);
	    }
	};
	
	MenuBar.Command myCommandProvider = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.PROVIDER);
	    }
	};
	
	MenuBar.Command myCommandLogout = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.LOGIN);
	    }
	};
	
	//Menu in Home
	MenuBar homeMenu = new MenuBar();
	MenuItem myMenu = homeMenu.addItem("Menu", null, null);
		MenuItem hilfe = myMenu.addItem("Hilfe", null, myCommandMenuHilfe );
		MenuItem provider = myMenu.addItem("Verzeichnis", null, myCommandProvider);
		MenuItem logout = myMenu.addItem("Logout", null, myCommandLogout);
		
	private Grid<claps.persistence.Event> myGrid() {
		
		EventDAO eventDAO = new EventDAO();
		
		Grid<claps.persistence.Event> myGrid = new Grid();
			myGrid.setHeightUndefined();
			myGrid.setWidth("100%");
			myGrid.setSelectionMode(SelectionMode.SINGLE);
			SingleSelect<claps.persistence.Event> selection = myGrid.asSingleSelect();
			
			myGrid.addSelectionListener(event -> {
			
				infoID = selection.getValue().getEventinfoID();

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
		subWin.center();
		
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
	
}