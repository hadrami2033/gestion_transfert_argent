package com.example.Entities;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_Operation",discriminatorType = DiscriminatorType.STRING,length = 12)
public class Opperation {

	@Id @GeneratedValue
	private long numOpperation;
	private Date DateOpperation;
	private double montant;
	@ManyToOne
	@JoinColumn(name = "Code_compte")
	private Compte compte;
	
	
	public Opperation() {
		super();
	}
	public Opperation(Date dateOpperation, double montant, Compte compte) {
		super();
		DateOpperation = dateOpperation;
		this.montant = montant;
		this.compte = compte;
	}
	public long getNumOpperation() {
		return numOpperation;
	}
	public void setNumOpperation(long numOpperation) {
		this.numOpperation = numOpperation;
	}
	public Date getDateOpperation() {
		return DateOpperation;
	}
	public void setDateOpperation(Date dateOpperation) {
		DateOpperation = dateOpperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
}
