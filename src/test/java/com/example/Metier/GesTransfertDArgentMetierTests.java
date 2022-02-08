package com.example.Metier;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jca.context.SpringContextResourceAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Dao.ClientRepository;
import com.example.Dao.CompteRepository;
import com.example.Dao.OperationRepository;
import com.example.Entities.Client;
import com.example.Entities.Compte;
import com.example.Metier.BanqueMetierImplment;
import com.example.Metier.IBanqueMetier;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@DataJpaTest
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration
//@PropertySource("classpath:application.properties")
//@AutoConfigureTestDatabase(connection=EmbeddedDatabaseConnection.H2)


@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
 public class GesTransfertDArgentMetierTests {
	
	
	@TestConfiguration
	static class GesTransfertDArgentMetierTestsContxtConf{
		@Bean
		public IBanqueMetier iBanqueMetier() {
			return new BanqueMetierImplment();
		}
	}
	 
  	
	@Autowired
	private IBanqueMetier iBanqueMetier;
	@MockBean
	private ClientRepository clientRepository;
	@MockBean
	private CompteRepository compteRepository;
	//@MockBean
	//private OperationRepository operationRepository;
	Client c;
	//@Autowired
	
	//@Autowired
	
	/*
	 * @Before public void init() { c=new Client("AbdRahmane", "53527",
	 * "abdrahmane@gmail.com"); }
	 */
	/*
	 * @Test public void tesTest() { String ss=iBanqueMetier.meTest("med");
	 * 
	 * assertEquals("med", ss); }
	 */
	
	  @Test
	 public  void addClientTest() { 
		  
		  iBanqueMetier.addClient(c); 
	      long idC=c.getId_client(); 
	      Client c1;
	      c1=iBanqueMetier.chercheClient(idC);
	      assertThat(c.getNom()).isEqualTo(c1.getNom());  
	  	//assertEquals(c.getNom(), c1.getNom());
	  	//assertEquals(c.getEmail(),c1.getEmail());
	    
	  }
	    
	 /*
	 * @Test public void chercheClientTest() { Client c1=
	 * iBanqueMetier.chercheClient(c.getId_client());
	 * assertEquals(c.getId_client(),c.getId_client()); }
	 * 
	 * @Test public void supprimeClientTest() { Client c2=new Client("Abdoou",
	 * "53527", "abde@gmail.com"); iBanqueMetier.addClient(c2); long
	 * idC2=c2.getId_client(); iBanqueMetier.supprimerClint(idC2);
	 * assertEquals(iBanqueMetier.chercheClient(idC2),null); }
	 * 
	 * @Test public void verifieClientTest() { Client c2=new Client("Abdoou",
	 * "53527", "abde@gmail.com"); String nom=c2.getNom(); Compte cmpt=new
	 * Compte("cd3366", new Date(), 64672, c2); String
	 * codeCmpt=cmpt.getCodeCompte();
	 * assertEquals(iBanqueMetier.verifieClient(nom,codeCmpt),true); }
	 * 
	 * @Test public void verserTest() { Client c2=new Client("Abdoou", "53527",
	 * "abde@gmail.com"); Compte cmpt=new Compte("cd3366", new Date(), 64672, c2);
	 * String codeCmpt=cmpt.getCodeCompte(); double slode0=cmpt.getSolde(); double
	 * mntVerser=6000; iBanqueMetier.verser(codeCmpt, mntVerser);
	 * 
	 * assertEquals(cmpt.getSolde(), slode0+mntVerser);
	 * 
	 * }
	 * 
	 * @Test public void retirerTest() { Client c2=new Client("Abdoou", "53527",
	 * "abde@gmail.com"); Compte cmpt=new Compte("cd3366", new Date(), 64672, c2);
	 * String codeCmpt=cmpt.getCodeCompte(); double slode0=cmpt.getSolde(); double
	 * mntVerser=6000; iBanqueMetier.retirer(codeCmpt, mntVerser);
	 * assertEquals(cmpt.getSolde(), slode0-mntVerser);
	 * 
	 * }
	 */



}
