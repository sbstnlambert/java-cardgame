package com.openclassrooms.cardgame.model;

 /*
  * Création d'une énumération-modèle de 2 à as, l'as étant la valeur la plus forte
  */

public enum Rank {
	NONE (0),
	TWO (2),
	THREE (3),
	FOUR (4),
	FIVE (5),
	SIX (6),
	SEVEN (7),
	EIGHT (8),
	NINE (9),
	JACK (10),
	QUEEN (11),
	KING (12),
	ACE (13);
	
	/* Association des constantes à leur valeur */
	int rank;
	
	private Rank(int value) {
		rank = value;
	}
	
	public int value() {
		return rank;
	}
	
}
