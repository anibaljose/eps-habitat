package org.habitatguate.hgerp.seguridad.client.principal;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;

public class Panel extends Composite {

	private AbsolutePanel absolutePanel_1;
	private Long id_empleado;
	
		public Panel() {
         SplitLayoutPanel splitLayoutPanel = new SplitLayoutPanel();
         initWidget(splitLayoutPanel);
         splitLayoutPanel.setSize("100%", "800px");
                
         HTMLPanel panel = new HTMLPanel("");
         panel.setStyleName("panelNorth");
         splitLayoutPanel.addNorth(panel, -6.0);
         panel.setSize("100%", "100%");
             
             HTMLPanel panel_1 = new HTMLPanel("");
             panel_1.setStyleName("Panel_Central");
             splitLayoutPanel.addSouth(panel_1, 27.0);
             panel_1.setSize("1200px", "20px");
             
             AbsolutePanel absolutePanel = new AbsolutePanel();
             absolutePanel.setStyleName("html-west");
             splitLayoutPanel.addWest(absolutePanel, 126.0);
             absolutePanel.setSize("100%", "100%");
             
             UIStacksEjemplo menu2 = new UIStacksEjemplo(this);
             absolutePanel.add(menu2, 0, 0);
             menu2.setSize("127px", "532px");
             
             absolutePanel_1 = new AbsolutePanel();
             splitLayoutPanel.add(absolutePanel_1);
                 setStyleName("Panel_principal");
                 setSize("1343px", "1834px");
                 
                 //Buscador_Parametro_Inv buscador = new Buscador_Parametro_Inv(); 
               //  Buscador_Empleados buscador = new Buscador_Empleados();
                 //Empleado_tab empleado = new Empleado_tab();
                // absolutePanel_1.add(buscador, 0, 0);
                 //empleado.setSize("1187px", "648px");
        }
		

        public AbsolutePanel getAbsolutePanel_1() {
		return absolutePanel_1;
	}


		public Long getId_empleado() {
			return id_empleado;
		}


		public void setId_empleado(Long id_empleado) {
			this.id_empleado = id_empleado;
		}
}