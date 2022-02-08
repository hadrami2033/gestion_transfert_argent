package com.example.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dao.ClientRepository;
import com.example.Entities.Client;
import com.example.Entities.Compte;
import com.example.Metier.IBanqueMetier;

import antlr.collections.List;

@Controller
public class ClientController {

	@Autowired
	private IBanqueMetier iBanqueMetier;
	@Autowired
	private ClientRepository clientRepository;
	
	@RequestMapping("/index")
	public String index(){
			return "index";	
	}
	 
	@RequestMapping("/votreCompte")
	public String consulteCompte(Model model,
			@RequestParam(name="nom", defaultValue = "") String Nom,
			@RequestParam(name="codeCmpt", defaultValue = "") String codeCmpt) {
		
		boolean passe=iBanqueMetier.verifieClient(Nom, codeCmpt);
		if(passe==false) {
			model.addAttribute("ressayer", "Assurez vos infos SVP");
			return "index";
		}
		model.addAttribute("ressayer", "");
		model.addAttribute("nomClient", Nom);
		model.addAttribute("codeCmptClient", codeCmpt);
		model.addAttribute("compte", iBanqueMetier.chercheCompte(codeCmpt));
		return "comptes";
	}
	
	@RequestMapping(value="/saveOperation",method = RequestMethod.POST)
	public String enregitrerOperation(Model model,String typeOperation,
		String codeCompte,double montant,String codeCompte2) {
		String nomC=iBanqueMetier.chercheCompte(codeCompte).getClient().getNom();
		try {
			if(typeOperation.equals("VER")) {
				iBanqueMetier.verser(codeCompte, montant);
			}
			else if(typeOperation.equals("VIR")) {
				iBanqueMetier.virement(codeCompte, codeCompte2, montant);
			}
			else 
				if(typeOperation.equals("RET")) {
					iBanqueMetier.retirer(codeCompte, montant);
			}
			
		} catch (Exception e) {
			model.addAttribute("exception", e);
		}
		
		return "redirect:/votreCompte?nom="+nomC+"&codeCmpt="+codeCompte;
		
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(Long id) {
		iBanqueMetier.supprimerClint(id);
		return "redirect:/gestionClients";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String ajoutClient(Model model) {
		model.addAttribute("client", new Client());
		return "formAjoutClient";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveClient(Model model,Client client) {
		//iBanqueMetier.addClient(client);
		clientRepository.save(client);
		return "redirect:/gestionClients";
	}
	
	
}
