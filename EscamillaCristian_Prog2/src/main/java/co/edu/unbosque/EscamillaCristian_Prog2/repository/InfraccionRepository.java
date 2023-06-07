package co.edu.unbosque.EscamillaCristian_Prog2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.EscamillaCristian_Prog2.model.Infraccion;


public interface InfraccionRepository extends CrudRepository<Infraccion, Integer> {

	
	public void deleteByPlaca(String placa);
	
	public Optional<Infraccion> findById(Integer id);
	
	public Optional<List<Infraccion>> findByPlaca(String placa);
	
	public List<Infraccion> findAll();
	
}
