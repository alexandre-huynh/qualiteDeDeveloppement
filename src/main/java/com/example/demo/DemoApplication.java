package com.example.demo;

import com.example.demo.data.Voiture;
import com.example.demo.data.VoitureRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(VoitureRepository.class);

	@Autowired
	private VoitureRepository voitureRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// injection de dépendance
	@Override
	public void run(String... args) throws Exception {
		voitureRepository.save(new Voiture("Ford", 59000));
		voitureRepository.save(new Voiture("Renault", 30000));
		voitureRepository.save(new Voiture("Citroën", 20000));
		voitureRepository.save(new Voiture("Ferrari", 100000));

		// saveall utilise une arraylist

		// on peut utiliser WHERE Marque = truc avec
		// findByMarque(String marque);
		// on suffit juste de faire // findByAttribut_ici
		// Optional<Voiture> findById(int id);

		// aussi
		// @Query("select v from Voiture v where v.prix> = ? 1 and v.prix <=?")
		// findByVoiturePriceBetween

		voitureRepository.findAll();
		voitureRepository.findById(3);

		// on accède sur internet avec
        // localhost:8080/h2-console


		/*
		for (Voiture v : voitureRepository.findAll()) {
			logger.info(v.getMarque() + " " + v.getPrix());
		}
		 */
	}
	
}
