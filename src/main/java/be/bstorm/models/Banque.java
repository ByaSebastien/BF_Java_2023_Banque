package be.bstorm.models;

import java.util.HashMap;

public class Banque {

    private String nom;
    private HashMap<String,Compte> comptes;

    public Banque(String nom){

        comptes = new HashMap<>();
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public HashMap<String, Compte> getComptes() {
//        return Map.copyOf(comptes);
        return (HashMap<String, Compte>) comptes.clone();
    }

    public void ajouterCompte(Compte c){
        if(comptes.containsKey(c.getNumero())){
            return;
        }
        comptes.put(c.getNumero(),c);
    }

    public void supprimerCompte(String numero){

        comptes.remove(numero);
    }

    public Compte recupCompte(String numero){

        return getComptes().get(numero);
    }
}
