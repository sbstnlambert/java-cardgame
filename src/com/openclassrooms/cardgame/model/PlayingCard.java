package com.openclassrooms.cardgame.model;

/*
 * Création d'une classe-modèle avec une valeur, une couleur et un flag indiquant si la carte est face visible ou cachée.
 */

public class PlayingCard {
	// Création des attributs privés
	private Rank rank;
	private Suit suit;
	private boolean faceUp;
	
	// Pour connaitre la valeur de ces attributs, je crée des getters
	// NB : Je ne crée pas de setters car je ne veux pas qu'un joueur puisse changer la valeur de la carte une fois construite
	public Rank getRank() {
		return rank;
	}
	public Suit getSuit() {
		return suit;
	}
	public boolean isFaceUp() {
		return faceUp;
	}
	public boolean flip() { // Méthode pour inverser la valeur de l'attribut
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
