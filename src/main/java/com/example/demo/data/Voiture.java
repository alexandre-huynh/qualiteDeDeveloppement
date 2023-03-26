package com.example.demo.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voiture {

    private int id;

    private String marque;

    private int prix;

    public Voiture(){

    }

    public Voiture(int unId, String uneMarque, int unPrix){
        this.id = unId;
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}