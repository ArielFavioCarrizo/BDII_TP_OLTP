package ar.edu.uca.template.entities.dtos;

public final class PersonaJuridicaDTO extends PersonaDTO {
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public <R> R accept(PersonaDTOVisitor<R> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PersonaJuridicaDTO))
			return false;
		PersonaJuridicaDTO other = (PersonaJuridicaDTO) obj;
		if ( ( other.getPersonaId() == null ) || ( !other.getPersonaId().equals(this.getPersonaId()) ) )
			return false;
			
		return true;
	}
}
