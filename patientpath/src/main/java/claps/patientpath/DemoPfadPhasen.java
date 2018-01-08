package claps.patientpath;


import com.vaadin.navigator.View;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;


@SuppressWarnings("serial")
public class DemoPfadPhasen extends VerticalLayout implements View {

	public DemoPfadPhasen() {
		
		setSizeFull();
		setSpacing(true);
		addComponent(titel);
		addComponent(buttonPhase1());
		addComponent(buttonPhase2());
		addComponent(buttonPhase3());
		addComponent(buttonPhase4());
		addComponent(buttonPhase5());
		addComponent(buttonPhase6());
		addComponent(buttonPhase7());
		addComponent(buttonPhase8());
	

	}
	
	Label titel = new Label("Wählen Sie die Pfad - Phase");
	
	Button buttonPhase1() {
		Button buttonPhase1 = new Button ("Zuhause (Start) 1",  new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
		        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", 3);
				getUI().getNavigator().navigateTo(MyUI.HOME);	
				
			}
			
		});
				
		return buttonPhase1;
	};
	
	Button buttonPhase2() {
		Button buttonPhase2 = new Button ("Hausarzt 2",  new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
		        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", 4);
				getUI().getNavigator().navigateTo(MyUI.HOME);	
				
			}
			
		});
				
		return buttonPhase2;
	};
	
	Button buttonPhase3() {
		Button buttonPhase3 = new Button ("Facharzt 3",  new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
		        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", 5);
				getUI().getNavigator().navigateTo(MyUI.HOME);	
				
			}
			
		});
				
		return buttonPhase3;
	};
	
	Button buttonPhase4() {
		Button buttonPhase4 = new Button ("Prä-OP 4",  new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
		        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", 6);
				getUI().getNavigator().navigateTo(MyUI.HOME);	
				
			}
			
		});
				
		return buttonPhase4;
	};
	
	Button buttonPhase5() {
		Button buttonPhase5 = new Button ("OP 5",  new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
		        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", 7);
				getUI().getNavigator().navigateTo(MyUI.HOME);	
				
			}
			
		});
				
		return buttonPhase5;
	};
	
	Button buttonPhase6() {
		Button buttonPhase6 = new Button ("Post-OP 6",  new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
		        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", 8);
				getUI().getNavigator().navigateTo(MyUI.HOME);	
				
			}
			
		});
				
		return buttonPhase6;
	};
	
	Button buttonPhase7() {
		Button buttonPhase7 = new Button ("Reha 7",  new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
		        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", 9);
				getUI().getNavigator().navigateTo(MyUI.HOME);	
				
			}
			
		});
				
		return buttonPhase7;
	};
	
	Button buttonPhase8() {
		Button buttonPhase8 = new Button ("Zuhause (Ende) 8",  new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
		        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("myValue", 10);
				getUI().getNavigator().navigateTo(MyUI.HOME);	
				
			}
			
		});
				
		return buttonPhase8;
	};
}
