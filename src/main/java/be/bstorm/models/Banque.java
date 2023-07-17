package be.bstorm.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banque {

    private String nom;
    private HashMap<String,Courant> comptes;

    public Banque(String nom){

        comptes = new HashMap<>();
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public HashMap<String, Courant> getComptes() {
//        return Map.copyOf(comptes);
        return (HashMap<String, Courant>) comptes.clone();
    }

    public void ajouterCompte(Courant c){
        if(comptes.containsKey(c.getNumero())){
            return;
        }
        comptes.put(c.getNumero(),c);
    }

    public void supprimerCompte(String numero){

        comptes.remove(numero);
    }

    public Courant recupCompte(String numero){

        return getComptes().get(numero);
    }


}
