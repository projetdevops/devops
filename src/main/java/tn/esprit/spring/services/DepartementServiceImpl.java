package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class DepartementServiceImpl  implements IDepartementService {
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;

	@Override
	public int ajouterDepartement(Departement departement) {
		deptRepoistory.save(departement);
		return departement.getId();
		
	}

	@Override
	public String getDepartementNameById(int departementId) {
		Departement departementManagedEntity = deptRepoistory.findById(departementId).get();
		return departementManagedEntity.getName();
		
	}

	@Override
	public void deleteDepartementById(int departementId) {
		Departement departement = deptRepoistory.findById(departementId).get();
		deptRepoistory.delete(departement);
		
	}

	@Override
	public int getNombreDepartementJPQL() {
		return deptRepoistory.countemp();
	}

	@Override
	public List<String> getAllDepartementNamesJPQL() {
		return deptRepoistory.employeNames();

	}

	@Override
	public List<Departement> getAllDepartements() {
		return (List<Departement>) deptRepoistory.findAll();
	}

}
