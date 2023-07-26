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

    public void ajouterCompte(Compte compte){
        if(comptes.containsKey(compte.getNumero())){
            return;
        }
        compte.setPassageEnNegatifEvent(c -> this.passageEnNegatifAction(c));
        comptes.put(compte.getNumero(),compte);
    }

    public void supprimerCompte(String numero){

        comptes.remove(numero);
    }

    public Compte recupCompte(String numero){

        return getComptes().get(numero);
    }

    private void passageEnNegatifAction(Compte c){

        System.out.println("Le compte " + c.getNumero() + "de la banque " + this.getNom() + " vient de passer en négatif");
    }
}
