package com.onnis.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onnis.entities.Frase;

public interface FraseDAO extends JpaRepository<Frase, Long> {

}
