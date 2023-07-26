package be.bstorm.models.interfaces;

import be.bstorm.models.Compte;

public interface PassageEnNegatifSubscriber {

    public void execute(Compte c);
}
