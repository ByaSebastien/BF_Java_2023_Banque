package be.bstorm.models;

import be.bstorm.exceptions.SoldeInsuffisantException;

public abstract class Compte {


    private String numero;
    private double solde;
    private Personne titulaire;

    public Compte(){}

    public Compte(String paramNumero, Personne paramTitulaire){
        this(paramNumero,paramTitulaire,0);
    }

    public Compte(String paramNumero, Personne paramTitulaire, double paramSolde){
        this.numero = paramNumero;
        this.titulaire = paramTitulaire;
        this.solde = paramSolde;
    }

    public String getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    public Personne getTitulaire() {
        return titulaire;
    }

    public void retrait(double montant) throws SoldeInsuffisantException {

        retrait(montant,0);
    }

    public void retrait(double montant, double ligneDeCredit) throws SoldeInsuffisantException {

        if(montant < 0){
            throw new IllegalArgumentException("Le montant doit être positif.");
        }
        if(getSolde() - montant < - ligneDeCredit){
            throw new SoldeInsuffisantException();
        }
        solde -= montant;
    }

    public void depot(double montant){
        if(montant < 0){
            throw new IllegalArgumentException("Le montant doit être positif.");
        }
        solde += montant;
    }

    protected abstract double calculInteret();

    public void appliquerInteret(){

        solde += calculInteret();
    }
}




























