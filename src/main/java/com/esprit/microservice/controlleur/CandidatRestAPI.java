package com.esprit.microservice.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.entite.Candidat;
import com.esprit.microservice.service.CandidatService;

@RestController
public class CandidatRestAPI {
	private String title ="Hello , I m the candidate Microservice";
	
	
	@Autowired
	private CandidatService cs;
	
	
	@RequestMapping("/hello")
	public String sayHello(){
		System.out.println(title);
		return title;
	}

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat){
		return new ResponseEntity<> (cs.addCandidat(candidat), HttpStatus.OK);
	}
	
	@PutMapping(value ="/{id}", produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Candidat> updateCandidat(@PathVariable(value = "id") int id,@RequestBody Candidat candidat ){
		return new ResponseEntity<>(cs.updateCandidat(id, candidat),HttpStatus.OK);
	}
	@DeleteMapping(value ="/{id}", produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deteleteCandidat(@PathVariable(value ="id")int id){
		return new ResponseEntity<>(cs.deleteCandidat(id),HttpStatus.OK);

	}
}


