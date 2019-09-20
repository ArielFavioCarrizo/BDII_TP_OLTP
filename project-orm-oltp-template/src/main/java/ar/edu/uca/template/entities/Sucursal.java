package ar.edu.uca.template.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SUCURSALES")
public class Sucursal {
	@Id
	@Column(name="SUCURSAL_ID")
	@SequenceGenerator(name = "sucursal_seq_sucursalId", sequenceName = "seq_sucursalId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sucursal_seq_sucursalId")	
	private Long sucursalId;

	private Domicilio domicilioComercial;

	public Domicilio getDomicilioComercial() {
		return domicilioComercial;
	}

	public void setDomicilioComercial(Domicilio domicilioComercial) {
		this.domicilioComercial = domicilioComercial;
	}

	public Long getSucursalId() {
		return sucursalId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domicilioComercial == null) ? 0 : domicilioComercial.hashCode());
		result = prime * result + sucursalId.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Sucursal))
			return false;
		Sucursal other = (Sucursal) obj;
		return ( sucursalId != null ) && sucursalId.equals(other.sucursalId);
	}
	
	@Override
	public String toString() {
		return "Sucursal " + this.sucursalId + ": (" + this.domicilioComercial + ")";
	}
}
