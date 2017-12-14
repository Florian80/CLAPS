package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
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
			
			Grid<Provider> myGrid = new Grid();
			myGrid.setSelectionMode(SelectionMode.NONE);
			myGrid.addColumn(claps.persistence.Provider::getProviderName).setCaption("Name");
			myGrid.addColumn(Provider -> "Info",
				      new ButtonRenderer(clickEvent -> {
				          System.out.println("yep");
				          MyUI.getCurrent().addWindow(subWindowModalExample());
				    }));
			myGrid.setItems(providerDAO.findAllProvider());

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