package claps.patientpath;

import claps.persistence.PathConnect;

import java.awt.MenuItem;

import com.vaadin.navigator.View;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class VersionTwo extends VerticalLayout implements View {
	
	HorizontalLayout sample;
	
	public VersionTwo() {
		setSizeFull();
		setSpacing(true);
		
		//Horizontal
        sample = new HorizontalLayout();
        sample.addStyleName("outlined");
        sample.setSpacing(false);
        sample.setMargin(false);
        sample.setSizeFull();
 
        Label label1 = new Label("Logo1");
        Label label2 = new Label("Logo2");
		
        sample.addComponent(label1);
        sample.addComponent(label2);
		
		//Under construction
		Label labelHeader = new Label("Stammdaten");
		Label labelHeader2 = new Label("Stammdaten");
			
			addComponent(labelHeader);
			addComponent(labelHeader2);
			addComponent(sample);
	}	
}



/*
package claps.patientpath;

import claps.persistence.PathConnect;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class VersionTwo extends VerticalLayout implements View {
	
	public VersionTwo() {
		setSizeFull();
		setSpacing(true);
		addComponent(labelHeader);
	}
	
	
	//Under construction
	private Label labelHeader = new Label("Version 2");
}*/



