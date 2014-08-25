package org.habitatguate.hgerp.seguridad.client.rrhh;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ListBox;

public class BuscadorEmpleados extends Composite  {

    private  Grid grid;
    private BuscadorEmpleados a;
    private ListBox listBox;
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	public BuscadorEmpleados() {
		this.a = this;
		grid = new Grid(2, 1);
		initWidget(grid);
		grid.setWidth("1178px");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("1130px", "60px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		final TextBox txtPrimerApellido = new TextBox();
		txtPrimerApellido.setStyleName("gwt-TextBox2");
		txtPrimerApellido.setMaxLength(100);
		absolutePanel.add(txtPrimerApellido, 10, 29);
		txtPrimerApellido.setSize("137px", "11px");
		
		final TextBox txtPrimerNombre = new TextBox();
		txtPrimerNombre.setStylePrimaryName("gwt-TextBox2");
		txtPrimerNombre.setStyleName("gwt-TextBox2");
		txtPrimerNombre.setMaxLength(100);
		absolutePanel.add(txtPrimerNombre, 337, 29);
		txtPrimerNombre.setSize("137px", "11px");
		
		final TextBox txtSegundoNombre = new TextBox();
		txtSegundoNombre.setStylePrimaryName("gwt-TextBox2");
		txtSegundoNombre.setStyleName("gwt-TextBox2");
		txtSegundoNombre.setMaxLength(100);
		absolutePanel.add(txtSegundoNombre, 500, 29);
		txtSegundoNombre.setSize("137px", "11px");
		
			final TextBox txtDPI = new TextBox();
			txtDPI.setStyleName("gwt-TextBox2");
			txtDPI.setMaxLength(100);
			absolutePanel.add(txtDPI, 668, 29);
			txtDPI.setSize("137px", "11px");
		
		final TextBox txtPasaporte = new TextBox();
		txtPasaporte.setStyleName("gwt-TextBox2");
		txtPasaporte.setMaxLength(100);
		absolutePanel.add(txtPasaporte, 837, 29);
		txtPasaporte.setSize("137px", "11px");
		
		final ListBox listEstado = new ListBox();
		listEstado.addItem("empleado activo");
		listEstado.addItem("empleado inactivo");
		listEstado.addItem("posible empleado");
		listEstado.setStyleName("gwt-TextBox2");
		absolutePanel.add(listEstado, 10, 73);
		listEstado.setSize("157px", "20px");
		
		listBox = new ListBox();
		listBox.addItem("DPI");
		listBox.addItem("Pasaporte");
		listBox.addItem("Nombres");
		listBox.addItem("Todos");
		listBox.addItem("Estado");
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 173, 70);
		listBox.setSize("157px", "20px");
		
		final TextBox txtSegundoApellido = new TextBox();
		txtSegundoApellido.setStyleName("gwt-TextBox2");
		txtSegundoApellido.setMaxLength(100);
		absolutePanel.add(txtSegundoApellido, 173, 29);
		txtSegundoApellido.setSize("137px", "11px");
		
		Label label = new Label("Primer Apellido");
		label.setStyleName("label");
		absolutePanel.add(label, 10, 10);
		label.setSize("157px", "13px");
		
		Label label_1 = new Label("Segundo Apellido");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 173, 10);
		label_1.setSize("192px", "13px");
		
		Label label_2 = new Label("Primer Nombre");
		label_2.setStyleName("label");
		absolutePanel.add(label_2, 337, 10);
		label_2.setSize("157px", "19px");
		
		Label label_3 = new Label("2do y Demás Nombres");
		label_3.setStyleName("label");
		absolutePanel.add(label_3, 500, 10);
		label_3.setSize("157px", "13px");
		
		Label dpi = new Label("DPI");
		dpi.setStyleName("label");
		absolutePanel.add(dpi, 668, 10);
		dpi.setSize("157px", "13px");
		
		Label NoPasaporte = new Label("No Pasaporte");
		NoPasaporte.setStyleName("label");
		absolutePanel.add(NoPasaporte, 837, 10);
		NoPasaporte.setSize("157px", "13px");
		
		Label lblBusquedaPor = new Label("Busqueda por: ");
		lblBusquedaPor.setStyleName("label");
		absolutePanel.add(lblBusquedaPor, 173, 51);
		lblBusquedaPor.setSize("118px", "13px");
		
