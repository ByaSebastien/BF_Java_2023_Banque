package be.bstorm.models;

import java.time.LocalDateTime;

public class Epargne extends Compte{

    private LocalDateTime dateDernierRetrait;

    public Epargne(String paramNumero, Personne paramTitulaire){
        super(paramNumero,paramTitulaire);
    }

    public Epargne(String paramNumero, Personne paramTitulaire, double paramSolde){
        super(paramNumero,paramTitulaire,paramSolde);
    }

    public LocalDateTime getDateDernierRetrait() {
        return dateDernierRetrait;
    }

    @Override
    public void retrait(double montant) {
        double previous = getSolde();
        super.retrait(montant);
        if(previous > getSolde()){
            this.dateDernierRetrait = LocalDateTime.now();
        }
    }

    @Override
    protected double calculInteret() {
        return getSolde() * 0.045;
    }
}
