package claps.patientpath;

import java.time.LocalDateTime;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.SingleSelect;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.renderers.LocalDateTimeRenderer;

import claps.persistence.ProviderDAO;
import claps.patientpath.MyUI;

@SuppressWarnings("serial")
public class Provider extends VerticalLayout implements View {
	
	private int id;
    private VerticalLayout placeHolder = new VerticalLayout();

	public Provider() {
		setSizeFull();
		setSpacing(true);
		addComponent(homeMenu);
		addComponent(placeHolder);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("WELCOME");
		id = Integer.valueOf(VaadinService.getCurrentRequest().getWrappedSession().getAttribute("myValue").toString());
		placeHolder.removeAllComponents();
		placeHolder.addComponent(myGrid());
	}
	
	
	MenuBar.Command myCommandHome = new MenuBar.Command() {
	    public void menuSelected(MenuItem selectedItem) {
	        getUI().getNavigator().navigateTo(MyUI.HOME);
	    }
	};
	
	//Menu in Provider
	MenuBar homeMenu = new MenuBar();
		MenuItem myMenu = homeMenu.addItem("Menu", null, null);
			MenuItem hilfe = myMenu.addItem("Hilfe", null, null);
			MenuItem home = myMenu.addItem("Home", null, myCommandHome);
	

	private Grid<claps.persistence.Provider> myGrid() {
				
				ProviderDAO providerDAO = new ProviderDAO();
				
				Grid<claps.persistence.Provider> myGrid = new Grid();
				
					myGrid.setSelectionMode(SelectionMode.SINGLE);
					SingleSelect<claps.persistence.Provider> selection = myGrid.asSingleSelect();
					
					Column <claps.persistence.Provider, String> myColumn = myGrid.addColumn(claps.persistence.Provider::getProviderName);
					
					myGrid.addSelectionListener(event -> {
						
						selection.getValue().getProviderinfoID();
						
						//addWindow(InfoSubWindow());
						UI.getCurrent().addWindow(InfoSubWindow());
						
						
						System.out.println(selection.getValue().getProviderinfoID());
						

					});
					
					myGrid.sort(myColumn, SortDirection.DESCENDING);
					
					myGrid.setItems(providerDAO.findAllProvider());
					
					
				
				return myGrid;
			}
	
	public Window InfoSubWindow() {
		
		Window subWin = new Window();
		
		GridLayout myGridLayout = new GridLayout(2,8);
		
		VerticalLayout subContent = new VerticalLayout();
        subWin.setContent(subContent);
		subContent.addComponent(myGridLayout);
		
		myGridLayout.addComponent(new Label("Titel"), 0, 0, 1, 0);
		
		myGridLayout.addComponent(new Label("Picture"), 0, 1, 0, 4);
		
		myGridLayout.addComponent(new Label("Adr 1"), 1, 1, 1, 1);
		
		myGridLayout.addComponent(new Label("Adr 2"), 1, 2, 1, 2);
		
		myGridLayout.addComponent(new Label("Adr 3"), 1, 3, 1, 3);
		
		myGridLayout.addComponent(new Label("Adr 4"), 1, 4, 1, 4);
		
		myGridLayout.addComponent(new Label("Web"), 0, 5, 0, 5);
		
		myGridLayout.addComponent(new Label("Mail"), 0, 6, 0, 6);
		
		myGridLayout.addComponent(new Label("Tel"), 1, 5, 1, 5);
		
		myGridLayout.addComponent(new Label("Fax"), 1, 6, 1, 6);
		
		myGridLayout.addComponent(new Label("Text"), 0, 7, 1, 7);
		
		return subWin;
	}
	
}
