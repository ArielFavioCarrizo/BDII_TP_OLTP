package ar.edu.uca.template.repositories;

import javax.transaction.Transactional;

import ar.edu.uca.template.entities.PersonaJuridica;

@Transactional
public interface PersonaJuridicaRepository extends PersonaRepository<PersonaJuridica> {

}
