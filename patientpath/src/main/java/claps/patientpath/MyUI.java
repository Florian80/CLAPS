package claps.patientpath;

import javax.servlet.annotation.WebServlet;

import claps.patientpath.Login;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 * 
 * THIS PAGE FOLLOWS STRICT VAADIN DESIGN PATTERNS FOR FURTHER INFO: vaadin.com
 * 
 */

@Theme("mytheme")
public class MyUI extends UI {
	
	
	//Navigator - our method to navigate in the App
	public Navigator navigator;
	
	//All Enum - Variables for the Navigation
	public static final String LOGIN = "login";
	public static final String LOGINHILFE ="LoginHilfe";
	public static final String HOME = "home";
	public static final String HOMEHILFE = "homeHilfe";
	public static final String PROVIDER ="provider";
	public static final String PROVIDERHILFE = "providerHilfe";
	public static final String CREATEUSER = "createUser";
	public static final String CREATEEVENT = "createEvent";
	public static final String CREATEPROVIDER = "createProvider";
	public static final String DEMOPFADPHASEN = "demoPfadPhasen";
	
	
//The init - Method is the central Method, registering all possible
//states of Navigation (Pages the user may go to)
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	

//Please change with caution! Follow Design Pattern!
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(layout);
		navigator = new Navigator(UI.getCurrent(), viewDisplay);
		navigator.addView("", new Login());
		navigator.addView(LOGINHILFE, new LoginHilfe());
		navigator.addView(HOME, new Home());
		navigator.addView(HOMEHILFE, new HomeHilfe());
		navigator.addView(PROVIDER,new Provider());
		navigator.addView(PROVIDERHILFE,new ProviderHilfe());
		navigator.addView(CREATEUSER, new CreateUser());
		navigator.addView(CREATEEVENT, new CreateEvent());
		navigator.addView(CREATEPROVIDER, new CreateProvider());
		navigator.addView(DEMOPFADPHASEN, new DemoPfadPhasen());
    }

//The Servlet is empty and gets populated by the App if started or deployed 
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
