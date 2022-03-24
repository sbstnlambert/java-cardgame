package com.openclassrooms.cardgame.model;

import java.util.ArrayList;
import java.util.List;

/*
 * Création d'une classe-modèle pour définir l'ensemble de cartes de jeu détenues par un joueur
 */

public class Hand {
	// Besoin d'une seule carte par main, mais création d'une liste pour que le code soit plus générique (en prévision de futures améliorations)
	private List<PlayingCard> cards;
	
	// Ajout d'un constructeur
	public Hand() {
		cards = new ArrayList<PlayingCard>();
	}
	
	public void addCard(PlayingCard pc) {
		cards.add(pc);
	}
	
	public PlayingCard getCard(int index) {
		return cards.get(index);
	}
	
	public PlayingCard removeCard() {
		return cards.remove(0);
	}

}
