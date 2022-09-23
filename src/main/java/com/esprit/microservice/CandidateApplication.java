package com.esprit.microservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.esprit.microservice.entite.Candidat;
import com.esprit.microservice.repositories.CandidatRepo;

@SpringBootApplication
public class CandidateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidateApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init (CandidatRepo cr){
		return args ->{
			Stream.of("Mariem","Sarra","Mouhamed").forEach(nom->{
				cr.save(new Candidat(nom));
			});
			cr.findAll().forEach(System.out::println);
		};
	}

}
