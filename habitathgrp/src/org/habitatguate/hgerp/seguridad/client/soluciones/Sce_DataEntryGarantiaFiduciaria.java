package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudCargaFamiliar;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaFiduciaria;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudReferenciaFamiliar;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;
import org.habitatguate.hgerp.seguridad.client.rrhh.FormularioFamilia;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;


public class Sce_DataEntryGarantiaFiduciaria extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryGarantiaSolicitud formularioSolicitud;
    private VerticalPanel panel = new VerticalPanel();

    private Mensaje mensaje; 
    private FlexTable flextable;

    // Valor Escritura-Lectura
    private boolean valor;
	 
	public Sce_DataEntryGarantiaFiduciaria(Sce_DataEntryGarantiaSolicitud formulario, boolean valor) {
		
		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		mensaje = new Mensaje();
		this.formularioSolicitud = formulario;
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        initWidget(panel);
        panel.setSize("761px", "79px");
        flextable = new FlexTable();
        panel.add(flextable);
		
        // Boton Agregar nuevo Formulario de Garantia Fiduciaria
        
        Button btnAgregar = new Button("Agregar");
		
        if(this.valor) {
			btnAgregar.setVisible(true);
		}else{
			btnAgregar.setVisible(false);
		}
        
        panel.add(btnAgregar);
        
        btnAgregar.setStyleName("sendButton");
        btnAgregar.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
        		agregarFormulario();
        	}
        });
        
        btnAgregar.setSize("227px", "34px");

	}

    private void agregarFormulario(){
        flextable.setWidget(flextable.getRowCount(), 0, new Sce_DataGarantiaFiduciaria(this, formularioSolicitud, this.valor));
    }
    
    public void EliminarFormulario(final Sce_DataGarantiaFiduciaria fa, final Long idFormulario, final Long id){

    	solucionesService.eliminarGarantiaFiduciaria(idFormulario, id, new AsyncCallback<Long>(){
            public void onFailure(Throwable caught) 
            {
            	mensaje.setMensaje("alert alert-error", 
            			"Error !! \nal Eliminar");
            }

			@Override
            public void onSuccess(Long result)
            {
				mensaje.setMensaje("alert alert-success", 
            			"Eliminado\n exitosamente!!!");
    	        flextable.remove(fa);
            }

     });
		
    }
    
    public void EliminarFormulario(Sce_DataGarantiaFiduciaria fa){
    	        flextable.remove(fa);
    }
    
    
    public void setDataGarantiaFiduciaria(List<AuxSolicitudGarantiaFiduciaria> results){

    	//load.visible();
    	if (!results.isEmpty()) {

    		for ( AuxSolicitudGarantiaFiduciaria n2 : results) {

    			System.out.println("ID Garantia Fiduciaria a Cargar: " + n2.getIdGarantiaFiduciaria() + ", ID Formulario: " + n2.getIdFormulario());
    			
    			Sce_DataGarantiaFiduciaria fa = new  Sce_DataGarantiaFiduciaria(this, formularioSolicitud, this.valor);
    			
    			fa.LlenarDatos(n2.getIdGarantiaFiduciaria(), 
    					n2.getNombre(), n2.getEstadoCivil(), n2.getEdad(), n2.getNacionalidad(),
    					n2.getActividadEconomica(),
    					n2.getCheckLeer(), n2.getCheckEscribir(), n2.getCheckFirmar(),
    					n2.getDireccionActual(), n2.getLugarTrabajo(),
    					n2.getTelefonoCasa(), n2.getTelefonoTrabajo());
    			
    			flextable.setWidget(flextable.getRowCount(), 0, fa );
    		
    		}


    		//load.invisible();

    	}
    }
    
    
}
