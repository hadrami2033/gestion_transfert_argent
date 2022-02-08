package com.example.Metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Dao.ClientRepository;
import com.example.Dao.CompteRepository;
import com.example.Dao.OperationRepository;
import com.example.Entities.Admin;
import com.example.Entities.Client;
import com.example.Entities.Compte;
import com.example.Entities.Opperation;
import com.example.Entities.Retrait;

import com.example.Entities.Versement;

@Service
@Transactional
public class BanqueMetierImplment implements IBanqueMetier{

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Compte consulterCompte(String codeCompte) {
		Optional<Compte> cpts=compteRepository.findById(codeCompte);
		Compte cp=cpts.get();
		if(cp==null) 
			throw new RuntimeException("Compte n'existe pas !");
		return cp;
	}

	@Override
	public void verser(String codeCompte, double montant) {
		Compte cp=consulterCompte(codeCompte);
		Versement v=new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde()+montant);
		compteRepository.save(cp);
		
	}

	@Override
	public void retirer(String codeCompte, double montant) {
		Compte cp=consulterCompte(codeCompte);
		if(cp.getSolde()<montant)
			throw new RuntimeException("Solde Insuffisant");
		Retrait R=new Retrait(new Date(), montant, cp);
		operationRepository.save(R);
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);
		
	}

	@Override
	public void virement(String codeCompte1, String codeCompte2, double montant) {
		
			retirer(codeCompte1, montant);
			verser(codeCompte2, montant);
		
		
		
	}

	@Override
	public Page<Opperation> listOpperation(String codeCompte, int page, int size) {
		return operationRepository.listOperation(codeCompte, new PageRequest(page, size));
	}

	@Override
	public void supprimerClint(long IdClient) {
		/*
		 * User user = userRepository.getOne(IdUser); if(user instanceof Admin) throw
		 * new RuntimeException("n'est pas possible de supprimer un Administrateur !");
		 * userRepository.delete(user);
		 */
		 clientRepository.deleteById(IdClient);

	   
	}

	@Override
	public Compte addCompte(Compte compte) {
		// TODO Auto-generated method stub
		return compteRepository.save(compte);
	}

	@Override
	public Client addClient(Client clt) {
		// TODO Auto-generated method stub
		return clientRepository.save(clt);
	}

	@Override
	public Client chercheClient(long idCl) {
		Optional<Client> c= clientRepository.findById(idCl);
		return c.get();
	}

	@Override
	public Compte chercheCompte(String codeCompte) {
		Optional<Compte> cmp= compteRepository.findById(codeCompte);
		Compte compte=null;
		if(cmp.isPresent()==true)
			compte=cmp.get();
		return compte;
	}

	@Override
	public boolean verifieClient(String nom, String codeCompte) {
		if(chercheCompte(codeCompte)==null) {
			return false;
		}else {
			String NOM=chercheCompte(codeCompte).getClient().getNom();
			if(nom.equals(NOM)) {
				return true;
			}
			return false;
		}
	}

	@Override
	public String meTest(String s) {
		// TODO Auto-generated method stub
		return s;
	}
	

}
