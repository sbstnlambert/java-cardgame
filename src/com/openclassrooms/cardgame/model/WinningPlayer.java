package com.openclassrooms.cardgame.model;

public class WinningPlayer implements IPlayer {
	
	// L'astuce du décorateur est qu'il va disposer d'une instance du joueur gagnant
	IPlayer winner;
	
	public WinningPlayer(IPlayer player) {
		this.winner = player;
	}

	@Override
	public void addCardToHand(PlayingCard pc) {
		winner.addCardToHand(pc);
	}

	@Override
	public PlayingCard getCard(int index) {
		return winner.getCard(index);
	}

	@Override
	public PlayingCard removeCard() {
		return winner.removeCard();
	}

	@Override
	public String getName() {
		return "***** " + winner.getName() + " *****";
	}
	
	

}
