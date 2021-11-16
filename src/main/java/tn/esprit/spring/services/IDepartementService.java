package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;
public interface IDepartementService {
	public int ajouterDepartement(Departement departement);
	public String getDepartementNameById(int departementId);
	public void deleteDepartementById(int departementId);
	public int getNombreDepartementJPQL();
	public List<String> getAllDepartementNamesJPQL();
	public List<Departement> getAllDepartements();

}
