package org.habitatguate.hgerp.seguridad.service.jdo;


import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegEntrevista implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key id_entrevista;
	
	@Persistent
    private Date fecha_entrevista;
	
	@Persistent
    private String que_conoces;   
	
	@Persistent
    private String por_que_trabajas_aqui;

	@Persistent
    private String como_se_describe;  
	
	@Persistent
    private String trabajar_por_presion; 
	
	@Persistent
    private String metas;    
	
	@Persistent
    private boolean Disponibilidad_inmediata; 
	
	@Persistent
    private boolean disposicion_a_viajar; 
	
	@Persistent
    private boolean flexibilidad_horario;
	
	@Persistent
    private float pretencion_salarial_minimo;  
	
	@Persistent
    private boolean antecedentes_penales;
	
	@Persistent
    private boolean antecedentes_policiacos;
	
	@Persistent
    private boolean carta_recomendacion_laboral; 
	
	@Persistent
    private boolean carta_recomendacion_personal;  
	
	@Persistent
    private boolean vive_con_familia; 
	
	@Persistent
    private boolean casa_propia; 
	
	@Persistent
    private String entrevisto;
	
	@Persistent
    private String enfermedades;
	
	@Persistent
    private float aporte_casa;
	
	@Persistent
    private boolean tiene_deudas;

	@Persistent
    private float amortizacion;
	
	@Persistent
    private int no_dependientes;
	
	@Persistent
    private String empresa_credito;
	
	@Persistent
    private boolean alquila;
	
	@Persistent
    private float pago_alquiler;

	@Persistent
    private String Otros_Ingresos;
	

	@Persistent
	private String txtEntrevistoB;
	@Persistent
	private String  txtEntrevistoC;
	@Persistent
	private String  txtEntrevistoD;
	@Persistent
	private String  txtObservacion1;
	@Persistent
	private String  txtObservacion2;
	@Persistent
	private String  txtObservacion3;
	@Persistent
	private String  txtObservacion4;
	@Persistent
	private String  txtObservacion5;
	@Persistent
	private Date dateFechaDeudaInicio;
	@Persistent
	private Date dateFechaDeudaFinal;
	@Persistent
	private String motivoDeuda;
	@Persistent
	private String listDeudas ;

	@Persistent
    private SegEmpleado empleado;

	public SegEntrevista() {
		super();
	}

	public Key getId_entrevista() {
		return id_entrevista;
	}

	public void setId_entrevista(Key id_entrevista) {
		this.id_entrevista = id_entrevista;
	}

	public Date getFecha_entrevista() {
		return fecha_entrevista;
	}

	public void setFecha_entrevista(Date fecha_entrevista) {
		this.fecha_entrevista = fecha_entrevista;
	}

	
	public float getAmortizacion() {
		return amortizacion;
	}

	public void setAmortizacion(float amortizacion) {
		this.amortizacion = amortizacion;
	}

	
	public String getQue_conoces() {
		return que_conoces;
	}

	public void setQue_conoces(String que_conoces) {
		this.que_conoces = que_conoces;
	}

	public String getPor_que_trabajas_aqui() {
		return por_que_trabajas_aqui;
	}

	public void setPor_que_trabajas_aqui(String por_que_trabajas_aqui) {
		this.por_que_trabajas_aqui = por_que_trabajas_aqui;
	}

	public String getComo_se_describe() {
		return como_se_describe;
	}

	public void setComo_se_describe(String como_se_describe) {
		this.como_se_describe = como_se_describe;
	}

	public String getTrabajar_por_presion() {
		return trabajar_por_presion;
	}

	public void setTrabajar_por_presion(String trabajar_por_presion) {
		this.trabajar_por_presion = trabajar_por_presion;
	}

	public String getMetas() {
		return metas;
	}

	public void setMetas(String metas) {
		this.metas = metas;
	}

	public boolean getDisponibilidad_inmediata() {
		return Disponibilidad_inmediata;
	}

	public void setDisponibilidad_inmediata(boolean disponibilidad_inmediata) {
		Disponibilidad_inmediata = disponibilidad_inmediata;
	}

	public boolean getDisposicion_a_viajar() {
		return disposicion_a_viajar;
	}

	public void setDisposicion_a_viajar(boolean disposicion_a_viajar) {
		this.disposicion_a_viajar = disposicion_a_viajar;
	}

	public boolean getFlexibilidad_horario() {
		return flexibilidad_horario;
	}

	public void setFlexibilidad_horario(boolean flexibilidad_horario) {
		this.flexibilidad_horario = flexibilidad_horario;
	}

	public float getPretencion_salarial_minimo() {
		return pretencion_salarial_minimo;
	}

	public void setPretencion_salarial_minimo(float pretencion_salarial_minimo) {
		this.pretencion_salarial_minimo = pretencion_salarial_minimo;
	}

	public boolean getAntecedentes_penales() {
		return antecedentes_penales;
	}

	public void setAntecedentes_penales(boolean antecedentes_penales) {
		this.antecedentes_penales = antecedentes_penales;
	}

	public boolean getAntecedentes_policiacos() {
		return antecedentes_policiacos;
	}

	public void setAntecedentes_policiacos(boolean antecedentes_policiacos) {
		this.antecedentes_policiacos = antecedentes_policiacos;
	}

	public boolean getCarta_recomendacion_laboral() {
		return carta_recomendacion_laboral;
	}

	public void setCarta_recomendacion_laboral(boolean carta_recomendacion_laboral) {
		this.carta_recomendacion_laboral = carta_recomendacion_laboral;
	}

	public boolean getCarta_recomendacion_personal() {
		return carta_recomendacion_personal;
	}

	public void setCarta_recomendacion_personal(boolean carta_recomendacion_personal) {
		this.carta_recomendacion_personal = carta_recomendacion_personal;
	}

	public boolean getVive_con_familia() {
		return vive_con_familia;
	}

	public void setVive_con_familia(boolean vive_con_familia) {
		this.vive_con_familia = vive_con_familia;
	}

	public boolean getCasa_propia() {
		return casa_propia;
	}

	public void setCasa_propia(boolean casa_propia) {
		this.casa_propia = casa_propia;
	}

	public String getEntrevisto() {
		return entrevisto;
	}

	public void setEntrevisto(String entrevisto) {
		this.entrevisto = entrevisto;
	}

	public String getEnfermedades() {
		return enfermedades;
	}

	public void setEnfermedades(String enfermedades) {
		this.enfermedades = enfermedades;
	}

	public float getAporte_casa() {
		return aporte_casa;
	}

	public void setAporte_casa(float aporte_casa) {
		this.aporte_casa = aporte_casa;
	}

	public boolean getTiene_deudas() {
		return tiene_deudas;
	}

	public void setTiene_deudas(boolean tiene_deudas) {
		this.tiene_deudas = tiene_deudas;
	}

	public int getNo_dependientes() {
		return no_dependientes;
	}

	public void setNo_dependientes(int no_dependientes) {
		this.no_dependientes = no_dependientes;
	}

	public String getEmpresa_credito() {
		return empresa_credito;
	}

	public void setEmpresa_credito(String empresa_credito) {
		this.empresa_credito = empresa_credito;
	}

	public boolean getAlquila() {
		return alquila;
	}

	public void setAlquila(boolean alquila) {
		this.alquila = alquila;
	}

	public float getPago_alquiler() {
		return pago_alquiler;
	}

	public void setPago_alquiler(float pago_alquiler) {
		this.pago_alquiler = pago_alquiler;
	}

	public String getOtros_Ingresos() {
		return Otros_Ingresos;
	}

	public void setOtros_Ingresos(String otros_Ingresos) {
		Otros_Ingresos = otros_Ingresos;
	}

	public SegEmpleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(SegEmpleado empleado) {
		this.empleado = empleado;
	}

	public String getTxtEntrevistoB() {
		return txtEntrevistoB;
	}

	public void setTxtEntrevistoB(String txtEntrevistoB) {
		this.txtEntrevistoB = txtEntrevistoB;
	}

	public String getTxtEntrevistoC() {
		return txtEntrevistoC;
	}

	public void setTxtEntrevistoC(String txtEntrevistoC) {
		this.txtEntrevistoC = txtEntrevistoC;
	}

	public String getTxtEntrevistoD() {
		return txtEntrevistoD;
	}

	public void setTxtEntrevistoD(String txtEntrevistoD) {
		this.txtEntrevistoD = txtEntrevistoD;
	}

	public String getTxtObservacion1() {
		return txtObservacion1;
	}

	public void setTxtObservacion1(String txtObservacion1) {
		this.txtObservacion1 = txtObservacion1;
	}

	public String getTxtObservacion2() {
		return txtObservacion2;
	}

	public void setTxtObservacion2(String txtObservacion2) {
		this.txtObservacion2 = txtObservacion2;
	}

	public String getTxtObservacion3() {
		return txtObservacion3;
	}

	public void setTxtObservacion3(String txtObservacion3) {
		this.txtObservacion3 = txtObservacion3;
	}

	public String getTxtObservacion4() {
		return txtObservacion4;
	}

	public void setTxtObservacion4(String txtObservacion4) {
		this.txtObservacion4 = txtObservacion4;
	}

	public String getTxtObservacion5() {
		return txtObservacion5;
	}

	public void setTxtObservacion5(String txtObservacion5) {
		this.txtObservacion5 = txtObservacion5;
	}

	public Date getDateFechaDeudaInicio() {
		return dateFechaDeudaInicio;
	}

	public void setDateFechaDeudaInicio(Date dateFechaDeudaInicio) {
		this.dateFechaDeudaInicio = dateFechaDeudaInicio;
	}

	public Date getDateFechaDeudaFinal() {
		return dateFechaDeudaFinal;
	}

	public void setDateFechaDeudaFinal(Date dateFechaDeudaFinal) {
		this.dateFechaDeudaFinal = dateFechaDeudaFinal;
	}

	public String getMotivoDeuda() {
		return motivoDeuda;
	}

	public void setMotivoDeuda(String motivoDeuda) {
		this.motivoDeuda = motivoDeuda;
	}

	public String getListDeudas() {
		return listDeudas;
	}

	public void setListDeudas(String listDeudas) {
		this.listDeudas = listDeudas;
	}
	 
	
	
}
