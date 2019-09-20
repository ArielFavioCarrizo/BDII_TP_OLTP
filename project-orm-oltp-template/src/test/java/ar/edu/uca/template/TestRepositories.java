package ar.edu.uca.template;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.function.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uca.template.entities.Cuenta;
import ar.edu.uca.template.entities.Domicilio;
import ar.edu.uca.template.entities.Persona;
import ar.edu.uca.template.entities.PersonaFisica;
import ar.edu.uca.template.entities.PersonaJuridica;
import ar.edu.uca.template.entities.Prestamo;
import ar.edu.uca.template.entities.Sucursal;
import ar.edu.uca.template.repositories.CuentaRepository;
import ar.edu.uca.template.repositories.PersonaFisicaRepository;
import ar.edu.uca.template.repositories.PersonaJuridicaRepository;
import ar.edu.uca.template.repositories.PersonaRepository;
import ar.edu.uca.template.repositories.PrestamoRepository;
import ar.edu.uca.template.repositories.SucursalRepository;
import org.junit.Assert;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
public class TestRepositories {
	@Autowired
	private CuentaRepository cuentaRepository;
	@Autowired
	private PersonaFisicaRepository personaFisicaRepository;
	@Autowired
	private PersonaJuridicaRepository personaJuridicaRepository;
	@Autowired
	private SucursalRepository sucursalRepository;
	@Autowired
	private PrestamoRepository prestamoRepository;
	
	private long sucursal1_id;
	private long sucursal2_id;
	private long sucursal3_id;
	
	private long juanPerez_id;
	private long cuentaJuanPerez_id;
	
	private long joseMontero_id;
	
	private long luisGerardo_id;
	
	private long esferixisSolutions_id;
	private long cuentaEsferixisSolutions_id;
	
	private long jupiter_id;
	private long cuentaJupiter_id;
	
	private long prestamoJupiter1_id;
	private long prestamoJupiter2_id;
	private long prestamoLuisGerardo_id;
	
