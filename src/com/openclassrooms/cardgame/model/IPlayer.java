package com.openclassrooms.cardgame.model;

/*
 * Cr�ation d'une classe-mod�le pour d�finir le joueur (un nom et une main)
 */

public interface IPlayer {
	
	public void addCardToHand(PlayingCard pc);
	
	public PlayingCard getCard (int index);
	
	public PlayingCard removeCard();

	public String getName();
	
}
