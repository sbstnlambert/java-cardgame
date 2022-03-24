package com.openclassrooms.cardgame.model;

import java.util.ArrayList;
import java.util.List;

/*
 * Cr�ation d'une classe-mod�le pour d�finir l'ensemble de cartes de jeu d�tenues par un joueur
 */

public class Hand {
	// Besoin d'une seule carte par main, mais cr�ation d'une liste pour que le code soit plus g�n�rique (en pr�vision de futures am�liorations)
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
