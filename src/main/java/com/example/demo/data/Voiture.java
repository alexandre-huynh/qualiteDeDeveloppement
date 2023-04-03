package com.example.demo.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// hors cours : projet lombock
// qui permet d'e générer les getter setters etc grace à
// @getter, @setter, @data, @tostring, @equalsHashCode

// cours
// 3 couches
// couche data
// couche service
// couche Web

/*
si on utilise lombock
@Getter
@Setter
@toString

on précise que les attributs et le getid (vu qu'il utilise des)

ou sinon
avec le plugin, sur intellij, clic droit puis generate
ou dans la section Code
 */

@Entity // composant springboot, un beeen
public class Voiture {

    private int id;

    private String marque;

    private int prix;

    public Voiture(){

    }

    // l'id est généré automatiquement
    public Voiture(String uneMarque, int unPrix){
        this.marque = uneMarque;
        this.prix = unPrix;
    }

    public String getMarque() {
        return marque;
    }

    public int getPrix() {
        return prix;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    // clé primaire id, ici bd en mémoire
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                '}';
    }
}