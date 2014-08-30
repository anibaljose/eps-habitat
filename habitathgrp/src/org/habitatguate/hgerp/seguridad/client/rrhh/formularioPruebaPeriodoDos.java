package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;
import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
public class formularioPruebaPeriodoDos extends Composite {

	 	private Empleados empleado;
		private Long id_prueba = 0L;
		private boolean bandera = true;
	    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
		
	    private ListBox listPregunta1;
		private ListBox listPregunta2;
		private ListBox listPregunta3;
		private ListBox listPregunta4;
		private ListBox listPregunta5;
		private ListBox listPregunta6;
		private ListBox listPregunta7;
		private ListBox listPregunta8;
		private ListBox listPregunta9;
		private ListBox listPregunta10;
		private TextBox txtEvaluador;
		private DoubleBox txtPunteoTotal;
		private DateBox dateFecha ;
		
	public formularioPruebaPeriodoDos(Empleados e) {

		this.empleado = e;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("700px", "1190px");
		
		listPregunta1 = new ListBox();
		listPregunta1.addItem("0");
		listPregunta1.addItem("1");
		listPregunta1.addItem("2");
		listPregunta1.addItem("3");
		listPregunta1.addItem("4");
		listPregunta1.addItem("5");
		listPregunta1.addItem("6");
		listPregunta1.addItem("7");
		listPregunta1.addItem("8");
		listPregunta1.addItem("9");
		listPregunta1.addItem("10");
		listPregunta1.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta1, 548, 428);
		listPregunta1.setSize("198px", "34px");
		
