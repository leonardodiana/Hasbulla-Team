package com.onnis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Parole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_parole;
	
	private String contenuto;

	public long getId_parole() {
		return id_parole;
	}

	public void setId_parole(long id_parole) {
		this.id_parole = id_parole;
	}

	public String getContenuto() {
		return contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}
	
	
}
