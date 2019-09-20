package ar.edu.uca.template.adapters;

import java.util.Calendar;
import java.util.GregorianCalendar;

import ar.edu.uca.template.entities.Domicilio;
import ar.edu.uca.template.entities.Persona;
import ar.edu.uca.template.entities.PersonaFisica;
import ar.edu.uca.template.entities.PersonaJuridica;
import ar.edu.uca.template.entities.PersonaVisitor;
import ar.edu.uca.template.entities.dtos.PersonaDTO;
import ar.edu.uca.template.entities.dtos.PersonaFisicaDTO;
import ar.edu.uca.template.entities.dtos.PersonaJuridicaDTO;

public class PersonaAdapter {
	public static PersonaFisicaDTO adapt(PersonaFisica personaFisica) {
		PersonaFisicaDTO dto = new PersonaFisicaDTO();
		
		dto.setPersonaId(personaFisica.getPersonaId());
		dto.setNombre(personaFisica.getNombre());
		dto.setApellido(personaFisica.getApellido());
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(personaFisica.getFechaDeNacimiento());
		
		dto.setFechaDeNacimientoEpoch(calendar.getTimeInMillis());
		dto.setCuit(personaFisica.getCuit());
		dto.setDni(personaFisica.getDni());
		Domicilio domCom = personaFisica.getDomicilioComercial();
		
		if ( domCom != null ) {
			dto.setDomCom_calle(domCom.getCalle());
			dto.setDomCom_numero(domCom.getNumero());
			dto.setDomCom_depto(domCom.getDepto());
			dto.setDomCom_localidad(domCom.getLocalidad());
			dto.setDomCom_pais(domCom.getPais());
			dto.setDomCom_partido(domCom.getPartido());
			dto.setDomCom_provincia(domCom.getProvincia());
			dto.setDomCom_localidad(domCom.getLocalidad());
		}

		Domicilio domPart = personaFisica.getDomicilioParticular();
		
		if ( domPart != null ) {
			dto.setDomCom_calle(domPart.getCalle());
			dto.setDomCom_numero(domPart.getNumero());
			dto.setDomCom_depto(domPart.getDepto());
			dto.setDomCom_localidad(domPart.getLocalidad());
			dto.setDomCom_pais(domPart.getPais());
			dto.setDomCom_partido(domPart.getPartido());
			dto.setDomCom_provincia(domPart.getProvincia());
			dto.setDomCom_localidad(domPart.getLocalidad());
		}

		return dto;
	}
	
	public static PersonaJuridicaDTO adapt(PersonaJuridica personaJuridica) {
		PersonaJuridicaDTO dto = new PersonaJuridicaDTO();
		
		dto.setPersonaId(personaJuridica.getPersonaId());
		dto.setCuit(personaJuridica.getCuit());
		dto.setNombre(personaJuridica.getNombre());
		Domicilio domCom = personaJuridica.getDomicilioComercial();
		
		if ( domCom != null ) {
			dto.setDomCom_calle(domCom.getCalle());
			dto.setDomCom_numero(domCom.getNumero());
			dto.setDomCom_depto(domCom.getDepto());
			dto.setDomCom_localidad(domCom.getLocalidad());
			dto.setDomCom_pais(domCom.getPais());
			dto.setDomCom_partido(domCom.getPartido());
			dto.setDomCom_provincia(domCom.getProvincia());
			dto.setDomCom_localidad(domCom.getLocalidad());
		}

		return dto;
	}
}
