package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture(){
        Voiture voiture1 = new Voiture(0, "Renault", 10000);
        Assert.isInstanceOf(Voiture.class, voiture1, "Pas une voiture");

        Assert.isTrue(voiture1.getId() == 0, "Id incorrect");
        Assert.isTrue(voiture1.getMarque().equals("Renault") == true, "Marque incorrect");
        Assert.isTrue(voiture1.getPrix() == 10000, "Prix incorrect");

        voiture1.setId(5);

        Assert.isTrue(voiture1.getId() == 5, "Id changé et incorrect");
    }

}
