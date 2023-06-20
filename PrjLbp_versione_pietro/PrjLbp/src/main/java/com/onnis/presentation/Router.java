package com.onnis.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onnis.LeggiTesto;
import com.onnis.entities.Frase;
import com.onnis.entities.Parole;
import com.onnis.entities.Text;
import com.onnis.repos.FraseDAO;
import com.onnis.repos.ParolaDAO;
import com.onnis.repos.TestoDAO;
import com.onnis.service.FraseService;
import com.onnis.service.ParolaService;
import com.onnis.service.TextService;

@Controller
@RequestMapping("/")
public class Router {

    @Autowired
    private FraseService serviceFrase;
    @Autowired
    private TextService serviceTesto;
    @Autowired 
    private ParolaService serviceParola;
    @Autowired
	private TestoDAO dao;
    @Autowired
	private FraseDAO daoFrase;
	@Autowired
	private ParolaDAO daoParola;
    
   

    @GetMapping("/index")
    public String mostraForm(Model model) {
        model.addAttribute("testo", ""); // Inizializza il campo testo nel form
        return "index";
    }

    @PostMapping("/analizza")
    public String analyzeText(@RequestParam String testo, Model model) throws IOException {
        
        
        
        System.out.println(testo);
        
        BufferedReader reader = new BufferedReader(new StringReader(testo));
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
        
        
    	Text testoUpdated = dao.save(testoCreated);
    	return "analizzatore-risultati";
    }
}
