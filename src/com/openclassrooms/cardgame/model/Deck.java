package com.openclassrooms.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * Cr�ation d'une classe-mod�le afin de cr�er le jeu de cartes
 * Transformation en classe abstraite : elle va g�rer les cartes mais n'aura pas de constructeur
 */

public abstract class Deck {
	protected List<PlayingCard> cards;
	
	public Deck() {
		cards = new ArrayList<PlayingCard>();
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				System.out.println("Creating card ["+rank+"]["+suit+"]");
				cards.add(new PlayingCard(rank, suit));
			}
		}
		shuffle();
	}

	// M�thode pour m�langer le paquet de cartes
	public void shuffle() {
		Random random = new Random();
		for (int i = 0; i < cards.size(); ++i) {
			Collections.swap(cards, i, random.nextInt(cards.size()));
		}
		
	}
	
	// M�thode pour retirer la premi�re carte du paquet
	public PlayingCard removeTopCard() {
		return cards.remove(0);
	}
	
	// M�thode pour remettre la carte dans le paquet
	public void returnCardToDeck(PlayingCard pc) {
		cards.add(pc);
	}
	
	// Un getter pour connaitre la valeur de la carte pioch�e
	public List<PlayingCard> getCards() {
		return cards;
	}

}
