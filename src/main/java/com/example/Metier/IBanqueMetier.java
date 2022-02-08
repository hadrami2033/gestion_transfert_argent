package com.example.Metier;
import org.springframework.data.domain.Page;

import com.example.Entities.Client;
import com.example.Entities.Compte;
import com.example.Entities.Opperation;

public interface IBanqueMetier {

	public Compte consulterCompte(String codeCompte);
	public void verser(String codeCompte,double montant);
	public void retirer(String codeCompte,double montant);
	public void virement(String codeCompte1,String codeCompte2,double montant);
	public Page<Opperation> listOpperation(String codeCompte,int page,int size);
	public void supprimerClint(long IdClient);
	public Compte addCompte(Compte cmpt);
	public Client addClient(Client clt);
	public Client chercheClient(long idClient);
	public Compte chercheCompte(String codeCompte);
	public boolean verifieClient(String nom,String codeCompte);
	public String meTest(String s);
	
}
