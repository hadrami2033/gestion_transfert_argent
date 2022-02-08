package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Dao.ClientRepository;
import com.example.Entities.Client;


//@RunWith(SpringRunner.class)
@DataJpaTest
@ExtendWith(SpringExtension.class)
public class GesTransfertJPAtests {
	
	@Autowired
	private ClientRepository clientRepository;
	

	  @Test
	 public  void addClientTest() { 
		  Client c=new Client("hdrm", "1234", "gggg@gmail.com");
		  clientRepository.save(c);
	      long idC=c.getId_client(); 
	      Optional<Client> c0;
	      c0=clientRepository.findById(idC);
	      Client c1=c0.get();
	      assertThat(c1.getNom()).isEqualTo(c1.getNom());  
	  	//assertEquals(c.getNom(), c1.getNom());
	  	//assertEquals(c.getEmail(),c1.getEmail());
	    
	  }

}
