package ar.edu.uca.template.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRESTAMO")
public class Prestamo {
	@Id
	@Column(name="PRESTAMO_ID")
	@SequenceGenerator(name = "prestamo_seq_prestamoId", sequenceName = "seq_prestamoId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prestamo_seq_prestamoId")
	private Long prestamoId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="SUCURSAL_ID", nullable=false)
	private Sucursal sucursal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CLIENTE_ID", nullable=false)
	private Persona cliente;
	
	private double monto;
	
	private Date fechaDeComienzo;
	private Date fechaDeVencimiento;
	
	public Prestamo() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((fechaDeVencimiento == null) ? 0 : fechaDeVencimiento.hashCode());
		result = prime * result + ((fechaDeVencimiento == null) ? 0 : fechaDeComienzo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(monto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((prestamoId == null) ? 0 : prestamoId.hashCode());
		result = prime * result + ((sucursal == null) ? 0 : sucursal.hashCode());
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
		Prestamo other = (Prestamo) obj;
		return ( other != null ) && prestamoId.equals(other.prestamoId);
	}

	public Long getPrestamoId() {
		return prestamoId;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Date getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}

	public void setFechaDeVencimiento(Date fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

	public Date getFechaDeComienzo() {
		return fechaDeComienzo;
	}

	public void setFechaDeComienzo(Date fechaDeComienzo) {
		this.fechaDeComienzo = fechaDeComienzo;
	}
}
