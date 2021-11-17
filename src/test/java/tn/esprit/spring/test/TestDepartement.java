package tn.esprit.spring.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.DepartementServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)

public class TestDepartement {
	private static final Logger l = LogManager.getLogger(TestDepartement.class);

	@Autowired
	private  DepartementServiceImpl departementservice ;
	@Autowired
	private  DepartementRepository departementrepository ;
	
	int IDdp ;
	
	@Test
	public void ajouterDepartement()
	{   int nbrB, nbrA ;
		
		Departement d =new Departement("ingenieur");
		departementservice.ajouterDepartement(d);
		 
		assertThat(d.getId()>0);
		l.info("le departement est ajouteé avec succés");
		
		
		IDdp = d.getId();
		
		
	}
	@Test
	public void dltDPT(){
		if(IDdp>0)
		{
			 departementservice.deleteDepartementById(IDdp);
			 l.info("le departement  est supprimé");
		}else
		{
			 l.info("le departement  est non supprimé");
		}
	}
	
	
		
	
	
	
}
