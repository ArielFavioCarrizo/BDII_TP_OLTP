package ar.edu.uca.template.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import ar.edu.uca.template.entities.Domicilio;
import ar.edu.uca.template.entities.Persona;

@NoRepositoryBean
public interface PersonaRepository<T extends Persona> extends CrudRepository<T, Long> {
	T findByDomicilioComercial(Domicilio domicilio);
	T findByCuit(long cuit);
}
