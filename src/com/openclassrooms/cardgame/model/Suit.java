package com.openclassrooms.cardgame.model;

/*
 * Cr�ation d'une �num�ration-mod�le des couleurs, tr�fle �tant la couleur la plus forte
 */

public enum Suit {
	NONE (0), DIAMOND(1), HEARTS(2), SPADES(3), CLUBS(4);
	
	/* Association des constantes � leur valeur */
	int suit;
	
	private Suit(int value) {
		suit = value;
	}
	
	public int value() {
		return suit;
	}

}
