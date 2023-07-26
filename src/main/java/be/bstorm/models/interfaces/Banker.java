package be.bstorm.models.interfaces;

import be.bstorm.models.Personne;

public interface Banker extends Customer{

    void appliquerInteret();
    Personne getTitulaire();
    String getNumero();
}
