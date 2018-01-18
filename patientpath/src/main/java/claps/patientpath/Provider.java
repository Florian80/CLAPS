package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ClassResource;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.SingleSelect;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.MenuBar.MenuItem;

import claps.persistence.Info;
import claps.persistence.InfoDAO;
import claps.persistence.ProviderDAO;


//The Provider Page showing a Grid List with all Providers
@SuppressWarnings("serial")
public class Provider extends VerticalLayout implements View {
	 
	//important Values and placeholder to load Grid on page load
	private int providerID;
	private int providerInfoID;
    private VerticalLayout placeHolder = new VerticalLayout();
    
    //Provider Method to add simple Fields and add all Components
	public Provider() {
    
		Image imageLogo = new Image();
		imageLogo.setSource(new ClassResource("/PatientPath_Logo.png"));
		imageLogo.setHeight("10%");
		imageLogo.setWidth("10%");

		setSizeFull();
		setSpacing(true);
		addComponent(homeMenu);
		addComponent(imageLogo);
		addComponent(placeHolder);
		//addComponent(editButton());
		//addComponent(newButton());
		addComponent(returnButton());
		setComponentAlignment(homeMenu, Alignment.TOP_RIGHT);
		setComponentAlignment(imageLogo, Alignment.TOP_RIGHT);
		setComponentAlignment(placeHolder, Alignment.MIDDLE_CENTER);
		homeMenu.setWidth("100%");
	}	
		
	@Override
	public void enter(ViewChangeEvent event) {
		placeHolder.removeAllComponents();
		placeHolder.addComponent(myGrid());
	}

	//Following: The Menu Commands (which Menu navigates where)
	
	MenuBar.Command myCommandProviderHilfe = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.PROVIDERHILFE);
	    }
	};
	
	MenuBar.Command myCommandHome = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.HOME);
	    }
	};

	
	MenuBar.Command myCommandCreateUser = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.CREATEUSER);
	    }
	};

	
	//Menu in Provider, with Logo very small
	//All Menu Items (Sub-Menu) with their commands registered 
	MenuBar homeMenu = new MenuBar();
	MenuItem myMenu = homeMenu.addItem("MENU",new ThemeResource("patientpath_logo_icon.ico") , null);
		MenuItem hilfe = myMenu.addItem("Hilfe", null, myCommandProviderHilfe );
		MenuItem provider = myMenu.addItem("Home", null, myCommandHome);
		MenuItem meinaccount = myMenu.addItem("Mein Account", null, myCommandCreateUser);
	
	

//The Provider Grid, showing all Provider from DB
	private Grid<claps.persistence.Provider> myGrid() {
				
				//New ProviderDAO to access DB
				ProviderDAO providerDAO = new ProviderDAO();
				//New Grid to b populated, selectionMode set
				Grid<claps.persistence.Provider> myGrid = new Grid();
				myGrid.setHeightUndefined();
				myGrid.setWidth("100%");
				myGrid.setSelectionMode(SelectionMode.SINGLE);
				SingleSelect<claps.persistence.Provider> selection = myGrid.asSingleSelect();
				
				//Set Items in Grid and add Column with Provider Names
				myGrid.setItems(providerDAO.findAllProvider());	
				Column <claps.persistence.Provider, String> myColumn = myGrid.addColumn(claps.persistence.Provider::getProviderName);
					
				myGrid.addSelectionListener(event -> {

					//Checks is Row to be selected is selectable (otherwise no selection happens)
					//Workaround for Selection issue in Vaadin (if already selcted Row gets selected
					//the system crashes) - This if statements resolves this issue
					//If selectable -> selects + stores eventId to show in Window (further below)
					//and adds this window (populated by info to this providerInfotId)
					if(selection.getValue() != null && selection.getValue() != null) {
						providerInfoID = selection.getValue().getProviderinfoID();
						providerID = selection.getValue().getProviderID();
						UI.getCurrent().addWindow(InfoSubWindow());
					}
						
				});
				return myGrid;
			}
	
	
	/*
	 * This code determines where to proceed by clicking on the edit button. 

	
	private Button editButton() {
		Button button = new Button("Gewählten Eintrag" + "Ändern oder Löschen", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
		        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myProviderID", providerID);
		        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myInfoID", providerInfoID);
				getUI().getNavigator().navigateTo(MyUI.CREATEPROVIDER);	
				
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
	
				getUI().getNavigator().navigateTo(MyUI.CREATEPROVIDER);	
				
			}
		});
		return button;
	}
	
	 */
	
	
	//Navigation Button to return to Home - Page
	private Button returnButton() {
		Button button = new Button("Zurück", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
	
				getUI().getNavigator().navigateTo(MyUI.HOME);	
				
			}
		});
		return button;
}
	
	//The Window which opens when Clicking on Row
	//Set up as a custom Grid with coordinates
	public Window InfoSubWindow() {
		
		//Creates the new Window and centers it.
		Window subWin = new Window();
		subWin.center();
		
		//Creates Custom Grid Layout (2 wide 8 deep)
		GridLayout myGridLayout = new GridLayout(2,8);
		myGridLayout.setWidth("700px");
		myGridLayout.setHeight("100%");
		
		//New Vertical Layout Placeholder for SubContent
		VerticalLayout subContent = new VerticalLayout();
		
		//New Info to be filled with info content
		Info myInfo = new Info();
		//New InfoDAO to access DB (populated with selected providerInfoID from Grid)
		InfoDAO infoDAO = new InfoDAO();
		myInfo = infoDAO.returnInfo(providerInfoID);
		
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
