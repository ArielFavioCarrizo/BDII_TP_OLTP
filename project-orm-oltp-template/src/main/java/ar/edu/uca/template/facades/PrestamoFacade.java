package ar.edu.uca.template.facades;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.uca.template.adapters.PrestamoAdapter;
import ar.edu.uca.template.entities.dtos.PrestamoDTO;
import ar.edu.uca.template.services.PrestamoService;

public class PrestamoFacade {
	@Autowired
	private PrestamoService prestamoService;
	
	@PutMapping("/addPrestamo")
	public long addPrestamo(
			@RequestParam("sucursalId") long sucursalId,
			@RequestParam("clienteId") long clienteId,
			@RequestParam("monto") double monto,
			@RequestParam("fechaDeComienzoEpoch") long fechaDeComienzoEpoch,
			@RequestParam("fechaDeVencimientoEpoch") long fechaDeVencimientoEpoch
	) {
		PrestamoDTO prestamoDTO = new PrestamoDTO();
		
		prestamoDTO.setSucursalId(sucursalId);
		prestamoDTO.setClienteId(clienteId);
		prestamoDTO.setMonto(monto);
		prestamoDTO.setFechaDeComienzoEpoch(fechaDeComienzoEpoch);
		prestamoDTO.setFechaDeVencimientoEpoch(fechaDeVencimientoEpoch);
		
		return this.prestamoService.addPrestamoFromDTO(prestamoDTO);
	}
	
	@GetMapping("/findAllPrestamo")
	public Iterable<PrestamoDTO> findAllPrestamo() {
		return PrestamoAdapter.adapt( this.prestamoService.findAllPrestamo() );
	}
	
	@GetMapping("/findByClienteId")
	public Iterable<PrestamoDTO> findByClienteId(@RequestParam("clienteId") long clienteId) {
		return PrestamoAdapter.adapt( this.prestamoService.findByClienteId(clienteId) );
	}
	
	@GetMapping("/findBySucursalId")
	public Iterable<PrestamoDTO> findBySucursalId(@RequestParam("sucursalId") long sucursalId) {
		return PrestamoAdapter.adapt( this.prestamoService.findBySucursalId(sucursalId) );
	}
	
	@PatchMapping("/pagarPrestamo")
	public void pagarPrestamo(@RequestParam("prestamoId") long prestamoId, @RequestParam("monto") double monto) {
		this.prestamoService.pagarPrestamoById(prestamoId, monto);
	}
}
