package ar.edu.uca.template.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Persona
 * 
 * @author ariel
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Porque la principal diferencia entre las clases concretas son los datos que almacenan
@Table(name="PERSONAS")
public abstract class Persona {
	@Id
	@Column(name="PERSONA_ID")
	@SequenceGenerator(name = "persona_seq_personaId", sequenceName = "seq_personaId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq_personaId")
	private Long personaId;
	
	@Column(name="CUIT")
	private long cuit;
	
	private Domicilio domicilioComercial;
	
	public Persona() {
		
	}

	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) {
		this.cuit = cuit;
	}

	public Domicilio getDomicilioComercial() {
		return domicilioComercial;
	}

	public void setDomicilioComercial(Domicilio domicilioComercial) {
		this.domicilioComercial = domicilioComercial;
	}

	public Long getPersonaId() {
		return personaId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cuit ^ (cuit >>> 32));
		result = prime * result + ((domicilioComercial == null) ? 0 : domicilioComercial.hashCode());
		result = prime * result + (int) (personaId.hashCode() ^ (personaId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		return ( personaId != null ) && personaId.equals(other.personaId);
	}
	
	public abstract <R> R accept(PersonaVisitor<R> visitor);
}
