package	 org.habitatguate.hgerp.seguridad.client.finanzas;


import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;


public class Buscador_Parametro_Inv extends Composite {
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    TablaGWT e = null;
    
    Timer timer2 = new Timer(){
    	  public void run() {
			loginService.ConsultaTodosParam(new AsyncCallback<List<AuxParametro>>() {
        		
        		@Override
        		public void onSuccess(List<AuxParametro> result) {
        			e.ActulizarList(result);      			
        			
        			
        		}
        		
        		@Override
        		public void onFailure(Throwable caught) {
        			System.out.println(caught);
        			
        		}
        	});

    	  }
      };
	public Buscador_Parametro_Inv(){

	final Grid grid = new Grid(2, 1);
	initWidget(grid);
	grid.setWidth("1178px");
	

	
	AbsolutePanel absolutePanel = new AbsolutePanel();
	grid.setWidget(0, 0, absolutePanel);
	absolutePanel.setSize("1130px", "20px");
	absolutePanel.setStyleName("gwt-Label-new");
	
	//----------------------------primera fila---------------------------------
	
	Label label = new Label("Nombre parametro");
	label.setStyleName("label");
	absolutePanel.add(label, 20, 10);
	label.setSize("157px", "13px");
	
	Label label_1 = new Label("Codigo Contable");
	label_1.setStyleName("label");
	absolutePanel.add(label_1, 257, 10);
	label_1.setSize("192px", "13px");
	
	final TextBox textBox = new TextBox();
	textBox.setStyleName("gwt-TextBox2");
	textBox.setMaxLength(100);
	absolutePanel.add(textBox, 20, 29);
	textBox.setSize("227px", "34px");
	
	final TextBox textBox_1 = new TextBox();
	textBox_1.setStyleName("gwt-TextBox2");
	textBox_1.setMaxLength(100);
	absolutePanel.add(textBox_1, 257, 29);
	textBox_1.setSize("227px", "34px");
	
	Label label_2 = new Label("Codigo Uno");
	label_2.setStyleName("label");
	absolutePanel.add(label_2, 494, 10);
	label_2.setSize("157px", "19px");
	
	final TextBox textBox_2 = new TextBox();
	textBox_2.setStylePrimaryName("gwt-TextBox2");
	textBox_2.setStyleName("gwt-TextBox2");
	textBox_2.setMaxLength(100);
	absolutePanel.add(textBox_2, 494, 29);
	textBox_2.setSize("227px", "34px");
	
	final TextBox textBox_3 = new TextBox();
	textBox_3.setStylePrimaryName("gwt-TextBox2");
	textBox_3.setStyleName("gwt-TextBox2");
	textBox_3.setMaxLength(100);
	absolutePanel.add(textBox_3, 731, 29);
	textBox_3.setSize("227px", "34px");
	
	Label label_3 = new Label("Codigo Dos");
	label_3.setStyleName("label");
	absolutePanel.add(label_3, 731, 10);
	label_3.setSize("157px", "13px");
	
	
	
	Image image = new Image("images/ico-lupa.png");
	absolutePanel.add(image, 958, 0);
	image.setSize("103px", "55px");
	
	
	
	Button button = new Button("Send");
	button.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			if (!textBox.getText().equals("")){

			loginService.Insertar(textBox.getText(), Integer.parseInt(textBox_1.getText()), Integer.parseInt(textBox_2.getText()), Integer.parseInt(textBox_3.getText()),
					new AsyncCallback<String[]>(){
				@Override		
                public void onFailure(Throwable caught) 
                {
                    Window.alert("Hubó un error al intentar guardar los datos, intentelo de nuevo"+caught);
                }

				@Override
                public void onSuccess(String[] result)
                {			
                	Window.alert("Datos Almacenados Correctamente");
                	textBox.setText("");
                	textBox_1.setText("");
                	textBox_2.setText("");
                	textBox_3.setText("");
                	timer2.schedule(1500);
                	
                }

         });
			

		}
		
		else{
			Window.alert("Debe completar el formulario");
		}
		}
	});		

	button.setText("Nuevo Parametro");
	button.setStylePrimaryName("gwt-TextBox2");
	button.setStyleName("gwt-TextBox2");
	absolutePanel.add(button, 968, 29);
	button.setSize("157px", "30px");
	
	

	loginService.ConsultaTodosParam(new AsyncCallback<List<AuxParametro>>() {
		
		@Override
		public void onSuccess(List<AuxParametro> result) {

			e = new TablaGWT(result);
			grid.setWidget(1, 0,e);
			e.setSize("1000px", "300px");
	
			
		}
		
		@Override
		public void onFailure(Throwable caught) {
			System.out.println(caught);
			
		}
	});
   
}
		
}
