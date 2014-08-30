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
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class formularioReferenciaPersonal extends Composite {

	private Empleados empleado;
	private referenciaPersonal a;
	private boolean bandera = true;
	private Long id_referencia_personal = 0L;
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	
	private TextBox txtNombre;
	private TextBox txtPuestoCandidato;
	private TextBox txtRelacion;
	private TextArea txtActitudes;
	private IntegerBox txtTelefono;
	
	
	public formularioReferenciaPersonal(referenciaPersonal a,Empleados e) {

		this.empleado = e;
		this.a = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("1007px", "150px");
		
		txtNombre = new TextBox();
		txtNombre.setMaxLength(200);
		txtNombre.setStylePrimaryName("gwt-TextBox2");
		txtNombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombre, 10, 29);
		txtNombre.setSize("227px", "34px");
		
		txtTelefono = new IntegerBox();
		txtTelefono.setText("0");
		txtTelefono.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefono, 255, 29);
		txtTelefono.setSize("227px", "34px");
		
		txtPuestoCandidato = new TextBox();
		txtPuestoCandidato.setMaxLength(200);
		txtPuestoCandidato.setStylePrimaryName("gwt-TextBox2");
		txtPuestoCandidato.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPuestoCandidato, 501, 29);
		txtPuestoCandidato.setSize("227px", "34px");
		
		txtRelacion = new TextBox();
		txtRelacion.setMaxLength(100);
		txtRelacion.setStylePrimaryName("gwt-TextBox2");
		txtRelacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtRelacion, 10, 102);
		txtRelacion.setSize("227px", "34px");
		
		txtActitudes = new TextArea();
		txtActitudes.getElement().setAttribute("maxlength", "500");
		txtActitudes.setStyleName("gwt-TextBox");
		absolutePanel.add(txtActitudes, 255, 102);
		txtActitudes.setSize("425px", "53px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(bandera) {
					loginService.Insertar_Referencia_Personal(empleado.id_empleado, txtNombre.getText(), txtTelefono.getText(), 
							txtPuestoCandidato.getText(), txtRelacion.getText(), txtActitudes.getText(), new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
                            Window.alert("Error  al Guardar Datos"+caught);
                        }

						@Override
                        public void onSuccess(Long result)
                        {
							id_referencia_personal = result;
							bandera = false;
                        	Window.alert("Datos Guardados exitosamente!!! ");
                        }
						});
				}else{
					loginService.Actualizar_Referencia_Personal(empleado.id_empleado,id_referencia_personal, txtNombre.getText(), txtTelefono.getText(), 
							txtPuestoCandidato.getText(), txtRelacion.getText(), txtActitudes.getText(), new AsyncCallback<Long>(){
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
		btnActualizar.setStylePrimaryName("sendButton");
		btnActualizar.setStyleName("sendButton");
		absolutePanel.add(btnActualizar, 746, 29);
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
		btnEliminar.setStylePrimaryName("sendButton");
		btnEliminar.setStyleName("sendButton");
		absolutePanel.add(btnEliminar, 746, 129);
		btnEliminar.setSize("227px", "34px");
		
		Label lblNivelAcademico = new Label("Nombre");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Telefono");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 255, 10);
		lblTitulodiploma.setSize("192px", "13px");
		
		Label lblParentesco = new Label("Puesto Candidato");
		lblParentesco.setStyleName("label");
		absolutePanel.add(lblParentesco, 501, 10);
		lblParentesco.setSize("192px", "13px");
		
		Label lblEmpresa = new Label("Relacion");
		lblEmpresa.setStyleName("label");
		absolutePanel.add(lblEmpresa, 10, 83);
		lblEmpresa.setSize("192px", "13px");
		
		Label lblActitudescualidadesaptitudesObserv = new Label("Actitudes/cualidades/aptitudes observadas");
		lblActitudescualidadesaptitudesObserv.setStyleName("label");
		absolutePanel.add(lblActitudescualidadesaptitudesObserv, 255, 83);
		lblActitudescualidadesaptitudesObserv.setSize("338px", "13px");
		
	}
	private void EliminarFormulario(){
        a.EliminarFormulario(this,empleado.id_empleado,id_referencia_personal);
    }
	private void EliminarFormularioSinDatos(){
        a.EliminarFormulario(this);
    }
	
	public void LlenarDatos(Long id, String txtNombre,
			 String txtPuestoCandidato,
			 String txtRelacion,
			 String txtActitudes,
			 String txtTelefono)
	{
		this.id_referencia_personal = id;
		this.bandera = false;
		this.txtNombre.setText(txtNombre);;
		this.txtPuestoCandidato.setText(txtPuestoCandidato);
		this.txtRelacion.setText(txtRelacion);
		this.txtActitudes.setText(txtActitudes);
		this.txtTelefono.setText(txtTelefono);
	}
}
