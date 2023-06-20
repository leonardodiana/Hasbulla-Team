package com.onnis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.onnis.entities.Text;
import com.onnis.repos.TestoDAO;

@Service
public class TextService {

	@Autowired
	private TestoDAO dao;

	
	
	
	public List<Text> getText() {
		return dao.findAll();
	}
	
	
}
