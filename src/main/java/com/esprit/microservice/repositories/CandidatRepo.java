package com.esprit.microservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.microservice.entite.Candidat;

public interface CandidatRepo  extends JpaRepository<Candidat, Integer>{
	
	@Query("select c from Candidat c where c.nom like :nom")
	public Page <Candidat> candidatByNom (@Param ("nom") String n ,Pageable pageable);
}
