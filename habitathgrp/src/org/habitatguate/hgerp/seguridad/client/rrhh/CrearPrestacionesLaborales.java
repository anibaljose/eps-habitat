/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class CrearPrestacionesLaborales extends Composite   {

    private Grid grid;
    private Loading load;
    private Image Busqueda;
	boolean bandera = false;
	private Mensaje mensaje; 
    private Prestaciones nuevo;
    private SuggestBox txtDato1;
    private SimpleCheckBox checkBonificacion;
    private SimpleCheckBox checkDecreto;

    private ListBox listBox;
    private ListBox listEstado;
    private ListBox listTipoPrestaciones;
    
    private DateBox dateFecha;

    private Label lbDato1;
    private Label lblFechaRegistro;
    private Label lblCantidad;
    private Label lblElijaElTipo;
    private AbsolutePanel absolutePanel;
    private Label lblDescripcionPequea;
    
    private TextBox Cantidad;
    private TextBox txtDescripcion;
    
	public List <AuxBDPuesto> auxbdPuestos = new ArrayList<AuxBDPuesto>();	
	public List <AuxAfiliado> auxAfiliados = new ArrayList<AuxAfiliado>();	
    private final SqlServiceAsync finanzasService = GWT.create(SqlService.class);
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    private DateBox dateFecha1;
    private Label lblFecha;
    private DateBox dateFecha2;
    
    /**
     * constructor
     */
	public CrearPrestacionesLaborales() {

    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		mensaje = new Mensaje();
		grid = new Grid(2, 1);
		nuevo = new Prestaciones();
		grid.setSize("1117px", "100%");
					
		absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("100%", "98px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		
		
		listBox = new ListBox();
		listBox.addItem("Nombres");
		listBox.addItem("Afiliado");
		listBox.addItem("Pasaporte");
		listBox.addItem("Estado");
		listBox.addItem("Puesto");
		listBox.addItem("Todos");
		listBox.addItem("DPI");
		listBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {

				if(listBox.getItemText(listBox.getSelectedIndex()).equals("DPI"))
				{
					lbDato1.setText("Ingrese el DPI");
					
					lbDato1.setVisible(true);
					
					txtDato1.setVisible(true);
					//absolutePanel.add(Busqueda, 420, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
				{
					lbDato1.setText("Primer Nombre");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(true);
					listEstado.setVisible(false);
					//absolutePanel.add(Busqueda, 420, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
				{
					lbDato1.setText("Primer Nombre");

					lbDato1.setVisible(false);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(false);
					//absolutePanel.add(Busqueda, 205, 16);

					grid.clearCell(1, 0);
					agregarFormulario('2',txtDato1.getText(), "","", 
							"",txtDato1.getText(),txtDato1.getText()
							,"");
					grid.setWidget(1, 0,nuevo);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Pasaporte"))
				{
					lbDato1.setText("Ingrese No. Pasaporte");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(true);
					listEstado.setVisible(false);
					//absolutePanel.add(Busqueda, 420, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Estado"))
				{
					listEstado.clear();
					listEstado.addItem("empleado activo","0");
					listEstado.addItem("empleado inactivo","1");
					listEstado.addItem("posible empleado","2");
					listEstado.addItem("practicante","3");
					listEstado.addItem("interino","4");
					
					lbDato1.setText("Seleccione el Estado del empleado");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(true);
					//absolutePanel.add(Busqueda, 390, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Puesto"))
				{

					listEstado.clear();
					listEstado.addItem("seleccione un puesto","0");
				    for (AuxBDPuesto p : auxbdPuestos) 
				    {
				    	listEstado.addItem(p.getNombre_puesto(),""+p.getId_puesto());
				    }
					lbDato1.setText("Seleccione el puesto");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(true);
					//absolutePanel.add(Busqueda, 390, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Afiliado"))
				{

					listEstado.clear();
					listEstado.addItem("seleccione un afiliado","0");
				    for (AuxAfiliado p : auxAfiliados) 
				    {
				    	listEstado.addItem(p.getNomAfiliado(),""+p.getIdAfiliado());
				    }
					lbDato1.setText("Seleccione el Afiliado");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(true);
					//absolutePanel.add(Busqueda, 420, 19);
			        load.invisible();
				}
			}
		});
		
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 10, 19);
		listBox.setSize("179px", "39px");
		
		txtDato1 =  new SuggestBox(createCountriesOracle());
		txtDato1.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {
				if(event.getNativeKeyCode()== KeyCodes.KEY_ENTER){
					Buscar();
				}
			}
		});
		txtDato1.setStylePrimaryName("gwt-TextBox2");
		txtDato1.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDato1, 205, 19);
		txtDato1.setSize("250px", "34px");
		
		listEstado = new ListBox();
		listEstado.addItem("empleado activo","0");
		listEstado.addItem("empleado inactivo","1");
		listEstado.addItem("posible empleado","2");
		listEstado.addItem("practicante","3");
		listEstado.addItem("interino","4");
		listEstado.setStyleName("gwt-TextBox2");
		listEstado.setVisible(false);
		absolutePanel.add(listEstado, 205, 16);
		listEstado.setSize("179px", "39px");
						
		Busqueda = new Image("images/ico-lupa.png");
		Busqueda.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Buscar();
			}
		});
		
		listTipoPrestaciones = new ListBox();
		listTipoPrestaciones.addItem("Decreto(78-89)", "1");
		listTipoPrestaciones.addItem("Comisiones", "2");
		listTipoPrestaciones.addItem("Bonificacion", "3");
		listTipoPrestaciones.addItem("Bono 14", "4");
		listTipoPrestaciones.addItem("Aguinaldo", "5");
		listTipoPrestaciones.addItem("Indemnizacion", "7");
		listTipoPrestaciones.addItem("Viaticos", "9");
		listTipoPrestaciones.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTipoPrestaciones, 10, 94);
		listTipoPrestaciones.setSize("179px", "39px");
						
		absolutePanel.add(Busqueda, 848, 78);
		Busqueda.setSize("103px", "55px");
		
		dateFecha = new DateBox();
		dateFecha.getTextBox().setReadOnly(true);
		dateFecha.setValue(new Date());
		dateFecha.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFecha.getDatePicker().setYearArrowsVisible(true);
		dateFecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha.getDatePicker().setVisibleYearCount(100);
		dateFecha.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(dateFecha, 463, 17);
		dateFecha.setSize("177px", "41px");
		
		txtDescripcion = new TextBox();
		txtDescripcion.setStyleName("gwt-TextBox2");
		txtDescripcion.setMaxLength(100);
		absolutePanel.add(txtDescripcion, 648, 19);
		txtDescripcion.setSize("177px", "39px");
		
		Cantidad = new TextBox();
		Cantidad.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(Cantidad.getText().equals("")) {Cantidad.setText("0.0");}
				else if(Cantidad.getText().equals(null)) {Cantidad.setText("0.0");}
				else{
					try{
						Float.parseFloat(Cantidad.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nCantidad no valida");
						Cantidad.setText("0.0");
					}
				}
			}
		});
		Cantidad.setText("0.0");
		Cantidad.setStyleName("gwt-TextBox2");
		Cantidad.setMaxLength(100);
		absolutePanel.add(Cantidad, 846, 19);
		Cantidad.setSize("145px", "39px");
		
		dateFecha1 = new DateBox();
		dateFecha1.getTextBox().setReadOnly(true);
		dateFecha1.setValue(new Date());
		dateFecha1.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFecha1.getDatePicker().setYearArrowsVisible(true);
		dateFecha1.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha1.getDatePicker().setVisibleYearCount(100);
		dateFecha1.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(dateFecha1, 205, 90);
		dateFecha1.setSize("177px", "41px");
		
		dateFecha2 = new DateBox();
		dateFecha2.getTextBox().setReadOnly(true);
		dateFecha2.setValue(new Date());
		dateFecha2.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFecha2.getDatePicker().setYearArrowsVisible(true);
		dateFecha2.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha2.getDatePicker().setVisibleYearCount(100);
		dateFecha2.setStyleName("gwt-PasswordTextBox");
		absolutePanel.add(dateFecha2, 397, 90);
		dateFecha2.setSize("177px", "41px");
		
		checkBonificacion = new SimpleCheckBox();
		absolutePanel.add(checkBonificacion, 645, 94);
		

		checkDecreto = new SimpleCheckBox();
		absolutePanel.add(checkDecreto, 645, 94);
		
		lbDato1 = new Label("Primer Nombre");
		lbDato1.setStyleName("label");
		lbDato1.setSize("368px", "19px");
		absolutePanel.add(lbDato1, 205, 0);
		
		Label lblBusquedaPor = new Label("Busqueda por: ");
		lblBusquedaPor.setStyleName("label");
		lblBusquedaPor.setSize("118px", "13px");
		absolutePanel.add(lblBusquedaPor, 10, 0);
		
		lblElijaElTipo = new Label("Elija el tipo de prestaciones a calcular");
		lblElijaElTipo.setStyleName("label");
		absolutePanel.add(lblElijaElTipo, 10, 61);
		lblElijaElTipo.setSize("179px", "13px");
		
		lblFechaRegistro = new Label("Fecha Registro");
		lblFechaRegistro.setStyleName("label");
		absolutePanel.add(lblFechaRegistro, 463, 0);
		lblFechaRegistro.setSize("179px", "13px");
		
		lblDescripcionPequea = new Label("Descripcion(Opcional)");
		lblDescripcionPequea.setStyleName("label");
		absolutePanel.add(lblDescripcionPequea, 648, 0);
		lblDescripcionPequea.setSize("216px", "19px");
		
		lblCantidad = new Label("Cantidad");
		lblCantidad.setStyleName("label");
		absolutePanel.add(lblCantidad, 846, 0);
		lblCantidad.setSize("157px", "13px");
		
		lblFecha = new Label("Rango de Fecha para calculo de Bono 14 y Aguinaldo");
		lblFecha.setStyleName("label");
		absolutePanel.add(lblFecha, 205, 73);
		lblFecha.setSize("389px", "13px");
		
		Label lblBonificacion = new Label("Extras");
		lblBonificacion.setStyleName("label");
		absolutePanel.add(lblBonificacion, 618, 78);
		lblBonificacion.setSize("94px", "13px");
		
    	recursosHumanosService.BDPuesto(new AsyncCallback<List<AuxBDPuesto>>(){
    		public void onFailure(Throwable caught) 
    		{
    			mensaje.setMensaje("alert alert-error", "Error en BD puestos\n"+caught);
    		}

			@Override
			public void onSuccess(List<AuxBDPuesto> results)
			{
				if (!(results.size()==0)) {
					auxbdPuestos = results;
		    	}	
			}
		});

		finanzasService.ConsultaTodosAfiliados(new AsyncCallback<List<AuxAfiliado>>(){
		    public void onFailure(Throwable caught) 
		    {
		    }
		
			@Override
		    public void onSuccess(List<AuxAfiliado> result)
		    {
				if (!(result.size()==0)) {
					auxAfiliados = result;
		    	}
		    }
		});
		initWidget(grid);
		
	}
	
	public void Buscar()
	{
		grid.clearCell(1, 0);
		nuevo = new Prestaciones();
		if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
		{
			agregarFormulario('2',txtDato1.getText(), "","","",txtDato1.getText(),txtDato1.getText(),"");
			grid.setWidget(1, 0,nuevo);
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
		{
			String nombreArray[] = txtDato1.getText().split(" ");
			String primerNombre = "";
			String segundoNombre = "";
			String segundoApellido = "";
			String primerApellido =  "";
			System.out.println(nombreArray.length);
			try{

				if(nombreArray.length == 2){
					primerNombre = nombreArray[0];
					segundoNombre = "";
					primerApellido =  nombreArray[1];
					segundoApellido = "";
					
					agregarFormulario('1',primerNombre, segundoNombre,primerApellido, segundoApellido,txtDato1.getText(),txtDato1.getText(),"");
					grid.setWidget(1, 0,nuevo);
					nuevo.setSize("100%", "648px");
				}else if(nombreArray.length == 3){
					
					primerNombre = nombreArray[0];
					segundoNombre =  nombreArray[1];
					primerApellido =  nombreArray[2];
					segundoApellido = "";
					
					
					if(agregarFormulario('1',primerNombre, segundoNombre,primerApellido, 
							segundoApellido,txtDato1.getText(),txtDato1.getText(),""))
					{
						primerNombre = nombreArray[0];
						segundoNombre =  "";
						primerApellido =  nombreArray[1];
						segundoApellido = nombreArray[2];
						
						agregarFormulario('1',primerNombre, segundoNombre,primerApellido, 
								segundoApellido,txtDato1.getText(),txtDato1.getText(),"");
					}
					
					grid.setWidget(1, 0,nuevo);
					nuevo.setSize("100%", "648px");
					
				}else if(nombreArray.length == 4){
					primerNombre = nombreArray[0];
					segundoNombre = nombreArray[1];
					primerApellido =  nombreArray[2];
					segundoApellido = nombreArray[3];
					
					agregarFormulario('1',primerNombre, segundoNombre,primerApellido, segundoApellido,txtDato1.getText(),txtDato1.getText(),"");
					grid.setWidget(1, 0,nuevo);
					nuevo.setSize("100%", "648px");
				}
				
			}catch(Exception e){
				 primerNombre = "";
				 segundoApellido = "";
				 primerApellido =  "";
			}
		}else if(listBox.getValue(listBox.getSelectedIndex()).equals("Pasaporte"))
		{
			if(!txtDato1.getText().equals("") ){
				agregarFormulario('3',txtDato1.getText(), "","", 
						"",txtDato1.getText(),txtDato1.getText()
						,"");
				grid.setWidget(1, 0,nuevo);
				nuevo.setSize("100%", "648px");
			}
			else{

    			mensaje.setMensaje("alert alert-info", "Escriba el No pasaporte");
    		}
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("DPI"))
		{

			if(!txtDato1.getText().equals("") ){
				agregarFormulario('4',txtDato1.getText(), "","", 
						"",txtDato1.getText(),txtDato1.getText()
						,"");
				grid.setWidget(1, 0,nuevo);
				nuevo.setSize("100%", "648px");
			}
			else{

    			mensaje.setMensaje("alert alert-info", "Escriba el DPI");
    		}
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Estado"))
		{
			agregarFormulario('5',txtDato1.getText(), "","", 
					"",txtDato1.getText(),txtDato1.getText()
					,listEstado.getValue(listEstado.getSelectedIndex()));
			grid.setWidget(1, 0,nuevo);
			nuevo.setSize("100%", "648px");
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Puesto"))
		{
			agregarFormulario('6',txtDato1.getText(), "","", 
					"",txtDato1.getText(),txtDato1.getText()
					,listEstado.getValue(listEstado.getSelectedIndex()));
			grid.setWidget(1, 0,nuevo);
			nuevo.setSize("100%", "648px");
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Afiliado"))
		{
			agregarFormulario('7',txtDato1.getText(), "","", 
					"",txtDato1.getText(),txtDato1.getText()
					,listEstado.getValue(listEstado.getSelectedIndex()));
			grid.setWidget(1, 0,nuevo);
			nuevo.setSize("100%", "648px");
		}
	}
	
	 public boolean agregarFormulario(final char tipo, final String primer_nombre, String segundo_nombre, 
				String primer_apellido, String segundo_apellido,String DPI, String Pasaporte,String Estado){

	        load.visible();
	    	recursosHumanosService.Buscar_Empleado(tipo, primer_nombre, segundo_nombre, 
							primer_apellido, segundo_apellido,DPI, Pasaporte,Estado,new AsyncCallback<List<AuxEmpleado>>(){
	            public void onFailure(Throwable caught) 
	            {
			        load.invisible();
	            	mensaje.setMensaje("alert alert-information alert-block", 
	            			"\nNo hay resultados");
	            }

				@Override
	            public void onSuccess( List<AuxEmpleado> result)
	            {
					bandera = !result.isEmpty();
					boolean error = false;
					String msj = "No hay resultados";
					
			        load.invisible();
			        
			        DateTimeFormat anio = DateTimeFormat.getFormat("yyyy");
			 		
			        String annio1 		= anio.format(dateFecha1.getValue());
			        String annio2 		= anio.format(dateFecha2.getValue());
			        
			        int dias			= (int) ((dateFecha2.getValue().getTime()-dateFecha1.getValue().getTime())/(1000*60*60*24)); 
			        String tipo 		= listTipoPrestaciones.getValue(listTipoPrestaciones.getSelectedIndex());
			        
			        if(!annio1.equals(annio2) && !tipo.equals("1") && !tipo.equals("2") && !tipo.equals("3")){
			        	error = true;
			        	msj = "rango de fechas debe ser del mismo año";
			        }
			        if(dateFecha2.getValue().getTime() < dateFecha1.getValue().getTime() && !error && !tipo.equals("1") && !tipo.equals("2") && !tipo.equals("3")){
			        	error = true;
			        	msj = "fecha 2 debe ser mayor a fecha 1";
			        }
			        if(dias <= 0 && !error && !tipo.equals("1") && !tipo.equals("2") && !tipo.equals("3")){
			        	error = true;
			        	msj = "el calculo debe ser para mas de 1 dia";
			        }
			        if((dias/30) >= 7 && !error && !tipo.equals("1") && !tipo.equals("2") && !tipo.equals("3")){
			        	error = true;
			        	msj = "el calculo de prestaciones, no debe ser para mas de 6 meses";
			        }
			        
			        
			        
					if(!result.isEmpty() && !error){
						Prestaciones(result,listTipoPrestaciones.getValue(listTipoPrestaciones.getSelectedIndex()),annio1);
						
					}else{
						mensaje.setMensaje("alert alert-information alert-block", "\n"+msj);
					}
	            }

	     });
	        load.invisible();

	        return bandera;

	    }
	 

	 	@SuppressWarnings("deprecation")
		private void Prestaciones(List<AuxEmpleado> result, String tipo,String listAnio)
	 	{
	 		String nombre = "";
	 		float salarioBaseCalculo = 0;
	 		float enero = 0, eneroBono = 0;
	 		float febrero= 0 , febreroBono = 0;
	 		float marzo= 0, marzoBono = 0;
	 		float abril= 0, abrilBono = 0;
	 		float mayo= 0, mayoBono = 0;
	 		float junio= 0, junioBono = 0;
	 		float julio= 0, julioBono = 0;
	 		float agosto= 0, agostoBono = 0;
	 		float septiembre= 0, septiembreBono = 0;
	 		float octubre= 0, octubreBono = 0;
	 		float noviembre= 0, noviembreBono = 0;
	 		float diciembre= 0, diciembreBono = 0;
	 		
	 		boolean bEnero = true, dEnero = true;
	 		boolean bFebrero = true, dFebrero = true;
	 		boolean bMarzo = true, dMarzo = true;
	 		boolean bAbril = true, dAbril = true;
	 		boolean bMayo = true, dMayo = true;
	 		boolean bJunio = true, dJunio = true;
	 		boolean bJulio = true, dJulio = true;
	 		boolean bAgosto = true, dAgosto = true;
	 		boolean bSeptiembre = true, dSeptiembre = true;
	 		boolean bOctubre = true, dOctubre= true;
	 		boolean bNoviembre = true, dNoviembre = true;
	 		boolean bDiciembre = true, dDiciembre = true;
	 		
	 		float eneroUltimoSalario = 0;
	 		float febreroUltimoSalario = 0;
	 		float marzoUltimoSalario = 0;
	 		float abrilUltimoSalario = 0;
	 		float mayoUltimoSalario = 0;
	 		float junioUltimoSalario = 0;
	 		float julioUltimoSalario = 0;
	 		float agostoUltimoSalario = 0;
	 		float septiembreUltimoSalario = 0;
	 		float octubreUltimoSalario = 0;
	 		float noviembreUltimoSalario = 0;
	 		float diciembreUltimoSalario = 0;
	 		
	 		float eneroUltimoDecreto = 0;
	 		float febreroUltimoDecreto = 0;
	 		float marzoUltimoDecreto = 0;
	 		float abrilUltimoDecreto = 0;
	 		float mayoUltimoDecreto = 0;
	 		float junioUltimoDecreto = 0;
	 		float julioUltimoDecreto = 0;
	 		float agostoUltimoDecreto = 0;
	 		float septiembreUltimoDecreto = 0;
	 		float octubreUltimoDecreto = 0;
	 		float noviembreUltimoDecreto = 0;
	 		float diciembreUltimoDecreto = 0;
	 		

	 		float eneroDecreto = 0;
	 		float febreroDecreto = 0;
	 		float marzoDecreto = 0;
	 		float abrilDecreto = 0;
	 		float mayoDecreto = 0;
	 		float junioDecreto = 0;
	 		float julioDecreto = 0;
	 		float agostoDecreto = 0;
	 		float septiembreDecreto = 0;
	 		float octubreDecreto = 0;
	 		float noviembreDecreto = 0;
	 		float diciembreDecreto = 0;
	 		
	 		int eneroAnioUltimo = 0;
	 		int febreroAnioUltimo = 0;
	 		int marzoAnioUltimo = 0;
	 		int abrilAnioUltimo = 0;
	 		int mayoAnioUltimo = 0;
	 		int junioAnioUltimo = 0;
	 		int julioAnioUltimo = 0;
	 		int agostoAnioUltimo = 0;
	 		int septiembreAnioUltimo = 0;
	 		int octubreAnioUltimo = 0;
	 		int noviembreAnioUltimo = 0;
	 		int diciembreAnioUltimo = 0;
	 		
	 		int eneroMesUltimo = 0;
	 		int febreroMesUltimo = 0;
	 		int marzoMesUltimo = 0;
	 		int abrilMesUltimo = 0;
	 		int mayoMesUltimo = 0;
	 		int junioMesUltimo = 0;
	 		int julioMesUltimo = 0;
	 		int agostoMesUltimo = 0;
	 		int septiembreMesUltimo = 0;
	 		int octubreMesUltimo = 0;
	 		int noviembreMesUltimo = 0;
	 		int diciembreMesUltimo = 0;
	 		
	 		DateTimeFormat anio = DateTimeFormat.getFormat("yyyy");
	 		DateTimeFormat mes 	= DateTimeFormat.getFormat("MM");


	        String mes1 		= mes.format(dateFecha1.getValue());
	        String mes2 		= mes.format(dateFecha2.getValue());
	 		//DateTimeFormat dia 	= DateTimeFormat.getFormat("dd");

	 		String AuxAnio 	= "";
	 		String AuxMes 	= "";
	 		//String formatDia 	= "";
	 		nuevo.limpiar();
	 		
	 		for(AuxEmpleado e:result)
	 		{
	 			nombre = e.getPrimer_nombre() +" "+ e.getSegundo_nombre() +" "+e.getPrimer_apellido() +" "+e.getSegundo_apellido(); 
	 			if(!tipo.equals("1") && !tipo.equals("2") && !tipo.equals("3")){
		 			for(AuxSalario s:e.getSalario())
		 			{
		 				AuxAnio = anio.format(new Date(s.getFecha()));
		 				AuxMes  = mes.format(new Date(s.getFecha()));
		 				
		 				//verifico el ultimo salario que tiene el empleado, si en caso:
		 				//esto primero verificando que el año del ultimo salario, este no sea de una fecha despues de la que se quiere calcular
		 				//fecha del salario menor o igual que el año a calcular
		 				if(Integer.parseInt(AuxAnio) <= Integer.parseInt(listAnio) &&  s.getTipoSalario().equals("0"))
		 				{
		 					//luego de lo anterior verifico que el año del salario y el mes del salario a tomar en cuenta
		 					//es mayor o igual a la fecha del ultimo salario, si es asi, entonces ese salario sera el ultimo
		 					//y asi hasta encontrar el ultimo entre la fecha a calcular hasta antes de esa fecha
		 					System.out.println(AuxMes);
		 					if(Integer.parseInt(AuxAnio) >= eneroAnioUltimo && Integer.parseInt(AuxMes) >= eneroMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 01)
		 					{
		 						eneroAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						eneroMesUltimo 		= Integer.parseInt(AuxMes);
		 						eneroUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= febreroAnioUltimo && Integer.parseInt(AuxMes) >= febreroMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 02)
		 					{
		 						febreroAnioUltimo 		= Integer.parseInt(AuxAnio);
		 						febreroMesUltimo 		= Integer.parseInt(AuxMes);
		 						febreroUltimoSalario 	=  s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= marzoAnioUltimo && Integer.parseInt(AuxMes) >= marzoMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 03)
		 					{
		 						marzoAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						marzoMesUltimo 		= Integer.parseInt(AuxMes);
		 						marzoUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= abrilAnioUltimo && Integer.parseInt(AuxMes) >= abrilMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 04)
		 					{
		 						abrilAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						abrilMesUltimo 		= Integer.parseInt(AuxMes);
		 						abrilUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= mayoAnioUltimo && Integer.parseInt(AuxMes) >= mayoMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 05)
		 					{
		 						mayoAnioUltimo 		= Integer.parseInt(AuxAnio);
		 						mayoMesUltimo 		= Integer.parseInt(AuxMes);
		 						mayoUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= junioAnioUltimo && Integer.parseInt(AuxMes) >= junioMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 06)
		 					{
		 						junioAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						junioMesUltimo 		= Integer.parseInt(AuxMes);
		 						junioUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= julioAnioUltimo && Integer.parseInt(AuxMes) >= julioMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 07)
		 					{
		 						julioAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						julioMesUltimo 		= Integer.parseInt(AuxMes);
		 						julioUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= agostoAnioUltimo && Integer.parseInt(AuxMes) >= agostoMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 8)
		 					{
		 						agostoAnioUltimo 		= Integer.parseInt(AuxAnio);
		 						agostoMesUltimo 		= Integer.parseInt(AuxMes);
		 						agostoUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= septiembreAnioUltimo && Integer.parseInt(AuxMes) >= septiembreMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 9)
		 					{
		 						septiembreAnioUltimo 		= Integer.parseInt(AuxAnio);
		 						septiembreMesUltimo 		= Integer.parseInt(AuxMes);
		 						septiembreUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= octubreAnioUltimo && Integer.parseInt(AuxMes) >= octubreMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 10)
		 					{
		 						octubreAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						octubreMesUltimo 		= Integer.parseInt(AuxMes);
		 						octubreUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= noviembreAnioUltimo && Integer.parseInt(AuxMes) >= noviembreMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 11)
		 					{
		 						noviembreAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						noviembreMesUltimo 		= Integer.parseInt(AuxMes);
		 						noviembreUltimoSalario 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= diciembreAnioUltimo && Integer.parseInt(AuxMes) >= diciembreMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 12)
		 					{
		 						diciembreAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						diciembreMesUltimo 		= Integer.parseInt(AuxMes);
		 						diciembreUltimoSalario 	= s.getSalario();
		 					}
		 					
		 				}
		 				
		 				if(Integer.parseInt(AuxAnio) <= Integer.parseInt(listAnio) &&  s.getTipoSalario().equals("1") && checkBonificacion.isChecked())
		 				{
		 					//luego de lo anterior verifico que el año del Decreto y el mes del Decreto a tomar en cuenta
		 					//es mayor o igual a la fecha del ultimo Decreto, si es asi, entonces ese Decreto sera el ultimo
		 					//y asi hasta encontrar el ultimo entre la fecha a calcular hasta antes de esa fecha
		 					System.out.println(AuxMes);
		 					if(Integer.parseInt(AuxAnio) >= eneroAnioUltimo && Integer.parseInt(AuxMes) >= eneroMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 01)
		 					{
		 						eneroAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						eneroMesUltimo 		= Integer.parseInt(AuxMes);
		 						eneroUltimoDecreto 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= febreroAnioUltimo && Integer.parseInt(AuxMes) >= febreroMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 02)
		 					{
		 						febreroAnioUltimo 		= Integer.parseInt(AuxAnio);
		 						febreroMesUltimo 		= Integer.parseInt(AuxMes);
		 						febreroUltimoDecreto 	=  s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= marzoAnioUltimo && Integer.parseInt(AuxMes) >= marzoMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 03)
		 					{
		 						marzoAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						marzoMesUltimo 		= Integer.parseInt(AuxMes);
		 						marzoUltimoDecreto 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= abrilAnioUltimo && Integer.parseInt(AuxMes) >= abrilMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 04)
		 					{
		 						abrilAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						abrilMesUltimo 		= Integer.parseInt(AuxMes);
		 						abrilUltimoDecreto 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= mayoAnioUltimo && Integer.parseInt(AuxMes) >= mayoMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 05)
		 					{
		 						mayoAnioUltimo 		= Integer.parseInt(AuxAnio);
		 						mayoMesUltimo 		= Integer.parseInt(AuxMes);
		 						mayoUltimoDecreto 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= junioAnioUltimo && Integer.parseInt(AuxMes) >= junioMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 06)
		 					{
		 						junioAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						junioMesUltimo 		= Integer.parseInt(AuxMes);
		 						junioUltimoDecreto 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= julioAnioUltimo && Integer.parseInt(AuxMes) >= julioMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 07)
		 					{
		 						julioAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						julioMesUltimo 		= Integer.parseInt(AuxMes);
		 						julioUltimoDecreto 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= agostoAnioUltimo && Integer.parseInt(AuxMes) >= agostoMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 8)
		 					{
		 						agostoAnioUltimo 		= Integer.parseInt(AuxAnio);
		 						agostoMesUltimo 		= Integer.parseInt(AuxMes);
		 						agostoUltimoDecreto 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= septiembreAnioUltimo && Integer.parseInt(AuxMes) >= septiembreMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 9)
		 					{
		 						septiembreAnioUltimo 		= Integer.parseInt(AuxAnio);
		 						septiembreMesUltimo 		= Integer.parseInt(AuxMes);
		 						septiembreUltimoDecreto 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= octubreAnioUltimo && Integer.parseInt(AuxMes) >= octubreMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 10)
		 					{
		 						octubreAnioUltimo 		= Integer.parseInt(AuxAnio);
		 						octubreMesUltimo 		= Integer.parseInt(AuxMes);
		 						octubreUltimoDecreto 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= noviembreAnioUltimo && Integer.parseInt(AuxMes) >= noviembreMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 11)
		 					{
		 						noviembreAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						noviembreMesUltimo 		= Integer.parseInt(AuxMes);
		 						noviembreUltimoDecreto 	= s.getSalario();
		 					}
		 					if(Integer.parseInt(AuxAnio) >= diciembreAnioUltimo && Integer.parseInt(AuxMes) >= diciembreMesUltimo
		 							 && Integer.parseInt(AuxMes)<= 12)
		 					{
		 						diciembreAnioUltimo 	= Integer.parseInt(AuxAnio);
		 						diciembreMesUltimo 		= Integer.parseInt(AuxMes);
		 						diciembreUltimoDecreto 	= s.getSalario();
		 					}
		 					
		 				}
		 				//*********************************************************************************
		 				/**
		 				 * por si cada mes no tuviera un salario en especifico, entonces se le asigna el ultimo salario calculado
		 				 * este salario para asignarle, el año debera ser menor o igual al año a calcular, y ademas el mes en 
		 				 * cuestion a asignarle el ultimo salario, el mes del ultimo salario debera ser menor o igual al mes al
		 				 * que se le va asignar el ultimo salario, en caso contrario ese mes, tendra salario = 0;
		 				 */
		 				//salario de enero
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("01") && s.getTipoSalario().equals("0"))
		 				{
		 					enero = s.getSalario();
		 					bEnero = false;
		 				}else if(bEnero)
		 				{
		 					enero = eneroUltimoSalario;
		 				}
		 				
		 				//decreto de enero
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("01") && s.getTipoSalario().equals("1") && checkDecreto.isChecked())
		 				{
		 					eneroDecreto = s.getSalario();
		 					dEnero = false;
		 				}else if(dEnero && checkDecreto.isChecked())
		 				{
		 					eneroDecreto = eneroUltimoDecreto;
		 				}
		 				
		 				//salario de febrero
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("02")&& s.getTipoSalario().equals("0"))
		 				{
		 					febrero = s.getSalario();
		 					bFebrero  = false;
		 				}else if(bFebrero)
		 				{
		 					febrero = febreroUltimoSalario;
		 				}
		 				
		 				//decreto de febrero
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("02")&& s.getTipoSalario().equals("1") && checkDecreto.isChecked())
		 				{
		 					febreroDecreto = s.getSalario();
		 					dFebrero  = false;
		 				}else if(dFebrero && checkDecreto.isChecked())
		 				{
		 					febreroDecreto = febreroUltimoDecreto;
		 				}
		 				
		 				//salario de marzo
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("03") && s.getTipoSalario().equals("0"))
		 				{
		 					marzo = s.getSalario();
		 					bMarzo  = false;
		 				}else if(bMarzo)
		 				{
		 					marzo = marzoUltimoSalario;
		 				}

		 				//decreto de marzo
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("03") && s.getTipoSalario().equals("1") && checkDecreto.isChecked())
		 				{
		 					marzoDecreto = s.getSalario();
		 					dMarzo  = false;
		 				}else if(dMarzo && checkDecreto.isChecked())
		 				{
		 					marzoDecreto = marzoUltimoDecreto;
		 				}
		 				
		 				//salario de abril
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("04") && s.getTipoSalario().equals("0"))
		 				{
		 					abril = s.getSalario();
		 					bAbril  = false;
		 				}else if(bAbril)
		 				{
		 					abril = abrilUltimoSalario;
		 				}
		 				
		 				//decreto de abril
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("04") && s.getTipoSalario().equals("1") && checkDecreto.isChecked())
		 				{
		 					abrilDecreto = s.getSalario();
		 					dAbril  = false;
		 				}else if(dAbril && checkDecreto.isChecked())
		 				{
		 					abrilDecreto = abrilUltimoDecreto;
		 				}
		 				
		 				//salario de mayo
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("05") && s.getTipoSalario().equals("0"))
		 				{
		 					mayo = s.getSalario();
		 					bMayo  = false;
		 				}else if(bMayo)
		 				{
		 					mayo = mayoUltimoSalario;
		 				}
		 				
		 				//decreto de mayo
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("05") && s.getTipoSalario().equals("1") && checkDecreto.isChecked())
		 				{
		 					mayoDecreto = s.getSalario();
		 					dMayo  = false;
		 				}else if(dMayo && checkDecreto.isChecked())
		 				{
		 					mayoDecreto = mayoUltimoDecreto;
		 				}
		 				
		 				//salario de junio
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("06") && s.getTipoSalario().equals("0"))
		 				{
		 					junio = s.getSalario();
		 					bJunio  = false;
		 				}else if(bJunio)
		 				{
		 					junio = junioUltimoSalario;
		 				}
		 				
		 				//decreto de junio
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("06") && s.getTipoSalario().equals("1") && checkDecreto.isChecked())
		 				{
		 					junioDecreto = s.getSalario();
		 					dJunio  = false;
		 				}else if(dJunio && checkDecreto.isChecked())
		 				{
		 					junioDecreto = junioUltimoDecreto;
		 				}
		 				
	
		 				//salario de julio
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("07") && s.getTipoSalario().equals("0"))
		 				{
		 					julio = s.getSalario();
		 					bJulio  = false;
		 				}else if(bJulio)
		 				{
		 					julio = julioUltimoSalario;
		 				}
		 				
		 				//Decreto de julio
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("07") && s.getTipoSalario().equals("1") && checkDecreto.isChecked())
		 				{
		 					julioDecreto = s.getSalario();
		 					dJulio  = false;
		 				}else if(dJulio && checkDecreto.isChecked())
		 				{
		 					julioDecreto = julioUltimoDecreto;
		 				}
		 				
		 				//salario de agosto
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("08") && s.getTipoSalario().equals("0"))
		 				{
		 					agosto = s.getSalario();
		 					bAgosto  = false;
		 				}else if(bAgosto)
		 				{
		 					agosto = agostoUltimoSalario;
		 				}
		 				
		 				//Decreto de agosto
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("08") && s.getTipoSalario().equals("1") && checkDecreto.isChecked())
		 				{
		 					agostoDecreto = s.getSalario();
		 					dAgosto  = false;
		 				}else if(dAgosto && checkDecreto.isChecked())
		 				{
		 					agostoDecreto = agostoUltimoDecreto;
		 				}
		 					
		 				//salario de septiembre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("09")  && s.getTipoSalario().equals("0"))
		 				{
		 					septiembre = s.getSalario();
		 					bSeptiembre  = false;
		 				}else if(bSeptiembre)
		 				{
		 					septiembre = septiembreUltimoSalario;
		 				}

	 					
		 				//Decreto de septiembre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("09")  && s.getTipoSalario().equals("1") && checkDecreto.isChecked())
		 				{
		 					septiembreDecreto = s.getSalario();
		 					dSeptiembre  = false;
		 				}else if(dSeptiembre && checkDecreto.isChecked())
		 				{
		 					septiembreDecreto = septiembreUltimoDecreto;
		 				}
		 				
	
		 				//salario de Octubre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("10") && s.getTipoSalario().equals("0"))
		 				{
		 					octubre = s.getSalario();
		 					bOctubre  = false;
		 				}else if(bOctubre)
		 				{
		 					octubre = octubreUltimoSalario;
		 				}
		 				
	
		 				//Decreto de Octubre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("10") && s.getTipoSalario().equals("1") && checkDecreto.isChecked())
		 				{
		 					octubreDecreto = s.getSalario();
		 					dOctubre  = false;
		 				}else if(dOctubre && checkDecreto.isChecked())
		 				{
		 					octubreDecreto = octubreUltimoDecreto;
		 				}
		 				
	
		 				//salario de Noviembre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("11") && s.getTipoSalario().equals("0"))
		 				{
		 					noviembre = s.getSalario();
		 					bNoviembre  = false;
		 				}else if(bNoviembre)
		 				{
		 					noviembre = noviembreUltimoSalario;
		 				}
		 				
	
		 				//Decreto de Noviembre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("11") && s.getTipoSalario().equals("1") && checkDecreto.isChecked())
		 				{
		 					noviembreDecreto = s.getSalario();
		 					dNoviembre  = false;
		 				}else if(dNoviembre && checkDecreto.isChecked())
		 				{
		 					noviembreDecreto = noviembreUltimoDecreto;
		 				}
		 				
	
		 				//salario de Diciembre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("12")  && s.getTipoSalario().equals("0"))
		 				{
		 					diciembre = s.getSalario();
		 					bDiciembre  = false;
		 				}else if(bDiciembre)
		 				{
		 					diciembre = diciembreUltimoSalario;
		 				}

		 				
		 				//Decreto de Diciembre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("12")  && s.getTipoSalario().equals("1") && checkDecreto.isChecked())
		 				{
		 					diciembreDecreto = s.getSalario();
		 					dDiciembre  = false;
		 				}else if(dDiciembre  && checkDecreto.isChecked())
		 				{
		 					diciembreDecreto = diciembreUltimoDecreto;
		 				}
		 				
	
		 				//*********************************************************************************
		 				
		 				//*********************************************************************************
		 				//bonos de enero
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("01")
		 	 				   && s.getTipoSalario().equals("3") && checkBonificacion.isChecked())
		 				{
		 					eneroBono += s.getSalario();
		 				}
		 				//bonos de febrero
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("02")
		 	 				   && s.getTipoSalario().equals("3") && checkBonificacion.isChecked())
		 				{
		 					febreroBono += s.getSalario();
		 				}
		 				//bonos de marzo
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("03")
		 	 				   && s.getTipoSalario().equals("3") && checkBonificacion.isChecked())
		 				{
		 					marzoBono += s.getSalario();
		 				}
		 				//bonos de abril
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("04")
		 	 				   && s.getTipoSalario().equals("3") && checkBonificacion.isChecked())
		 				{
		 					abrilBono += s.getSalario();
		 				}
		 				//bonos de mayo
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("05")
		 	 				   && s.getTipoSalario().equals("3") && checkBonificacion.isChecked())
		 				{
		 					mayoBono += s.getSalario();
		 				}
		 				//bonos de junio
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("06")
		 	 				   && s.getTipoSalario().equals("3") && checkBonificacion.isChecked())
		 				{
		 					junioBono += s.getSalario();
		 				}
		 				//bonos de julio
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("07")
		 	 				   && s.getTipoSalario().equals("3") && checkBonificacion.isChecked())
		 				{
		 					julioBono += s.getSalario();
		 				}
		 				//bonos de agosto
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("08")
		 	 				   && s.getTipoSalario().equals("3") && checkBonificacion.isChecked())
		 				{
		 					agostoBono += s.getSalario();
		 				}
		 				//bonos de septiembre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("09")
		 	 				   && s.getTipoSalario().equals("3") && checkBonificacion.isChecked())
		 				{
		 					septiembreBono += s.getSalario();
		 				}
		 				//bonos de octubre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("10")
		 	 				   && s.getTipoSalario().equals("3") && checkBonificacion.isChecked())
		 				{
		 					octubreBono += s.getSalario();
		 				}
		 				//bonos de noviembre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("11")
		 	 				   && s.getTipoSalario().equals("3") && checkBonificacion.isChecked())
		 				{
		 					noviembreBono += s.getSalario();
		 				}
		 				//bonos de diciembre
		 				if(AuxAnio.equals(listAnio) && AuxMes.equals("12")
		 	 				   && s.getTipoSalario().equals("3") && checkBonificacion.isChecked())
		 				{
		 					diciembreBono += s.getSalario();
		 				}
		 				//*********************************************************************************
		 				
		 				
		 			}//fin for salario
		 		}
	 			enero 		= enero + eneroBono + eneroDecreto;
	 			febrero 	= febrero + febreroBono +febreroDecreto;
	 			marzo 		= marzo + marzoBono + marzoDecreto;
	 			abril 		= abril + abrilBono + abrilDecreto;
	 			mayo 		= mayo + mayoBono + mayoDecreto;
	 			junio 		= junio + junioBono + junioDecreto;
	 			julio 		= julio + julioBono + julioDecreto;
	 			agosto 		= agosto + agostoBono + agostoDecreto;
	 			septiembre 	= septiembre + septiembreBono + septiembreDecreto;
	 			octubre 	= octubre + octubreBono + octubreDecreto;
	 			noviembre 	= noviembre + noviembreBono + noviembreDecreto;
	 			diciembre 	= diciembre + diciembreBono + diciembreDecreto;

	 			System.out.println("mes2: "+mes2);
	 			System.out.println("mes1: "+mes1);
	 			if(Integer.parseInt(mes2)>= 1 && Integer.parseInt(mes1)<=1){
	 				salarioBaseCalculo +=enero;
	 			}if(Integer.parseInt(mes2)>= 2 && Integer.parseInt(mes1)<=2){
	 				salarioBaseCalculo +=febrero;
	 			}if(Integer.parseInt(mes2)>= 3 && Integer.parseInt(mes1)<=3){
	 				salarioBaseCalculo +=marzo;
	 			}if(Integer.parseInt(mes2)>= 4 && Integer.parseInt(mes1)<=4){
	 				salarioBaseCalculo +=abril;
	 			}if(Integer.parseInt(mes2)>= 5 && Integer.parseInt(mes1)<=5){
	 				salarioBaseCalculo +=mayo;
	 			}if(Integer.parseInt(mes2)>= 6 && Integer.parseInt(mes1)<=6){
	 				salarioBaseCalculo +=junio;
	 			}if(Integer.parseInt(mes2)>= 7 && Integer.parseInt(mes1)<=7){
	 				salarioBaseCalculo +=julio;
	 			}if(Integer.parseInt(mes2)>= 8 && Integer.parseInt(mes1)<=8){
	 				salarioBaseCalculo +=agosto;
	 			}if(Integer.parseInt(mes2)>= 9 && Integer.parseInt(mes1)<=9){
	 				salarioBaseCalculo +=septiembre;
	 			}if(Integer.parseInt(mes2)>= 10 && Integer.parseInt(mes1)<=10){
	 				salarioBaseCalculo +=octubre;
	 			}if(Integer.parseInt(mes2)>= 11 && Integer.parseInt(mes1)<=11){
	 				salarioBaseCalculo +=noviembre;
	 			}if(Integer.parseInt(mes2)>= 12 && Integer.parseInt(mes1)<=12){
	 				salarioBaseCalculo +=diciembre;
	 			}

		        int dias			= (int) ((dateFecha2.getValue().getTime()-dateFecha1.getValue().getTime())/(1000*60*60*24)); 
	 			System.out.println(salarioBaseCalculo+" / " +mes2);
	 			salarioBaseCalculo=  salarioBaseCalculo / Integer.parseInt(mes2);
	 			
	 			if(tipo.equals("1") || tipo.equals("2") || tipo.equals("3") || tipo.equals("9")){
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, txtDescripcion.getText(),nombre
	 						,""+Cantidad.getText(), "1", "1",dateFecha.getValue());
	 			}if(tipo.equals("4")){
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, "Bono 14 del año: "+listAnio,nombre
	 						,""+salarioBaseCalculo, ""+dias, "365",dateFecha.getValue());
	 			}if(tipo.equals("5")){
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, "Aguinaldo del año: "+listAnio,nombre
	 						,""+salarioBaseCalculo, ""+dias, "365",dateFecha.getValue());
	 			}if(tipo.equals("7")){
	 				nuevo.agregarFormulario(e.getId_empleado(), tipo, "Indemnizacion del año: "+listAnio,nombre
	 						,""+salarioBaseCalculo, "14", "12",dateFecha.getValue());
	 			}
 			salarioBaseCalculo = 0;
 			enero = 0;
 			febrero = 0;
 			marzo = 0;
 			abril = 0;
 			mayo = 0;
 			junio = 0;
 			julio = 0;
 			agosto = 0;
 			septiembre = 0;
 			octubre = 0;
 			noviembre = 0;
 			diciembre = 0;
 			
 			eneroBono = 0;
 			febreroBono = 0;
 			marzoBono = 0;
 			abrilBono = 0;
 			mayoBono = 0;
 			junioBono = 0;
 			julioBono = 0;
 			agostoBono = 0;
 			septiembreBono = 0;
 			octubreBono = 0;
 			noviembreBono = 0;
 			diciembreBono = 0;
	 			

	 		 bEnero = true;
	 		 bFebrero = true;
	 		 bMarzo	= true;
	 		 bAbril = true;
	 		 bMayo = true;
	 		 bJunio = true;
	 		 bJulio = true;
	 		 bAgosto = true;
	 		 bSeptiembre = true;
	 		 bOctubre = true;
	 		 bNoviembre = true;
	 		 bDiciembre = true;
	 		 
	 		 dEnero = true;
	 		 dFebrero = true;
	 		 dMarzo	= true;
	 		 dAbril = true;
	 		 dMayo = true;
	 		 dJunio = true;
	 		 dJulio = true;
	 		 dAgosto = true;
	 		 dSeptiembre = true;
	 		 dOctubre = true;
	 		 dNoviembre = true;
	 		 dDiciembre = true;

	 		 eneroUltimoSalario = 0;
	 		 febreroUltimoSalario = 0;
	 		 marzoUltimoSalario = 0;
	 		 abrilUltimoSalario = 0;
	 		 mayoUltimoSalario = 0;
	 		 junioUltimoSalario = 0;
	 		 julioUltimoSalario = 0;
	 		 agostoUltimoSalario = 0;
	 		 septiembreUltimoSalario = 0;
	 		 octubreUltimoSalario = 0;
	 		 noviembreUltimoSalario = 0;
	 		 diciembreUltimoSalario = 0;

	 		 eneroUltimoDecreto = 0;
	 		 febreroUltimoDecreto = 0;
	 		 marzoUltimoDecreto = 0;
	 		 abrilUltimoDecreto = 0;
	 		 mayoUltimoDecreto = 0;
	 		 junioUltimoDecreto = 0;
	 		 julioUltimoDecreto = 0;
	 		 agostoUltimoDecreto = 0;
	 		 septiembreUltimoDecreto = 0;
	 		 octubreUltimoDecreto = 0;
	 		 noviembreUltimoDecreto = 0;
	 		 diciembreUltimoDecreto = 0;
	 		
	 		 eneroAnioUltimo = 0;
	 		 febreroAnioUltimo = 0;
	 		 marzoAnioUltimo = 0;
	 		 abrilAnioUltimo = 0;
	 		 mayoAnioUltimo = 0;
	 		 junioAnioUltimo = 0;
	 		 julioAnioUltimo = 0;
	 		 agostoAnioUltimo = 0;
	 		 septiembreAnioUltimo = 0;
	 		 octubreAnioUltimo = 0;
	 		 noviembreAnioUltimo = 0;
	 		 diciembreAnioUltimo = 0;
	 		
	 		 eneroMesUltimo = 0;
	 		 febreroMesUltimo = 0;
	 		 marzoMesUltimo = 0;
	 		 abrilMesUltimo = 0;
	 		 mayoMesUltimo = 0;
	 		 junioMesUltimo = 0;
	 		 julioMesUltimo = 0;
	 		 agostoMesUltimo = 0;
	 		 septiembreMesUltimo = 0;
	 		 octubreMesUltimo = 0;
	 		 noviembreMesUltimo = 0;
	 		 diciembreMesUltimo = 0;

	 		 AuxAnio 	= "";
	 		 AuxMes 	= "";
	 		}//fin for empleado

	        load.invisible();
	 	}
	 	
	 	MultiWordSuggestOracle createCountriesOracle()
		{
		    final MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
		    
		    recursosHumanosService.Buscar_Empleado('2', "", "", 
		    		"", "","", "","",new AsyncCallback<List<AuxEmpleado>>(){
			    public void onFailure(Throwable caught) 
			    {
			        load.invisible();
			    }
			
				@Override
			    public void onSuccess( List<AuxEmpleado> result)
			    {
					for(AuxEmpleado p : result) 
					{
						oracle.add(p.getPrimer_nombre()+" "+p.getSegundo_nombre()+" "+p.getPrimer_apellido()+" "+p.getSegundo_apellido());
					}
			    }
			
			});
		    return oracle;
	    }
}
