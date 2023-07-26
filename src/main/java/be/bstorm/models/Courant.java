package be.bstorm.models;

import be.bstorm.exceptions.ArgumentOutOfRangeException;
import be.bstorm.exceptions.SoldeInsuffisantException;

public class Courant extends Compte{
    private double ligneDeCredit;

    public Courant(String paramNumero, Personne paramTitulaire){
        super(paramNumero,paramTitulaire);
    }

    public Courant(double paramLigneDeCredit, String paramNumero, Personne paramTitulaire) throws ArgumentOutOfRangeException {
        super(paramNumero,paramTitulaire);
        setLigneDeCredit(paramLigneDeCredit);
    }

    public double getLigneDeCredit() {
        return ligneDeCredit;
    }

    private void setLigneDeCredit(double ligneDeCredit) throws ArgumentOutOfRangeException {
        if(ligneDeCredit < 0){
            throw new ArgumentOutOfRangeException("Ligne de crédit doit être positive.");
        }
        this.ligneDeCredit = ligneDeCredit;
    }

    @Override
    public void retrait(double montant) throws SoldeInsuffisantException {
        double previous = getSolde();
        super.retrait(montant,getLigneDeCredit());
        if(previous >= 0 && getSolde() < 0){
            raisePassageEnNegatifEvent();
        }
    }

    @Override
    protected double calculInteret() {
        if(getSolde() < 0){
            return getSolde() * 0.0975;
        }
        return getSolde() * 0.03;
//        return getSolde() < 0 ? getSolde() * 0.0975 : getSolde() * 0.03;
    }
}