		listPregunta2 = new ListBox();
		listPregunta2.addItem("0");
		listPregunta2.addItem("1");
		listPregunta2.addItem("2");
		listPregunta2.addItem("3");
		listPregunta2.addItem("4");
		listPregunta2.addItem("5");
		listPregunta2.addItem("6");
		listPregunta2.addItem("7");
		listPregunta2.addItem("8");
		listPregunta2.addItem("9");
		listPregunta2.addItem("10");
		listPregunta2.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta2, 548, 468);
		listPregunta2.setSize("198px", "34px");
		
		listPregunta3 = new ListBox();
		listPregunta3.addItem("0");
		listPregunta3.addItem("1");
		listPregunta3.addItem("2");
		listPregunta3.addItem("3");
		listPregunta3.addItem("4");
		listPregunta3.addItem("5");
		listPregunta3.addItem("6");
		listPregunta3.addItem("7");
		listPregunta3.addItem("8");
		listPregunta3.addItem("9");
		listPregunta3.addItem("10");
		listPregunta3.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta3, 548, 508);
		listPregunta3.setSize("198px", "34px");
		
		listPregunta4 = new ListBox();
		listPregunta4.addItem("0");
		listPregunta4.addItem("1");
		listPregunta4.addItem("2");
		listPregunta4.addItem("3");
		listPregunta4.addItem("4");
		listPregunta4.addItem("5");
		listPregunta4.addItem("6");
		listPregunta4.addItem("7");
		listPregunta4.addItem("8");
		listPregunta4.addItem("9");
		listPregunta4.addItem("10");
		listPregunta4.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta4, 548, 548);
		listPregunta4.setSize("198px", "34px");
		
		listPregunta5 = new ListBox();
		listPregunta5.addItem("0");
		listPregunta5.addItem("1");
		listPregunta5.addItem("2");
		listPregunta5.addItem("3");
		listPregunta5.addItem("4");
		listPregunta5.addItem("5");
		listPregunta5.addItem("6");
		listPregunta5.addItem("7");
		listPregunta5.addItem("8");
		listPregunta5.addItem("9");
		listPregunta5.addItem("10");
		listPregunta5.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta5, 548, 588);
		listPregunta5.setSize("198px", "34px");
		
		listPregunta6 = new ListBox();
		listPregunta6.addItem("0");
		listPregunta6.addItem("1");
		listPregunta6.addItem("2");
		listPregunta6.addItem("3");
		listPregunta6.addItem("4");
		listPregunta6.addItem("5");
		listPregunta6.addItem("6");
		listPregunta6.addItem("7");
		listPregunta6.addItem("8");
		listPregunta6.addItem("9");
		listPregunta6.addItem("10");
		listPregunta6.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta6, 548, 628);
		listPregunta6.setSize("198px", "34px");
		
		listPregunta7 = new ListBox();
		listPregunta7.addItem("0");
		listPregunta7.addItem("1");
		listPregunta7.addItem("2");
		listPregunta7.addItem("3");
		listPregunta7.addItem("4");
		listPregunta7.addItem("5");
		listPregunta7.addItem("6");
		listPregunta7.addItem("7");
		listPregunta7.addItem("8");
		listPregunta7.addItem("9");
		listPregunta7.addItem("10");
		listPregunta7.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta7, 548, 668);
		listPregunta7.setSize("198px", "34px");
		
		listPregunta8 = new ListBox();
		listPregunta8.addItem("0");
		listPregunta8.addItem("1");
		listPregunta8.addItem("2");
		listPregunta8.addItem("3");
		listPregunta8.addItem("4");
		listPregunta8.addItem("5");
		listPregunta8.addItem("6");
		listPregunta8.addItem("7");
		listPregunta8.addItem("8");
		listPregunta8.addItem("9");
		listPregunta8.addItem("10");
		listPregunta8.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta8, 548, 708);
		listPregunta8.setSize("198px", "34px");
		
		listPregunta9 = new ListBox();
		listPregunta9.addItem("0");
		listPregunta9.addItem("1");
		listPregunta9.addItem("2");
		listPregunta9.addItem("3");
		listPregunta9.addItem("4");
		listPregunta9.addItem("5");
		listPregunta9.addItem("6");
		listPregunta9.addItem("7");
		listPregunta9.addItem("8");
		listPregunta9.addItem("9");
		listPregunta9.addItem("10");
		listPregunta9.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta9, 548, 748);
		listPregunta9.setSize("198px", "34px");
		
		listPregunta10 = new ListBox();
		listPregunta10.addItem("0");
		listPregunta10.addItem("1");
		listPregunta10.addItem("2");
		listPregunta10.addItem("3");
		listPregunta10.addItem("4");
		listPregunta10.addItem("5");
		listPregunta10.addItem("6");
		listPregunta10.addItem("7");
		listPregunta10.addItem("8");
		listPregunta10.addItem("9");
		listPregunta10.addItem("10");
		listPregunta10.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta10, 548, 788);
		listPregunta10.setSize("198px", "34px");
		
		txtPunteoTotal = new DoubleBox();
		txtPunteoTotal.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPunteoTotal, 548, 862);
		txtPunteoTotal.setSize("198px", "34px");
		
		txtEvaluador = new TextBox();
		txtEvaluador.setMaxLength(500);
		txtEvaluador.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEvaluador, 37, 939);
		txtEvaluador.setSize("198px", "34px");
		
		dateFecha = new DateBox();
		dateFecha.setValue(new Date(1407518962255L));
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 330, 939);
		dateFecha.setSize("198px", "34px");
		
		Button btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				try{
					new Date(dateFecha.getValue().getTime());
				}catch(Exception e){
					dateFecha.setValue(new Date(1407518124684L));
				}
			
				if(bandera) {
					loginService.Insertar_Test(empleado.id_empleado, Integer.parseInt(listPregunta1.getItemText(listPregunta1.getSelectedIndex())), 
							Integer.parseInt(listPregunta2.getItemText(listPregunta2.getSelectedIndex())), Integer.parseInt(listPregunta3.getItemText(listPregunta3.getSelectedIndex())), 
							Integer.parseInt(listPregunta4.getItemText(listPregunta4.getSelectedIndex())), Integer.parseInt(listPregunta5.getItemText(listPregunta5.getSelectedIndex())), 
							Integer.parseInt(listPregunta6.getItemText(listPregunta6.getSelectedIndex())), Integer.parseInt(listPregunta7.getItemText(listPregunta7.getSelectedIndex())), 
							Integer.parseInt(listPregunta8.getItemText(listPregunta8.getSelectedIndex())), Integer.parseInt(listPregunta9.getItemText(listPregunta9.getSelectedIndex())), 
							Integer.parseInt(listPregunta10.getItemText(listPregunta10.getSelectedIndex())), dateFecha.getValue(), 
							txtEvaluador.getText(), "2", new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
                            Window.alert("Error  al Guardar Datos"+caught);
                        }

						@Override
                        public void onSuccess(Long result)
                        {
							id_prueba= result;
							bandera = false;
                        	Window.alert("Datos Guardados exitosamente!!! ");
                        }

                 });
		}else{
			loginService.Actualizar_Test(empleado.id_empleado,id_prueba, Integer.parseInt(listPregunta1.getItemText(listPregunta1.getSelectedIndex())), 
					Integer.parseInt(listPregunta2.getItemText(listPregunta2.getSelectedIndex())), Integer.parseInt(listPregunta3.getItemText(listPregunta3.getSelectedIndex())), 
					Integer.parseInt(listPregunta4.getItemText(listPregunta4.getSelectedIndex())), Integer.parseInt(listPregunta5.getItemText(listPregunta5.getSelectedIndex())), 
					Integer.parseInt(listPregunta6.getItemText(listPregunta6.getSelectedIndex())), Integer.parseInt(listPregunta7.getItemText(listPregunta7.getSelectedIndex())), 
					Integer.parseInt(listPregunta8.getItemText(listPregunta8.getSelectedIndex())), Integer.parseInt(listPregunta9.getItemText(listPregunta9.getSelectedIndex())), 
					Integer.parseInt(listPregunta10.getItemText(listPregunta10.getSelectedIndex())), dateFecha.getValue(), 
					txtEvaluador.getText(), "2", new AsyncCallback<Long>(){
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
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("sendButton");
		btnGuardar.setStyleName("sendButton");
		absolutePanel.add(btnGuardar, 332, 1102);
		btnGuardar.setSize("198px", "32px");
		
		Label lblNivelAcademico = new Label("Evaluación de Período de Prueba realizada en Oficina Nacional");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 115, 10);
		lblNivelAcademico.setSize("456px", "13px");
		
		Label lblInstruccionesParaRealizar = new Label("Instrucciones para realizar objetiva y eficientemente la evaluación de Período de Prueba de los nuevos colaboradores de Fundación Hábitat para la Humanidad Guatemala.");
		lblInstruccionesParaRealizar.setStyleName("label");
		absolutePanel.add(lblInstruccionesParaRealizar, 37, 29);
		lblInstruccionesParaRealizar.setSize("667px", "13px");
		
		Label lblObjetivoevaluarElDesempeo = new Label("Objetivo: Evaluar el desempeño del nuevo colaborador durante los primeros tres meses de labores dentro de la Fundación, y emitir un juicio objetivo para poder confirmarlo o no en el puesto de trabajo para el que ha sido contratado.");
		lblObjetivoevaluarElDesempeo.setStyleName("label");
		absolutePanel.add(lblObjetivoevaluarElDesempeo, 37, 67);
		lblObjetivoevaluarElDesempeo.setSize("676px", "13px");
		
		Label lblProcedimientoParaLa = new Label("Procedimiento para la aplicación de la herramienta:");
		lblProcedimientoParaLa.setStyleName("label");
		absolutePanel.add(lblProcedimientoParaLa, 37, 122);
		lblProcedimientoParaLa.setSize("676px", "13px");
		
		Label lblPosteriorA = new Label("1. \tPosterior a los 2 meses y medio de trabajo, el personal de Oficina Nacional (Directores, Coordinadores) realizará una única evaluación de período de prueba a los nuevos colaboradores de la Fundación, con los que haya tenido contacto.\t\t\t\t\t\n\t\t\t\t\t\t\n2.\tLos aspectos a evaluar son 10, siendo estos los más generales, pero al mismo tiempo importantes para emitir un juicio justo.\t\t\t\t\t\n\t\t\t\t\t\t\n3\tEl puntaje irá de 1 a 10 en cada uno de los aspectos, lo que dará un total de 100 puntos.\t\t\t\t\t\n\t\t\t\t\t\t\n4\tPara que el colaborador sea confirmado en el puesto de trabajo, deberá aprobar la evluación con un mínimo de 71 puntos.\t\t\t\t\t\n\t\t\t\t\t\t\n5\tEl evaluador deberá entregar la herramienta a la Coordinación de Recursos Humanos, cuando le sea solicitada. \t\t\t\t\t\n\t\t\t\t\t\t\n6\tLa Coordinación de Recursos Humanos procederá adjuntar la evaluación hecha por Oficina Nacional, a la hecha por el jefe inmediato superior para promediar su puntaje y determinar las acciones a tomar en base a los resultados.\t\t\t\t\t\n\t\t\t\t\t\t\n7\tLa evaluación deberá basarse en datos objetivos y no desde un punto de vista personal\t\t\t\t\t\n\t\t\t\t\t\t\n8\tNo puede deajarse ninguno de los aspectos sin calificación, ya que esto perjudicará el puntaje final del trabajador.\t\t\t\t\t\n\t\t\t\t\t\t\n9\tSe recomienda contar con toda la información necesaria previo a aplicar la herramienta, con el propósito que el resultado sea lo más objetivo posible.\t\t\t\t\t\n\t\t\t\t\t\t\n10\tLa Coordinación de Recursos Humanos apoyará directamente a los colaboradores que deban aplicar la herramienta, para poder cumplir con el objetivo para el que fue creada.\t\t\t\t\t\n\t\t\t\t\t\t");
		lblPosteriorA.setStyleName("label");
		absolutePanel.add(lblPosteriorA, 37, 141);
		lblPosteriorA.setSize("667px", "13px");
		
		Label lblAtiendeEficientementeLos = new Label("Apoya y motiva a los miembros del comité\t\t\t\t");
		lblAtiendeEficientementeLos.setStyleName("label");
		absolutePanel.add(lblAtiendeEficientementeLos, 36, 428);
		lblAtiendeEficientementeLos.setSize("379px", "13px");
		
		Label lblLaInformacinQue = new Label("Es eficiente y ordenado en la realización de sus actividades\t\t\t\t");
		lblLaInformacinQue.setStyleName("label");
		absolutePanel.add(lblLaInformacinQue, 37, 468);
		lblLaInformacinQue.setSize("511px", "13px");
		
		Label lblTieneClarosLos = new Label("Cumple con lo acordado para los diferentes eventos\t\t\t\t");
		lblTieneClarosLos.setStyleName("label");
		absolutePanel.add(lblTieneClarosLos, 37, 508);
		lblTieneClarosLos.setSize("524px", "13px");
		
		Label lblLosResultadosQue = new Label("Mantiene un clima de unidad\t\t\t\t");
		lblLosResultadosQue.setStyleName("label");
		absolutePanel.add(lblLosResultadosQue, 37, 548);
		lblLosResultadosQue.setSize("293px", "13px");
		
		Label lblProporcionaUnClima = new Label("Supervisa constante \t\t\t\t");
		lblProporcionaUnClima.setStyleName("label");
		absolutePanel.add(lblProporcionaUnClima, 37, 588);
		lblProporcionaUnClima.setSize("511px", "13px");
		
		Label lblSuDisposicinDe = new Label("Su colaboración es expontánea e inmediata\t\t\t\t");
		lblSuDisposicinDe.setStyleName("label");
		absolutePanel.add(lblSuDisposicinDe, 37, 629);
		lblSuDisposicinDe.setSize("511px", "13px");
		
		Label lblMantieneUnaActitud = new Label("Se identifica y compromete con los objetivos de la Fundación\t\t\t\t");
		lblMantieneUnaActitud.setStyleName("label");
		absolutePanel.add(lblMantieneUnaActitud, 37, 788);
		lblMantieneUnaActitud.setSize("511px", "13px");
		
		Label lblAdministraEficientementeLos = new Label("Demuestra deseos de aprender y mejorar\t\t\t\t");
		lblAdministraEficientementeLos.setStyleName("label");
		absolutePanel.add(lblAdministraEficientementeLos, 37, 748);
		lblAdministraEficientementeLos.setSize("511px", "13px");
		
		Label lblLaComunicacinQue = new Label("Se conduce con ética y profesionalismo\t\t\t\t");
		lblLaComunicacinQue.setStyleName("label");
		absolutePanel.add(lblLaComunicacinQue, 37, 709);
		lblLaComunicacinQue.setSize("511px", "13px");
		
		Label lblTieneClarasSus = new Label("Conoce su área de trabajo\t\t\t\t");
		lblTieneClarasSus.setStyleName("label");
		absolutePanel.add(lblTieneClarasSus, 37, 668);
		lblTieneClarasSus.setSize("511px", "13px");
		
		Label lblPunteoTotal = new Label("Punteo Total");
		lblPunteoTotal.setStyleName("label");
		absolutePanel.add(lblPunteoTotal, 587, 841);
		lblPunteoTotal.setSize("143px", "13px");
		
		Label lblEvaluador = new Label("Evaluador");
		lblEvaluador.setStyleName("label");
		absolutePanel.add(lblEvaluador, 62, 904);
		lblEvaluador.setSize("75px", "13px");
		
		Label lblFecha = new Label("Fecha");
		lblFecha.setStyleName("label");
		absolutePanel.add(lblFecha, 340, 904);
		lblFecha.setSize("75px", "13px");
	}
	

	
	public  void LlenarDatos(Long id, String listPregunta1,
			String listPregunta2, String listPregunta3,
			String listPregunta4, String listPregunta5,
			String listPregunta6, String listPregunta7,
			String listPregunta8, String listPregunta9,
			String listPregunta10, String txtEvaluador, Long dateFecha) {

		this.id_prueba = id;
		this.bandera = false;
		boolean bandera = true;
		for(int i=0; i < this.listPregunta1.getItemCount() && bandera; i++){
			bandera = !this.listPregunta1.getItemText(i).equals(listPregunta1);
			this.listPregunta1.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta2.getItemCount() && bandera; i++){
			bandera = !this.listPregunta2.getItemText(i).equals(listPregunta2);
			this.listPregunta2.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta3.getItemCount() && bandera; i++){
			bandera = !this.listPregunta3.getItemText(i).equals(listPregunta3);
			this.listPregunta3.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta4.getItemCount() && bandera; i++){
			bandera = !this.listPregunta4.getItemText(i).equals(listPregunta4);
			this.listPregunta4.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta5.getItemCount() && bandera; i++){
			bandera = !this.listPregunta5.getItemText(i).equals(listPregunta5);
			this.listPregunta5.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta6.getItemCount() && bandera; i++){
			bandera = !this.listPregunta6.getItemText(i).equals(listPregunta6);
			this.listPregunta6.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta7.getItemCount() && bandera; i++){
			bandera = !this.listPregunta7.getItemText(i).equals(listPregunta7);
			this.listPregunta7.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta8.getItemCount() && bandera; i++){
			bandera = !this.listPregunta8.getItemText(i).equals(listPregunta8);
			this.listPregunta8.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta9.getItemCount() && bandera; i++){
			bandera = !this.listPregunta9.getItemText(i).equals(listPregunta9);
			this.listPregunta9.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta10.getItemCount() && bandera; i++){
			bandera = !this.listPregunta10.getItemText(i).equals(listPregunta10);
			this.listPregunta10.setSelectedIndex(i);
		}
		this.txtEvaluador.setText(txtEvaluador);
		this.dateFecha.setValue(new Date(dateFecha));
	}

}