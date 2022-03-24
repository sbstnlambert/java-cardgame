package com.openclassrooms.cardgame.games;

import java.util.List;

import com.openclassrooms.cardgame.model.IPlayer;
import com.openclassrooms.cardgame.model.PlayingCard;

public class HighCardGameEvaluator implements GameEvaluator {

	@Override
	public IPlayer evaluateWinner(List<IPlayer> players) {
		// Initialisation des variables
		IPlayer bestPlayer = null;
		int bestRank = -1;
		int bestSuit = -1;
		
		// On regarde la carte de chaque joueur et on la compare avec la meilleure carte trouvée jusqu'ici
		for (IPlayer player : players) {
			boolean newBestPlayer = false;

			if (bestPlayer == null) {
				newBestPlayer = true;
			} else {
				PlayingCard pc = player.getCard(0);
				int thisRank = pc.getRank().value();
				if (thisRank >= bestRank) {
					if (thisRank > bestRank) {
						newBestPlayer = true;
					} else {
						if (pc.getSuit().value() > bestSuit) {
							newBestPlayer = true;
						}
					}
				}
			}
			
			// Si elle est plus forte, on retient le joueur, ainsi que le rank et le suit de cette carte
			if (newBestPlayer) {
				bestPlayer = player;
				PlayingCard pc = player.getCard(0);
				bestRank = pc.getRank().value();
				bestSuit = pc.getSuit().value();
			}
		} // et ainsi de suite pour tous les joueurs
		return bestPlayer;
	}
}
