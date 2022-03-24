package com.openclassrooms.cardgame.model;

public class DeckFactory {
	public enum DeckType {
		Normal, // 52 cartes
		Small, // 32 cartes
		Test // uniquement jeux spécifiques pour des tests
	};
	
	// Notre Factory ne possède qu'une méthode statique qui prend en paramètre le type de Deck à créer
	public static Deck makeDeck(DeckType type) {
		switch (type) {
		case Normal: return new NormalDeck();
		case Small: return new SmallDeck();
		case Test: return new TestDeck();
		}
		
		return new NormalDeck();
	}
}
