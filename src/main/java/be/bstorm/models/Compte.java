package be.bstorm.models;

public class Compte {


    private String numero;
    private double solde;
    private Personne titulaire;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public Personne getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Personne titulaire) {
        this.titulaire = titulaire;
    }

    public void retrait(double montant){

        retrait(montant,0);
    }

    public void retrait(double montant, double ligneDeCredit){

        if(montant < 0){
            return;
        }
        if(getSolde() - montant < - ligneDeCredit){
            return;
        }
        solde -= montant;
    }

    public void depot(double montant){
        if(montant < 0){
            return;
        }
        solde += montant;
    }
}




























