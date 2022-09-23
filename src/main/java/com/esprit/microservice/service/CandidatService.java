package com.esprit.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.entite.Candidat;
import com.esprit.microservice.repositories.CandidatRepo;

@Service
public class CandidatService {

	
	@Autowired
	private CandidatRepo cr;
	
	public Candidat addCandidat(Candidat candidat){
		return cr.save(candidat);
	}
	
	public Candidat updateCandidat (int id, Candidat newCandidat) {
		if (cr.findById(id).isPresent()){
			Candidat existingCandidat = cr.findById(id).get();
			existingCandidat.setNom(newCandidat.getNom());
			existingCandidat.setEmail(newCandidat.getEmail());
			existingCandidat.setPrenom(newCandidat.getPrenom());
			
			return cr.save(existingCandidat);
		}else 
			return null;
			}
	
	public String deleteCandidat (int id){
		if(cr.findById(id).isPresent()){
			cr.deleteById(id);
			return "Candidat supprimé";
		}else
			return "Candidat non  supprimé";
	}
}
