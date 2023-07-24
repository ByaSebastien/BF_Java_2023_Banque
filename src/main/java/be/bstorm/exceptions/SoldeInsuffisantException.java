package be.bstorm.exceptions;

// RuntimeException -> On ne peut pas y faire grand chose (la méthode qui la throw ne doit rien faire de special)
// Exception -> On peut et on doit la gérer (la méthode qui la throw doit le specifier avec le mot clef throws)
public class SoldeInsuffisantException extends IllegalStateException{

    public SoldeInsuffisantException() {
        super("Solde insuffisant.");
    }

    public SoldeInsuffisantException(String message) {
        super(message);
    }
}
