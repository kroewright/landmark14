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
	private GameDriver driver;
	
	public ProductionPhaseTurn(Player[] players, Overworld map) {
		this.map = map;
		this.players = players;
		
		if(turn == 0) {
			productionRound += 1;
			System.out.println(productionRound);
		}
		
		town = new TownPanel(players, productionRound, turn, map);
		timer = new Clock(players, productionRound, turn, town, map);
		town.setPub(timer);
		
		if(turn == (players.length - 1)) {
    		turn = 0;
    		players = map.orderPlayersByScore(players);
    	}
    	else {
    		turn += 1;
    	}
	}
	
	public void setDriver(GameDriver driver) {
		this.driver = driver;
	}
	
	public GameDriver getDriver() {
		return driver;
	}
	
	public TownPanel getTownPanel() {
		return town;
	}
	
	public Clock getClock() {
		return timer;
	}
}
