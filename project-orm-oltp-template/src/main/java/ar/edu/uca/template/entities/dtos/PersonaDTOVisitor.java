package ar.edu.uca.template.entities.dtos;

public interface PersonaDTOVisitor<R> {
	public R visit(PersonaFisicaDTO personaFisicaDTO);
	public R visit(PersonaJuridicaDTO personaJuridicaDTO);
}
