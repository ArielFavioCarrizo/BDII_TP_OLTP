package ar.edu.uca.template.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.cfg.context.ReturnValueConstraintMappingContext;

@Entity
@Table(name="PERSONASJURIDICAS")
public class PersonaJuridica extends Persona {
	/*
	@Id
	@Column(name="PERSONAJURIDICA_ID")
	@SequenceGenerator(name = "personaJuridica_seq_personaJuridicaId", sequenceName = "seq_personaJuridicaId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personaJuridica_seq_personaJuridicaId")
	private int personaJuridicaI
	*/
	
	@Column(name="NOMBRE")
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
		int result = super.hashCode();
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return
				"PersonaJuridica " + this.getPersonaId() + ": " +
				"( Nombre = " + this.getNombre() +
				", Cuit = " + this.getCuit() + 
				", DomicilioComercial = " + this.getDomicilioComercial();
	}

	@Override
	public <R> R accept(PersonaVisitor<R> visitor) {
		return visitor.visit(this);
	}
}
