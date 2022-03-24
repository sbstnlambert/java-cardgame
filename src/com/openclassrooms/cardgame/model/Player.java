package com.openclassrooms.cardgame.model;

public class Player implements IPlayer {
	
	// Le joueur a un nom
		private String name;
		private Hand hand;

		// On s'assure que le joueur a un nom dès le début avec le constructeur
		public Player(String name) {
			super();
			this.name = name;
			hand = new Hand();
		}
		
		public void addCardToHand(PlayingCard pc) {
			hand.addCard(pc);
		}
		
		public PlayingCard getCard (int index) {
			return hand.getCard(index);
		}
		
		public PlayingCard removeCard() {
			return hand.removeCard();
		}

		public String getName() {
			return name;
		}

}
