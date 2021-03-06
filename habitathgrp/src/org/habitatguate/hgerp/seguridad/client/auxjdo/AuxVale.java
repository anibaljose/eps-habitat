package org.habitatguate.hgerp.seguridad.client.auxjdo;


import java.util.Date;






import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;

public class AuxVale implements Comparable<AuxVale>,IsSerializable{
	
	/* El KEY_PROVIDER es el que provee el ID de un contacto.
    */
   public static final ProvidesKey<AuxVale> KEY_PROVIDER = new ProvidesKey<AuxVale>() {
     @Override
     public Object getKey(AuxVale item) {
       return item == null ? null : item.getIdVale();
     }
   };
   @Override
   public int compareTo(AuxVale o) {
     return (o == null || o.idVale == null) ? -1 : -o.idVale.compareTo(idVale);
   }
	
	private String idVale;

	private Double totalVale;

	private Date fechaVale;
	
	private boolean estado;
	
	private Double totalPagado;
	
	private int aprobado;
	
	//private List<AuxHistorialPagoProv> lista = new ArrayList<AuxHistorialPagoProv>();
	
	
	
	public String getIdVale() {
		return idVale;
	}

	public int getAprobado() {
		return aprobado;
	}

	public void setAprobado(int aprobado) {
		this.aprobado = aprobado;
	}

	public void setIdVale(String idVale) {
		this.idVale = idVale;
	}

	public Double getTotalVale() {
		return totalVale;
	}

	public void setTotalVale(Double totalVale) {
		this.totalVale = totalVale;
	}

	public Date getFechaVale() {
		return fechaVale;
	}

	public void setFechaVale(Date fechaVale) {
		this.fechaVale = fechaVale;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Double getTotalPagado() {
		return totalPagado;
	}

	public void setTotalPagado(Double totalPagado) {
		this.totalPagado = totalPagado;
	}

/*	public List<AuxHistorialPagoProv> getLista() {
		return lista;
	}

	public void setLista(List<AuxHistorialPagoProv> lista) {
		this.lista = lista;
	}*/
	
	

}
