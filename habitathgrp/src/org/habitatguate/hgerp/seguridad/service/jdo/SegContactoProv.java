package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegContactoProv implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long idContactoProv;
	@Persistent
	private String nomContacto;
	@Persistent
	private String puestoContacto;
	@Persistent
	private String correoContacto;
	@Persistent
	private String telContacto;
	@Persistent
	private String cellphoneContacto;
	@Persistent
	private Long idProveedor;
	@Persistent
	private int status;
	
	
	

	public Long getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getIdContactoProv() {
		return idContactoProv;
	}
	public void setIdContactoProv(Long idContactoProv) {
		this.idContactoProv = idContactoProv;
	}
	public String getNomContacto() {
		return nomContacto;
	}
	public void setNomContacto(String nomContacto) {
		this.nomContacto = nomContacto;
	}

	public String getPuestoContacto() {
		return puestoContacto;
	}
	public void setPuestoContacto(String puestoContacto) {
		this.puestoContacto = puestoContacto;
	}
	public String getCorreoContacto() {
		return correoContacto;
	}
	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}
	public String getTelContacto() {
		return telContacto;
	}
	public void setTelContacto(String telContacto) {
		this.telContacto = telContacto;
	}
	public String getCellphoneContacto() {
		return cellphoneContacto;
	}
	public void setCellphoneContacto(String cellphoneContacto) {
		this.cellphoneContacto = cellphoneContacto;
	}
	
	
	

}
