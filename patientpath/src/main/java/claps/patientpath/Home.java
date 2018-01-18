package claps.patientpath;

import claps.persistence.EventDAO;

import claps.persistence.Info;
import claps.persistence.InfoDAO;

import java.time.LocalDateTime;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ClassResource;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.SingleSelect;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.renderers.LocalDateTimeRenderer;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Image;
import com.vaadin.ui.MenuBar.MenuItem;

//The Home - Page
@SuppressWarnings("serial")
public class Home extends VerticalLayout implements View {
	
	//Important values and a placeholder to load grid with Client-Side Rendering
	private int id;
	private int eventInfoID;
	private int eventID;
    private VerticalLayout placeHolder = new VerticalLayout();

    //Home Method with simple Fields (Images (not yet in use), Logo)
    //and adding all Components
	public Home() {
		
		Image imageLogo = new Image();
		imageLogo.setSource(new ClassResource("/PatientPath_Logo.png"));
		imageLogo.setHeight("20%");
		imageLogo.setWidth("20%");
		
		Image imageZuHause = new Image();
		imageZuHause.setSource(new ClassResource("/house.ico"));
		
		Image imageHausarzt = new Image();
		imageHausarzt.setSource(new ClassResource("/hausarzt.ico"));
		
		Image imageSpezialist = new Image();
		imageSpezialist.setSource(new ClassResource("/spzialist.ico"));
		imageSpezialist.setWidth("20%");
		imageSpezialist.setHeight("20%");
		
		Image imageHospital = new Image();
		imageHospital.setSource(new ClassResource("/hospital.ico"));
		
		Image imageOp = new Image();
		imageOp.setSource(new ClassResource("/op.ico"));
		
		Image imagePostOp = new Image();
		imagePostOp.setSource(new ClassResource("/postop.ico"));
		
		Image imageReha = new Image();
		imageReha.setSource(new ClassResource("/reha.ico"));

		setSizeFull();
		setSpacing(true);
		addComponent(homeMenu);
		addComponent(imageLogo);
		addComponent(placeHolder);
		//addComponent(editButton());
		//addComponent(newButton());
		setComponentAlignment(homeMenu, Alignment.TOP_RIGHT);
		setComponentAlignment(imageLogo, Alignment.TOP_RIGHT);
		setComponentAlignment(placeHolder, Alignment.MIDDLE_CENTER);
		homeMenu.setWidth("100%");

	}

