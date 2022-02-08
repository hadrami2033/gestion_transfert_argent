package com.example.Entities;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client{

	@Id @GeneratedValue
	private long id_client;
	private String Nom;
	private String password;
	private String email;
	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
	private Collection<Compte> comptes;
	
	
	public Client() { 
	} 


	public Client(String nom, String password, String email) {
		super();
		Nom = nom;
		this.password = password;
		this.email = email;
	}


	public Client(String nom, String password) {
		super();
		Nom = nom;
		this.password = password;
	}


	public long getId_client() {
		return id_client;
	}


	public void setId_client(long id_client) {
		this.id_client = id_client;
	}


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Collection<Compte> getComptes() {
		return comptes;
	}


	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	
	
	
	}
