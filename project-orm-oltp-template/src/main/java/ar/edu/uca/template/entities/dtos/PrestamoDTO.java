package ar.edu.uca.template.entities.dtos;

public class PrestamoDTO {
	private Long prestamoId;
	
	private long sucursalId;
	
	private long clienteId;
	
	private double monto;
	
	private long fechaDeComienzoEpoch;
	private long fechaDeVencimientoEpoch;
	
	public Long getPrestamoId() {
		return prestamoId;
	}
	public void setPrestamoId(Long prestamoId) {
		this.prestamoId = prestamoId;
	}
	public Long getSucursalId() {
		return sucursalId;
	}
	public void setSucursalId(long sucursalId) {
		this.sucursalId = sucursalId;
	}
	public long getClienteId() {
		return clienteId;
	}
	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public long getFechaDeComienzoEpoch() {
		return fechaDeComienzoEpoch;
	}
	public void setFechaDeComienzoEpoch(long fechaDeComienzoEpoch) {
		this.fechaDeComienzoEpoch = fechaDeComienzoEpoch;
	}
	public long getFechaDeVencimientoEpoch() {
		return fechaDeVencimientoEpoch;
	}
	public void setFechaDeVencimientoEpoch(long fechaDeVencimientoEpoch) {
		this.fechaDeVencimientoEpoch = fechaDeVencimientoEpoch;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (clienteId ^ (clienteId >>> 32));
		result = prime * result + (int) (fechaDeComienzoEpoch ^ (fechaDeComienzoEpoch >>> 32));
		result = prime * result + (int) (fechaDeVencimientoEpoch ^ (fechaDeVencimientoEpoch >>> 32));
		long temp;
		temp = Double.doubleToLongBits(monto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (prestamoId ^ (prestamoId >>> 32));
		result = prime * result + (int) (sucursalId ^ (sucursalId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PrestamoDTO))
			return false;
		PrestamoDTO other = (PrestamoDTO) obj;
		
		if ( (prestamoId == null) || (prestamoId != other.prestamoId) )
			return false;
		return true;
	}
	
	
}
