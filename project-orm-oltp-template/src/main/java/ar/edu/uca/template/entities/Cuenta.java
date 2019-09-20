package ar.edu.uca.template.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CUENTAS")
public class Cuenta {
	@Id
	@Column(name="CUENTA_ID")
	@SequenceGenerator(name = "cuenta_seq_cuentaId", sequenceName = "seq_cuentaId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuenta_seq_cuentaId")
	private Long cuentaId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="TITULAR_ID", nullable=false)
	private Persona titular;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="SUCURSAL_ID", nullable=false)
	private Sucursal sucursal;
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
	private Collection<Persona> asociados = new ArrayList<Persona>();
	
	private double saldo;

	public Persona getTitular() {
		return titular;
	}

	public void setTitular(Persona titular) {
		this.titular = titular;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cuentaId ^ (cuentaId >>> 32));
		result = prime * result + ((sucursal == null) ? 0 : sucursal.hashCode());
		result = prime * result + ((titular == null) ? 0 : titular.hashCode());
		result = prime * result + Double.hashCode(this.saldo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cuenta))
			return false;
		Cuenta other = (Cuenta) obj;
		return ( cuentaId != null ) && cuentaId.equals(other.cuentaId);
	}

	public Long getCuentaId() {
		return cuentaId;
	}
	
	@Override
	public String toString() {
		return "Cuenta " + this.getCuentaId() + ", titular: (" + this.getTitular() + ", sucursal: " + this.getSucursal() + ")";
	}

	public Collection<Persona> getAsociados() {
		return asociados;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
