package tn.esprit.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;

public class RestControlDepartement {
	@Autowired
	IEmployeService iemployeservice;
	@Autowired
	IEntrepriseService ientrepriseservice;
	@Autowired
	ITimesheetService itimesheetservice;
	@Autowired
	IDepartementService idepartementservice;
	
	// http://localhost:8085/SpringMVC/servlet/ajouterDepartement
		//{"id":1,"nom":"kallel", "prenom":"khaled", "email":"Khaled.kallel@ssiiconsulting.tn", "isActif":true, "role":"INGENIEUR"}
	@PostMapping("/ajouterDepartement")
	@ResponseBody
	public Departement ajouterDepartement(@RequestBody Departement departement)
	{
		idepartementservice.ajouterDepartement(departement);
		return departement;
	}
	
	   // URL : http://localhost:8085/SpringMVC/servlet/getDepartementNameById/2
	   @GetMapping(value = "getDepartementNameById/{iddep}")
	   @ResponseBody
	   public String getDepartementNameById(@PathVariable("iddep")int departementId) {
			return idepartementservice.getDepartementNameById(departementId);
		}
	   
	// URL : http://localhost:8085/SpringMVC/servlet/deleteDepartementById/1
	    @DeleteMapping("/deleteDepartementById/{iddep}") 
		@ResponseBody 
		public void deleteDepartementById(@PathVariable("iddep")int departementId) {
	    	idepartementservice.deleteDepartementById(departementId);
			
		}
	    
	    // URL : http://localhost:8085/SpringMVC/servlet/getNombreDepartementJPQL
	    @GetMapping(value = "getNombreDepartementJPQL")
	    @ResponseBody
		public int getNombreDepartementJPQL() {
			
			return idepartementservice.getNombreDepartementJPQL();
		}

	    // URL : http://localhost:8085/SpringMVC/servlet/getAllDepartementNamesJPQL
	    @GetMapping(value = "getAllDepartementNamesJPQL")
	    @ResponseBody
		public List<String> getAllDepartementNamesJPQL() {
			
			return idepartementservice.getAllDepartementNamesJPQL();
		}
	    
		 // URL : http://localhost:8085/SpringMVC/servlet/getAllDepartements
		@GetMapping(value = "/getAllDepartements")
	    @ResponseBody
		public List<Departement> getAllDepartements() {
			
			return idepartementservice.getAllDepartements();
		}
}

