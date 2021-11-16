package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Departement;
import java.util.List;
import org.springframework.data.jpa.repository.Query;



public interface DepartementRepository extends CrudRepository<Departement, Integer>{
	@Query("SELECT count(*) FROM Departement")
    public int countemp();
	
	
	@Query("SELECT name FROM Departement")
    public List<String> employeNames();

}
