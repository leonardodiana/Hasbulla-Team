package com.onnis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.onnis.entities.Frase;
import com.onnis.entities.Parole;
import com.onnis.entities.Text;
import com.onnis.repos.FraseDAO;
import com.onnis.repos.ParolaDAO;
import com.onnis.repos.TestoDAO;
import com.onnis.repos.TestoFraseDAO;

@Component
public class LeggiTesto {
	
	@Autowired
	private TestoDAO dao;
	@Autowired
	private FraseDAO daoFrase;
	@Autowired
	private TestoFraseDAO daoTF;
	@Autowired
	private ParolaDAO daoParola;

	@EventListener(ApplicationReadyEvent.class)
	public void leggiFile() {
		
	Scanner scanner = new Scanner(System.in);
	BufferedReader reader = null;
	try {
		reader = new BufferedReader(new FileReader("C:\\Users\\ICTS22-24.084\\Desktop\\provaa.txt"));
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	StringBuilder sb = new StringBuilder();
	String line;
	try {
		while ((line = reader.readLine()) != null) {
		    sb.append(line);
		    sb.append(System.lineSeparator());
		}
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	String text = sb.toString();
	
	
	Text textEntity = new Text();//dare id
	textEntity.setContenuto(text);
	textEntity.setNumeroParole(daoParola.count());
	dao.save(textEntity);
	
	String[] frasi = text.split("\\.\\s+");
	for (String frase : frasi) {
	    Frase frasee = new Frase();
	    frasee.setContenuto(frase.trim());
	    daoFrase.save(frasee);
	}
	
	String[] words = text.split("\\s+");
    for (String word : words) {
    	Parole parola = new Parole();
    	parola.setContenuto(word);
    	daoParola.save(parola);
    }
        
	
	}
	


	
	
}



