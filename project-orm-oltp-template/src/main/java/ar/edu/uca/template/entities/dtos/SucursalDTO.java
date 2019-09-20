package ar.edu.uca.template.entities.dtos;

import ar.edu.uca.template.entities.Domicilio;

public class SucursalDTO {
	private Long id;
	
	private String domCom_calle;
	private int domCom_numero;
	private String domCom_depto;
	private String domCom_provincia;
	private String domCom_partido;
	private String domCom_localidad;
	private String domCom_pais;
	
	public SucursalDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public String getDomCom_calle() {
		return domCom_calle;
	}

	public void setDomCom_calle(String domCom_calle) {
		this.domCom_calle = domCom_calle;
	}

	public int getDomCom_numero() {
		return domCom_numero;
	}

	public void setDomCom_numero(int domCom_numero) {
		this.domCom_numero = domCom_numero;
	}

	public String getDomCom_depto() {
		return domCom_depto;
	}

	public void setDomCom_depto(String domCom_depto) {
		this.domCom_depto = domCom_depto;
	}

	public String getDomCom_provincia() {
		return domCom_provincia;
	}

	public void setDomCom_provincia(String domCom_provincia) {
		this.domCom_provincia = domCom_provincia;
	}

	public String getDomCom_partido() {
		return domCom_partido;
	}

	public void setDomCom_partido(String domCom_partido) {
		this.domCom_partido = domCom_partido;
	}

	public String getDomCom_localidad() {
		return domCom_localidad;
	}

	public void setDomCom_localidad(String domCom_localidad) {
		this.domCom_localidad = domCom_localidad;
	}

	public String getDomCom_pais() {
		return domCom_pais;
	}

	public void setDomCom_pais(String domCom_pais) {
		this.domCom_pais = domCom_pais;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domCom_calle == null) ? 0 : domCom_calle.hashCode());
		result = prime * result + ((domCom_depto == null) ? 0 : domCom_depto.hashCode());
		result = prime * result + ((domCom_localidad == null) ? 0 : domCom_localidad.hashCode());
		result = prime * result + domCom_numero;
		result = prime * result + ((domCom_pais == null) ? 0 : domCom_pais.hashCode());
		result = prime * result + ((domCom_partido == null) ? 0 : domCom_partido.hashCode());
		result = prime * result + ((domCom_provincia == null) ? 0 : domCom_provincia.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SucursalDTO))
			return false;
		SucursalDTO other = (SucursalDTO) obj;
		if ( (other.id == null ) || ( !other.id.equals(this.id) ) )
			return false;
		return true;
	}
}