		SimplePanel simplePanel = new SimplePanel();
		grid.setWidget(1, 0, simplePanel);
		simplePanel.setSize("1184px", "716px");
		
		Image image = new Image("images/ico-lupa.png");
		image.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				grid.clearCell(1, 0);
				EmpleadoLista  nuevo = new EmpleadoLista();

				if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
				{
					nuevo.agregarFormulario('2',a,txtPrimerNombre.getText(), txtSegundoNombre.getText(), 
							txtPrimerApellido.getText(), txtSegundoApellido.getText(),txtDPI.getText(),txtPasaporte.getText()
							,listEstado.getItemText(listEstado.getSelectedIndex()));
					grid.setWidget(1, 0,nuevo);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
				{
					nuevo.agregarFormulario('1',a,txtPrimerNombre.getText(), txtSegundoNombre.getText(), 
						txtPrimerApellido.getText(), txtSegundoApellido.getText(),txtDPI.getText(),txtPasaporte.getText(),
						listEstado.getItemText(listEstado.getSelectedIndex()));
					grid.setWidget(1, 0,nuevo);
					nuevo.setSize("1187px", "648px");
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Pasaporte"))
				{
					nuevo.agregarFormulario('3',a,txtPrimerNombre.getText(), txtSegundoNombre.getText(), 
						txtPrimerApellido.getText(), txtSegundoApellido.getText(),txtDPI.getText(),txtPasaporte.getText()
						,listEstado.getItemText(listEstado.getSelectedIndex()));
					grid.setWidget(1, 0,nuevo);
					nuevo.setSize("1187px", "648px");
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("DPI"))
				{
					nuevo.agregarFormulario('4',a,txtPrimerNombre.getText(), txtSegundoNombre.getText(), 
						txtPrimerApellido.getText(), txtSegundoApellido.getText(),txtDPI.getText(),txtPasaporte.getText()
						,listEstado.getItemText(listEstado.getSelectedIndex()));
					grid.setWidget(1, 0,nuevo);
					nuevo.setSize("1187px", "648px");
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Estado"))
				{
					nuevo.agregarFormulario('5',a,txtPrimerNombre.getText(), txtSegundoNombre.getText(), 
						txtPrimerApellido.getText(), txtSegundoApellido.getText(),txtDPI.getText(),txtPasaporte.getText()
						,listEstado.getItemText(listEstado.getSelectedIndex()));
					grid.setWidget(1, 0,nuevo);
					nuevo.setSize("1187px", "648px");
				}
			}
		});

		absolutePanel.add(image, 347, 45);
		image.setSize("103px", "55px");
		
		Label lblEstadoEmpleado = new Label("Estado Empleado");
		lblEstadoEmpleado.setStyleName("label");
		absolutePanel.add(lblEstadoEmpleado, 10, 54);
		lblEstadoEmpleado.setSize("118px", "13px");
		
	}
	
	public void Empleado_registrado(final Long id_empleado){

		grid.clearCell(1, 0);
		final Empleados e = new Empleados(0);
		e.NuevasPestanas();
		grid.setWidget(1, 0,e);
        e.setSize("1187px", "648px");
        loginService.Empleado_Registrado(id_empleado,new AsyncCallback<AuxEmpleado>(){
        	
        	public void onFailure(Throwable caught) 
        	{
        		Window.alert("No hay resultados "+caught);
        	}

        	@Override
        	public void onSuccess(AuxEmpleado result)
        	{

        		try{
        			
        			e.setFD(result);
        			
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setA(result.getHistorial_academico());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setF(result.getFamilia());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setH(result.getHistorial());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setI(result.getIdiomas());
        		}catch(Exception e){

        		}
        		try{
        			e.setP(result.getPuestos());
        		}catch(Exception e){

        		}
        		try{
        			e.setRL(result.getReferencia_laboral());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setRP(result.getReferencia_personal());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setV(result.getVacaciones());
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setFE(result.getEntrevista().get(0));
        		}catch(Exception e){
        			
        		}
        		try{
        			e.setFPP(result.getTest());
        		}catch(Exception e){
        			
        		}
        		
        	}

        });
	}
	
}
