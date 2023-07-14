package be.bstorm.models;

public class Courant {

    private String numero;
    private double solde;
    private double ligneDeCredit;
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

    public double getLigneDeCredit() {
        return ligneDeCredit;
    }

    public void setLigneDeCredit(double ligneDeCredit) {
        if(ligneDeCredit < 0){
            return;
        }
        this.ligneDeCredit = ligneDeCredit;
    }

    public Personne getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Personne titulaire) {
        this.titulaire = titulaire;
    }

    public void retrait(double montant){
        if(montant < 0){
            return;
        }
        if(getSolde() - montant < -getLigneDeCredit()){
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
