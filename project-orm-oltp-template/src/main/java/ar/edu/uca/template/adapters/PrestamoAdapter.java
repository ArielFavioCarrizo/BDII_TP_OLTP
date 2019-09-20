package ar.edu.uca.template.adapters;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import ar.edu.uca.template.entities.Prestamo;
import ar.edu.uca.template.entities.dtos.PrestamoDTO;

public class PrestamoAdapter {
	public static PrestamoDTO adapt(Prestamo prestamo) {
		if ( prestamo == null ) return null;
		
		PrestamoDTO dto = new PrestamoDTO();
		
		dto.setPrestamoId(prestamo.getPrestamoId());
		dto.setClienteId(prestamo.getCliente().getPersonaId());
		dto.setMonto(prestamo.getMonto());
		
		Calendar calendar = new GregorianCalendar();
		
		calendar.setTime(prestamo.getFechaDeComienzo());
		dto.setFechaDeComienzoEpoch(calendar.getTimeInMillis());
		
		calendar.setTime(prestamo.getFechaDeVencimiento());
		dto.setFechaDeVencimientoEpoch(calendar.getTimeInMillis());
		
		return dto;
	}
	
	public static Iterable<PrestamoDTO> adapt(Iterable<Prestamo> prestamos) {
		List<PrestamoDTO> dtos = new ArrayList<PrestamoDTO>();
		
		for ( Prestamo cadaPrestamo : prestamos ) {
			dtos.add( adapt(cadaPrestamo) );
		}
		
		return dtos;
	}
}
