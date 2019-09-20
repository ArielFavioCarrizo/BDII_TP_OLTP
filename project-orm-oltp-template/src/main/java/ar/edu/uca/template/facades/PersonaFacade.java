package ar.edu.uca.template.facades;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uca.template.entities.Domicilio;
import ar.edu.uca.template.entities.dtos.PersonaFisicaDTO;
import ar.edu.uca.template.entities.dtos.PersonaJuridicaDTO;
import ar.edu.uca.template.services.PersonaService;

@RestController
public class PersonaFacade {
	@Autowired
	private PersonaService personaService;
	
	@PutMapping("/addPersonaFisica")
	public long addPersonaFisica(
		@RequestParam("nombre") String nombre,
		@RequestParam("apellido") String apellido,
		@RequestParam("fechaDeNacimientoEpoch") long fechaDeNacimientoEpoch,
		@RequestParam("cuit") long cuit,
		@RequestParam("dni") long dni,
		@RequestParam("domCom_calle") String domCom_calle,
		@RequestParam("domCom_numero") int domCom_numero,
		@RequestParam("domCom_depto") String domCom_depto,
		@RequestParam("domCom_provincia") String domCom_provincia,
		@RequestParam("domCom_partido") String domCom_partido,
		@RequestParam("domCom_localidad") String domCom_localidad,
		@RequestParam("domCom_pais") String domCom_pais,
		@RequestParam("domPart_calle") String domPart_calle,
		@RequestParam("domPart_numero") int domPart_numero,
		@RequestParam("domPart_depto") String domPart_depto,
		@RequestParam("domPart_provincia") String domPart_provincia,
		@RequestParam("domPart_partido") String domPart_partido,
		@RequestParam("domPart_localidad") String domPart_localidad,
		@RequestParam("domPart_pais") String domPart_pais
		) {
		PersonaFisicaDTO dto = new PersonaFisicaDTO();
		
		dto.setNombre(nombre);
		dto.setApellido(apellido);
		dto.setFechaDeNacimientoEpoch(fechaDeNacimientoEpoch);
		dto.setCuit(cuit);
		dto.setDni(dni);
		dto.setDomCom_calle(domCom_calle);
		dto.setDomCom_numero(domCom_numero);
		dto.setDomCom_depto(domCom_depto);
		dto.setDomCom_provincia(domCom_provincia);
		dto.setDomCom_partido(domCom_partido);
		dto.setDomCom_localidad(domCom_localidad);
		dto.setDomCom_pais(domCom_pais);
		dto.setDomPart_calle(domPart_calle);
		dto.setDomPart_numero(domPart_numero);
		dto.setDomPart_depto(domPart_depto);
		dto.setDomPart_provincia(domPart_provincia);
		dto.setDomPart_partido(domPart_partido);
		dto.setDomPart_localidad(domPart_localidad);
		dto.setDomPart_pais(domPart_pais);
		
		return this.personaService.addPersonaFromDTO(dto);
	}
	
	@PutMapping("/addPersonaJuridica")
	public long addPersonaJuridica(
		@RequestParam("nombre") String nombre,
		@RequestParam("cuit") long cuit,
		@RequestParam("domCom_calle") String domCom_calle,
		@RequestParam("domCom_numero") int domCom_numero,
		@RequestParam("domCom_depto") String domCom_depto,
		@RequestParam("domCom_provincia") String domCom_provincia,
		@RequestParam("domCom_partido") String domCom_partido,
		@RequestParam("domCom_localidad") String domCom_localidad,
		@RequestParam("domCom_pais") String domCom_pais
		) {
		PersonaJuridicaDTO dto = new PersonaJuridicaDTO();
		
		dto.setNombre(nombre);
		dto.setCuit(cuit);
		dto.setDomCom_calle(domCom_calle);
		dto.setDomCom_numero(domCom_numero);
		dto.setDomCom_depto(domCom_depto);
		dto.setDomCom_provincia(domCom_provincia);
		dto.setDomCom_partido(domCom_partido);
		dto.setDomCom_localidad(domCom_localidad);
		dto.setDomCom_pais(domCom_pais);
		
		return this.personaService.addPersonaFromDTO(dto);
	}
	
	@DeleteMapping("/removePersonaFisicaById")
	public void removePersonaFisicaById(@RequestParam("id") long id) {
		this.personaService.removePersonaFisicaById(id);
	}
	
	@DeleteMapping("/removePersonaJuridicaById")
	public void removePersonaJuridicaById(@RequestParam("id") long id) {
		this.personaService.removePersonaJuridicaById(id);
	}
	
	@PutMapping("/findPersonaFisicaByCuit")
	public void findPersonaFisicaByCuit(long cuit) {
		this.findPersonaFisicaByCuit(cuit);
	}
	
	@RequestMapping("/findPersonaJuridicaByCuit")
	public void findPersonaJuridicaByCuit(long cuit) {
		this.findPersonaJuridicaByCuit(cuit);
	}
}