	//On Page-entry takes Thread-/Session-Safe Values from Vaadin Session Wrapper (here:userId
	//On page entry re-load Grid with correct Values passed in (only events of this user)
	//Shows a "Welcom" Notification
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("WELCOME");
		id = Integer.valueOf(VaadinService.getCurrentRequest().getWrappedSession().getAttribute("myValue").toString());
		placeHolder.removeAllComponents();
		placeHolder.addComponent(myGrid());
	}
	
	
	//Following: The Menu Commands (which Menu navigates where)
	
	MenuBar.Command myCommandMenuHilfe = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.HOMEHILFE);
	    }
	};
	
	MenuBar.Command myCommandDemo = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.DEMOPFADPHASEN);
	    }
	};
	
	MenuBar.Command myCommandProvider = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.PROVIDER);
	    }
	};
	
	MenuBar.Command myCommandCreateUser = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.CREATEUSER);
	    }
	};
	
	//Menu in Home, with Logo very small
	//All Menu Items (Sub-Menu) with their commands registered 
	MenuBar homeMenu = new MenuBar();
	MenuItem myMenu = homeMenu.addItem("MENU",new ThemeResource("patientpath_logo_icon.ico") , null);
		MenuItem demo = myMenu.addItem("App - Demo", null, myCommandDemo);
		MenuItem provider = myMenu.addItem("Alle Provider", null, myCommandProvider);
		MenuItem meinaccount = myMenu.addItem("Mein Account", null, myCommandCreateUser);
		MenuItem hilfe = myMenu.addItem("Hilfe", null, myCommandMenuHilfe );
	
	//The main Grid showing the Events of the logged in user (or App-Demo-User)
	private Grid<claps.persistence.Event> myGrid() {
		
		//A new EventDAO to load Data from DB
		EventDAO eventDAO = new EventDAO();
		
		//The Grid with set Size and Selection Mode
		Grid<claps.persistence.Event> myGrid = new Grid();
			myGrid.setHeightUndefined();
			myGrid.setWidth("100%");
			myGrid.setSelectionMode(SelectionMode.SINGLE);
			SingleSelect<claps.persistence.Event> selection = myGrid.asSingleSelect();
			
			//The Selection Listener (What to do if selected)
			myGrid.addSelectionListener(event -> {

				//Checks is Row to be selected is selectable (otherwise no selection happens)
				//Workaround for Selection issue in Vaadin (if already selcted Row gets selected
				//the system crashes) - This if statements resolves this issue
				//If selectable -> selects + stores eventId to show in Window (further below)
				//and adds this window (populated by info to this evenInfotId)
				if(selection.getValue() != null && selection.getValue() != null) {
					eventInfoID = selection.getValue().getEventinfoID();
					eventID = selection.getValue().getEventID();
					UI.getCurrent().addWindow(InfoSubWindow());
				}
				
				});
			//Adding the Columns to the Grid and Set the Items in the Grid and
			//define order (here:ascending -> by Datetime; later Date = higher Value)
			//And Rendering Timestamp to Local Date Time for better user readability
			myGrid.addColumn(claps.persistence.Event::getPathObjectID);
			myGrid.addColumn(claps.persistence.Event::getEventName);
			Column <claps.persistence.Event, LocalDateTime> myColumn = myGrid.addColumn(claps.persistence.Event::getSimpleDateTime, new LocalDateTimeRenderer("dd.MM.yyyy 'um' hh:mm"));
			myGrid.setItems(eventDAO.findAllEvent(id));
			myGrid.sort(myColumn, SortDirection.ASCENDING);
		
		return myGrid;
	}
	
	/*
	 * This code determines where to proceed by clicking on the edit button. 

	private Button editButton() {
		Button button = new Button("Gewählten Eintrag" + " Ändern oder Löschen", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
		        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myEventID", eventID);
		        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myInfoID", eventInfoID);
				getUI().getNavigator().navigateTo(MyUI.CREATEEVENT);	
				
			}
		});
		return button;
	}
	
	*/
	
	/*
	 * This code determines where to proceed by clicking on the new button. 

	
	private Button newButton() {
		Button button = new Button("Neuen Eintrag Erstellen", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
	
				getUI().getNavigator().navigateTo(MyUI.CREATEEVENT);	
				
			}
		});
		return button;
	}
		
	/*
	 * In this method, the window that appears by clicking on the path object is defined
	 */
	
	
	//The Window which opens when Clicking on Row
	//Set up as a custom Grid with coordinates
	public Window InfoSubWindow() {
		
		//The new Windo is created and centered on Screen
		Window subWin = new Window();
		subWin.center();
		
		//The CusstomGrid is created and Size is set (Custom grid 2 wide, 8 deep)
		GridLayout myGridLayout = new GridLayout(2,8);
		myGridLayout.setWidth("700px");
		myGridLayout.setHeight("100%");
		
		//Creates placeholder for Content of Window 
		VerticalLayout subContent = new VerticalLayout();
		
		//New Info to be filled from DB and showed in Window
		Info myInfo = new Info();
		
		//New eventDAO to access events stored in DB
		InfoDAO eventDAO = new InfoDAO();
		//MyInfo is the Info of this event, gets called from DB and stored in myInfo
		myInfo = eventDAO.returnInfo(eventInfoID);
		
		//The Image is rendered Client Side, therefore has to be stored in Variable (myImage)
		//And Check is needed to see if there is an Image, otherwise, shows Logo as a Placeholder
		
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
		
		//All Components and their positioning in Grid
		//all get loaded from myInfo and at the end the window is returned
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