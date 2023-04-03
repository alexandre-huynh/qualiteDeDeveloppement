package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture(){

        // avec arguments
        Voiture voiture1 = new Voiture("Renault", 10000);
        Assert.isInstanceOf(Voiture.class, voiture1, "Pas une voiture");

        // vérification marque et prix
        Assert.isTrue(voiture1.getMarque().equals("Renault"), "Marque incorrect");
        Assert.isTrue(voiture1.getPrix() == 10000, "Prix incorrect");

        // changement de marque
        voiture1.setMarque("Peugeot");
        Assert.isTrue(voiture1.getMarque().equals("Peugeot") , "Marque changé incorrect");

        // changement de prix
        voiture1.setPrix(5000);
        Assert.isTrue(voiture1.getPrix() == 5000, "Prix changé incorrect");

        // =====================================

        // sans arguments
        Voiture voiture2 = new Voiture();
        Assert.isInstanceOf(Voiture.class, voiture2, "Pas une voiture");

        //Assert.isTrue(voiture2.getMarque().equals("") == true, "Prix constr. défaut faux");
        //Assert.isTrue(voiture2.getPrix()== 0, "Prix constr. défaut faux");

        // ancien avec changement de id
        //Assert.isTrue(voiture1.getId() == 0, "Id incorrect");
        //voiture1.setId(5);
        //Assert.isTrue(voiture1.getId() == 5, "Id changé et incorrect");
    }

    @Test
    void modifMarqueVoiture(){
        Voiture voiture1 = new Voiture("Renault", 10000);
        voiture1.setMarque("Peugeot");
        Assert.isTrue(voiture1.getMarque().equals("Peugeot") , "Marque changé incorrect");
    }

    @Test
    void modifPrixVoiture(){
        Voiture voiture1 = new Voiture("Renault", 10000);
        voiture1.setPrix(5000);
        Assert.isTrue(voiture1.getPrix() == 5000, "Prix changé incorrect");
    }

    @Test
    void typeVoitureCorrect(){
        Voiture voiture1 = new Voiture("Renault", 10000);
        Assert.isInstanceOf(Voiture.class, voiture1, "Pas une voiture");
    }

    @Test
    void comparePrix(){
        Voiture voiture1 = new Voiture("Renault", 10000);
        Voiture voiture2 = new Voiture("Peugeot", 15000);
        Assert.isTrue(voiture1.getPrix() != voiture2.getPrix(), "Prix comparé égal alors que tapé 10 000 et 15 000");

        voiture1.setPrix(15000);
        Assert.isTrue(voiture1.getPrix() == voiture2.getPrix(), "Prix modifié et non égal");
    }

}
