package be.bstorm;

import be.bstorm.models.Banque;
import be.bstorm.models.Courant;
import be.bstorm.models.Epargne;
import be.bstorm.models.Personne;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Banque banque = new Banque("Les voleurs");
        Personne p1 = new Personne();
        p1.setNom("Schwary");
        p1.setPrenom("Arnold");
        p1.setDdn(LocalDate.of(1960,5,21));

        Courant c1 = new Courant();
        c1.setNumero("1");
        c1.setLigneDeCredit(1000);
        c1.setTitulaire(p1);
        c1.depot(1000);

        Personne p2 = new Personne();
        p2.setNom("Stalone");
        p2.setPrenom("Sylvester");
        p2.setDdn(LocalDate.of(1960,5,21));

        Epargne c2 = new Epargne();
        c2.setNumero("2");
        c2.setTitulaire(p2);
        c2.depot(1500);

        banque.ajouterCompte(c1);
        banque.ajouterCompte(c2);


        banque.recupCompte("2").retrait(500);
        banque.recupCompte("1").retrait(250);



        System.out.println(banque.recupCompte("1").getTitulaire().getPrenom());

        System.out.println(c1.getTitulaire().getPrenom() + " : " + c1.getSolde() + " euro.");
        c1.depot(1000);
        System.out.println(c1.getTitulaire().getPrenom() + " : " + c1.getSolde() + " euro.");
        c1.retrait(500);
        System.out.println(c1.getTitulaire().getPrenom() + " : " + c1.getSolde() + " euro.");

        System.out.println(c1.getTitulaire().getDdn().getYear());
    }
}