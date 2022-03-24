package com.openclassrooms.cardgame.model;

/*
 * Création d'une classe-modèle pour définir le joueur (un nom et une main)
 */

public interface IPlayer {
	
	public void addCardToHand(PlayingCard pc);
	
	public PlayingCard getCard (int index);
	
	public PlayingCard removeCard();

	public String getName();
	
}
