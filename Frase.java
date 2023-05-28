package com.onnis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Frase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_frase;
	
	private String contenuto;

	public long getId_frase() {
		return id_frase;
	}

	public void setId_frase(long id_frase) {
		this.id_frase = id_frase;
	}

	public String getContenuto() {
		return contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}
	
	
}
