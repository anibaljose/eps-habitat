
package org.habitatguate.hgerp.seguridad.client.api;

import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudEncuestaSatisfaccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSituacionEconomica;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface SolucionesConstruidasServiceAsync {
	
// DATOS SOLICITANTE	
	
	void ingresarDatosSolicitante(Long idEmpleado, Long idAfiliado, String usrName,
			Date fecrec, 
			String nombreSolicitante, String estadoCivil, int edad, String nacionalidad, 
			String profesionOficio, String dpi, int dpiUnico, int dpiReferencia, String actividadEconomica,
			Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar, 
			String direccionActual, String direccionSolucion, 
			Boolean camion, Boolean carro, Boolean peatonal,
			String lugarTrabajoSolicitante, int telefonoCasaSolicitante, int telefonoTrabajoSolicitante,
			String solucionConstruir, float cuotaPagar,
			String nombreConyuge, int telefonoConyuge, String lugarTrabajoConyuge, int telefonoTrabajoConyuge,
			Boolean creditoAprobado, Boolean creditoNoAprobado, float montoAprobado, String observacionNoAprobado,
			Boolean primeraSupervision, Boolean segundaSupervision, Boolean terceraSupervision, Boolean cuartaSupervision, 
			String aldeaDireccionActual, String aldeaDireccionSolucion,
			String departamentoMunicipioDireccionActual, String departamentoMunicipioDireccionSolucion,
			String direccionLugarTrabajoSolicitante, String direccionLugarTrabajoConyuge,
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	
	 void actualizarDatosSolicitante(Long idFormulario, Long idEmpleado, Long idAfiliado, String usrName,
			 	Date fecupdate,
			 	String nombreSolicitante, String estadoCivil, int edad, String nacionalidad, 
				String profesionOficio, String dpi, int dpiUnico, int dpiReferencia, String actividadEconomica,
				Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar, 
				String direccionActual, String direccionSolucion, 
				Boolean camion, Boolean carro, Boolean peatonal,
				String lugarTrabajoSolicitante, int telefonoCasaSolicitante, int telefonoTrabajoSolicitante,
				String solucionConstruir, float cuotaPagar,
				String nombreConyuge, int telefonoConyuge, String lugarTrabajoConyuge, int telefonoTrabajoConyuge,
				String aldeaDireccionActual, String aldeaDireccionSolucion,
				String departamentoMunicipioDireccionActual, String departamentoMunicipioDireccionSolucion,
				String direccionLugarTrabajoSolicitante, String direccionLugarTrabajoConyuge,
				AsyncCallback<Long> callback) throws IllegalArgumentException;	

// CARGAS FAMILIARES

	 void ingresarCargaFamiliar(Date fecrec, Long idFormulario, 
			 String nombreFamiliar, int edadFamiliar, String escolaridadFamiliar, String ocupacionFamiliar,
			 AsyncCallback<Long> callback) throws IllegalArgumentException;

	 void actualizarCargaFamiliar(Long idFormulario, Long idReferenciaFamiliar,
			 String nombreFamiliar, int edadFamiliar, 
			 String escolaridadFamiliar, String ocupacionFamiliar,
			 AsyncCallback<Long> callback)  throws IllegalArgumentException;	

	 void eliminarCargaFamiliar(Long idFormulario, Long id, AsyncCallback<Long> callback) throws IllegalArgumentException;		 
	 
// REFERENCIAS FAMILIARES
	 
	void ingresarReferenciaFamiliar(Date fecrec, Long idFormulario, 
			String nombreFamiliar, int edadFamiliar, String escolaridadFamiliar, String ocupacionFamiliar,
			AsyncCallback<Long> callback) throws IllegalArgumentException;

	void actualizarReferenciaFamiliar(Long idFormulario, Long idReferenciaFamiliar,
			 String nombreFamiliar, int telefonoFamiliar, 
			 String parentescoFamiliar, String direccionFamiliar,
				AsyncCallback<Long> callback)  throws IllegalArgumentException;	
	
	void eliminarReferenciaFamiliar(Long idFormulario, Long id, AsyncCallback<Long> callback) throws IllegalArgumentException;	
	
// DATOS VIVIENDA ACTUAL	
	
	void ingresarDatosVivienda(Date fecrec, Long idFormulario, 
			String datosVivienda, String otroDatosVivienda,
			String techo, String pared, String cocina,
			Boolean servicioAgua, Boolean servicioDrenaje, Boolean servicioElectricidad, Boolean servicioSanitario, 
			String bienesInmuebles, float valorInmuebles,
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	
	void actualizarDatosViviendaActual(Long idFormulario, Long idDatosVivienda,
			String datosVivienda, String otroDatosVivienda,
			String techo, String pared, String cocina,
			Boolean servicioAgua, Boolean servicioDrenaje, Boolean servicioElectricidad, Boolean servicioSanitario, 
			String bienesInmuebles, float valorInmuebles,
			AsyncCallback<Long> callback) throws IllegalArgumentException;		
	
// SITUACION ECONOMICA

	void ingresarSituacionEconomica(Date fecrec, Long idFormulario, 
			float ingresosSolicitante, float ingresosConyuge, float otrosIngresos, float ingresosTotales,
			float totalIngresos, float totalEgresos, float diferencia, float pagosBuro, float cuota, float excedente,
			float alquilerVivienda, float alimentacion, float ropa, float gastosMedicos, float transporte, float educacion,
			float pagoLuzAgua, float pagoPrestamos, float otrosGastos1, float otrosGastos2, float egresosTotales,
			AsyncCallback<Long> callback) throws IllegalArgumentException;	
	
	void actualizarSituacionEconomica(Long idFormulario, Long idDatosVivienda,
			float ingresosSolicitante, float ingresosConyuge, float otrosIngresos, float ingresosTotales,
			float totalIngresos, float totalEgresos, float diferencia, float pagosBuro, float cuota, float excedente,
			float alquilerVivienda, float alimentacion, float ropa, float gastosMedicos, float transporte, float educacion,
			float pagoLuzAgua, float pagoPrestamos, float otrosGastos1, float otrosGastos2, float egresosTotales,
			AsyncCallback<Long> callback) throws IllegalArgumentException;		
	
// GARANTIA HIPOTECARIA
	
	void ingresarGarantiaHipotecaria(Date fecrec, Long idFormulario, 
			String escrituraNoRegistrada, String escrituraRegistrada, String folio, String libro, String finca,
			String nombreNotario, float areaTerreno, float valorTerreno,
			Boolean checkSi, Boolean checkNo,
			String nombrePersona, int telefonoPersona,
			String numDpiPersona, String direccionTerrenoPersona, String aldeaPersona, String departamentoMunicipioDireccionPersona,
			String direccionTerrenoGarantia, String aldeaGarantia, String departamentoMunicipioDireccionGarantia,
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	
	void actualizarGarantiaHipotecaria(Long idFormulario, Long idGarantiaHipotecaria,
			String escrituraNoRegistrada, String escrituraRegistrada, String folio, String libro, String finca,
			String nombreNotario, float areaTerreno, float valorTerreno,
			Boolean checkSi, Boolean checkNo,
			String nombrePersona, int telefonoPersona,
			String numDpiPersona, String direccionTerrenoPersona, String aldeaPersona, String departamentoMunicipioDireccionPersona,
			String direccionTerrenoGarantia, String aldeaGarantia, String departamentoMunicipioDireccionGarantia,
			AsyncCallback<Long> callback)  throws IllegalArgumentException;
	
	// GARANTIA FIDUCIARIA

	void ingresarGarantiaFiduciaria(Date fecrec, Long idFormulario, 
			String nombre, String numDpi, 
			String estadoCivil, int edad, String nacionalidad,
			String actividad,
			Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar,
			String direccionActual, String lugarTrabajo,
			int telefonoCasa, int telefonoTrabajo,
			String profesionOficio, String direccionLugarTrabajo, String correo,
			int numeroCelular, String telefonoInternacional,
			AsyncCallback<Long> callback) throws IllegalArgumentException;

	void actualizarGarantiaFiduciaria(Long idFormulario, Long idGarantiaHipotecaria,
			String nombre, String numDpi, 
			String estadoCivil, int edad, String nacionalidad,
			String actividad,
			Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar,
			String direccionActual, String lugarTrabajo,
			int telefonoCasa, int telefonoTrabajo,
			String profesionOficio, String direccionLugarTrabajo, String correo,
			int numeroCelular, String telefonoInternacional,
			AsyncCallback<Long> callback)  throws IllegalArgumentException;
	
	void eliminarGarantiaFiduciaria(Long idFormulario, Long id, AsyncCallback<Long> callback) throws IllegalArgumentException;
	
// GARANTIA GRUPO SOLIDARIO

	 void ingresarGarantiaSolidario(Date fecrec, Long idFormulario, 
			 String nombre, String numDpi, 
				String estadoCivil, int edad, String nacionalidad,
				String actividad,
				Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar,
				String direccionActual, String lugarTrabajo,
				int telefonoCasa, int telefonoTrabajo,
				String profesionOficio, String direccionLugarTrabajo, String correo,
				int numeroCelular, String telefonoInternacional,
			 AsyncCallback<Long> callback) throws IllegalArgumentException;

	 void actualizarGarantiaSolidario(Long idFormulario, Long idGarantiaSolidario,
			 String nombre, String numDpi, 
				String estadoCivil, int edad, String nacionalidad,
				String actividad,
				Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar,
				String direccionActual, String lugarTrabajo,
				int telefonoCasa, int telefonoTrabajo,
				String profesionOficio, String direccionLugarTrabajo, String correo,
				int numeroCelular, String telefonoInternacional,
			 AsyncCallback<Long> callback)  throws IllegalArgumentException;	

	 void eliminarGarantiaSolidario(Long idFormulario, Long id, AsyncCallback<Long> callback) throws IllegalArgumentException;	
	
// SUPERVISION PRIMERA
	
	void ingresarSupervisionPrimera(Date fecrec, Long idFormulario, 
			Date fechaVisita,
			Boolean checkSi, Boolean checkNo,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	
	void actualizarSupervisionPrimera(Long idFormulario, Long idSupervisionPrimera,
			Date fechaVisita,
			Boolean checkSi, Boolean checkNo,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;		

// SUPERVISION SEGUNDA

	void ingresarSupervisionSegunda(Date fecrec, Long idFormulario, 
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;

	void actualizarSupervisionSegunda(Long idFormulario, Long idSupervisionSegunda,
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;		
	
// SUPERVISION TERCERA

	void ingresarSupervisionTercera(Date fecrec, Long idFormulario, 
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;

	void actualizarSupervisionTercera(Long idFormulario, Long idSupervisionTercera,
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;		
	
	// SUPERVISION CUARTA

	void ingresarSupervisionCuarta(Date fecrec, Long idFormulario, 
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;

	void actualizarSupervisionCuarta(Long idFormulario, Long idSupervisionCuarta,
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;		
	
	// SUPERVISION UBICACION

	void ingresarSupervisionUbicacion(Date fecrec, Long idFormulario, 
			String latitud, String longitud,
			AsyncCallback<Long> callback) throws IllegalArgumentException;

	void actualizarSupervisionUbicacion(Long idFormulario, Long idSupervisionUbicacion,
			String latitud, String longitud,
			AsyncCallback<Long> callback) throws IllegalArgumentException;		
	
	// ENCUESTA SATISFACCION

	void ingresarEncuestaSatisfaccion(Date fecrec, Long idFormulario, 
			String preguntaNo1, String preguntaNo2, String preguntaNo3, String preguntaNo4,
			String preguntaNo5, String preguntaNo6, String preguntaNo7, String preguntaNo8,
			String preguntaNo9, String preguntaNo10, String preguntaNo11, String preguntaNo12,
			String preguntaNo13, String preguntaNo14, String preguntaNo15, String preguntaNo16,
			String departamento,
			AsyncCallback<Long> callback) throws IllegalArgumentException;	
	
	void actualizarEncuestaSatisfaccion(Long idFormulario, Long idEncuestaSatisfaccion,
			String preguntaNo1, String preguntaNo2, String preguntaNo3, String preguntaNo4,
			String preguntaNo5, String preguntaNo6, String preguntaNo7, String preguntaNo8,
			String preguntaNo9, String preguntaNo10, String preguntaNo11, String preguntaNo12,
			String preguntaNo13, String preguntaNo14, String preguntaNo15, String preguntaNo16,
			String departamento,
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	
	// BURO CREDITO
	
	void actualizarDatosAprobacionBuroCredito(Long idFormulario, 
			Boolean aprobacion, Boolean creditoNoAprobado, float montoAprobado, String observacionNoAprobado,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	
    // SOLUCIONES
 
	void buscarFormulario(char tipo, Long idEmpleado, Long idAfiliado, String nombreSolicitante, String solucionConstruir,
			AsyncCallback<List<AuxSolicitudGeneral>> callback) throws IllegalArgumentException;
    
	void obtenerDataFormularioRegistrado(Long idFormulario, AsyncCallback<AuxSolicitudGeneral> callback)throws IllegalArgumentException;
	 
	void consultaEncuestaSatisfaccion(Long idFormulario, Long idEncuestaSatisfaccion, AsyncCallback<AuxSolicitudEncuestaSatisfaccion> callback)throws IllegalArgumentException;

	void consultaEmpleadoRegistrado(Long idEmpleado, AsyncCallback<AuxEmpleado> callback)throws IllegalArgumentException;
	
	void consultaEmpleadoAsignacion(String idEmpleado, AsyncCallback<AuxEmpleado> callback)throws IllegalArgumentException;
	
	void asignarSolicitud(Long idFormulario, Long idEmpleado, String usrName, AsyncCallback<String> callback)throws IllegalArgumentException;
	
	void consultaSituacionEconomica(Long idFormulario, Long idSituacionEconomica, AsyncCallback<AuxSolicitudSituacionEconomica> callback)throws IllegalArgumentException;
	
	// Remover imagen de Blobstore
	 
	 void remove(String fileURL,AsyncCallback<String> callback)throws IllegalArgumentException;

}
