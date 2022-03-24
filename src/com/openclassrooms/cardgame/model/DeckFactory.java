package com.openclassrooms.cardgame.model;

public class DeckFactory {
	public enum DeckType {
		Normal, // 52 cartes
		Small, // 32 cartes
		Test // uniquement jeux sp�cifiques pour des tests
	};
	
	// Notre Factory ne poss�de qu'une m�thode statique qui prend en param�tre le type de Deck � cr�er
	public static Deck makeDeck(DeckType type) {
		switch (type) {
		case Normal: return new NormalDeck();
		case Small: return new SmallDeck();
		case Test: return new TestDeck();
		}
		
		return new NormalDeck();
	}
}