	@Before
	public void setUp() throws Exception {
		Calendar calendar = new GregorianCalendar();
		
		Domicilio domicilioSucursal1;
				
	    domicilioSucursal1 = new Domicilio();
		domicilioSucursal1.setCalle("Av Cabildo");
		domicilioSucursal1.setNumero(3802);
		domicilioSucursal1.setDepto("");
		domicilioSucursal1.setPais("Argentina");
		domicilioSucursal1.setProvincia("CABA");
		domicilioSucursal1.setPartido("");
		domicilioSucursal1.setLocalidad("");
		
		Sucursal sucursal1 = new Sucursal();
		sucursal1.setDomicilioComercial(domicilioSucursal1);
		sucursal1 = this.sucursalRepository.save(sucursal1);
		this.sucursal1_id = sucursal1.getSucursalId();
		
	    Domicilio domicilioSucursal2 = new Domicilio();
		domicilioSucursal2.setCalle("Av Santa Fe");
		domicilioSucursal2.setNumero(2343);
		domicilioSucursal2.setDepto("");
		domicilioSucursal2.setPais("Argentina");
		domicilioSucursal2.setProvincia("CABA");
		domicilioSucursal2.setPartido("");
		domicilioSucursal2.setLocalidad("");
		
		Sucursal sucursal2 = new Sucursal();
		sucursal2.setDomicilioComercial(domicilioSucursal2);
		sucursal2 = this.sucursalRepository.save(sucursal2);
		this.sucursal2_id = sucursal2.getSucursalId();
		
	    Domicilio domicilioSucursal3 = new Domicilio();
		domicilioSucursal3.setCalle("Av San Martin");
		domicilioSucursal3.setNumero(1234);
		domicilioSucursal3.setDepto("");
		domicilioSucursal3.setPais("Argentina");
		domicilioSucursal3.setProvincia("Buenos Aires");
		domicilioSucursal3.setPartido("Tres De Febrero");
		domicilioSucursal3.setLocalidad("Caseros");
		
		Sucursal sucursal3 = new Sucursal();
		sucursal3.setDomicilioComercial(domicilioSucursal3);
	 	sucursal3 = this.sucursalRepository.save(sucursal3);
	 	this.sucursal3_id = sucursal3.getSucursalId();
	 	
	    Domicilio domicilioJuanPerez = new Domicilio();
		domicilioJuanPerez.setCalle("Av Santa Fe");
		domicilioJuanPerez.setNumero(1456);
		domicilioJuanPerez.setDepto("");
		domicilioJuanPerez.setPais("Argentina");
		domicilioJuanPerez.setProvincia("CABA");
		domicilioJuanPerez.setPartido("");
		domicilioJuanPerez.setLocalidad("");
		
		PersonaFisica juanPerez = new PersonaFisica();
		juanPerez.setNombre("Juan");
		juanPerez.setApellido("Perez");
		juanPerez.setDni(35243747);
		juanPerez.setDomicilioParticular(domicilioJuanPerez);
		juanPerez.setCuit(20352437479l);
		
		calendar.set(1990, 7, 15);
		juanPerez.setFechaDeNacimiento(calendar.getTime());
	    juanPerez = this.personaFisicaRepository.save(juanPerez);
	    this.juanPerez_id = juanPerez.getPersonaId();
	    
		Cuenta cuentaJuanPerez = new Cuenta();
		cuentaJuanPerez.setSucursal(sucursal1);
		cuentaJuanPerez.setTitular(juanPerez);
		cuentaJuanPerez = this.cuentaRepository.save(cuentaJuanPerez);
		this.cuentaJuanPerez_id = cuentaJuanPerez.getCuentaId();
		
	    Domicilio domicilioJoseMontero = new Domicilio();
		domicilioJoseMontero.setCalle("Av Santa Fe");
		domicilioJoseMontero.setNumero(1921);
		domicilioJoseMontero.setDepto("");
		domicilioJoseMontero.setPais("Argentina");
		domicilioJoseMontero.setProvincia("CABA");
		domicilioJoseMontero.setPartido("");
		domicilioJoseMontero.setLocalidad("");
		
		PersonaFisica joseMontero = new PersonaFisica();
		joseMontero.setNombre("Jose");
		joseMontero.setApellido("Montero");
		joseMontero.setDni(39268227);
		joseMontero.setDomicilioParticular(domicilioJoseMontero);
		joseMontero.setCuit(20392682279l);
		
		calendar.set(1985, 5, 18);
		joseMontero.setFechaDeNacimiento(calendar.getTime());
	    joseMontero = this.personaFisicaRepository.save(joseMontero);
	    this.joseMontero_id = joseMontero.getPersonaId();
	  
		PersonaFisica luisGerardo = new PersonaFisica();
		luisGerardo.setNombre("Luis");
		luisGerardo.setApellido("Gerardo");
		luisGerardo.setDni(39268221);
		luisGerardo.setDomicilioParticular(domicilioJoseMontero);
		luisGerardo.setCuit(20392682271l);
		
		calendar.set(1987, 3, 25);
		luisGerardo.setFechaDeNacimiento(calendar.getTime());
	    luisGerardo = this.personaFisicaRepository.save(luisGerardo);
	    this.luisGerardo_id = luisGerardo.getPersonaId();
	   
	    Domicilio domicilioEsferixisSolutions = new Domicilio();
		domicilioEsferixisSolutions.setCalle("San Pedrito");
		domicilioEsferixisSolutions.setNumero(456);
		domicilioEsferixisSolutions.setDepto("");
		domicilioEsferixisSolutions.setPais("Argentina");
		domicilioEsferixisSolutions.setProvincia("CABA");
		domicilioEsferixisSolutions.setPartido("");
		domicilioEsferixisSolutions.setLocalidad("");
		
		PersonaJuridica esferixisSolutions = new PersonaJuridica();
		esferixisSolutions.setNombre("Esferixis solutions");
		esferixisSolutions.setCuit(30802456781l);
		esferixisSolutions.setDomicilioComercial(domicilioEsferixisSolutions);
	    esferixisSolutions = this.personaJuridicaRepository.save(esferixisSolutions);
		this.esferixisSolutions_id = esferixisSolutions.getPersonaId();
		
		Cuenta cuentaEsferixisSolutions = new Cuenta();
		cuentaEsferixisSolutions.setSucursal(sucursal2);
		cuentaEsferixisSolutions.setTitular(esferixisSolutions);
		cuentaEsferixisSolutions.getAsociados().add(luisGerardo);
		cuentaEsferixisSolutions = this.cuentaRepository.save(cuentaEsferixisSolutions);
		this.cuentaEsferixisSolutions_id = cuentaEsferixisSolutions.getCuentaId();
	    
	    Domicilio domicilioJupiter = new Domicilio();
		domicilioJupiter.setCalle("San Nicolas");
		domicilioJupiter.setNumero(788);
		domicilioJupiter.setDepto("");
		domicilioJupiter.setPais("Argentina");
		domicilioJupiter.setProvincia("CABA");
		domicilioJupiter.setPartido("");
		domicilioJupiter.setLocalidad("");
	    
		PersonaJuridica jupiter = new PersonaJuridica();
		jupiter.setNombre("Jupiter");
		jupiter.setCuit(30302652431l);
		jupiter.setDomicilioComercial(domicilioJupiter);
		
	    jupiter = this.personaJuridicaRepository.save(jupiter);
	    this.jupiter_id = jupiter.getPersonaId();
	    
		Cuenta cuentaJupiter = new Cuenta();
		cuentaJupiter.setSucursal(sucursal3);
		cuentaJupiter.setTitular(jupiter);
		cuentaJupiter = this.cuentaRepository.save(cuentaJupiter);
		this.cuentaJupiter_id = cuentaJupiter.getCuentaId();
		
		Prestamo prestamoJupiter1 = new Prestamo();
		prestamoJupiter1.setSucursal(sucursal3);
		prestamoJupiter1.setCliente(jupiter);
		prestamoJupiter1.setMonto(250000);
		calendar.set(2017, 2, 20);
		prestamoJupiter1.setFechaDeVencimiento(calendar.getTime());
		calendar.set(2019, 2, 20);
		prestamoJupiter1.setFechaDeVencimiento(calendar.getTime());
		prestamoJupiter1 = this.prestamoRepository.save(prestamoJupiter1);
		this.prestamoJupiter1_id = prestamoJupiter1.getPrestamoId();
		
		Prestamo prestamoJupiter2 = new Prestamo();
		prestamoJupiter2.setSucursal(sucursal3);
		prestamoJupiter2.setCliente(jupiter);
		prestamoJupiter2.setMonto(800000);
		calendar.set(2017, 5, 20);
		prestamoJupiter2.setFechaDeVencimiento(calendar.getTime());
		calendar.set(2019, 5, 20);
		prestamoJupiter2.setFechaDeVencimiento(calendar.getTime());
		prestamoJupiter2 = this.prestamoRepository.save(prestamoJupiter2);
		this.prestamoJupiter2_id = prestamoJupiter2.getPrestamoId();
		
		Prestamo prestamoLuisGerardo = new Prestamo();
		prestamoLuisGerardo.setSucursal(sucursal1);
		prestamoLuisGerardo.setCliente(luisGerardo);
		prestamoLuisGerardo.setMonto(100000);
		calendar.set(2017, 1, 27);
		prestamoLuisGerardo.setFechaDeVencimiento(calendar.getTime());
		calendar.set(2019, 3, 24);
		prestamoLuisGerardo.setFechaDeVencimiento(calendar.getTime());
		prestamoLuisGerardo = this.prestamoRepository.save(prestamoLuisGerardo);
		this.prestamoLuisGerardo_id = prestamoLuisGerardo.getPrestamoId();
	}

