package com.openclassrooms.cardgame.model;

/*
 * Cr�ation d'une classe-mod�le avec une valeur, une couleur et un flag indiquant si la carte est face visible ou cach�e.
 */

public class PlayingCard {
	// Cr�ation des attributs priv�s
	private Rank rank;
	private Suit suit;
	private boolean faceUp;
	
	// Pour connaitre la valeur de ces attributs, je cr�e des getters
	// NB : Je ne cr�e pas de setters car je ne veux pas qu'un joueur puisse changer la valeur de la carte une fois construite
	public Rank getRank() {
		return rank;
	}
	public Suit getSuit() {
		return suit;
	}
	public boolean isFaceUp() {
		return faceUp;
	}
	public boolean flip() { // M�thode pour inverser la valeur de l'attribut
		faceUp = !faceUp;
		return faceUp;
	}
	
	// J'ai besoin d'un constructeur qui utilise la valeur et la couleur
	public PlayingCard(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}
	

}
