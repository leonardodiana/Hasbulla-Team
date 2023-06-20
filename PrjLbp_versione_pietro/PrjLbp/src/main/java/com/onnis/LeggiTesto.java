package com.onnis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

@Component
public class LeggiTesto {
	
	@Autowired
	private TestoDAO dao;
	@Autowired
	private FraseDAO daoFrase;
	@Autowired
	private ParolaDAO daoParola;
	
	


	@EventListener(ApplicationReadyEvent.class)
	public void leggiFile() {
		
	/*Scanner scanner = new Scanner(System.in);
	BufferedReader reader = null;
	try {
		reader = new BufferedReader(new FileReader("C:\\Users\\ICTS22-24.346\\Desktop\\provaa.txt"));
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
	Text testoCreated = dao.save(textEntity);
	testoCreated.setNumeroCaratteri(textEntity.getContenuto().length());//aggiungere numerofrasi per avere contacaratteri corretto
	
	String[] frasi = text.split("\\.\\s+");
	for (String frase : frasi) {
	    Frase frasee = new Frase();
	    frasee.setContenuto(frase.trim());
	    frasee.setText(testoCreated);
	    Frase fraseCreated = daoFrase.save(frasee);
	    String[] words = frase.split("\\s+");
	    fraseCreated.setNumeroParole(words.length);
	    
	    
	    
	    int max = 0;
	    String mostRepeatedWord = "";
	    Map<String, Integer> wordCount = new HashMap<>();
	    
	    for (String word : words) {
	    	int count = wordCount.getOrDefault(word, 0) + 1;
	    	wordCount.put(word, count);
	    	if (count > max) {
	    		max = count;
	    		mostRepeatedWord = word;
	    		frasee.setParolaChiave(mostRepeatedWord);
	    		textEntity.setParolaChiave(mostRepeatedWord);
	    	}
	    }
	    String[] parole = frase.split("[\\p{Punct}&&[^.@]]+|\\s+");
	    String longestWord = "";
	    for (String parola: parole) {
	    	if (parola.length() > longestWord.length()) {
	    		longestWord = parola;
	    	}
	    	frasee.setParolaPiùLunga(longestWord);
	    	
	    }
	    daoFrase.save(fraseCreated);
	    
	    
	    
	    
	    
	    long numeroFrasii = textEntity.getNumeroFrasi();
	    for (String word : words) {
    	Parole parola = new Parole();
    	parola.setContenuto(word);
    	parola.setFrase(fraseCreated);
    	daoParola.save(parola);
   
    	if (textEntity.getParolaPiùLunga().length()<word.length()) {
    		textEntity.setParolaPiùLunga(word);
    	}
	    }
    	
    	
        
	   
	    
	    
	    
	String[] numberWord = text.split("\\s+");
    testoCreated.setNumeroParole(numberWord.length);
    testoCreated.setNumeroFrasi(frasi.length);
    
	}
    
    
	Text testoUpdated = dao.save(testoCreated);*/
	
        
	
	}
	


	
	
}

