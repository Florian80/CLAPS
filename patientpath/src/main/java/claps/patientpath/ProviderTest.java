package claps.patientpath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.vaadin.navigator.View;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.components.grid.ItemClickListener;
import com.vaadin.ui.components.grid.SingleSelectionModel;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.SingleSelect;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window;

import claps.persistence.Provider;
import claps.persistence.ProviderDAO;


@SuppressWarnings("serial")
public class ProviderTest extends VerticalLayout implements View {

	//Under construction
	private Label labelHeader = new Label("Provider");
	
	public ProviderTest() {
		
		setSizeFull();
		setSpacing(true);
		addComponent(myGrid());
	    
	  }


	
		private Grid<Provider> myGrid() {
			
			ProviderDAO providerDAO = new ProviderDAO();
			
			Grid<Provider> myGrid = new Grid<Provider>();
			myGrid.setSelectionMode(SelectionMode.SINGLE);
			SingleSelect<Provider> selection = myGrid.asSingleSelect();
			//SingleSelectionModel<Provider> defaultModel = (SingleSelectionModel<Provider>) myGrid.getSelectionModel();
			//SingleSelectionModel<Provider> singleSelect = (SingleSelectionModel<Provider>) myGrid.getSelectionModel();
			myGrid.addColumn(claps.persistence.Provider::getProviderName).setCaption("Name");
			myGrid.setItems(providerDAO.findAllProvider());
			myGrid.addSelectionListener(event -> {
				Notification.show(selection.getValue().getProviderinfoID() + " was selected");

				/**
				Provider provider = new Provider();
			    Set <Provider> selected = event.getAllSelectedItems();
			    Iterator iterator = new selected.Iterator();
			    **/
	
			});
			
			
			myGrid.addColumn(Provider -> "Info",
				      new ButtonRenderer(clickEvent -> {
				          System.out.println("yep");
				          MyUI.getCurrent().addWindow(subWindowModalExample());
				    }));
			
			
			/**
			myGrid.addItemClickListener(new ItemClickListener() {
				
				public void itemClick(ItemClickEvent event) {
					
					if(event.isDoubleClick()) {
						
						Object itemID = event.getItemID();
						
						
					}
				}
				
			});
			**/
			

			/**
			myGrid.addSelectionListener(event -> {
				System.out.println("Hallo: " + event.getValue().toString());
			    Notification.show("Fuck you");
			});
			**/
			
			/**
			myGrid.addSelectionListener(selectionEvent -> {
				
				System.out.println("Go fuck yourself");
	            	
			});
			**/
			
			
			return myGrid;
		}

		private Window subWindowModalExample() {
			
			Window subWindow = new Window("A test window");
			subWindow.setModal(true);
			VerticalLayout subContent = new VerticalLayout();
			Label message = new Label("Hello World");
			Label test = new Label("This is a test");
			subContent.addComponent(message);
			subContent.addComponent(test);
	        subWindow.setContent(subContent);

			return subWindow;
			
			
		}
		
}