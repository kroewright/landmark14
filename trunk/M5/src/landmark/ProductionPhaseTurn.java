package landmark;

import java.awt.CardLayout;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ProductionPhaseTurn implements Serializable{
	
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
		
		if(lowestScorePlayer != null && players[turn] != lowestScorePlayer) {
			RandomEvents event = new RandomEvents(players[turn], productionRound);
			int chance = event.calculateChance();
			if(chance <= 27) {
				String message = event.getRandomEvent();
				JOptionPane.showMessageDialog(null, message, "Random Event", JOptionPane.INFORMATION_MESSAGE);
				map.setPlayerPanel(players.length);
			}
		}
		
		if(productionRound != 1) {
			produceAndGather();
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
	
	/**
	 * Handles getting the right resources from the tile and checks
	 * if the player has enough energy to run his or her mules.
	 */
	private void produceAndGather() {
		ArrayList<Tile> ownedTiles = players[turn].getTilesOwned();
		ArrayList<Mule> ownedMules = players[turn].getMules();
		int muleSize = ownedMules.size();
		if(players[turn].getEnergy() >= muleSize) {
			int producedFood = players[turn].getFoodYield();
			int totalFood = players[turn].getFood() + producedFood;
			players[turn].setFood(totalFood);
			int producedEnergy = players[turn].getEnergyYield();
			int totalEnergy = players[turn].getEnergy() + producedEnergy;
			players[turn].setEnergy((totalEnergy - muleSize));
			int producedOre = players[turn].getOreYield();
			int totalOre = players[turn].getOre() + producedOre;
			players[turn].setOre(totalOre);
			JOptionPane.showMessageDialog(null, players[turn].getName() + ", you produced and harvested:\n" + "Food: " 
					+ producedFood + "\nEnergy: " + producedEnergy + "\nSmithore: " + producedOre + "\nYou used " + muleSize + 
					" energy to run your mules.", "Harvested Resources", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(players[turn].getEnergy() > 0){
			int currentEnergy = players[turn].getEnergy();
			players[turn].resetYields();
			for(Tile tile: ownedTiles) {
				if(currentEnergy != 0) {
					players[turn].increaseFoodYield(tile.getFYield());
					players[turn].increaseEnergyYield(tile.getEYield());
					players[turn].increaseOreYield(tile.getOYield());
					currentEnergy -= 1;
				}
			}
			
			int producedFood = players[turn].getFoodYield();
			int totalFood = players[turn].getFood() + producedFood;
			players[turn].setFood(totalFood);
			int producedEnergy = players[turn].getEnergyYield();
			players[turn].setEnergy(producedEnergy);
			int producedOre = players[turn].getOreYield();
			int totalOre = players[turn].getOre() + producedOre;
			players[turn].setOre(totalOre);
			JOptionPane.showMessageDialog(null, players[turn].getName() + ", you don't have enough energy to run all of your mules!" +
					"\nYou used the rest of your energy to run some of your mules. You produced and harvested:\n" + "Food: " + producedFood + "\nEnergy: " + producedEnergy + 
					"\nSmithore: " + producedOre, "Harvested Resources", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, players[turn].getName() + ", you do not have any energy to run your mules! " +
					"\nNothing was produced or harvested. I'd build some power plants if I were you...", 
					"Harvested Resources", JOptionPane.INFORMATION_MESSAGE);
		}
		map.setPlayerPanel(players.length);
	}
}
