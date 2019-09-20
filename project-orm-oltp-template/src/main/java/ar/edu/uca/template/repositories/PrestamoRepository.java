package ar.edu.uca.template.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.uca.template.entities.Prestamo;

@Transactional
public interface PrestamoRepository extends CrudRepository<Prestamo, Long> {
	
}