	/*
	@After
	public void tearDown() throws Exception {
		
	}
	*/
	
	private <T extends Persona> void testTitularCuentaRelation(PersonaRepository<T> personaRepository, long titular_id, long cuenta_id) {
		Persona titularById = personaRepository.findOne(titular_id);
		Cuenta cuentaById = cuentaRepository.findOne(cuenta_id);
		
		Assert.assertEquals(titularById, cuentaById.getTitular());
	}
	
	private void testCuentaSucursalRelation(long cuenta_id, long sucursal_id) {
		Cuenta cuentaById = cuentaRepository.findOne(cuenta_id);
		Sucursal sucursalById = sucursalRepository.findOne(sucursal_id);
		
		Assert.assertEquals(sucursalById, cuentaById.getSucursal());
	}
	
	private void testPrestamoSucursalRelation(long prestamo_id, long sucursal_id) {
		Prestamo prestamoById = prestamoRepository.findOne(prestamo_id);
		Sucursal sucursalById = sucursalRepository.findOne(sucursal_id);
		
		Assert.assertEquals(sucursalById, prestamoById.getSucursal());
	}
	
	private <T extends Persona> void testPrestamoClienteRelation(PersonaRepository<T> personaRepository, long prestamo_id, long cliente_id) {
		Prestamo prestamoById = prestamoRepository.findOne(prestamo_id);
		Persona clienteById = personaRepository.findOne(cliente_id);
		
		Assert.assertEquals(clienteById, prestamoById.getCliente());
	}
	
