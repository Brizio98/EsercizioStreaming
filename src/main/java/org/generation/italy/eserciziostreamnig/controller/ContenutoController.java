package org.generation.italy.eserciziostreamnig.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.generation.italy.eserciziostreamnig.model.contenuto;
import org.generation.italy.eserciziostreamnig.repository.ContenutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping ("/streaming")
public class ContenutoController {
	
	@Autowired       //oggettifichiamo l'interfaccia 
	ContenutoRepository contenutoRepository;
	
	
	
	@GetMapping("contenuti")
	@ResponseBody
	public String elencoContenuti (
			@RequestParam (required = false) String tipologia,
			@RequestParam (required = false) String genere,
			@RequestParam (required = false) String titolo,
			@RequestParam (required = false) String annoinizio,
			@RequestParam (required = false) String annofine,
			@RequestParam (required = false) String ordinamento) {
		
		ArrayList<contenuto> elencoContenuti;
		elencoContenuti=null;
		
		if(tipologia== null && genere == null && annoinizio==null && annofine==null && titolo==null)
			elencoContenuti=(ArrayList<contenuto>)contenutoRepository.findAll();
		else if (tipologia == null && genere != null && annoinizio==null && annofine==null && titolo==null)
			elencoContenuti=(ArrayList<contenuto>)contenutoRepository.findByGenere(genere);
		else if(tipologia != null && genere != null && annoinizio==null && annofine==null && titolo==null) 
				elencoContenuti=(ArrayList<contenuto>)contenutoRepository.findByTipologia(tipologia);
		else if(genere  == null && titolo != null && tipologia == null && annoinizio==null && annofine==null) 
			elencoContenuti=(ArrayList<contenuto>)contenutoRepository.findByTipologiaLike("%" + titolo + "%");
		else if (genere  == null && titolo == null && tipologia == null && annoinizio !=null && annofine !=null )
			elencoContenuti = (ArrayList<contenuto>)contenutoRepository.findByannoproduzioneBetween(2010,2015);
		
		if (ordinamento!=null)
		{
			if (ordinamento.equals("asc"))
				Collections.sort(elencoContenuti);		//ordinamento predefinito (tramite nome) in maniera crescente
			else if (ordinamento.equals("desc"))
				Collections.sort(elencoContenuti,Collections.reverseOrder());	//ordinamento predefinito (tramite nome) in maniera decrescente
			else
				return "Ordinamento non valido";
		}
		
		StringBuilder elenco = new StringBuilder();
		elenco.append("");
        elenco.append("<br><br>");
		for (contenuto c : elencoContenuti)
			if (tipologia!=null && c.getTipologia().equals(tipologia) ||   
			tipologia == null || genere!=null && c.getGenere().equals(genere) ||
			genere == null)
			elenco.append(c.toString() + "<br>");
		return elencoContenuti.toString();
		
	}
	
	

}
