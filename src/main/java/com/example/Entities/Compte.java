package com.example.Entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compte {

	@Id
	private String CodeCompte;
	private Date DateCreation;
	private double Solde;
	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;
	@OneToMany(mappedBy = "compte",fetch = FetchType.LAZY)
	private Collection<Opperation> opperations;
	
	public Compte() {
		super();
	}

	public Compte(String codeCompte, Date dateCreation, double solde, Client client) {
		super();
		CodeCompte = codeCompte;
		DateCreation = dateCreation;
		Solde = solde;
		this.client = client;
		
	}

	public String getCodeCompte() {
		return CodeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		CodeCompte = codeCompte;
	}

	public Date getDateCreation() {
		return DateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}

	public double getSolde() {
		return Solde;
	}

	public void setSolde(double solde) {
		Solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<Opperation> getOpperations() {
		return opperations;
	}

	public void setOpperations(Collection<Opperation> opperations) {
		this.opperations = opperations;
	}
	
	
}
