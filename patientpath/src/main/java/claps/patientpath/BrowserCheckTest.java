package claps.patientpath;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.Page.BrowserWindowResizeEvent;
import com.vaadin.server.WebBrowser;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings("serial")
public class BrowserCheckTest extends VerticalLayout implements View {
	
	/**
	Page page = BrowserCheckTest.getPage();
	page.addBrowserWindowResizeListener(new BrowserWindowResizeListener() {
	  public void browserWindowResized(BrowserWindowResizeEvent event) {
	    Notification.show("Window width=" + event.getWidth() + ", height=" + event.getHeight());
	  }
	});
	
	public WebBrowser browser = new WebBrowser();
	
	private Label labelHeader = new Label("IP: " + browser.getAddress() +
            "User-Agent: " + browser.getBrowserApplication() +
            "Linux: " + browser.isLinux());
	**/
	
	public BrowserCheckTest() {
	    
		setSizeFull();
		setSpacing(true);
		//addComponent(labelHeader);
	    
	  }
	//A test thing
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("IP" + Page.getCurrent().getWebBrowser());
	}
	
}


