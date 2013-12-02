package landmark;


import java.awt.*;
import landmark.Tiles.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import landmark.Mules.Farm;
import landmark.Mules.Mine;
import landmark.Mules.PPlant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author landmark - team 14
 * 
 * Store class that keeps track of the inventory of items and controls 
 * how players buy and sell items.
 * 
 */
public class Store implements Serializable {
	public Player player;
	public static TownPanel town;
	private Overworld map;
	//private JButton btnOre;
	//private JButton btnEnergy;
	//private JButton btnFood;
	//private JButton btnMules;
	private static boolean storeCreated = false;

	private Mule mule;
	//private String energy;
	//private String ore;
	//private String food;


	private static int foodInventory = 0;
	private static int energyInventory = 0;
	private static int oreInventory = 0;
	//private static int oreInventoryMules = 0;
	//private static int foodInventoryMules = 0;
	//private static int energyInventoryMules = 0;
	private static int muleInventory = 0;
	private int difficulty;

	private final int MULE_FOOD = 25;
	private final int MULE_ENERGY = 50;
	private final int MULE_ORE = 75;

	private final int FOOD_COST = 30;
	private final int ENERGY_COST = 25;
	private final int ORE_COST = 50;
	private final int MULE_COST = 100;

	
	
	/**
	 * Constructor that takes in the current player and town to control the buying 
	 * and selling process for each turn.
	 * 
	 * @param player
	 * @param town
	 */
	public Store(Player player, TownPanel town) {
		//food = "food";
		//ore = "ore";
		//energy = "energy";
		this.town = town;
		this.player = player;
		difficulty = player.getDifficulty();
		if (difficulty == 1 && storeCreated == false){
			foodInventory = 16;
			energyInventory = 16;
			oreInventory = 0;
			muleInventory = 25;
			storeCreated = true;
		}
		else if(storeCreated == false) {
			foodInventory = 8;
			energyInventory = 8;
			oreInventory = 0;
			muleInventory = 14;		
			storeCreated = true;
		}
		map = town.getMap();
		map.setStore(this);

	}
	/**
	 * Decides whether to buy or sell, then abstracts other two functions for trading
	 * lands between players.
	 */
	public void landTransaction(){
		String[] options = {"Buy" , "Sell", "Cancel"};
		int buyOrSell = JOptionPane.showOptionDialog(null, "Buy or sell?", "Land Transactions",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
		
		if(buyOrSell == JOptionPane.YES_OPTION){
			Player playerExchange = pickExchangePlayer();
			Player playerBuy = Overworld.players[Overworld.getPlayerTurn()];
			handleTransaction(playerBuy,playerExchange);
			//TODO Finish transaction handler

		}
		else if(buyOrSell == JOptionPane.NO_OPTION){
			Player playerExchange = pickExchangePlayer();
			Player playerSell = Overworld.players[Overworld.getPlayerTurn()];
			handleTransaction(playerExchange,playerSell);
	
		}
	}
	
	
	/**
	 * Method that controls the functionality of the Ore button in the store.
	 * Determines if a player is buying or selling and if they have enough of an 
	 * item or enough money.
	 */
	public void oreTransaction() {
		Object[] options = {"Buy", "Sell", "Cancel"};
		int buyOrSell = JOptionPane.showOptionDialog(null, "Would you like to buy or sell?",
				"Buy or sell Ore", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
				null, options, null);

		if (buyOrSell == JOptionPane.YES_OPTION) { //buy ore

			int playerSelection = 0;
			boolean done = false;  

			while(!done) {			
				try { 			
					String selectionString = JOptionPane.showInputDialog(null, "Please enter the amount of ORE you would like to buy.",
							"Buying Ore", JOptionPane.OK_CANCEL_OPTION);
					if (selectionString == null) break;       // Exit loop on Cancel/close box.
					playerSelection = Integer.parseInt(selectionString); 
					done = true;
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Please enter a number. Try again.");
				}
			}

			int totalCost = ORE_COST * playerSelection;
			//check if player has enough money
			if (player.getMoney() >= totalCost && oreInventory >= playerSelection){
				player.setMoney(player.getMoney() - totalCost);
				int totalOre = player.getOre() + playerSelection;
				player.setOre(totalOre);
				oreInventory = oreInventory-playerSelection;
			} else {
				if (player.getMoney() < totalCost){
					JOptionPane.showMessageDialog(null, player.getName() + ", you do not have enough money for this transaction."
							, "Insufficient Funds", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (oreInventory < playerSelection){
					JOptionPane.showMessageDialog(null, "Sorry, the store doesn't have that much in it's inventory. It only has:\n" +
							"Smithore: " + oreInventory +"\nEnergy: " + energyInventory + "\nFood: " + foodInventory + "\nMules: " + muleInventory,
							"Store Inventory Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

		else if (buyOrSell == JOptionPane.NO_OPTION){ //sell ore

			int valInt = 0;
			boolean done = false;  

			while(!done) {			
				try { 
					String valStr= JOptionPane.showInputDialog(null, "Please enter the amount of ORE you would like to sell.",
							"Selling Ore", JOptionPane.OK_CANCEL_OPTION);
					if (valStr == null) break;       // Exit loop on Cancel/close box.
					valInt= Integer.parseInt(valStr);
					done = true;
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You should enter a number. Try again.");
				}
			}

			int moneyGiven = ORE_COST * valInt;
			//Add the money to players total
			if (player.getOre() >= valInt){
				player.setMoney(player.getMoney() + moneyGiven);
				player.setOre(player.getOre() - valInt);
				oreInventory = oreInventory + valInt;
			}
			else {
				JOptionPane.showMessageDialog(null, player.getName() + ", you do not have enough smithore for this transaction."
						, "Insufficient Amount of Smithore", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		map.setPlayerPanel(town.getPlayers().length);
	}

	/**
	 * Method that controls the functionality of the Energy button in the store.
	 * Determines if a player is buying or selling and if they have enough of an 
	 * item or enough money.
	 */
	public void energyButt() {
		
		
		Object[] options = {"Buy", "Sell", "Cancel"};
		int n = JOptionPane.showOptionDialog(null, "Would you like to buy or sell?",
				"Buy or sell Energy", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
				null, options, null);
		if (n == JOptionPane.YES_OPTION) { //buy energy

			int valInt = 0;
			boolean done = false;  

			while(!done) {			
				try { 
					String valStr= JOptionPane.showInputDialog(null, "Please enter the amount of ENERGY you would like to buy.",
							"Buying Energy", JOptionPane.OK_CANCEL_OPTION);
					if (valStr == null) break;       // Exit loop on Cancel/close box.
					valInt = Integer.parseInt(valStr); 
					done = true;
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You should enter a number. Try again.");
				}
			}

			int totalCost = ENERGY_COST * valInt;
			//check if player has enough money
			if (player.getMoney() >= totalCost && energyInventory >= valInt){
				player.setMoney(player.getMoney() - totalCost);
				int totalEnergy = player.getEnergy() + valInt;
				player.setEnergy(totalEnergy);
				energyInventory = energyInventory-valInt;
			}
			else {
				if (player.getMoney() <totalCost){
					JOptionPane.showMessageDialog(null, player.getName() + ", you do not have enough money for this transaction."
							, "Insufficient Funds", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (energyInventory < valInt){
					JOptionPane.showMessageDialog(null, "Sorry, the store doesn't have that much in it's inventory. It only has:\n" +
							"Smithore: " + oreInventory +"\nEnergy: " + energyInventory + "\nFood: " + foodInventory + "\nMules: " + muleInventory,
							"Store Inventory Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

		else if (n == JOptionPane.NO_OPTION){ //sell energy

			int valInt = 0;
			boolean done = false;  

			while(!done) {			
				try { 
					String valStr=  JOptionPane.showInputDialog(null, "Please enter the amount of ENERGY you would like to sell.",
							"Selling ENERGY", JOptionPane.OK_CANCEL_OPTION);
					if (valStr == null) break;       // Exit loop on Cancel/close box.
					valInt= Integer.parseInt(valStr);
					done = true;
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You should enter a number. Try again.");
				}
			}

			int moneyGiven = ENERGY_COST * valInt;
			//Add the money to players total
			if (player.getEnergy() >= valInt){
				player.setMoney(player.getMoney() + moneyGiven);
				player.setEnergy(player.getEnergy() - valInt);
				energyInventory = energyInventory + valInt;
			}
			else {
				JOptionPane.showMessageDialog(null, player.getName() + ", you do not have enough energy for this transaction."
						, "Insufficient Amount of Energy", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		map.setPlayerPanel(town.getPlayers().length);	
	}

	/**
	 * Method that controls the functionality of the Food button in the store.
	 * Determines if a player is buying or selling and if they have enough of an 
	 * item or enough money.
	 */
	public void foodButt() {
		System.out.println("Food");
		Object[] options = {"Buy", "Sell", "Cancel"};
		int n = JOptionPane.showOptionDialog(null, "Would you like to buy or sell?",
				"Buy or sell Food", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
				null, options, null);
		if (n == JOptionPane.YES_OPTION) { //buy food
			int valInt = 0;
			boolean done = false;  

			while(!done) {			
				try { 
					String valStr= JOptionPane.showInputDialog(null, "Please enter the amount of FOOD you would like to buy.",
							"Buying Food", JOptionPane.OK_CANCEL_OPTION);
					if (valStr == null) break;       // Exit loop on Cancel/close box.
					valInt = Integer.parseInt(valStr);
					done = true;
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You should enter a number. Try again.");
				}
			}

			int totalCost = FOOD_COST * valInt;
			//check if player has enough money
			if (player.getMoney() >= totalCost && foodInventory >= valInt){
				player.setMoney(player.getMoney() - totalCost);
				int totalFood = player.getFood() + valInt;
				player.setFood(totalFood);
				foodInventory = foodInventory-valInt;
			} else {
				if (player.getMoney() <totalCost){
					JOptionPane.showMessageDialog(null, player.getName() + ", you do not have enough money for this transaction."
							, "Insufficient Funds", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (foodInventory < valInt){
					JOptionPane.showMessageDialog(null, "Sorry, the store doesn't have that much in it's inventory. It only has:\n" +
							"Smithore: " + oreInventory +"\nEnergy: " + energyInventory + "\nFood: " + foodInventory + "\nMules: " + muleInventory,
							"Store Inventory Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

		else if (n == JOptionPane.NO_OPTION){ //sell food

			int valInt = 0;
			boolean done = false;  

			while(!done) {			
				try { 
					String valStr = JOptionPane.showInputDialog(null, "Please enter the amount of FOOD you would like to sell.",
							"Selling Food", JOptionPane.OK_CANCEL_OPTION);
					if (valStr == null) break;       // Exit loop on Cancel/close box.
					valInt= Integer.parseInt(valStr);
					done = true;
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You should enter a number. Try again.");
				}
			}

			int moneyGiven = FOOD_COST * valInt;
			//Add the money to players total
			if (player.getFood() >= valInt){
				player.setMoney(player.getMoney() + moneyGiven);
				player.setFood(player.getFood() - valInt);
				foodInventory = foodInventory + valInt;
			}
			else {
				JOptionPane.showMessageDialog(null, player.getName() + ", you do not have enough food for this transaction."
						, "Insufficient Amount of Food", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		map.setPlayerPanel(town.getPlayers().length);
	}

	/**
	 * Method that controls the functionality of the Mule button in the store.
	 * Determines what type of mule a player wants to purchase and if they have
	 * enough money to do so.
	 * 
	 * Only one mule can be purchased at a time and another cannot be purchased until a 
	 * player has planted their last mule.
	 */
	public void muleButt() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int n = JOptionPane.showConfirmDialog(town, "Would you like to buy a mule?",
				"Buy a Mule", dialogButton);

		if (n == JOptionPane.YES_OPTION && muleInventory != 0 && player.hasMule() == false) { //buy mules
			Object[] types = {"Energy", "Ore", "Food"};
			int m = JOptionPane.showOptionDialog(town, "What kind of MULE would you like to purchase?",
					"Type of Mule", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, types, null);	

			int totalCost=0;
			if (m == JOptionPane.YES_OPTION) {
				totalCost = (MULE_ENERGY + MULE_COST);
				mule = new PPlant();
				player.setCurrentMule(mule);
				player.setHasCurrentMule(true);		//added by irina
			}

			else if (m == JOptionPane.NO_OPTION) {
				totalCost = (MULE_ORE + MULE_COST);
				mule = new Mine();
				player.setCurrentMule(mule);		
				player.setHasCurrentMule(true);		//added by irina
			}

			else{
				totalCost = (MULE_FOOD + MULE_COST);
				mule = new Farm();
				player.setCurrentMule(mule);
				player.setHasCurrentMule(true);    //added by irina
			}

			if (player.getMoney() >= totalCost){
				player.setMoney(player.getMoney() - totalCost);				
				muleInventory = muleInventory - 1;
			}
			else {
				JOptionPane.showMessageDialog(town, player.getName() + ", you do not have enough money for this transaction."
						, "Insufficient Funds", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(n == JOptionPane.YES_OPTION && muleInventory == 0) {
			JOptionPane.showMessageDialog(town, "Sorry, the store doesn't have anymore mules!",
					"Store Inventory Error", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(player.hasMule() == true) {
			JOptionPane.showMessageDialog(town, "You already bought a mule!",
					"Mule Already Purchased", JOptionPane.INFORMATION_MESSAGE);
		}
		map.setPlayerPanel(town.getPlayers().length);
	}

	/**
	 * Method that returns the stores food inventory.
	 * 
	 * @return foodInventory
	 */
	public int getFoodInv() {
		return foodInventory;
	}

	/**
	 * Method that returns the stores energy inventory.
	 * 
	 * @return energyInventory
	 */
	public int getEnergyInv() {
		return energyInventory;
	}
	
	/**
	 * Method that returns the stores ore inventory.
	 * 
	 * @return oreInventory
	 */
	public int getOreInv() {
		return oreInventory;
	}
	
	/**
	 * Method that returns the stores mule inventory.
	 * 
	 * @return muleInventory
	 */
	public int getMuleInv() {
		return muleInventory;
	}

	
	/**
	 * Performs the actual changing of territories
	 * @param buyer
	 * @param seller
	 */
	public static void handleTransaction(Player buyer, Player seller){
		Object[] types = {"Plains", "Mountains", "River"};
		boolean done = false;
		String type;
		Tile tileToExchange = null;

		while(!done){
			int m = JOptionPane.showOptionDialog(town, "What kind of land would you like to purchase?",
				"Type of Land", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, types, null);	
			if(m == JOptionPane.YES_OPTION) type = "Plains";
			else if(m == JOptionPane.NO_OPTION) type = "Mountains";
			else type = "River";
			
			for(Tile t: seller.getTilesOwned()){
				if(type.equals("River") && t instanceof River ||
				   type.equals("Plains") && t instanceof Plains ||
				   type.equals("Mountains") && t instanceof Mountains){
					done = true;
					tileToExchange = t;
					break;
				}
				else {
					done = false;
				}
			}
		}
		
		//TODO Handle the actual Transaction
		
		
		
	}
	/**
	 * Finds the other player (the one who's turn it isn't)
	 * to perform the trade with
	 * @return
	 */
	public static Player pickExchangePlayer(){
		int playerSelected = 0;
		boolean done = false;
		Player playerExchange = null;
		while(!done){
			try{
				String selectionString = JOptionPane.showInputDialog(null,
						"Enter the name of the player you would like to exchange land with? (1 for player 1 etc)"
				,"Exchanging land", JOptionPane.OK_CANCEL_OPTION);
				if(selectionString == null) break;
				playerSelected = Integer.parseInt(selectionString);
				done = true;
				
				if(playerSelected > Overworld.players.length) done = false;
				else 	playerExchange = Overworld.players[playerSelected-1];
		
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Incorrect choice, please try again.");
			}
		}
		return playerExchange;
	}
	
	
}
