package co.edu.unbosque.EscamillaCristian_Prog2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.EscamillaCristian_Prog2.model.Vehiculo;

public interface VehiculoRepository extends CrudRepository<Vehiculo, Integer> {

	
	public void deleteByPlaca(String placa);
	
	public Optional<Vehiculo> findById(Integer id);
	
	public Optional<List<Vehiculo>> findByPlaca(String placa);
	
	public List<Vehiculo> findAll();
	
}

