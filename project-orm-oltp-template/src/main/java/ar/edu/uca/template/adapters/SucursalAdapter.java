package ar.edu.uca.template.adapters;

import java.util.ArrayList;
import java.util.List;

import ar.edu.uca.template.entities.Domicilio;
import ar.edu.uca.template.entities.Sucursal;
import ar.edu.uca.template.entities.dtos.SucursalDTO;

public class SucursalAdapter {
	public static SucursalDTO adapt(Sucursal sucursal) {
		if ( sucursal == null ) return null;
		
		SucursalDTO dto = new SucursalDTO();
		dto.setId(sucursal.getSucursalId());
		
		Domicilio domicilio = sucursal.getDomicilioComercial();
		
		dto.setDomCom_calle(domicilio.getCalle());
		dto.setDomCom_depto(domicilio.getDepto());
		dto.setDomCom_localidad(domicilio.getLocalidad());
		dto.setDomCom_numero(domicilio.getNumero());
		dto.setDomCom_pais(domicilio.getPais());
		dto.setDomCom_partido(domicilio.getPartido());
		dto.setDomCom_provincia(domicilio.getProvincia());
		
		return dto;
	}
	
	public static List<SucursalDTO> adaptIterable(Iterable<Sucursal> sucursales) {
		if ( sucursales == null ) return null;
		
		List<SucursalDTO> dtos = new ArrayList<SucursalDTO>();
		for ( Sucursal cadaSucursal : sucursales ) {
			dtos.add(adapt(cadaSucursal));
		}
		
		return dtos;
	}
}
