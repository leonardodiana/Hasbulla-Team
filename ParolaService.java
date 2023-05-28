package com.onnis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onnis.entities.Parole;
import com.onnis.repos.ParolaDAO;

@Service
public class ParolaService {

	@Autowired
	private ParolaDAO dao;
	
	public List<Parole> getParola() {
		return dao.findAll();
		
	}
}
