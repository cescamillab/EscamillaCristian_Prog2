package co.edu.unbosque.EscamillaCristian_Prog2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.EscamillaCristian_Prog2.model.Dueno;


public interface DuenoRepository extends CrudRepository<Dueno, Integer> {

	
	public void deleteByCedula(String cedula);
	
	public Optional<Dueno> findById(Integer id);
	
	public Optional<List<Dueno>> findByCedula(String cedula);
	
	public List<Dueno> findAll();
	
}
