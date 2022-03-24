package com.openclassrooms.cardgame.controller;

import java.util.ArrayList;
import java.util.List;

import com.openclassrooms.cardgame.games.GameEvaluator;
import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.model.IPlayer;
import com.openclassrooms.cardgame.model.Player;
import com.openclassrooms.cardgame.model.PlayingCard;
import com.openclassrooms.cardgame.model.WinningPlayer;
import com.openclassrooms.cardgame.view.GameViewable;

public class GameController {
	
	// Introduction d'une énumération qui représente l'état du jeu (et une variable gameState pour contenir cette info)
	enum GameState {
		AddingPlayers, CardsDealt, WinnerRevealed;
	}
	
	Deck deck;
	List<IPlayer> players;
	IPlayer winner;
	GameViewable view;
	
	GameState gameState;
	GameEvaluator evaluator;
	
	// Création du constructeur du controleur avec la vue et le deck en paramètres, et configuration du reste des propriétés
	public GameController(Deck deck, GameViewable view, GameEvaluator evaluator) {
		super();
		this.deck = deck;
		this.view = view;
		this.players = new ArrayList<IPlayer>();
		this.gameState = GameState.AddingPlayers;
		this.evaluator = evaluator;
		view.setController(this);
	}
	
	// Méthode run() qui regarde l'état du jeu et appelle les méthodes de la vue
	public void run() {
		// Boucler sur l'état AddingPlayers pour ajouter autant de joueurs qu'on souhaite
		while (gameState == GameState.AddingPlayers) {
			view.promptForPlayerName();
		}
		
		switch (gameState) {
		case CardsDealt:
			view.promptForFlip();
			break;
		case WinnerRevealed:
			view.promptForNewGame();
			break;
		}
	}
	
	// Méthode addPlayer() afin d'ajouter des joueurs
	public void addPlayer(String playerName) {
		if (gameState == GameState.AddingPlayers) {
			players.add(new Player(playerName));
			view.showPlayerName(players.size(), playerName);
		}
	}
	
	// Méthode pour démarrer le jeu
	public void startGame() {
		if (gameState != GameState.CardsDealt) {
			deck.shuffle(); // ce qui implique de mélanger le paquet
			int playerIndex = 1;
			for (IPlayer player : players) {
				player.addCardToHand(deck.removeTopCard()); // tirer une carte pour chaque joueur
				view.showFaceDownCardForPlayer(playerIndex++, player.getName());
			}
			gameState = GameState.CardsDealt;
		}
		this.run(); // et passer à l'étape suivante du jeu
	}
	
	// Méthode flipCards()
	public void flipCards() {
		int playerIndex = 1;
		for(IPlayer player : players) {
			PlayingCard pc = player.getCard(0);
			pc.flip();
			view.showCardForPlayer(playerIndex++, player.getName(),
					pc.getRank().toString(),
					pc.getSuit().toString());
		}
		evaluateWinner();
		displayWinner();
		rebuildDeck();
		gameState = GameState.WinnerRevealed;
		this.run();
	}
	
	void evaluateWinner() {
		winner = new WinningPlayer(evaluator.evaluateWinner(players));
	}
	
	void displayWinner() {
		view.showWinner(winner.getName());
	}
	
	void rebuildDeck() {
		for (IPlayer player : players) {
			deck.returnCardToDeck(player.removeCard());
		}
	}
	
	void exitGame() {
		System.exit(0);
	}

	public void nextAction(String nextChoice) {
		if ("+q".equals(nextChoice)) {
			exitGame();
		} else {
			startGame();
		}
		
	}
	
}
