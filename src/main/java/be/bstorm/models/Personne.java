package be.bstorm.models;

import java.time.LocalDate;

public class Personne {

    private String nom;
    private String prenom;
    private LocalDate ddn;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDdn() {
        return ddn;
    }

    public void setDdn(LocalDate ddn) {
        this.ddn = ddn;
    }
}
