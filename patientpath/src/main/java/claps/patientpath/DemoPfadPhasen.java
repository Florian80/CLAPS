package claps.patientpath;


import com.vaadin.navigator.View;
import com.vaadin.server.ClassResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

//The Page App Demo, where user can change Path - Settings of Demo-User
@SuppressWarnings("serial")
public class DemoPfadPhasen extends VerticalLayout implements View {

	//Method containing the simple Fields (images) and adds all Components
	public DemoPfadPhasen() {
		
		Image imageZuHause = new Image();
		imageZuHause.setSource(new ClassResource("/house.ico"));
		imageZuHause.setWidth("20%");
		imageZuHause.setHeight("20%");
		
		Image imageHausarzt = new Image();
		imageHausarzt.setSource(new ClassResource("/hausarzt.ico"));
		imageHausarzt.setWidth("20%");
		imageHausarzt.setHeight("20%");
		
		Image imageSpezialist = new Image();
		imageSpezialist.setSource(new ClassResource("/spzialist.ico"));
		imageSpezialist.setWidth("20%");
		imageSpezialist.setHeight("20%");
		
		Image imageHospital = new Image();
		imageHospital.setSource(new ClassResource("/hospital.ico"));
		imageHospital.setWidth("20%");
		imageHospital.setHeight("20%");
		
		Image imageOp = new Image();
		imageOp.setSource(new ClassResource("/op.ico"));
		imageOp.setWidth("20%");
		imageOp.setHeight("20%");
		
		Image imagePostOp = new Image();
		imagePostOp.setSource(new ClassResource("/postop.ico"));
		imagePostOp.setWidth("20%");
		imagePostOp.setHeight("20%");
		
		Image imageReha = new Image();
		imageReha.setSource(new ClassResource("/reha.ico"));
		imageReha.setWidth("20%");
		imageReha.setHeight("20%");
		
		
		setSizeFull();
		setSpacing(true);
		
		addComponent(titel);
		addComponent(imageZuHause);
		addComponent(buttonPhase1());
		addComponent(imageHausarzt);
		addComponent(buttonPhase2());
		addComponent(imageSpezialist);
		addComponent(buttonPhase3());
		addComponent(imageHospital);
		addComponent(buttonPhase4());
		addComponent(imageOp);
		addComponent(buttonPhase5());
		addComponent(imagePostOp);
		addComponent(buttonPhase6());
		addComponent(imageReha);
		addComponent(buttonPhase7());
		addComponent(imageZuHause);
		addComponent(buttonPhase8());
	

	}
	
	// The Titel Label
	Label titel = new Label("Wählen Sie die Pfad - Phase");
	
	//All following Buttons stand for one Phase in Patient Path (of Demo Patient)
	//Chose Phase and move back to home page, with id set to Demo-User in chosen Path - Phase
	//Value (Demo-User-Id) passing Thread-/Session-Save to Home Page
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
