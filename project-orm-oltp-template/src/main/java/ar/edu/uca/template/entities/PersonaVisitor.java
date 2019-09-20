package ar.edu.uca.template.entities;

public interface PersonaVisitor<R> {
	public R visit(PersonaFisica personaFisica);
	public R visit(PersonaJuridica personaJuridica);
}
