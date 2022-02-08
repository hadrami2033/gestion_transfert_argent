package com.example;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Dao.ClientRepository;
import com.example.Dao.CompteRepository;
import com.example.Dao.OperationRepository;
import com.example.Entities.Admin;
import com.example.Entities.Client;
import com.example.Entities.Compte;
import com.example.Entities.Retrait;
import com.example.Entities.Versement;
import com.example.Metier.IBanqueMetier;

@SpringBootApplication
public class GesTransfertDArgentApplication implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier iBanqueMetier;
	
	public static void main(String[] args) {
		SpringApplication.run(GesTransfertDArgentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client cl1=clientRepository.save(new Client("vadi","1425", "vadli28@gmail.com"));
		Client cl2=clientRepository.save(new Client("najim","hdr1234", "najmi4433@gmail.com"));
		Client cl5=clientRepository.save(new Client("vadil","065675", "gadfi28@gmail.com"));
		Client cl6=clientRepository.save(new Client("molay","79825", "mlaay28@gmail.com"));
		
		Compte cm1=compteRepository.save(new Compte("cd3344", new Date(), 5462378, cl1));
		Compte cm2=compteRepository.save(new Compte("cd3644", new Date(), 90000, cl2));
		
		operationRepository.save(new Versement(new Date(), 67457, cm1));
		operationRepository.save(new Retrait(new Date(), 67457, cm2));

		iBanqueMetier.verser("cd3344", 203399);
		//iBanqueMetier.supprimerClint(1);
		
	}


}
