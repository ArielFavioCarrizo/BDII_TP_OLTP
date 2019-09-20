package ar.edu.uca.template.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uca.template.adapters.CuentaAdapter;
import ar.edu.uca.template.entities.dtos.CuentaDTO;
import ar.edu.uca.template.services.CuentaService;

@RestController
public class CuentaFacade {
	@Autowired
	private CuentaService cuentaService;
	
	@GetMapping(value = "/findByPersona")
	public Iterable<CuentaDTO> findByPersona(@RequestParam("personaId") long personaId) {
		return CuentaAdapter.adapt(this.cuentaService.findByPersonaId(personaId));
	}
	
	@PutMapping("/addCuenta")
	public long addCuenta(
		@RequestParam("titularId") long titularId,
		@RequestParam("sucursalId") long sucursalId
    ) {
		CuentaDTO cuentaDTO = new CuentaDTO();
		cuentaDTO.setSucursalId(sucursalId);
		cuentaDTO.setTitularId(titularId);
		
		return this.cuentaService.addCuentaFromDTO(cuentaDTO);
	}
	
	@DeleteMapping("/removeCuenta")
	public void removeCuenta(@RequestParam("id") long id) {		
		this.cuentaService.removeCuentaById(id);
	}
	
	@PatchMapping("addAsociadoCuenta")
	public void addAsociadoCuenta(@RequestParam("cuentaId") long cuentaId, @RequestParam("personaId") long personaId) {
		this.cuentaService.addAsociadoById(cuentaId, personaId);
	}
	
	@PatchMapping("removeAsociadoCuenta")
	public void removeAsociadoCuenta(@RequestParam("cuentaId") long cuentaId, @RequestParam("personaId") long personaId) {
		this.cuentaService.removeAsociadoById(cuentaId, personaId);
	}
	
	@PatchMapping("/transferir")
	public void transferir(
		@RequestParam("cuentaOrigenId") long cuentaOrigenId,
		@RequestParam("cuentaDestinoId") long cuentaDestinoId,
		@RequestParam("monto") double monto
	) {
		this.cuentaService.transferirByIDs(cuentaOrigenId, cuentaDestinoId, monto);
	}
}
