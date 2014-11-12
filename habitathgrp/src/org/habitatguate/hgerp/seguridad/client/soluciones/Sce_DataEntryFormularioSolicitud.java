 /**
 * 
 */
package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudCargaFamiliar;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudDatosVivienda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudReferenciaFamiliar;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSituacionEconomica;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;

public class Sce_DataEntryFormularioSolicitud extends Composite {

	public Long idFormulario = 0L;
	private Sce_DataFormularioSolicitud fd1;
	private Sce_DataEntryCargasFamiliares fd3;
	private Sce_DataEntryDatosVivienda fd4;
	private Sce_DataEntrySituacionEconomica fd5;
	private Sce_DataEntryReferenciasFamiliares fd6;
	
	public Sce_DataEntryFormularioSolicitud() {
		
		tabPanel = new TabPanel();
		tabPanel.setSize("100%", "100%");
		initWidget(tabPanel);
		
		// 1. Datos generales solicitante
		scrollPanel1 = new ScrollPanel();
		scrollPanel1.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel1, "Datos del solicitante", true);
		scrollPanel1.setSize("100%", "100%");
		fd1 = new Sce_DataFormularioSolicitud(this);
		scrollPanel1.setWidget(fd1);	
		
	}

	public void NuevasPestanas() {

		// 3. Carga Familiares
		scrollPanel3 = new ScrollPanel();
		scrollPanel3.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel3, "Carga Familiares", true);
		scrollPanel3.setSize("100%", "1000px");
		fd3 = new Sce_DataEntryCargasFamiliares(this);
		scrollPanel3.setWidget(fd3);	

		// 4. Datos Vivienda Actual
		scrollPanel4 = new ScrollPanel();
		scrollPanel4.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel4, "Situacion Vivienda Actual", true);
		scrollPanel4.setSize("100%", "100%");
		fd4 = new Sce_DataEntryDatosVivienda(this);
		scrollPanel4.setWidget(fd4);

		// 5. Situacion economica familiar

		scrollPanel5 = new ScrollPanel();
		scrollPanel5.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel5, "Situacion Economica",true);
		scrollPanel5.setSize("100%", "100%");
		fd5 = new Sce_DataEntrySituacionEconomica(this);
		scrollPanel5.setWidget(fd5);	

		// 6. Referencias Familiares
		
		scrollPanel6 = new ScrollPanel();
		scrollPanel6.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel6, "Referencias Familiares",true);
		scrollPanel6.setSize("100%", "100%");
		fd6 = new Sce_DataEntryReferenciasFamiliares(this);
		scrollPanel6.setWidget(fd6);	

	}
	
	// Referencia para Carga de Data
	
	public void setDataSolicitud(AuxSolicitudGeneral r) {

		this.idFormulario = r.getIdFormulario();
		fd1.LlenarDatos(r.getIdFormulario(), 
				r.getNombreSolicitante(), r.getEstadoCivil(), r.getEdad(), r.getNacionalidad(),
				r.getProfesionOficio(), r.getNumDpi(), r.getNumDpiUnico(), r.getNumDpiReferencia(), r.getActividadEconomica(),
				r.getCheckLeer(), r.getCheckEscribir(), r.getCheckFirmar(),
				r.getDireccionActual(), r.getDireccionSolucion(),
				r.getCheckCamion(), r.getCheckCarro(), r.getCheckPeatonal(),
				r.getLugarTrabajoSolicitante(), r.getTelefonoCasaSolicitante(), r.getTelefonoTrabajoSolicitante(),
				r.getSolucionConstruir(), r.getCuotaPagar(),
				r.getNombreConyuge(), r.getTelefonoConyuge(), r.getLugarTrabajoConyuge(), r.getTelefonoTrabajoConyuge()
				);
	}
	
	public void setDataCargaFamiliar(List<AuxSolicitudCargaFamiliar> results) {
		fd3.setDataCargasFamiliares(results);
	}

	public void setDataDatosVivienda(List<AuxSolicitudDatosVivienda> results) {
		fd4.setDataDatosVivienda(results);
	}

	public void setDataSituacionEconomica(List<AuxSolicitudSituacionEconomica> results) {
		fd5.setDataSituacionEconomica(results);
	}
	
	public void setDataReferenciaFamiliar(List<AuxSolicitudReferenciaFamiliar> results) {
		fd6.setDataReferenciaFamiliar(results);
	}
	
	// --- ELEMENTOS
	
	private TabPanel tabPanel;
	
	public TabPanel getTabPanel() {
		return tabPanel;
	}

	public void setTabPanel(TabPanel tabPanel) {
		this.tabPanel = tabPanel;
	}

	private ScrollPanel scrollPanel1;
	
	public ScrollPanel getScrollPanel1() {
		return scrollPanel1;
	}

	public void setScrollPanel1(ScrollPanel scrollPanel1) {
		this.scrollPanel1 = scrollPanel1;
	}

	private ScrollPanel scrollPanel2;
	
	public ScrollPanel getScrollPanel2() {
		return scrollPanel2;
	}

	public void setScrollPanel2(ScrollPanel scrollPanel2) {
		this.scrollPanel2 = scrollPanel2;
	}

	private ScrollPanel scrollPanel3;
	
	public ScrollPanel getScrollPanel3() {
		return scrollPanel3;
	}

	public void setScrollPanel3(ScrollPanel scrollPanel3) {
		this.scrollPanel3 = scrollPanel3;
	}	
	
	private ScrollPanel scrollPanel4;
	
	public ScrollPanel getScrollPanel4() {
		return scrollPanel4;
	}

	public void setScrollPanel4(ScrollPanel scrollPanel4) {
		this.scrollPanel4 = scrollPanel4;
	}

	private ScrollPanel scrollPanel5;
	
	public ScrollPanel getScrollPanel5() {
		return scrollPanel5;
	}

	public void setScrollPanel5(ScrollPanel scrollPanel5) {
		this.scrollPanel5 = scrollPanel5;
	}

	private ScrollPanel scrollPanel6;

	public ScrollPanel getScrollPanel6() {
		return scrollPanel6;
	}

	public void setScrollPanel6(ScrollPanel scrollPanel6) {
		this.scrollPanel6 = scrollPanel6;
	}
	
}