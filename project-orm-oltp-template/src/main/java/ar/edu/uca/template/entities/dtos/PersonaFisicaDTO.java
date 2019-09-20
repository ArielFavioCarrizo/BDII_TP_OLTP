package ar.edu.uca.template.entities.dtos;

import java.util.Date;


public final class PersonaFisicaDTO extends PersonaDTO {
    private String nombre;
    private String apellido;
    private long dni;
	private long fechaDeNacimientoEpoch;
    
	private String domPart_calle;
	private int domPart_numero;
	private String domPart_depto;
	private String domPart_provincia;
	private String domPart_partido;
	private String domPart_localidad;
	private String domPart_pais;
	
	@Override
	public <R> R accept(PersonaDTOVisitor<R> visitor) {
		return visitor.visit(this);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public long getFechaDeNacimientoEpoch() {
		return fechaDeNacimientoEpoch;
	}

	public void setFechaDeNacimientoEpoch(long fechaDeNacimientoEpoch) {
		this.fechaDeNacimientoEpoch = fechaDeNacimientoEpoch;
	}

	public String getDomPart_calle() {
		return domPart_calle;
	}

	public void setDomPart_calle(String domPart_calle) {
		this.domPart_calle = domPart_calle;
	}

	public int getDomPart_numero() {
		return domPart_numero;
	}

	public void setDomPart_numero(int domPart_numero) {
		this.domPart_numero = domPart_numero;
	}

	public String getDomPart_depto() {
		return domPart_depto;
	}

	public void setDomPart_depto(String domPart_depto) {
		this.domPart_depto = domPart_depto;
	}

	public String getDomPart_provincia() {
		return domPart_provincia;
	}

	public void setDomPart_provincia(String domPart_provincia) {
		this.domPart_provincia = domPart_provincia;
	}

	public String getDomPart_partido() {
		return domPart_partido;
	}

	public void setDomPart_partido(String domPart_partido) {
		this.domPart_partido = domPart_partido;
	}

	public String getDomPart_localidad() {
		return domPart_localidad;
	}

	public void setDomPart_localidad(String domPart_localidad) {
		this.domPart_localidad = domPart_localidad;
	}

	public String getDomPart_pais() {
		return domPart_pais;
	}

	public void setDomPart_pais(String domPart_pais) {
		this.domPart_pais = domPart_pais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + (int) (dni ^ (dni >>> 32));
		result = prime * result + ((domPart_calle == null) ? 0 : domPart_calle.hashCode());
		result = prime * result + ((domPart_depto == null) ? 0 : domPart_depto.hashCode());
		result = prime * result + ((domPart_localidad == null) ? 0 : domPart_localidad.hashCode());
		result = prime * result + domPart_numero;
		result = prime * result + ((domPart_pais == null) ? 0 : domPart_pais.hashCode());
		result = prime * result + ((domPart_partido == null) ? 0 : domPart_partido.hashCode());
		result = prime * result + ((domPart_provincia == null) ? 0 : domPart_provincia.hashCode());
		result = prime * result + Long.hashCode(fechaDeNacimientoEpoch);
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PersonaFisicaDTO))
			return false;
		PersonaFisicaDTO other = (PersonaFisicaDTO) obj;
		if ( ( other == null ) || !other.getPersonaId().equals(this.getPersonaId()) ) {
			return false;
		}
		
		return true;
	}
}
