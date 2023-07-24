package be.bstorm.models;

public class Courant extends Compte{
    private double ligneDeCredit;

    public Courant(String paramNumero, Personne paramTitulaire){
        super(paramNumero,paramTitulaire);
    }

    public Courant(double paramLigneDeCredit, String paramNumero, Personne paramTitulaire){
        super(paramNumero,paramTitulaire);
        setLigneDeCredit(paramLigneDeCredit);
    }

    public double getLigneDeCredit() {
        return ligneDeCredit;
    }

    private void setLigneDeCredit(double ligneDeCredit) {
        if(ligneDeCredit < 0){
            throw new IllegalStateException("Ligne de crédit doit être positive.");
        }
        this.ligneDeCredit = ligneDeCredit;
    }

    @Override
    public void retrait(double montant) {
        super.retrait(montant,getLigneDeCredit());
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