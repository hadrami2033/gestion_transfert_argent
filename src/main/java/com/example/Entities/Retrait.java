package com.example.Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Retrait")
public class Retrait extends Opperation{

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date dateOpperation, double montant, Compte compte) {
		super(dateOpperation, montant, compte);
		// TODO Auto-generated constructor stub
	}

	
}
