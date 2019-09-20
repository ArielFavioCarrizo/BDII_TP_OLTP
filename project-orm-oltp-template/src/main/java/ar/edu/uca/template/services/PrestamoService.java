package ar.edu.uca.template.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uca.template.entities.Cuenta;
import ar.edu.uca.template.entities.Persona;
import ar.edu.uca.template.entities.Prestamo;
import ar.edu.uca.template.entities.Sucursal;
import ar.edu.uca.template.entities.dtos.PrestamoDTO;
import ar.edu.uca.template.repositories.PersonaFisicaRepository;
import ar.edu.uca.template.repositories.PersonaJuridicaRepository;
import ar.edu.uca.template.repositories.PrestamoRepository;
import ar.edu.uca.template.repositories.SucursalRepository;

@Service
public class PrestamoService {
	@Autowired
	private PrestamoRepository prestamoRepository;
	
	@Autowired
	private PersonaFisicaRepository personaFisicaRepository;
	
	@Autowired
	private PersonaJuridicaRepository personaJuridicaRepository;
	
	@Autowired
	private SucursalRepository sucursalRepository;
	
	@Transactional(
			readOnly = false,
			timeout = 5000,
			propagation = Propagation.SUPPORTS,
			isolation = Isolation.READ_COMMITTED
	)
	public Iterable<Prestamo> findAllPrestamo() {
		return this.prestamoRepository.findAll();
	}
	
	@Transactional(
			readOnly = true,
			timeout = 5000,
			propagation = Propagation.SUPPORTS,
			isolation = Isolation.READ_COMMITTED
	)
	public Iterable<Prestamo> findByClienteId(long personaId) {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		
		for ( Prestamo cadaPrestamo : this.findAllPrestamo() ) {
			if ( cadaPrestamo.getCliente().getPersonaId() == personaId ) {
				prestamos.add(cadaPrestamo);
			}
		}
		
		return prestamos;
	}
	
	@Transactional(
			readOnly = true,
			timeout = 5000,
			propagation = Propagation.SUPPORTS,
			isolation = Isolation.READ_COMMITTED
	)
	public Iterable<Prestamo> findBySucursalId(long sucursalId) {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		
		for ( Prestamo cadaPrestamo : this.findAllPrestamo() ) {
			if ( cadaPrestamo.getSucursal().getSucursalId() == sucursalId ) {
				prestamos.add(cadaPrestamo);
			}
		}
		
		return prestamos;
	}
	
	@Transactional(
			readOnly = false,
			timeout = 5000,
			propagation = Propagation.REQUIRED,
			isolation = Isolation.READ_COMMITTED
	)
	public long addPrestamoFromDTO(PrestamoDTO prestamoDTO) {
		if ( prestamoDTO != null ) {
			Prestamo prestamo = new Prestamo();
			
			Persona persona;
			
			persona = this.personaFisicaRepository.findOne(prestamoDTO.getClienteId());
			
			if ( persona == null ) {
				persona = this.personaJuridicaRepository.findOne(prestamoDTO.getClienteId());
			}
			
			if ( persona == null ) {
				throw new IllegalStateException("Persona inexistente");
			}
			
			prestamo.setCliente(persona);
			
			Sucursal sucursal = this.sucursalRepository.findOne(prestamoDTO.getPrestamoId());
			
			if ( sucursal == null ) {
				throw new IllegalStateException("La sucursal no existe");
			}
			
			prestamo.setSucursal( sucursal );
			
			if ( ! ( prestamoDTO.getMonto() > 0.0d ) ) {
				throw new IllegalArgumentException("Monto invalido");
			}
 			
			prestamo.setMonto(prestamoDTO.getMonto());
			
			Calendar calendar = new GregorianCalendar();
			
			if ( prestamoDTO.getFechaDeVencimientoEpoch() < prestamoDTO.getFechaDeComienzoEpoch() ) {
				throw new IllegalArgumentException("Vencimiento anterior al comienzo");
			}
			
			calendar.setTimeInMillis(prestamoDTO.getFechaDeComienzoEpoch());
			prestamo.setFechaDeComienzo(calendar.getTime());
			
			calendar.setTimeInMillis(prestamoDTO.getFechaDeVencimientoEpoch());
			prestamo.setFechaDeVencimiento(calendar.getTime());
			
			prestamo = this.prestamoRepository.save(prestamo);
			
			return prestamo.getPrestamoId();
		}
		else {
			throw new NullPointerException();
		}
	}
	
	@Transactional(
			readOnly = false,
			timeout = 5000,
			propagation = Propagation.REQUIRED,
			isolation = Isolation.SERIALIZABLE
	)
	public void pagarPrestamo(Prestamo prestamo, double monto) {
		if ( prestamo != null ) {
			if ( !(monto > 0) ) {
				throw new IllegalArgumentException("Monto invalido");
			}
			
			if ( monto > prestamo.getMonto() ) {
				throw new IllegalStateException("Monto excesivo");
			}
			
			this.prestamoRepository.delete(prestamo);
		}
		else {
			throw new NullPointerException();
		}
	}
	
	@Transactional(
			readOnly = false,
			timeout = 5000,
			propagation = Propagation.REQUIRED,
			isolation = Isolation.SERIALIZABLE
	)
	public void pagarPrestamoById(long prestamoId, double monto) {
		Prestamo prestamo = this.prestamoRepository.findOne(prestamoId);
		
		if ( prestamo == null ) {
			throw new IllegalStateException("El prestamo no existe");
		}
		
		this.pagarPrestamo(prestamo, monto);
	}
}
