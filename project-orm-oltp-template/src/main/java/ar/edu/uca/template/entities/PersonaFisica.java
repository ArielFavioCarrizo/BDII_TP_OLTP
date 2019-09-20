package ar.edu.uca.template.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PERSONASFISICAS")
public class PersonaFisica extends Persona {
	/*
	@Id
	@Column(name="PERSONAFISICA_ID")
	@SequenceGenerator(name = "personaFisica_seq_personaFisicaId", sequenceName = "seq_personaFisicaId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personaFisica_seq_personaFisicaId")
	private int personaFisicaId;
	*/
	
	@Column(name="NOMBRE")
    private String nombre;
    @Column(name="APELLIDO")
    private String apellido;
    
    @Column(name="DNI")
    private long dni;
    
	@Column(name="FECHADENACIMIENTO")
	private Date fechaDeNacimiento;
    
    private Domicilio domicilioParticular;

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

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public Domicilio getDomicilioParticular() {
		return domicilioParticular;
	}

	public void setDomicilioParticular(Domicilio domicilioParticular) {
		this.domicilioParticular = domicilioParticular;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ( Long.hashCode(dni) );
		result = prime * result + ((domicilioParticular == null) ? 0 : domicilioParticular.hashCode());
		result = prime * result + ((fechaDeNacimiento == null) ? 0 : fechaDeNacimiento.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return
				"PersonaFisica " + this.getPersonaId() + ": " +
				"( Nombre = " + this.getNombre() +
				", Apellido = " + this.getApellido() +
				", Cuit = " + this.getCuit() + 
				", Dni = " + this.getDni() +
				", FechaDeNacimiento = " + this.getFechaDeNacimiento() +
				", DomicilioComercial = " + this.getDomicilioComercial() +
				", DomicilioParticular = " + this.getDomicilioParticular();
	}

	@Override
	public <R> R accept(PersonaVisitor<R> visitor) {
		return visitor.visit(this);
	}
}
