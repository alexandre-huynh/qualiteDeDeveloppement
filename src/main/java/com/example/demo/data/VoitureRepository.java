package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VoitureRepository extends CrudRepository<Voiture, Integer> {

    List<Voiture> findByMarque(String marque);
}

