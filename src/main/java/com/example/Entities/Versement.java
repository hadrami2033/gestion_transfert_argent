package com.example.Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Versement")
public class Versement extends Opperation {

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Date dateOpperation, double montant, Compte compte) {
		super( dateOpperation, montant, compte);
		// TODO Auto-generated constructor stub
	}

	
}
