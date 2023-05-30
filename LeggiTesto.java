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

import com.onnis.entities.Text;
import com.onnis.repos.TestoDAO;

@Component
public class LeggiTesto {
	
	@Autowired
	private TestoDAO dao;

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
	
	
	Text textEntity = new Text();
	textEntity.setContenuto(text);
	dao.save(textEntity);
	}
	
	
}

