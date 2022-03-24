package com.openclassrooms.cardgame.model;

/*
 * Création d'une énumération-modèle des couleurs, trèfle étant la couleur la plus forte
 */

public enum Suit {
	NONE (0), DIAMOND(1), HEARTS(2), SPADES(3), CLUBS(4);
	
	/* Association des constantes à leur valeur */
	int suit;
	
	private Suit(int value) {
		suit = value;
	}
	
	public int value() {
		return suit;
	}

}
