package ar.edu.uca.template.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.uca.template.entities.Domicilio;
import ar.edu.uca.template.entities.Sucursal;

@Transactional
public interface SucursalRepository extends CrudRepository<Sucursal, Long> {
	Sucursal findByDomicilioComercial(Domicilio domicilioComercial);
}
