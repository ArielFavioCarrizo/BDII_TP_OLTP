package ar.edu.uca.template.repositories;

import javax.transaction.Transactional;

import ar.edu.uca.template.entities.Domicilio;
import ar.edu.uca.template.entities.PersonaFisica;

@Transactional
public interface PersonaFisicaRepository extends PersonaRepository<PersonaFisica> {
	PersonaFisica findByDomicilioParticular(Domicilio domicilio);
	
	PersonaFisica findByDni(long dni);
}
