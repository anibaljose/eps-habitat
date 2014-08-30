package org.habitatguate.hgerp.seguridad.client.rrhh;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;


public class formularioFamilia  extends Composite  {

	private familiares a;
	private Empleados empleado;
	private Long id_familia = 0L;
	private boolean bandera = true;
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	
	private TextBox txtPrimer_apellido ;
	private TextBox txtSegundo_apellidp;
	private TextBox txtPrimer_nombre;
	private TextBox txtSegundo_nombre;
	private TextBox txtOcupacion;
	private TextBox txtParentesco;
	private TextBox txtEdad ;
	
	public formularioFamilia(String pariente, familiares a,Empleados e) {

		this.empleado = e;
		this.a = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("1263px", "100px");
		
		txtPrimer_apellido = new TextBox();
		txtPrimer_apellido.setMaxLength(100);
		txtPrimer_apellido.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPrimer_apellido, 10, 29);
		txtPrimer_apellido.setSize("227px", "34px");
		
		txtSegundo_apellidp = new TextBox();
		txtSegundo_apellidp.setMaxLength(100);
		txtSegundo_apellidp.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtSegundo_apellidp, 267, 29);
		txtSegundo_apellidp.setSize("227px", "34px");
		
		txtParentesco = new TextBox();
		txtParentesco.setStylePrimaryName("gwt-TextBox2");
		txtParentesco.setStyleName("gwt-TextBox2");
		txtParentesco.setEnabled(false);
		absolutePanel.add(txtParentesco, 516, 29);
		txtParentesco.setSize("227px", "34px");
		txtParentesco.setText(pariente);
		
		txtPrimer_nombre = new TextBox();
		txtPrimer_nombre.setMaxLength(100);
		txtPrimer_nombre.setStylePrimaryName("gwt-TextBox2");
		txtPrimer_nombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPrimer_nombre, 10, 99);
		txtPrimer_nombre.setSize("227px", "34px");
		
		txtSegundo_nombre = new TextBox();
		txtSegundo_nombre.setMaxLength(100);
		txtSegundo_nombre.setStylePrimaryName("gwt-TextBox2");
		txtSegundo_nombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtSegundo_nombre, 267, 99);
		txtSegundo_nombre.setSize("227px", "34px");
		
		txtOcupacion = new TextBox();
		txtOcupacion.setMaxLength(100);
		txtOcupacion.setStylePrimaryName("gwt-TextBox2");
		txtOcupacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtOcupacion, 515, 99);
		txtOcupacion.setSize("227px", "34px");
		
				txtEdad = new TextBox();
				txtEdad.addChangeHandler(new ChangeHandler() {
					public void onChange(ChangeEvent event) {
						if(txtEdad.getText().equals("")) {txtEdad.setText("0");}
						else if(txtEdad.getText().equals(null)) {txtEdad.setText("0");}
						else{
							try{
								Integer.parseInt(txtEdad.getText());
							}catch(Exception e){
								Window.alert("Edad no valido");
								txtEdad.setText("0");
							}
						}

						
					}
				});
				txtEdad.setText("0");
				txtEdad.setStylePrimaryName("gwt-TextBox2");
				txtEdad.setStyleName("gwt-TextBox2");
				txtEdad.setMaxLength(100);
				absolutePanel.add(txtEdad, 761, 99);
				txtEdad.setSize("68px", "34px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(bandera) {
					System.out.println(empleado.id_empleado);
					loginService.Insertar_Familiar(empleado.id_empleado, txtPrimer_nombre.getText(), 
							txtSegundo_nombre.getText(), txtPrimer_apellido.getText(),txtSegundo_apellidp.getText(), 
							Integer.parseInt(txtEdad.getValue()), txtOcupacion.getText(), txtParentesco.getText(), 
							new AsyncCallback<Long>(){
	                            public void onFailure(Throwable caught) 
	                            {
	                                Window.alert("Error  al Guardar Datos"+caught);
	                            }

								@Override
	                            public void onSuccess(Long result)
	                            {
									id_familia = result;
									bandera = false;
	                            	Window.alert("Datos Guardados exitosamente!!! ");
	                            }

	                     });
				}else{
					loginService.Actualizar_Familiar(empleado.id_empleado,id_familia, txtPrimer_nombre.getText(), 
							txtSegundo_nombre.getText(), txtPrimer_apellido.getText(),txtSegundo_apellidp.getText(), 
							Integer.parseInt(txtEdad.getValue()), txtOcupacion.getText(), txtParentesco.getText(), 
							new AsyncCallback<Long>(){
	                            public void onFailure(Throwable caught) 
	                            {
	                                Window.alert("Error  al Actualizar Datos"+caught);
	                            }

								@Override
	                            public void onSuccess(Long result)
	                            {
									bandera = false;
	                            	Window.alert("Datos Actualizados exitosamente!!! ");
	                            }

	                     });
				}
					
			}
		});
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("sendButton");
		absolutePanel.add(btnActualizar, 855, 22);
		btnActualizar.setSize("227px", "34px");
		
		
		
		Button btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(bandera){
					EliminarFormularioSinDatos();
				}else{
					if(Window.confirm("Esta Seguro de Eliminar el formulario"))
						EliminarFormulario();
				}
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("gwt-TextBox2");
		btnEliminar.setStyleName("sendButton");
		absolutePanel.add(btnEliminar, 855, 101);
		btnEliminar.setSize("227px", "34px");
		
		Label label_3 = new Label("Primer Apellido");
		label_3.setStyleName("label");
		absolutePanel.add(label_3, 10, 10);
		label_3.setSize("157px", "13px");
		
		Label label_4 = new Label("Segundo Apellido");
		label_4.setStyleName("label");
		absolutePanel.add(label_4, 267, 10);
		label_4.setSize("192px", "13px");
		
		Label label_6 = new Label("Primer Nombre");
		label_6.setStyleName("label");
		absolutePanel.add(label_6, 10, 80);
		label_6.setSize("157px", "19px");
		
		Label label_7 = new Label("2do y Demás Nombres");
		label_7.setStyleName("label");
		absolutePanel.add(label_7, 267, 80);
		label_7.setSize("219px", "13px");
		
		Label lblParentesco = new Label("Parentesco");
		lblParentesco.setStyleName("label");
		absolutePanel.add(lblParentesco, 517, 10);
		lblParentesco.setSize("192px", "13px");
		
		Label lblOcupacion = new Label("Ocupacion ");
		lblOcupacion.setStyleName("label");
		absolutePanel.add(lblOcupacion, 515, 80);
		lblOcupacion.setSize("163px", "13px");
		
		Label lblEdad = new Label("Edad");
		lblEdad.setStyleName("label");
		absolutePanel.add(lblEdad, 763, 71);
		lblEdad.setSize("76px", "13px");
		
	}
	private void EliminarFormulario(){
        a.EliminarFormulario(this,empleado.id_empleado, id_familia);
    }
	
	private void EliminarFormularioSinDatos(){
        a.EliminarFormulario(this);
    }
	
	public void LlenarDatos(Long id,String txtPrimer_apellido ,
			String txtSegundo_apellidp,
			String txtPrimer_nombre,
			String txtSegundo_nombre,
			String txtOcupacion,
			String txtParentesco,
			String txtEdad )
	{
		this.id_familia = id;
		this.bandera = false;
		this.txtPrimer_apellido.setText(txtPrimer_apellido);
		this.txtSegundo_apellidp.setText(txtSegundo_apellidp);
		this.txtPrimer_nombre.setText(txtPrimer_nombre);
		this.txtSegundo_nombre.setText(txtSegundo_nombre);
		this.txtOcupacion.setText(txtOcupacion);
		this.txtEdad.setText(txtEdad);
	}
	
	

}
