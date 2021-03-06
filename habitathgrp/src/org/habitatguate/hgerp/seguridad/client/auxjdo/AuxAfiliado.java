package org.habitatguate.hgerp.seguridad.client.auxjdo;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;





public class AuxAfiliado implements Comparable<AuxAfiliado>,IsSerializable{
	
	/**

     * El KEY_PROVIDER es el que provee el ID de un contacto.
     */
    public static final ProvidesKey<AuxAfiliado> KEY_PROVIDER = new ProvidesKey<AuxAfiliado>() {
      @Override
      public Object getKey(AuxAfiliado item) {
        return item == null ? null : item.getIdAfiliado();
      }
    };
    @Override
    public int compareTo(AuxAfiliado o) {
      return (o == null || o.idAfiliado == null) ? -1 : -o.idAfiliado.compareTo(idAfiliado);
    }
	
	private Long idAfiliado;

	private String nomAfiliado;

	private String dirAfiliado;

	private String municipio;

	private String departamento;
	
	private String telefono;
	
	private String codigoAfiliado;
	
	private int correlativoVale;
	
	private List<AuxBeneficiario> listaBene;
	
	private List<AuxProveedor> listaProveedores = new ArrayList<AuxProveedor>();
	
	public Long getIdAfiliado() {
		return idAfiliado;
	}

	public void setIdAfiliado(Long idAfiliado) {
		this.idAfiliado = idAfiliado;
	}

	public String getNomAfiliado() {
		return nomAfiliado;
	}

	public void setNomAfiliado(String nomAfiliado) {
		this.nomAfiliado = nomAfiliado;
	}

	public String getDirAfiliado() {
		return dirAfiliado;
	}

	public void setDirAfiliado(String dirAfiliado) {
		this.dirAfiliado = dirAfiliado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public List<AuxBeneficiario> getListaBene() {
		return listaBene;
	}

	public void setListaBene(List<AuxBeneficiario> listaBene) {
		this.listaBene = listaBene;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<AuxProveedor> getListaProveedores() {
		return listaProveedores;
	}

	public void setListaProveedores(List<AuxProveedor> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}

	public String getCodigoAfiliado() {
		return codigoAfiliado;
	}

	public void setCodigoAfiliado(String codigoAfiliado) {
		this.codigoAfiliado = codigoAfiliado;
	}

	public int getCorrelativoVale() {
		return correlativoVale;
	}

	public void setCorrelativoVale(int correlativoVale) {
		this.correlativoVale = correlativoVale;
	}
	
	
	
	
	

}
