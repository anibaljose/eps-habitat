package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class formulario_historial extends Composite {

	private historiales a;
	private int id_historial =0;
	public formulario_historial(historiales a) {
		this.a = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("534px", "140px");
		
		Label lblNivelAcademico = new Label("Fecha");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.setText("Actualizar");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnActualizar, 378, 41);
		btnActualizar.setSize("157px", "20px");
		
		Button btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				EliminarFormulario();
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("gwt-TextBox2");
		btnEliminar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnEliminar, 378, 83);
		btnEliminar.setSize("157px", "20px");
		
		Label lblMotivo = new Label("Descripcion");
		lblMotivo.setStyleName("label");
		absolutePanel.add(lblMotivo, 10, 56);
		lblMotivo.setSize("192px", "13px");
		
		Label lblLoRecomienda = new Label("Tipo ");
		lblLoRecomienda.setStyleName("label");
		absolutePanel.add(lblLoRecomienda, 173, 10);
		lblLoRecomienda.setSize("103px", "13px");
		
		ListBox listTipo = new ListBox();
		listTipo.addItem("permisos");
		listTipo.addItem("ausencias");
		listTipo.addItem("aciertos ");
		listTipo.addItem("llamadas de atención");
		listTipo.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTipo, 173, 29);
		listTipo.setSize("157px", "19px");
		
		TextArea txtDescripcion = new TextArea();
		txtDescripcion.getElement().setAttribute("maxlength", "1000");
		txtDescripcion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDescripcion, 10, 71);
		txtDescripcion.setSize("317px", "61px");
		
		DateBox dateFecha = new DateBox();
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 10, 29);
		dateFecha.setSize("123px", "11px");
	}
	
	private void EliminarFormulario(){
        a.EliminarFormulario(this);
    }
}
