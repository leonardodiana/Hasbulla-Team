package com.onnis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onnis.entities.Frase;
import com.onnis.repos.FraseDAO;

@Service
public class FraseService {

	@Autowired
	private FraseDAO dao;
	
	public List<Frase> getFrasi(){
		return dao.findAll();
	}
}
