package co.edu.unbosque.EscamillaCristian_Prog2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.EscamillaCristian_Prog2.model.Dueno;
import co.edu.unbosque.EscamillaCristian_Prog2.model.Vehiculo;
import co.edu.unbosque.EscamillaCristian_Prog2.model.Infraccion;
import co.edu.unbosque.EscamillaCristian_Prog2.repository.DuenoRepository;
import co.edu.unbosque.EscamillaCristian_Prog2.repository.InfraccionRepository;
import co.edu.unbosque.EscamillaCristian_Prog2.repository.VehiculoRepository;
import jakarta.transaction.Transactional;

@Transactional
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cristianapi")
public class Controller {
	@Autowired
	private DuenoRepository drep;
	private VehiculoRepository vrep;
	private InfraccionRepository irep;
	
	@PostMapping("/dueño-agregar")
	public ResponseEntity<String> agregarDueno(@RequestParam String nombre,@RequestParam String cedula){
		Dueno tempd = new Dueno();
		tempd.setNombre(nombre);
		tempd.setCedula(cedula);
		drep.save(tempd);
		return ResponseEntity.status(HttpStatus.CREATED).body("Dueño creado con exito");
	}
	
	@DeleteMapping("/dueño-eliminar")
	public ResponseEntity<String> eliminarDueno(@RequestParam String cedula){
		Optional<List<Dueno>> dato = drep.findByCedula(cedula);
		List<Dueno> temp = dato.get();
		if(temp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar el dato.");
		}
		drep.deleteByCedula(cedula);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Dato eliminado con exito.");
 	}
	
	@PutMapping("/dueño-actualizar")
	public ResponseEntity<String> actualizarDueno(@RequestParam Integer id,@RequestParam String cedula,@RequestParam String nombre){
		Optional<Dueno> dato = drep.findById(id);
		if(dato.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dato no encontrado");
		}
		Dueno temp = dato.get();
		temp.setCedula(cedula);
		temp.setNombre(nombre);
		drep.save(temp);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Dato actualizado con exito.");
		
	}
	
	@GetMapping("/dueño-lista")
	public ResponseEntity<List<Dueno>> mostrarDueno(){
		List<Dueno> lista = (List<Dueno>) drep.findAll();
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(lista);
	}
	
	@PostMapping("/vehiculo-agregar")
	public ResponseEntity<String> agregarVehiculo(@RequestParam String cedula,@RequestParam String placa,@RequestParam String marca,@RequestParam String modelo){
		Vehiculo tempv = new Vehiculo();
		tempv.setCedula(cedula);
		tempv.setPlaca(placa);
		tempv.setMarca(marca);
		tempv.setModelo(modelo);
		vrep.save(tempv);
		return ResponseEntity.status(HttpStatus.CREATED).body("Dueño creado con exito");
	}
	
	@DeleteMapping("/vehiculo-eliminar")
	public ResponseEntity<String> eliminarVehiculo(@RequestParam String placa){
		Optional<List<Vehiculo>> dato = vrep.findByPlaca(placa);
		List<Vehiculo> temp = dato.get();
		if(temp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar el dato.");
		}
		vrep.deleteByPlaca(placa);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Dato eliminado con exito.");
 	}
	
	@PutMapping("/vehiculo-actualizar")
	public ResponseEntity<String> actualizarVehiculo(@RequestParam Integer id,@RequestParam String placa,@RequestParam String marca,@RequestParam String modelo){
		Optional<Vehiculo> dato = vrep.findById(id);
		if(dato.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dato no encontrado");
		}
		Vehiculo temp = dato.get();
		temp.setPlaca(placa);
		temp.setMarca(marca);
		temp.setModelo(modelo);
		vrep.save(temp);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Dato actualizado con exito.");
		
	}
	
	@GetMapping("/vehiculo-lista")
	public ResponseEntity<List<Vehiculo>> mostrarVehiculo(){
		List<Vehiculo> lista = (List<Vehiculo>) vrep.findAll();
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(lista);
	}
	
	@PostMapping("/infraccion-agragar")
	public ResponseEntity<String> agregarInfraccion(@RequestParam String placa,@RequestParam String infraccion){
		Infraccion tempi = new Infraccion();
		tempi.setPlaca(placa);
		tempi.setInfraccion(infraccion);
		irep.save(tempi);
		return ResponseEntity.status(HttpStatus.CREATED).body("Dueño creado con exito");
	}
	
	@DeleteMapping("/infraccion-eliminar")
	public ResponseEntity<String> eliminarInfraccion(@RequestParam String placa){
		Optional<List<Infraccion>> dato = irep.findByPlaca(placa);
		List<Infraccion> temp = dato.get();
		if(temp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar el dato.");
		}
		irep.deleteByPlaca(placa);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Dato eliminado con exito.");
 	}
	
	@PutMapping("/infraccion-actualizar")
	public ResponseEntity<String> actualizarInfraccion(@RequestParam Integer id,@RequestParam String infraccion){
		Optional<Infraccion> dato = irep.findById(id);
		if(dato.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dato no encontrado");
		}
		Infraccion temp = dato.get();
		temp.setInfraccion(infraccion);
		irep.save(temp);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Dato actualizado con exito.");
		
	}
	
	@GetMapping("/infraccion-lista")
	public ResponseEntity<List<Infraccion>> mostrarInfraccion(){
		List<Infraccion> lista = (List<Infraccion>) irep.findAll();
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(lista);
	}
	
}
