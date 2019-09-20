package ar.edu.uca.template.entities.dtos;

import java.util.List;

public class CuentaDTO {
	private Long cuentaId;
	
	private long titularId;
	
	private long sucursalId;
	
	private double saldo;
	
	private List<Long> asociadosById;

	public Long getCuentaId() {
		return cuentaId;
	}

	public void setCuentaId(Long cuentaId) {
		this.cuentaId = cuentaId;
	}

	public long getTitularId() {
		return titularId;
	}

	public void setTitularId(long personaId) {
		this.titularId = personaId;
	}

	public long getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(long sucursalId) {
		this.sucursalId = sucursalId;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cuentaId ^ (cuentaId >>> 32));
		result = prime * result + (int) (titularId ^ (titularId >>> 32));
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (sucursalId ^ (sucursalId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CuentaDTO))
			return false;
		CuentaDTO other = (CuentaDTO) obj;
		if ( ( cuentaId == null ) || (cuentaId != other.cuentaId) ) {
			return false;
		}
		return true;
	}

	public List<Long> getAsociadosById() {
		return asociadosById;
	}

	public void setAsociadosById(List<Long> asociadosById) {
		this.asociadosById = asociadosById;
	}
	
	
}
