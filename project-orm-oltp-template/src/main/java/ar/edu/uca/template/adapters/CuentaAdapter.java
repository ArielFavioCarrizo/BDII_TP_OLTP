package ar.edu.uca.template.adapters;

import java.util.ArrayList;
import java.util.List;

import ar.edu.uca.template.entities.Cuenta;
import ar.edu.uca.template.entities.dtos.CuentaDTO;

public final class CuentaAdapter {
	public static CuentaDTO adapt(Cuenta cuenta) {
		if ( cuenta == null ) return null;
		
		CuentaDTO dto = new CuentaDTO();
		
		dto.setCuentaId(cuenta.getCuentaId());
		dto.setSaldo(cuenta.getSaldo());
		dto.setSucursalId(cuenta.getSucursal().getSucursalId());
		dto.setTitularId(cuenta.getTitular().getPersonaId());
		
		return dto;
	}
	
	public static Iterable<CuentaDTO> adapt(Iterable<Cuenta> cuentas) {
		List<CuentaDTO> dtos = new ArrayList<CuentaDTO>();
		
		for ( Cuenta eachCuenta: cuentas ) {
			dtos.add( adapt(eachCuenta) );
		}
		
		return dtos;
	}
}
