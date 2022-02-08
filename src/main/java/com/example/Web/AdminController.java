package com.example.Web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Dao.ClientRepository;
import com.example.Entities.Client;
@Controller
public class AdminController {
	@Autowired
	private ClientRepository clientRepository;
		 @RequestMapping(value="/login")  
		 public String login(){      
			 return "redirect:/login";  
			 }  
		 @RequestMapping(value="/consulterUnCompte")
		 public String index(){
			 
			 return "redirect:/Choisir";  
			 }  
		 @RequestMapping(value="/gestionClients")  
		 public String gestionClient( Model model){  
			 
			 List<Client> listClient=clientRepository.findAll();
			 model.addAttribute("listClients", listClient);
			
			 return "gesClients";  
			 }  
		 @RequestMapping(value="/403")  
			 public String accessDenied(){   
			 return "403";  
			 }
		 
		 
		 
	
}
