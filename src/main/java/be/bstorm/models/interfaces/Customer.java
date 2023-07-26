package be.bstorm.models.interfaces;

import be.bstorm.exceptions.SoldeInsuffisantException;

public interface Customer {
    double getSolde();
    void retrait(double montant) throws SoldeInsuffisantException;
    void depot(double montant);
}
