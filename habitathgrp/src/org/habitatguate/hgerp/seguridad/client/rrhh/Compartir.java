package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;

public class Compartir extends Composite{
        
        
       private Loading load;
       private Long idTest = 0L;
   	   private Mensaje mensaje; 
       private SuggestBox txtUser;
       private Button btnAceptar;
       private AbsolutePanel rootPanel;
       private Long idEmpleadoCompartido = 0L;
       private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
   		
        public Compartir(Long idTes, Long isEmpleadoCompartid) 
        {
        	load = new Loading();
            load.Mostrar();
            load.invisible();
            
			mensaje = new Mensaje();
        	this.idEmpleadoCompartido = isEmpleadoCompartid;
        	this.idTest = idTes;
        	
        	rootPanel = new AbsolutePanel();
        	rootPanel.setSize("299px", "199px");
            rootPanel.setStyleName("body");
            
            Label lblNewLabel_1 = new Label("");
            lblNewLabel_1.setStyleName("gwt-Label-new");
            rootPanel.add(lblNewLabel_1, 10, 5);
            lblNewLabel_1.setSize("205px", "142px");
            
            txtUser =new SuggestBox(createCountriesOracle());
            txtUser.setStyleName("gwt-PasswordTextBox");
            txtUser.getElement().setAttribute("placeHolder", "Ingrese correo");
            rootPanel.add(txtUser, 30, 86);
            txtUser.setSize("241px", "49px");
            
            btnAceptar = new Button("Send");
            btnAceptar.addClickHandler(new ClickHandler() {
            	public void onClick(ClickEvent event) {

                    load.visible();
            		 recursosHumanosService.InsertarCompartido(txtUser.getText(),idTest,idEmpleadoCompartido,new AsyncCallback<String>()
					    {
				            public void onFailure(Throwable caught) 
				            {
						        load.invisible();
				            	mensaje.setMensaje("alert alert-error", 
			                			"Error !! \nal Compartir Evaluacion");
				            }
	
							public void onSuccess(String result)
				            {
						        load.invisible();
								mensaje.setMensaje("alert alert-success", result);
				            }
	
					    });

                     load.invisible();
            	}
            });
            btnAceptar.setText("Aceptar");
            btnAceptar.setStyleName("sendButton");
            rootPanel.add(btnAceptar, 30, 143);
            btnAceptar.setSize("243px", "44px");
            
            initWidget(rootPanel);
            
            Label lblNewLabel = new Label("Escribe el correo del Empleado, con quien quieres compartir el test:");
            rootPanel.add(lblNewLabel, 30, 10);
            lblNewLabel.setSize("243px", "19px");
            

        }
        

	MultiWordSuggestOracle createCountriesOracle()
	{
	    final MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
	    
	    recursosHumanosService.getCorreos(new AsyncCallback<List<String>>()
	    {
            public void onFailure(Throwable caught) 
            {
            }

			public void onSuccess(List<String> ListCorreos)
            {
				if(!ListCorreos.isEmpty())
				{	
					for(String correo: ListCorreos){
						oracle.add(correo);
					}
				}
            }

	    });
	    return oracle;
    }
       
}