package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.DoubleBox;

public class formulario_entrevista extends Composite {

	public formulario_entrevista() {
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("700px", "1090px");
		
		Label lblNivelAcademico = new Label("Informe Entrevista");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 115, 10);
		lblNivelAcademico.setSize("456px", "13px");
		
		TextArea txtQueConoces = new TextArea();
		txtQueConoces.getElement().setAttribute("maxlength", "500");
		txtQueConoces.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtQueConoces, 10, 48);
		txtQueConoces.setSize("318px", "61px");
		
		Label lblQueConoce = new Label("1. Qué conoces de la Fundación?");
		lblQueConoce.setStyleName("label");
		absolutePanel.add(lblQueConoce, 10, 29);
		lblQueConoce.setSize("338px", "13px");
		
		TextArea txtPorque_Trabajar = new TextArea();
		txtPorque_Trabajar.getElement().setAttribute("maxlength", "500");
		txtPorque_Trabajar.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPorque_Trabajar, 379, 48);
		txtPorque_Trabajar.setSize("318px", "61px");
		
		Label lblPorQu = new Label("2. Por qué desea trabajar en la Fundación?");
		lblPorQu.setStyleName("label");
		absolutePanel.add(lblPorQu, 379, 29);
		lblPorQu.setSize("338px", "13px");
		
		TextArea txtComoDescribe = new TextArea();
		txtComoDescribe.getElement().setAttribute("maxlength", "500");
		txtComoDescribe.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtComoDescribe, 10, 157);
		txtComoDescribe.setSize("318px", "61px");
		
		Label lblCmoSe = new Label("3. Cómo se describe así mismo?");
		lblCmoSe.setStyleName("label");
		absolutePanel.add(lblCmoSe, 10, 138);
		lblCmoSe.setSize("338px", "13px");
		
		TextArea txtPresion = new TextArea();
		txtPresion.getElement().setAttribute("maxlength", "500");
		txtPresion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPresion, 379, 157);
		txtPresion.setSize("318px", "61px");
		
		Label lblpuedesTrabajar = new Label("4. ¿Puedes trabajar bajo presión?");
		lblpuedesTrabajar.setStyleName("label");
		absolutePanel.add(lblpuedesTrabajar, 379, 138);
		lblpuedesTrabajar.setSize("338px", "13px");
		
		TextArea txtMetas = new TextArea();
		txtMetas.getElement().setAttribute("maxlength", "1000");
		txtMetas.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtMetas, 10, 263);
		txtMetas.setSize("687px", "100px");
		
		Label lblMetas = new Label("Metas");
		lblMetas.setStyleName("label");
		absolutePanel.add(lblMetas, 10, 244);
		lblMetas.setSize("338px", "13px");
		
		Label lblATieneDisponibilidad = new Label("a) Tiene disponibilidad inmediata");
		lblATieneDisponibilidad.setStyleName("label");
		absolutePanel.add(lblATieneDisponibilidad, 37, 399);
		lblATieneDisponibilidad.setSize("293px", "13px");
		
		ListBox listA = new ListBox();
		listA.addItem("Si");
		listA.addItem("No");
		listA.setStyleName("gwt-TextBox2");
		absolutePanel.add(listA, 567, 393);
		listA.setSize("137px", "19px");
		
		Label lblBTieneDisposicin = new Label("b) Tiene disposición de viajar incluso fines de semana");
		lblBTieneDisposicin.setStyleName("label");
		absolutePanel.add(lblBTieneDisposicin, 37, 424);
		lblBTieneDisposicin.setSize("511px", "13px");
		
		ListBox listB = new ListBox();
		listB.addItem("Si");
		listB.addItem("No");
		listB.setStyleName("gwt-TextBox2");
		absolutePanel.add(listB, 567, 418);
		listB.setSize("137px", "19px");
		
		Label lblCTieneFlexibilidad = new Label("c) Tiene flexibilidad en el horario");
		lblCTieneFlexibilidad.setStyleName("label");
		absolutePanel.add(lblCTieneFlexibilidad, 37, 449);
		lblCTieneFlexibilidad.setSize("524px", "13px");
		
		ListBox listC = new ListBox();
		listC.addItem("Si");
		listC.addItem("No");
		listC.setStyleName("gwt-TextBox2");
		absolutePanel.add(listC, 567, 443);
		listC.setSize("137px", "19px");
		
		Label lblDSuPretensin = new Label("d) Su pretensión salarial mínima es");
		lblDSuPretensin.setStyleName("label");
		absolutePanel.add(lblDSuPretensin, 37, 474);
		lblDSuPretensin.setSize("293px", "13px");
		
		Label lblETieneAntecedentes = new Label("e) Tiene antecedentes penales");
		lblETieneAntecedentes.setStyleName("label");
		absolutePanel.add(lblETieneAntecedentes, 37, 502);
		lblETieneAntecedentes.setSize("511px", "13px");
		
		Label lblFTieneAntecedentes = new Label("f) Tiene antecedentes policíacos");
		lblFTieneAntecedentes.setStyleName("label");
		absolutePanel.add(lblFTieneAntecedentes, 37, 527);
		lblFTieneAntecedentes.setSize("511px", "13px");
		
		Label lblGCartasDe = new Label("g) Cartas de recomendación laborales");
		lblGCartasDe.setStyleName("label");
		absolutePanel.add(lblGCartasDe, 37, 552);
		lblGCartasDe.setSize("511px", "13px");
		
		Label lblHCartasDe = new Label("h) Cartas de recomendación personales");
		lblHCartasDe.setStyleName("label");
		absolutePanel.add(lblHCartasDe, 37, 577);
		lblHCartasDe.setSize("511px", "13px");
		
		ListBox listD = new ListBox();
		listD.addItem("Si");
		listD.addItem("No");
		listD.setStyleName("gwt-TextBox2");
		absolutePanel.add(listD, 567, 468);
		listD.setSize("137px", "19px");
		
		ListBox listE = new ListBox();
		listE.addItem("Si");
		listE.addItem("No");
		listE.setStyleName("gwt-TextBox2");
		absolutePanel.add(listE, 567, 496);
		listE.setSize("137px", "19px");
		
		ListBox listF = new ListBox();
		listF.addItem("Si");
		listF.addItem("No");
		listF.setStyleName("gwt-TextBox2");
		absolutePanel.add(listF, 567, 521);
		listF.setSize("137px", "19px");
		
		ListBox listG = new ListBox();
		listG.addItem("Si");
		listG.addItem("No");
		listG.setStyleName("gwt-TextBox2");
		absolutePanel.add(listG, 567, 546);
		listG.setSize("137px", "19px");
		
		ListBox listH = new ListBox();
		listH.addItem("Si");
		listH.addItem("No");
		listH.setStyleName("gwt-TextBox2");
		absolutePanel.add(listH, 567, 571);
		listH.setSize("137px", "19px");
		
		Label lblEnfermedades = new Label("Enfermedades");
		lblEnfermedades.setStyleName("label");
		absolutePanel.add(lblEnfermedades, 10, 654);
		lblEnfermedades.setSize("338px", "13px");
		
		TextArea txtEnfermedades = new TextArea();
		txtEnfermedades.getElement().setAttribute("maxlength", "500");
		txtEnfermedades.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEnfermedades, 10, 673);
		txtEnfermedades.setSize("687px", "100px");
		
		Label lblI = new Label("i) Vive con familia");
		lblI.setStyleName("label");
		absolutePanel.add(lblI, 37, 602);
		lblI.setSize("511px", "13px");
		
		ListBox listI = new ListBox();
		listI.addItem("Si");
		listI.addItem("No");
		listI.setStyleName("gwt-TextBox2");
		absolutePanel.add(listI, 567, 596);
		listI.setSize("137px", "19px");
		
		Label lblAporteCasa = new Label("Aporte Casa");
		lblAporteCasa.setStyleName("label");
		absolutePanel.add(lblAporteCasa, 20, 787);
		lblAporteCasa.setSize("75px", "13px");
		
		ListBox listDeudas = new ListBox();
		listDeudas.addItem("Si");
		listDeudas.addItem("No");
		listDeudas.setStyleName("gwt-TextBox2");
		absolutePanel.add(listDeudas, 175, 812);
		listDeudas.setSize("137px", "19px");
		
		Label lblTieneDeudas = new Label("Tiene deudas");
		lblTieneDeudas.setStyleName("label");
		absolutePanel.add(lblTieneDeudas, 175, 787);
		lblTieneDeudas.setSize("81px", "13px");
		
		Label lblAmortizacinMensual = new Label("Amortización mensual");
		lblAmortizacinMensual.setStyleName("label");
		absolutePanel.add(lblAmortizacinMensual, 330, 787);
		lblAmortizacinMensual.setSize("137px", "13px");
		
		Label lblNombreDeLa = new Label("Nombre de la institución donde tiene el crédito");
		lblNombreDeLa.setStyleName("label");
		absolutePanel.add(lblNombreDeLa, 488, 787);
		lblNombreDeLa.setSize("229px", "13px");
		
		TextBox txtNombreEmpresa = new TextBox();
		txtNombreEmpresa.setMaxLength(200);
		txtNombreEmpresa.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombreEmpresa, 488, 812);
		txtNombreEmpresa.setSize("209px", "11px");
		
		ListBox listNoDependientes = new ListBox();
		listNoDependientes.addItem("0");
		listNoDependientes.addItem("1");
		listNoDependientes.addItem("2");
		listNoDependientes.addItem("2");
		listNoDependientes.addItem("3");
		listNoDependientes.addItem("4");
		listNoDependientes.addItem("5");
		listNoDependientes.addItem("6");
		listNoDependientes.addItem("7");
		listNoDependientes.addItem("8");
		listNoDependientes.addItem("9");
		listNoDependientes.addItem("10");
		listNoDependientes.addItem("11");
		listNoDependientes.addItem("12");
		listNoDependientes.addItem("13");
		listNoDependientes.addItem("14");
		listNoDependientes.addItem("15");
		listNoDependientes.addItem("16");
		listNoDependientes.addItem("17");
		listNoDependientes.addItem("18");
		listNoDependientes.addItem("19");
		listNoDependientes.addItem("20");
		listNoDependientes.setStyleName("gwt-TextBox2");
		absolutePanel.add(listNoDependientes, 20, 862);
		listNoDependientes.setSize("137px", "19px");
		
		Label lblNoDependientes = new Label("No. Dependientes");
		lblNoDependientes.setStyleName("label");
		absolutePanel.add(lblNoDependientes, 20, 837);
		lblNoDependientes.setSize("137px", "13px");
		
		Label label = new Label("Fecha");
		label.setStyleName("label");
		absolutePanel.add(label, 175, 837);
		label.setSize("75px", "13px");
		
		Label lblPagoMensual = new Label("Pago mensual");
		lblPagoMensual.setStyleName("label");
		absolutePanel.add(lblPagoMensual, 485, 837);
		lblPagoMensual.setSize("137px", "13px");
		
		ListBox listAlquila = new ListBox();
		listAlquila.addItem("Si");
		listAlquila.addItem("No");
		listAlquila.setStyleName("gwt-TextBox2");
		absolutePanel.add(listAlquila, 330, 862);
		listAlquila.setSize("137px", "19px");
		
		Label lblAlquila = new Label("Alquila");
		lblAlquila.setStyleName("label");
		absolutePanel.add(lblAlquila, 330, 837);
		lblAlquila.setSize("81px", "13px");
		
		ListBox listJ = new ListBox();
		listJ.addItem("Si");
		listJ.addItem("No");
		listJ.setStyleName("gwt-TextBox2");
		absolutePanel.add(listJ, 567, 621);
		listJ.setSize("137px", "19px");
		
		Label lblKCasaPropia = new Label("J) Casa Propia");
		lblKCasaPropia.setStyleName("label");
		absolutePanel.add(lblKCasaPropia, 37, 627);
		lblKCasaPropia.setSize("511px", "13px");
		
		Label lblPretencionSalarial = new Label("Pretencion Salarial");
		lblPretencionSalarial.setStyleName("label");
		absolutePanel.add(lblPretencionSalarial, 20, 887);
		lblPretencionSalarial.setSize("137px", "13px");
		
		Label lblOtrosIngresos = new Label("Otros Ingresos");
		lblOtrosIngresos.setStyleName("label");
		absolutePanel.add(lblOtrosIngresos, 10, 939);
		lblOtrosIngresos.setSize("338px", "13px");
		
		TextArea txtOtrosIngresos = new TextArea();
		txtOtrosIngresos.getElement().setAttribute("maxlength", "500");
		txtOtrosIngresos.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtOtrosIngresos, 10, 958);
		txtOtrosIngresos.setSize("687px", "100px");
		
		TextBox txtEntrevisto = new TextBox();
		txtEntrevisto.setMaxLength(500);
		txtEntrevisto.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEntrevisto, 175, 906);
		txtEntrevisto.setSize("117px", "11px");
		
		Label lblEntrevisto = new Label("Entrevisto");
		lblEntrevisto.setStyleName("label");
		absolutePanel.add(lblEntrevisto, 175, 887);
		lblEntrevisto.setSize("137px", "13px");
		
		DateBox dateFecha = new DateBox();
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 175, 862);
		dateFecha.setSize("117px", "11px");
		
		DoubleBox txtAporteCasa = new DoubleBox();
		txtAporteCasa.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtAporteCasa, 20, 812);
		txtAporteCasa.setSize("117px", "11px");
		
		DoubleBox txtAmortizacion = new DoubleBox();
		txtAmortizacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtAmortizacion, 330, 812);
		txtAmortizacion.setSize("117px", "11px");
		
		DoubleBox txtPagoMensual = new DoubleBox();
		txtPagoMensual.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPagoMensual, 485, 862);
		txtPagoMensual.setSize("117px", "11px");
		
		DoubleBox txtPretencionSalarial = new DoubleBox();
		txtPretencionSalarial.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPretencionSalarial, 20, 906);
		txtPretencionSalarial.setSize("117px", "11px");
	}
}