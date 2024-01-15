package org.generation.italy.eserciziostreamnig.model;

import java.sql.Time;
import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity  
public class contenuto implements Comparable<contenuto>{
	//creazione delle tabelle 
	
	@Id
	@Column (nullable = false, length=30)
	private String titolo;
	
	

	@Column (nullable = false, length=20)
	private String tipologia;
	
	@Column(nullable = false, length=20)
	private String genere;
	
	@Column(nullable = false)
	private Integer  annoproduzione;
	
	@Column(nullable = false)
	private Time durata;

	public contenuto(String titolo, String tipologia, String genere, Integer annoproduzione, Time durata) {
		super();
		this.titolo = titolo;
		this.tipologia = tipologia;
		this.genere = genere;
		this.annoproduzione = annoproduzione;
		this.durata = durata;
	}

	public contenuto() {
		super();
	}

	public String getTitolo() {
		return titolo;
	}

	public String getTipologia() {
		return tipologia;
	}

	public String getGenere() {
		return genere;
	}

	public Integer getAnnoproduzione() {
		return annoproduzione;
	}

	public Time getDurata() {
		return durata;
	}

	@Override
	public int compareTo(contenuto o) {
		if (this.titolo.compareTo(o.getTitolo())!=0)	//se i nomi non sono uguali
			return this.titolo.compareTo(o.getTitolo());
		return 0;
	
	}

	

	

	
	


}
