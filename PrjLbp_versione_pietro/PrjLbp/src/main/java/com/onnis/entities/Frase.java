package com.onnis.entities;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="frase")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Frase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_frase;
	

	@Column(length=20000)
	private String contenuto;
	
	private int numeroParole;
	
	@Column(length=20000)
	private String parolaChiave;
	
	@Column(length=20000)
	private String parolaPiùLunga;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testo_id")
    private Text text;
	
    @JsonBackReference
    @OneToMany(mappedBy = "frase", cascade = CascadeType.ALL)
    private List<Parole> parole;
	

    

	public String getParolaPiùLunga() {
		return parolaPiùLunga;
	}

	public void setParolaPiùLunga(String parolaPiùLunga) {
		this.parolaPiùLunga = parolaPiùLunga;
	}

	public int getNumeroParole() {
		return numeroParole;
	}

	public void setNumeroParole(int length) {
		this.numeroParole = length;
	}


	public String getParolaChiave() {
		return parolaChiave;
	}

	public void setParolaChiave(String mostRepeatedWord) {
		this.parolaChiave = mostRepeatedWord;
	}

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

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public List<Parole> getParole() {
		return parole;
	}

	public void setParole(List<Parole> parole) {
		this.parole = parole;
	}
	
	
}
