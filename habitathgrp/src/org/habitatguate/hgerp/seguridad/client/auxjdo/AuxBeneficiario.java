package org.habitatguate.hgerp.seguridad.client.auxjdo;


import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;

public class AuxBeneficiario implements Comparable<AuxBeneficiario>,IsSerializable{

	private Long idBeneficiario;

	private String nomBeneficiario;

	private String dirBeneficiario;

	private int telBeneficiario;
	
	private AuxAfiliado afiliado;
	
	private AuxSolucion solucion;
	
	private AuxSolicitudGeneral solicitud;
	
	private String DPI;
	/**

     * El KEY_PROVIDER es el que provee el ID de un contacto.
     */
    public static final ProvidesKey<AuxBeneficiario> KEY_PROVIDER = new ProvidesKey<AuxBeneficiario>() {
      @Override
      public Object getKey(AuxBeneficiario item) {
        return item == null ? null : item.getIdBeneficiario();
      }
    };
    @Override
    public int compareTo(AuxBeneficiario o) {
      return (o == null || o.getIdBeneficiario() == null) ? -1 : -o.getIdBeneficiario().compareTo(getIdBeneficiario());
    }

	public Long getIdBeneficiario() {
		return idBeneficiario;
	}

	public void setIdBeneficiario(Long idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}

	public String getNomBeneficiario() {
		return nomBeneficiario;
	}

	public void setNomBeneficiario(String nomBeneficiario) {
		this.nomBeneficiario = nomBeneficiario;
	}

	public String getDirBeneficiario() {
		return dirBeneficiario;
	}

	public void setDirBeneficiario(String dirBeneficiario) {
		this.dirBeneficiario = dirBeneficiario;
	}

	public int getTelBeneficiario() {
		return telBeneficiario;
	}

	public void setTelBeneficiario(int telBeneficiario) {
		this.telBeneficiario = telBeneficiario;
	}

	public AuxAfiliado getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(AuxAfiliado afiliado) {
		this.afiliado = afiliado;
	}

	public AuxSolucion getSolucion() {
		return solucion;
	}

	public void setSolucion(AuxSolucion solucion) {
		this.solucion = solucion;
	}

	public AuxSolicitudGeneral getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(AuxSolicitudGeneral solicitud) {
		this.solicitud = solicitud;
	}

	public String getDPI() {
		return DPI;
	}

	public void setDPI(String dPI) {
		DPI = dPI;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
