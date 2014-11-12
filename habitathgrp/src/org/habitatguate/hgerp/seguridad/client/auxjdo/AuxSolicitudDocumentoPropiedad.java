package org.habitatguate.hgerp.seguridad.client.auxjdo;


import com.google.gwt.user.client.rpc.IsSerializable;


public class AuxSolicitudDocumentoPropiedad implements IsSerializable {

	public AuxSolicitudDocumentoPropiedad() {
		super();
	}
	
	// Llave Primaria
	
    private Long idDocumentoPropiedad;
	
	public Long getIdDocumentoPropiedad() {
		return idDocumentoPropiedad;
	}

	public void setIdDocumentoPropiedad(Long idDocumentoPropiedad) {
		this.idDocumentoPropiedad = idDocumentoPropiedad;
	}

	    
	// Atributos
	
    private String escrituraNoRegistrada;

	public String getEscrituraNoRegistrada() {
		return escrituraNoRegistrada;
	}

	public void setEscrituraNoRegistrada(String escrituraNoRegistrada) {
		this.escrituraNoRegistrada = escrituraNoRegistrada;
	}
	
	
    private String escrituraRegistrada;
	
	public String getEscrituraRegistrada() {
		return escrituraRegistrada;
	}

	public void setEscrituraRegistrada(String escrituraRegistrada) {
		this.escrituraRegistrada = escrituraRegistrada;
	}

	
    private String folioEscritura;
	
	public String getFolioEscritura() {
		return folioEscritura;
	}

	public void setFolioEscritura(String folioEscritura) {
		this.folioEscritura = folioEscritura;
	}

	
    private String libroEscritura;
	
	public String getLibroEscritura() {
		return libroEscritura;
	}

	public void setLibroEscritura(String libroEscritura) {
		this.libroEscritura = libroEscritura;
	}

	
    private String fincaEscritura;
	
	public String getFincaEscritura() {
		return fincaEscritura;
	}

	public void setFincaEscritura(String fincaEscritura) {
		this.fincaEscritura = fincaEscritura;
	}
	
	
    private String nombreNotario;
	
	public String getNombreNotario() {
		return nombreNotario;
	}

	public void setNombreNotario(String nombreNotario) {
		this.nombreNotario = nombreNotario;
	}

	
    private int areaTerreno;
	
	public int getAreaTerreno() {
		return areaTerreno;
	}

	public void setAreaTerreno(int areaTerreno) {
		this.areaTerreno = areaTerreno;
	}

	
    private float valorEstimado;

	public float getValorEstimado() {
		return valorEstimado;
	}

	public void setValorEstimado(float valorEstimado) {
		this.valorEstimado = valorEstimado;
	}

	
    private Boolean checkSi;

	public Boolean getCheckSi() {
		return checkSi;
	}

	public void setCheckSi(Boolean checkSi) {
		this.checkSi = checkSi;
	}

	
    private Boolean checkNo;
	
	public Boolean getCheckNo() {
		return checkNo;
	}

	public void setCheckNo(Boolean checkNo) {
		this.checkNo = checkNo;
	}
	
	
    private String nombrePersona;
	
	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	
    private int telefonoPersona;
	
	public int getTelefonoPersona() {
		return telefonoPersona;
	}

	public void setTelefonoPersona(int telefonoPersona) {
		this.telefonoPersona = telefonoPersona;
	}

	// Llave Foranea
	
	private long idFormulario;
	
	public long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(long idFormulario) {
		this.idFormulario = idFormulario;
	}
    
}
