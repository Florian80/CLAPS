package claps.patientpath;

import javax.servlet.annotation.WebServlet;

import claps.patientpath.Home;
import claps.patientpath.Login;
import claps.patientpath.Kalender;
import claps.patientpath.VersionTwo;
import claps.persistence.User;

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
 */
@Theme("mytheme")
public class MyUI extends UI {
	
	public Navigator navigator;
	
	public static final String LOGIN = "login";
	public static final String HOME = "home";
	public static final String KALENDER = "kalender";
	public static final String VERSIONTWO = "versionTwo";
	public static final String VERSIONTHREE = "versionThree";
	public static final String PROVIDERTEST = "providerTest";
	public static final String BROWSERCHECKTEST = "providerCheckTest";
	public static final String INFOHAUSARZT = "InfoHausarzt";
	public static final String WINDOWHILFE ="WindowHilfe";
	

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        //Please change with caution
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setMargin(true);
        setContent(layout);
        ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(layout);
		navigator = new Navigator(UI.getCurrent(), viewDisplay);
		navigator.addView("", new Login());
		navigator.addView(HOME, new Home());
		navigator.addView(KALENDER, new Kalender());
		navigator.addView(VERSIONTWO, new VersionTwo());
		navigator.addView(VERSIONTHREE, new VersionThree());
		navigator.addView(PROVIDERTEST,  new ProviderTest());
		navigator.addView(BROWSERCHECKTEST, new BrowserCheckTest());
		navigator.addView(INFOHAUSARZT, new InfoHausarzt());
		navigator.addView(WINDOWHILFE,new WindowHilfe());
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
