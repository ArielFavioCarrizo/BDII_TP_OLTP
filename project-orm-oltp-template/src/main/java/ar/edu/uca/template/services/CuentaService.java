package ar.edu.uca.template.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uca.template.entities.Cuenta;
import ar.edu.uca.template.entities.Persona;
import ar.edu.uca.template.entities.Sucursal;
import ar.edu.uca.template.entities.dtos.CuentaDTO;
import ar.edu.uca.template.repositories.CuentaRepository;
import ar.edu.uca.template.repositories.PersonaFisicaRepository;
import ar.edu.uca.template.repositories.PersonaJuridicaRepository;
import ar.edu.uca.template.repositories.SucursalRepository;

@Service
public class CuentaService {
	@Autowired
	private CuentaRepository cuentaRepository;
	
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
	public Iterable<Cuenta> findAllCuenta() {
		return this.cuentaRepository.findAll();
	}
	
	@Transactional(
			readOnly = true,
			timeout = 5000,
			propagation = Propagation.SUPPORTS,
			isolation = Isolation.READ_COMMITTED
	)
	public Iterable<Cuenta> findByPersona(Persona persona) {
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		
		for ( Cuenta cadaCuenta : this.findAllCuenta() ) {
			if ( ( cadaCuenta.getTitular().equals(persona) || cadaCuenta.getAsociados().contains(persona) ) ) {
				cuentas.add(cadaCuenta);
			}
		}
		
		return cuentas;
	}
	
	@Transactional(
			readOnly = true,
			timeout = 5000,
			propagation = Propagation.SUPPORTS,
			isolation = Isolation.READ_COMMITTED
	)
	public Iterable<Cuenta> findByPersonaId(long personaId) {
		Persona persona = null;
		
		persona = this.personaFisicaRepository.findOne(personaId);
		
		if ( persona == null ) {
			persona = this.personaJuridicaRepository.findOne(personaId);
		}
		
		if ( persona != null ) {
			return this.findByPersona(persona);
		}
		else {
			throw new IllegalStateException("La persona no existe");
		}
	}
	
	@Transactional(
			readOnly = false,
			timeout = 5000,
			propagation = Propagation.SUPPORTS,
			isolation = Isolation.READ_COMMITTED
	)
	public long addCuentaFromDTO(CuentaDTO cuentaDTO) {
		if ( cuentaDTO != null ) {
			Cuenta cuenta = new Cuenta();
			
			Persona persona = this.personaFisicaRepository.findOne(cuentaDTO.getTitularId());
			if ( persona == null )
				persona = this.personaJuridicaRepository.findOne(cuentaDTO.getTitularId());
			
			cuenta.setTitular(persona);
			
			cuenta.setSucursal( this.sucursalRepository.findOne(cuentaDTO.getSucursalId()) );
			
			cuenta.setSaldo(0);
			
			cuenta = this.cuentaRepository.save(cuenta);
			
			return cuenta.getCuentaId();
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
	public void removeCuenta(Cuenta cuenta) {
		if ( cuenta != null ) {
			if ( cuenta.getSaldo() > 0 ) {
				throw new IllegalStateException("Error: La cuenta tiene saldo");
			}
			
			this.cuentaRepository.delete(cuenta);
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
	public void removeCuentaById(long id) {
		this.removeCuenta( this.cuentaRepository.findOne(id) );
	}
	
	@Transactional(
			readOnly = false,
			timeout = 5000,
			propagation = Propagation.REQUIRED,
			isolation = Isolation.SERIALIZABLE
	)
	public void addAsociadoById(long cuentaId, long personaId) {
		Cuenta cuenta = this.cuentaRepository.findOne(cuentaId);
		
		if ( cuenta == null ) {
			throw new IllegalStateException("La cuenta no existe");
		}
		
		Persona persona = this.personaFisicaRepository.findOne(personaId);
		if ( persona == null )
			persona = this.personaJuridicaRepository.findOne(personaId);
		
		if ( persona == null )
			throw new IllegalStateException("La persona no existe");
		
		for ( Persona cadaPersona : cuenta.getAsociados() ) {
			if ( cadaPersona == persona ) {
				throw new IllegalStateException("La persona ya esta asociada");
			}
		}
		
		cuenta.getAsociados().add(persona);
		
		this.cuentaRepository.save(cuenta);
	}
	
	@Transactional(
			readOnly = false,
			timeout = 5000,
			propagation = Propagation.REQUIRED,
			isolation = Isolation.SERIALIZABLE
	)
	public void removeAsociadoById(long cuentaId, long personaId) {
		Cuenta cuenta = this.cuentaRepository.findOne(cuentaId);
		
		if ( cuenta == null ) {
			throw new IllegalStateException("La cuenta no existe");
		}
		
		Persona persona = this.personaFisicaRepository.findOne(personaId);
		if ( persona == null )
			persona = this.personaJuridicaRepository.findOne(personaId);
		
		if ( persona == null )
			throw new IllegalStateException("La persona no existe");
		
		if ( cuenta.getAsociados().contains(persona) ) {
			cuenta.getAsociados().remove(persona);
		}
		else {
			throw new IllegalStateException("La persona no esta asociada");
		}
	}
	
	@Transactional(
			readOnly = false,
			timeout = 5000,
			propagation = Propagation.REQUIRED,
			isolation = Isolation.SERIALIZABLE
	)
	public void transferir(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto) {
		if ( cuentaOrigen == null ) {
			throw new NullPointerException();
		}
		
		if ( cuentaDestino == null ) {
			throw new NullPointerException();
		}
		
		if ( !(monto > 0) ) {
			throw new IllegalArgumentException("Monto invalido");
		}
		
		if ( monto > cuentaOrigen.getSaldo() ) {
			throw new IllegalStateException("Monto insuficiente en cuenta origen");
		}
		
		cuentaOrigen.setSaldo( cuentaOrigen.getSaldo()-monto );
		cuentaDestino.setSaldo( cuentaDestino.getSaldo()+monto );
	}
	
	@Transactional(
			readOnly = false,
			timeout = 5000,
			propagation = Propagation.REQUIRED,
			isolation = Isolation.SERIALIZABLE
	)
	public void transferirByIDs(long cuentaOrigenId, long cuentaDestinoId, double monto) {
		Cuenta cuentaOrigen = this.cuentaRepository.findOne(cuentaOrigenId);
		Cuenta cuentaDestino = this.cuentaRepository.findOne(cuentaDestinoId);
		
		if ( cuentaOrigen == null ) {
			throw new IllegalStateException("La cuenta origen no existe");
		}
		
		if ( cuentaDestino == null ) {
			throw new IllegalStateException("La cuenta destino no existe");
		}
		
		this.transferir( cuentaOrigen, cuentaDestino, monto );
	}
}
