package com.onnis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FraseParola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "frase_id")
    private Frase frase;

    @ManyToOne
    @JoinColumn(name = "parola_id")
    private Parole parola;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Frase getFrase() {
        return frase;
    }

    public void setFrase(Frase frase) {
        this.frase = frase;
    }

    public Parole getParole() {
        return parola;
    }

    public void setParole(Parole parole) {
        this.parola = parole;
    }
}