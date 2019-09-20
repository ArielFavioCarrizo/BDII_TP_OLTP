package ar.edu.uca.template.facades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uca.template.entities.Domicilio;
import ar.edu.uca.template.entities.Sucursal;
import ar.edu.uca.template.entities.dtos.SucursalDTO;
import ar.edu.uca.template.services.SucursalService;

import ar.edu.uca.template.adapters.SucursalAdapter;

@RestController
public class SucursalFacade {
	@Autowired
	private SucursalService sucursalService;
	
	@GetMapping("/findAllSucursales")
	public List<SucursalDTO> findAllSucursales()
	{
		return SucursalAdapter.adaptIterable(this.sucursalService.findAllSucursal());
	}
	
	@PutMapping("/addSucursalByDomicilio")
	public long addSucursalByDomicilio(
		@RequestParam("calle") String calle,
		@RequestParam("numero") int numero,
		@RequestParam("depto") String depto,
		@RequestParam("provincia") String provincia,
		@RequestParam("partido") String partido,
		@RequestParam("localidad") String localidad,
		@RequestParam("localidad") String pais
		) {
		Domicilio domicilio = new Domicilio();
		domicilio.setCalle(calle);
		domicilio.setNumero(numero);
		domicilio.setProvincia(provincia);
		domicilio.setPartido(partido);
		domicilio.setLocalidad(localidad);
		
		SucursalDTO dto = new SucursalDTO();
		dto.setDomCom_calle(calle);
		dto.setDomCom_numero(numero);
		dto.setDomCom_depto(depto);
		dto.setDomCom_provincia(provincia);
		dto.setDomCom_partido(partido);
		dto.setDomCom_localidad(localidad);
		dto.setDomCom_pais(pais);
		
		return this.sucursalService.addSucursalFromDTO(dto).getSucursalId();
	}
	
	@GetMapping("/findSucursalById")
	public SucursalDTO findSucursalById(long id) {
		return SucursalAdapter.adapt( this.sucursalService.findSucursalById(id) );
	}
	
	@DeleteMapping("/removeSucursalById")
	public SucursalDTO removeSucursalById(long id) {
		Sucursal sucursal = this.sucursalService.findSucursalById(id);
		SucursalDTO sucursalDto = SucursalAdapter.adapt(sucursal);
		
		this.sucursalService.removeSucursalById(id);
		
		return sucursalDto;
	}
}
