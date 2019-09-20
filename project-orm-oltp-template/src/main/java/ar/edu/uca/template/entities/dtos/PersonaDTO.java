package ar.edu.uca.template.entities.dtos;

import ar.edu.uca.template.entities.Domicilio;

public abstract class PersonaDTO {
	private Long personaId;
	
	private long cuit;
	
	private String domCom_calle;
	private int domCom_numero;
	private String domCom_depto;
	private String domCom_provincia;
	private String domCom_partido;
	private String domCom_localidad;
	private String domCom_pais;
	
	public PersonaDTO() {
		
	}
	
	public abstract <R> R accept(PersonaDTOVisitor<R> visitor);

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) {
		this.cuit = cuit;
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
}
