package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.Collections;

import static org.mockito.Mockito.*;

//classe de test
@SpringBootTest
public class BaseDeDonneesTests {

    // le service de fourniture de données
    // on mock/mime/imite la base de données --> objet
    // ex quand on save, si j'appelle méthode la save, then return la voiture
    // on a simulé le comportement save
    // on peut donc tester sans le vrai fournisseur de données
    @MockBean
    private VoitureRepository voitureRepository;


    @Test
    void uneVoiture(){
        // tester les méthodes de l'interface CrudRepository qui permette d'accéder à la base de données:
        // https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
        // save, find, delete...

        voitureRepository = mock(VoitureRepository.class);

        Voiture voiture_bd = new Voiture("a", 10000);

        when(voitureRepository.save(voiture_bd)).thenReturn(voiture_bd);

        //Voiture voiture_ajouter = voitureRepository.save();

        // on enregistre dans la bd spring data une voiture
        // AVEC SAVE
        //voitureRepository.save(voiture_bd);

        //voitureRepository.findById(0);


        //Assert.isTrue(voitureRepository.count() == 1, "Erreur nb entité enregistré");

    }

    @Test
    void compterTaille(){
        voitureRepository = mock(VoitureRepository.class);
        Voiture voiture_bd = new Voiture("a", 10000);
        when(voitureRepository.save(voiture_bd)).thenReturn(voiture_bd);



    }

}
