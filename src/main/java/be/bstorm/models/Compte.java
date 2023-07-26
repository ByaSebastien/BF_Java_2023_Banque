package be.bstorm.models;

import be.bstorm.exceptions.SoldeInsuffisantException;
import be.bstorm.models.interfaces.Banker;
import be.bstorm.models.interfaces.Customer;
import be.bstorm.models.interfaces.PassageEnNegatifSubscriber;

import java.util.List;

public abstract class Compte implements Customer, Banker {

    private PassageEnNegatifSubscriber passageEnNegatifEvent;
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
    @Override
    public String getNumero() {
        return numero;
    }
    @Override
    public double getSolde() {
        return solde;
    }
    @Override
    public Personne getTitulaire() {
        return titulaire;
    }
    @Override
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
    @Override
    public void depot(double montant){
        if(montant < 0){
            throw new IllegalArgumentException("Le montant doit être positif.");
        }
        solde += montant;
    }

    protected abstract double calculInteret();
    @Override
    public void appliquerInteret(){

        solde += calculInteret();
    }

    public void setPassageEnNegatifEvent(PassageEnNegatifSubscriber subscriber){

        passageEnNegatifEvent = subscriber;
    }

    public void raisePassageEnNegatifEvent(){

        if(passageEnNegatifEvent == null){
            return;
        }
        passageEnNegatifEvent.execute(this);
    }
}




























