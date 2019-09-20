package ar.edu.uca.template.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.uca.template.entities.Cuenta;

@Transactional
public interface CuentaRepository extends CrudRepository<Cuenta, Long> {

}
