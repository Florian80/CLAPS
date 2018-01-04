package claps.patientpath;

import java.time.LocalDateTime;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Grid;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.SingleSelect;
import com.vaadin.ui.VerticalLayout;
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
						System.out.println(selection.getValue().getProviderinfoID());
						
						myGrid.sort(myColumn, SortDirection.DESCENDING);
						
						
					});
					
					myGrid.setItems(providerDAO.findAllProvider());
					
					
				
				return myGrid;
			}

	
}
