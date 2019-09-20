package ar.edu.uca.template.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uca.template.entities.Domicilio;
import ar.edu.uca.template.entities.Sucursal;
import ar.edu.uca.template.entities.dtos.SucursalDTO;
import ar.edu.uca.template.repositories.SucursalRepository;

@Service
public class SucursalService {
	@Autowired
	private SucursalRepository sucursalRepository;
	
	@Transactional(
			readOnly = false,
			timeout = 5000,
			propagation = Propagation.SUPPORTS,
			isolation = Isolation.READ_COMMITTED
	)
	public Iterable<Sucursal> findAllSucursal() {
		return this.sucursalRepository.findAll();
	}
	
	@Transactional(
			readOnly = false,
			timeout = 5000,
			propagation = Propagation.REQUIRED,
			isolation = Isolation.READ_COMMITTED
	)
	public Sucursal findSucursalById(long id) {
		return this.sucursalRepository.findOne(id);
	}
	
	@Transactional(
			readOnly = false,
			timeout = 5000,
			propagation = Propagation.REQUIRED,
			isolation = Isolation.READ_COMMITTED
	)
	public Sucursal addSucursalFromDTO(SucursalDTO sucursalDTO) {
		if ( sucursalDTO != null ) {
			Sucursal sucursal = new Sucursal();
			Domicilio domicilio = new Domicilio();
			
			domicilio.setCalle(sucursalDTO.getDomCom_calle());
			domicilio.setNumero(sucursalDTO.getDomCom_numero());
			domicilio.setDepto(sucursalDTO.getDomCom_depto());
			domicilio.setLocalidad(sucursalDTO.getDomCom_localidad());
			domicilio.setPais(sucursalDTO.getDomCom_pais());
			domicilio.setPartido(sucursalDTO.getDomCom_partido());
			domicilio.setProvincia(sucursalDTO.getDomCom_provincia());
			
			sucursal.setDomicilioComercial(domicilio);
			
			this.sucursalRepository.save(sucursal);
			
			return sucursal;
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
	public void removeSucursalById(long id) {
		this.sucursalRepository.delete(id);
	}
}
