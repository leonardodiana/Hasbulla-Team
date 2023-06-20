package com.onnis.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="parole")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Parole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_parole;
	
	
	private String contenuto;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "frase_id")
	    private Frase frase;

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

	public Frase getFrase() {
		return frase;
	}

	public void setFrase(Frase frase) {
		this.frase = frase;
	}
	
	
}
