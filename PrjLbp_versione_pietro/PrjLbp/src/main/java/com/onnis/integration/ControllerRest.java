package com.onnis.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onnis.entities.Frase;
import com.onnis.entities.Parole;
import com.onnis.entities.Text;
import com.onnis.service.FraseService;
import com.onnis.service.ParolaService;
import com.onnis.service.TextService;

@RestController
public class ControllerRest {

	@Autowired
	private ParolaService serviceParola;
	@Autowired
	private FraseService serviceFrase;
	@Autowired
	private TextService serviceText;
	
	@GetMapping("parole")
	public List<Parole> getParola() {
		return serviceParola.getParola();
	}
	
	@GetMapping("frase")
	public List<Frase> getFrasi(){
		return serviceFrase.getFrasi();
	}
	
	@GetMapping("testi")
	public List<Text> getTesti(){
		return serviceText.getText();
	}
	
}
