package com.onnis.entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "testo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Text {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(length=10000)
    private String contenuto;
    

    private long numeroParole;
    
    private long numeroFrasi;
	
	private long numeroCaratteri = 0;
	
	@Column(length=20000)
	private String parolaChiave = "";
	
	private String parolaPiùLunga = "";
	
    
	@OneToMany(mappedBy = "text", cascade = CascadeType.ALL)
    private List<Frase> frasi;

    
	public long getNumeroFrasi() {
		return numeroFrasi;
	}
	public void setNumeroFrasi(long numeroFrasi) {
		this.numeroFrasi = numeroFrasi;
	}
	
	public String getParolaPiùLunga() {
		return parolaPiùLunga;
	}
	public void setParolaPiùLunga(String parolaPiùLunga) {
		this.parolaPiùLunga = parolaPiùLunga;
	}
	public long getNumeroParole() {
		return numeroParole;
	}
	public void setNumeroParole(long numeroParole) {
		this.numeroParole = numeroParole;
	}
	public long getNumeroCaratteri() {
		return numeroCaratteri;
	}
	public void setNumeroCaratteri(long numeroCaratteri) {
		this.numeroCaratteri = numeroCaratteri;
	}
	public String getParolaChiave() {
		return parolaChiave;
	}
	public void setParolaChiave(String mostRepeatedWord) {
		this.parolaChiave = mostRepeatedWord;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContenuto() {
		return contenuto;
	}
	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}
	

    
    
}