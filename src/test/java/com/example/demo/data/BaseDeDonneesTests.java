package com.example.demo.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    // pour les logs
    private static final Logger log = LoggerFactory.getLogger(BaseDeDonneesTests.class);

    // exemple de recherche de voiture par marque
    // List<Voiture> findByMarque(String marque);

    // mockito on l'utilise pour simuler des données où normalement on dépend de la BD
    // pour tester base de données, on utilise Junit

    // ========================================
    // ICI LES TESTS NE SONT PAS EXACTEMENT CORRECT (je crois)
    // SE FAIT AVEC MOCKBEAN MAIS NORMALEMENT DOIT ETRE AVEC AUTOWIRED?
    // PAS SUR QUE LES COMMANDES S'EXECUTE VRAIMENT
    // ========================================

    @Test
    void uneVoiture(){
        // tester les méthodes de l'interface CrudRepository qui permette d'accéder à la base de données:
        // https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
        // save, find, delete...

        ArrayList<Voiture> liste_voitures = new ArrayList<Voiture>();

        liste_voitures.add(new Voiture("a", 10000));
        liste_voitures.add(new Voiture("b", 20000));
        liste_voitures.add(new Voiture("c", 30000));

        voitureRepository.saveAll(liste_voitures);

        log.info("Voitures found with findAll():");
        log.info("-------------------------------");
        for (Voiture v : voitureRepository.findAll()) {
            log.info(v.toString());
        }
        log.info("");
    }

    /* =========== NON FONCTIONNEL ===============
    @Test
    void compterTaille(){
        voitureRepository = mock(VoitureRepository.class);
        Voiture voiture_1 = new Voiture("a", 10000);
        Voiture voiture_2 = new Voiture("b", 20000);
        Voiture voiture_3 = new Voiture("c", 30000);

        when(voitureRepository.save(voiture_1)).thenReturn(voiture_1);
        when(voitureRepository.save(voiture_2)).thenReturn(voiture_2);
        when(voitureRepository.save(voiture_3)).thenReturn(voiture_3);

        voitureRepository.save(voiture_1);
        voitureRepository.save(voiture_2);
        voitureRepository.save(voiture_3);

        Assert.isTrue(voitureRepository.count() == 3, "Erreur nb entité enregistré : " + voitureRepository.count());
    }
     */

    @Test
    void insererVoiture(){
        voitureRepository = mock(VoitureRepository.class);
        Voiture voiture_bd = new Voiture("a", 10000);
        Voiture voiture_fausse = new Voiture();

        // méthode de Mock
        when(voitureRepository.save(voiture_bd)).thenReturn(voiture_bd);
        when(voitureRepository.save(voiture_fausse)).thenReturn(voiture_fausse);

        Assert.isTrue(voitureRepository.save(voiture_bd) == voiture_bd, "Erreur insertion voiture");
        Assert.isTrue(voitureRepository.save(voiture_bd) != voiture_fausse, "Erreur insertion voiture : la voiture insérée est égale à une autre voiture");
    }

    @Test
    void insererVoitureListe(){
        voitureRepository = mock(VoitureRepository.class);

        Voiture voiture_1 = new Voiture("a", 10000);
        Voiture voiture_2 = new Voiture("b", 20000);
        Voiture voiture_3 = new Voiture("c", 30000);

        ArrayList<Voiture> liste_voitures = new ArrayList<Voiture>();

        liste_voitures.add(voiture_1);
        liste_voitures.add(voiture_2);
        liste_voitures.add(voiture_3);

        when(voitureRepository.saveAll(liste_voitures)).thenReturn(liste_voitures);

        Assert.isTrue(voitureRepository.saveAll(liste_voitures) == liste_voitures,"Erreur insertion liste de voitures" );
    }

    @Test
    void afficherVoiture(){
        voitureRepository = mock(VoitureRepository.class);

        Voiture voiture_1 = new Voiture("a", 10000);

        voitureRepository.save(voiture_1);

        Assert.isTrue(voitureRepository.findByMarque("a").equals(voiture_1), "Erreur affichage voiture" + voitureRepository.findByMarque("a"));
    }

}