	@Test
	public void testTitularidadCuentaJuanPerezRelation() {
		this.testTitularCuentaRelation(this.personaFisicaRepository, this.juanPerez_id, this.cuentaJuanPerez_id);
	}

	@Test 
	public void testCuentaJuanPerezSucursalRelation() {
		this.testCuentaSucursalRelation(this.cuentaJuanPerez_id, this.sucursal1_id);
	}
	
	@Test
	public void testTitularidadCuentaEsferixisSolutionsRelation() {
		this.testTitularCuentaRelation(this.personaJuridicaRepository, this.esferixisSolutions_id, this.cuentaEsferixisSolutions_id);
	}
	
	@Test
	public void testCuentaEsferixisSolutionsSucursalRelation() {
		this.testCuentaSucursalRelation(this.cuentaEsferixisSolutions_id, this.sucursal2_id);
	}
	
	@Test
	public void testCuentaJupiterSucursalRelation() {
		this.testCuentaSucursalRelation(this.cuentaJupiter_id, this.sucursal3_id);
	}
	
	@Test
	public void testPrestamoJupiter1SucursalRelation() {
		this.testPrestamoSucursalRelation(this.prestamoJupiter1_id, this.sucursal3_id);
	}
	
	@Test
	public void testPrestamoJupiter1ClienteRelation() {
		this.testPrestamoClienteRelation(this.personaJuridicaRepository, this.prestamoJupiter1_id, this.jupiter_id);
	}
	
	@Test
	public void testPrestamoJupiter2SucursalRelation() {
		this.testPrestamoSucursalRelation(this.prestamoJupiter2_id, this.sucursal3_id);
	}
	
	@Test
	public void testPrestamoJupiter2ClienteRelation() {
		this.testPrestamoClienteRelation(this.personaJuridicaRepository, this.prestamoJupiter2_id, this.jupiter_id);
	}
	
	@Test
	public void testPrestamoLuisGerardoSucursalRelation() {
		this.testPrestamoSucursalRelation(this.prestamoLuisGerardo_id, this.sucursal1_id);
	}
	
	@Test
	public void testPrestamoLuisGerardoClienteRelation() {
		this.testPrestamoClienteRelation(this.personaFisicaRepository, this.prestamoLuisGerardo_id, this.luisGerardo_id);
	}
	
	@Test
	public void testCuentaRepository() {
		System.out.println("Cuentas: ");
		
		for (Cuenta a : cuentaRepository.findAll()) 
			System.out.println(a);
	}	
	
	@Test
	public void testPersonaJuridicaRepository() {
		System.out.println("Personas juridicas: ");
		
		for (PersonaJuridica a : personaJuridicaRepository.findAll()) 
			System.out.println(a);			
	}
	
	@Test
	public void testPersonaFisicaRepository() {
		System.out.println("Personas fisicas: ");
		
		for (PersonaFisica a : personaFisicaRepository.findAll()) 
			System.out.println(a);			
	}
	
	@Test
	public void testSucursalRepository() {
		System.out.println("Sucursales: ");
		
		for (Sucursal a : this.sucursalRepository.findAll()) 
			System.out.println(a);
	}
	
}
