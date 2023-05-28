package com.onnis.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onnis.entities.Text;

public interface TestoDAO extends JpaRepository<Text, Long> {

}
