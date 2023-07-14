package be.bstorm;

import be.bstorm.models.Courant;
import be.bstorm.models.Personne;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Personne p1 = new Personne();
        p1.setNom("Schwary");
        p1.setPrenom("Arnold");
        p1.setDdn(LocalDate.of(1960,5,21));

        Courant c1 = new Courant();
        c1.setNumero("1");
        c1.setLigneDeCredit(1000);
        c1.setTitulaire(p1);

        System.out.println(c1.getTitulaire().getPrenom() + " : " + c1.getSolde() + " euro.");
        c1.depot(1000);
        System.out.println(c1.getTitulaire().getPrenom() + " : " + c1.getSolde() + " euro.");
        c1.retrait(500);
        System.out.println(c1.getTitulaire().getPrenom() + " : " + c1.getSolde() + " euro.");

        System.out.println(c1.getTitulaire().getDdn().getYear());

    }
}