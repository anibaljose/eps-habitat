package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegBeneficiario implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key idBeneficiario;
	@Persistent
	private String nomBeneficiario;
	@Persistent
	private String dirBeneficiario;
	@Persistent
	private int telBeneficiario;
	@Persistent
	private SegAfiliado afiliado;
	
	@OneToMany(mappedBy = "beneficiario")
	private List<SegSolucion> solucion;
	
	
	public SegBeneficiario(){
		super();
	}

	
	//aqui vienen todas los objetos con los que se relaciona





	public Key getIdBeneficiario() {
		return idBeneficiario;
	}



	public void setIdBeneficiario(Key idBeneficiario) {
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







	public List<SegSolucion> getSolucion() {
		return solucion;
	}



	public void setSolucion(List<SegSolucion> solucion) {
		this.solucion = solucion;
	}


	public SegAfiliado getAfiliado() {
		return afiliado;
	}


	public void setAfiliado(SegAfiliado afiliado) {
		this.afiliado = afiliado;
	}
	
	
	
	
	
}
