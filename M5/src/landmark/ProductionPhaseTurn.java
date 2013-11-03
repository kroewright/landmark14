package landmark;

import java.awt.CardLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ProductionPhaseTurn {
	
	private static int productionRound = 0;
	private static int turn = 0; //player1 = 0, player2 = 1, player3 = 2, player3 = 2, player4 = 3
	private TownPanel town;
	private Overworld map;
	private Clock timer;
	private Player[] players;
	private GameDriver driver;
	private static Player lowestScorePlayer;
	
	/**
	 * Constructor for a turn in the production phase. This
	 * class creates a TownPanel and a clock for each player's 
	 * turn.
	 * 
	 * @param players
	 * @param map
	 */
	public ProductionPhaseTurn(Player[] players, Overworld map, GameDriver driver) {
		this.map = map;
		this.players = players;
		this.driver = driver;
		map.setPlayerTurn(turn);
		map.setPlayers(players);
		
		if(turn == 0) {
			productionRound += 1;
			lowestScorePlayer = players[0];
			int counter = 0;
			for(Player p: players) {
				if(p.getMoney() < lowestScorePlayer.getMoney()) {
					p = lowestScorePlayer;
				}
				else if(p.getMoney() == lowestScorePlayer.getMoney()) {
					counter += 1;
				}
				
				if(counter == players.length) {
					lowestScorePlayer = null;
				}
			}
		}
		
		System.out.println(lowestScorePlayer.getName());
		
		if(lowestScorePlayer != null && players[turn] != lowestScorePlayer) {
			RandomEvents event = new RandomEvents(players[turn], productionRound);
			int chance = event.calculateChance();
			if(chance <= 27) {
				String message = event.getRandomEvent();
				JOptionPane.showMessageDialog(null, message, "Random Event", JOptionPane.INFORMATION_MESSAGE);
				map.setPlayerPanel(players.length);
			}
		}
		
		town = new TownPanel(players, productionRound, turn, map, driver);
		timer = new Clock(players, productionRound, turn, town, map, driver);
		town.setPub(timer);
		
		if(turn == (players.length - 1)) {
    		turn = 0;
    		//players = map.orderPlayersByScore(players);
    	}
    	else {
    		turn += 1;
    	}
	}
	
	/**
	 * Sets the GameDriver JPanel so graphics can be updated.
	 * 
	 * @param driver
	 */
	public void setDriver(GameDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Gets the GameDriver JPanel.
	 * 
	 * @return driver
	 */
	public GameDriver getDriver() {
		return driver;
	}
	
	/**
	 * Gets the TownPanel JPanel.
	 * 
	 * @return town
	 */
	public TownPanel getTownPanel() { //SOURSE OF POTENTIAL ERROR
		return town;
	}
	
	/**
	 * Gets the working clock for this turn.
	 * 
	 * @return timer
	 */
	public Clock getClock() {
		return timer;
	}
}
