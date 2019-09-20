package ar.edu.uca.template;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

import ar.edu.uca.template.entities.Cuenta;
import ar.edu.uca.template.entities.Domicilio;
import ar.edu.uca.template.entities.PersonaJuridica;
import ar.edu.uca.template.entities.Prestamo;
import ar.edu.uca.template.entities.Sucursal;
import ar.edu.uca.template.entities.PersonaFisica;
import ar.edu.uca.template.entities.Persona;

@Component
public class RepositoriesConf extends RepositoryRestConfigurerAdapter {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Cuenta.class, Persona.class, Persona.class, Prestamo.class, Sucursal.class);
    }

}
