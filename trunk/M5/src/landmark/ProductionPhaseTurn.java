package landmark;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class ProductionPhaseTurn {
	
	private static int productionRound = 0;
	private static int turn = 0; //player1 = 0, player2 = 1, player3 = 2, player3 = 2, player4 = 3
	private TownPanel town;
	private Overworld map;
	private Clock timer;
	private Player[] players;
	private static JPanel driver;
	private static CardLayout layout;
	
	public ProductionPhaseTurn(Player[] players, Overworld map) {
		this.map = map;
		this.players = players;
		town = new TownPanel();
		
		if(turn == 0) {
			productionRound += 1;
		}
		
		timer = new Clock(players, productionRound, turn, town, map);
		
		if(turn == (players.length - 1)) {
    		turn = 0;
    		
    	}
    	else {
    		turn += 1;
    	}
	}
	
	public TownPanel getTownPanel() {
		return town;
	}
	
	public Clock getClock() {
		return timer;
	}
}
