package ar.edu.uca.template.services;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uca.template.adapters.PersonaAdapter;
import ar.edu.uca.template.entities.Cuenta;
import ar.edu.uca.template.entities.Domicilio;
import ar.edu.uca.template.entities.Persona;
import ar.edu.uca.template.entities.PersonaFisica;
import ar.edu.uca.template.entities.PersonaJuridica;
import ar.edu.uca.template.repositories.PersonaFisicaRepository;
import ar.edu.uca.template.repositories.PersonaJuridicaRepository;
import ar.edu.uca.template.repositories.PersonaRepository;

import ar.edu.uca.template.entities.PersonaVisitor;
import ar.edu.uca.template.entities.dtos.PersonaDTO;
import ar.edu.uca.template.entities.dtos.PersonaDTOVisitor;
import ar.edu.uca.template.entities.dtos.PersonaFisicaDTO;
import ar.edu.uca.template.entities.dtos.PersonaJuridicaDTO;

@Service
public class PersonaService {
	@Autowired
	private PersonaJuridicaRepository personaJuridicaRepository;
	
	@Autowired
	private PersonaFisicaRepository personaFisicaRepository;
	
	@Transactional(
			readOnly = false,
			timeout = 5000,
			propagation = Propagation.REQUIRED,
			isolation = Isolation.READ_COMMITTED
	)
	public long addPersonaFromDTO(PersonaDTO personaDTO) {
		final PersonaService self = this;
		
		if ( personaDTO != null ) {
			return personaDTO.accept( new PersonaDTOVisitor<Long>() {

				@Override
				public Long visit(PersonaFisicaDTO dto) {
					PersonaFisica persona = new PersonaFisica();
					persona.setNombre(dto.getNombre());
					persona.setApellido(dto.getApellido());
					
					Calendar calendar = new GregorianCalendar();
					calendar.setTimeInMillis(dto.getFechaDeNacimientoEpoch());
					
					persona.setFechaDeNacimiento(calendar.getTime());
					persona.setCuit(dto.getCuit());
					persona.setDni(dto.getDni());
					
					if ( dto.getDomCom_calle() != "" ) {
						Domicilio d = new Domicilio();
						d.setCalle(dto.getDomCom_calle());
						d.setDepto(dto.getDomCom_depto());
						d.setLocalidad(dto.getDomCom_localidad());
						d.setNumero(dto.getDomCom_numero());
						d.setPais(dto.getDomCom_pais());
						d.setPartido(dto.getDomCom_partido());
						d.setProvincia(dto.getDomCom_provincia());
						
						persona.setDomicilioComercial(d);
					}
					
					if ( dto.getDomPart_calle() != "" ) {
						Domicilio d = new Domicilio();
						d.setCalle(dto.getDomPart_calle());
						d.setDepto(dto.getDomPart_depto());
						d.setLocalidad(dto.getDomPart_localidad());
						d.setNumero(dto.getDomPart_numero());
						d.setPais(dto.getDomPart_pais());
						d.setPartido(dto.getDomPart_partido());
						d.setProvincia(dto.getDomPart_provincia());
						
						persona.setDomicilioParticular(d);
					}
					
					return self.personaFisicaRepository.save(persona).getPersonaId();
				}

				@Override
				public Long visit(PersonaJuridicaDTO dto) {
					PersonaJuridica persona = new PersonaJuridica();
					persona.setNombre(dto.getNombre());
					
					persona.setCuit(dto.getCuit());

					if ( dto.getDomCom_calle() != "" ) {
						Domicilio d = new Domicilio();
						d.setCalle(dto.getDomCom_calle());
						d.setDepto(dto.getDomCom_depto());
						d.setLocalidad(dto.getDomCom_localidad());
						d.setNumero(dto.getDomCom_numero());
						d.setPais(dto.getDomCom_pais());
						d.setPartido(dto.getDomCom_partido());
						d.setProvincia(dto.getDomCom_provincia());
						
						persona.setDomicilioComercial(d);
					}
					
					return self.personaJuridicaRepository.save(persona).getPersonaId();
				}
				
			});
		}
		else {
			throw new NullPointerException();
		}
	}
	
	@Transactional(
			readOnly = false,
			timeout = 5000,
			propagation = Propagation.REQUIRED,
			isolation = Isolation.SERIALIZABLE
	)
	public void removePersonaFisicaById(long id) {
		this.personaFisicaRepository.delete(id);
	}
	
	@Transactional(
			readOnly = false,
			timeout = 5000,
			propagation = Propagation.REQUIRED,
			isolation = Isolation.SERIALIZABLE
	)
	public void removePersonaJuridicaById(long id) {
		this.personaJuridicaRepository.delete(id);
	}
	
	@Transactional(
			readOnly = true,
			timeout = 5000,
			propagation = Propagation.SUPPORTS,
			isolation = Isolation.READ_COMMITTED
	)
	public PersonaFisicaDTO findPersonaFisicaByCuit(long cuit) {
		return PersonaAdapter.adapt( this.personaFisicaRepository.findByCuit(cuit) );
	}
	
	@Transactional(
			readOnly = true,
			timeout = 5000,
			propagation = Propagation.SUPPORTS,
			isolation = Isolation.READ_COMMITTED
	)
	public PersonaJuridicaDTO findPersonaJuridicaByCuit(long cuit) {
		return PersonaAdapter.adapt( this.personaJuridicaRepository.findByCuit(cuit) );
	}
}
