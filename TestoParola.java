package com.onnis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TestoParola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "testo_id")
    private Text testo;

    @ManyToOne
    @JoinColumn(name = "parola_id")
    private Parole parola;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Text getTesto() {
        return testo;
    }

    public void setTesto(Text testo) {
        this.testo = testo;
    }

    public Parole getParola() {
        return parola;
    }

    public void setParola(Parole parola) {
        this.parola = parola;
    }
}
