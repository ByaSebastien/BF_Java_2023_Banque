package be.bstorm.models;

public class Courant extends Compte{
    private double ligneDeCredit;

    public double getLigneDeCredit() {
        return ligneDeCredit;
    }

    public void setLigneDeCredit(double ligneDeCredit) {
        if(ligneDeCredit < 0){
            return;
        }
        this.ligneDeCredit = ligneDeCredit;
    }

    @Override
    public void retrait(double montant) {
        super.retrait(montant,getLigneDeCredit());
    }
}