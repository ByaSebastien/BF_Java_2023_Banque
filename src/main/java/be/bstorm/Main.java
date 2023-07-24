package be.bstorm;

import be.bstorm.exceptions.SoldeInsuffisantException;
import be.bstorm.models.Banque;
import be.bstorm.models.Courant;
import be.bstorm.models.Epargne;
import be.bstorm.models.Personne;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Banque banque = new Banque("Les voleurs");
        Personne p1 = new Personne("Schwarzy", "Arnold", LocalDate.of(1960, 5, 21));

        Courant c1 = new Courant(1000, "1", p1);


        Personne p2 = new Personne("Stalone", "Sylvester", LocalDate.of(1960, 5, 21));

        Epargne c2 = new Epargne("2", p2, 1500);

        banque.ajouterCompte(c1);
        banque.ajouterCompte(c2);


        try {
            c1.depot(1000);
            banque.recupCompte("1").retrait(1000);
            banque.recupCompte("2").retrait(500);
        }catch (SoldeInsuffisantException ex){
            System.out.println(ex.getMessage());
        }catch (IllegalStateException ex){
            System.out.println(ex.getMessage());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }


        System.out.println(banque.recupCompte("1").getTitulaire().getPrenom());

        System.out.println(c1.getTitulaire().getPrenom() + " : " + c1.getSolde() + " euro.");
        c1.depot(1000);
        System.out.println(c1.getTitulaire().getPrenom() + " : " + c1.getSolde() + " euro.");
        c1.retrait(500);
        System.out.println(c1.getTitulaire().getPrenom() + " : " + c1.getSolde() + " euro.");

        System.out.println(c1.getTitulaire().getDdn().getYear());
    }
}