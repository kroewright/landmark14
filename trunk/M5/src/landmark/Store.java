package landmark;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import landmark.Mules.Farm;
import landmark.Mules.Mine;
import landmark.Mules.PPlant;

/**
 * 
 * @author landmark - team 14
 * 
 */

public class Store {

	public Player player;
	public TownPanel town;
	private Overworld map;
	private JButton btnOre;
	private JButton btnEnergy;
	private JButton btnFood;
	private JButton btnMules;
	private static boolean storeCreated = false;

	private Mule mule;
	private String energy;
	private String ore;
	private String food;


	private static int invFood = 0;
	private static int invEnergy = 0;
	private static int invOre = 0;
	private static int invOreMules = 0;
	private static int invFoodMules = 0;
	private static int invEnergyMules = 0;
	private static int invMules = 0;
	private int difficulty;

	private final int MULE_FOOD = 25;
	private final int MULE_ENERGY = 50;
	private final int MULE_ORE = 75;

	private final int FOOD_COST = 30;
	private final int ENERGY_COST = 25;
	private final int ORE_COST = 50;
	private final int MULE_COST = 100;

	//private Tiles[] landForSale;


	public Store(Player player, TownPanel town) {
		food= "food";
		ore= "ore";
		energy= "energy";
		this.town = town.getTP();
		this.player = town.getPlayer();
		difficulty = player.getDifficulty();
		if (difficulty == 1 && storeCreated == false){
			invFood = 16;
			invEnergy = 16;
			invOre = 0;
			invMules = 25;
			storeCreated = true;
		}
		else if(storeCreated == false) {
			invFood = 8;
			invEnergy = 8;
			invOre = 0;
			invMules = 14;		
			storeCreated = true;
		}
		map = town.getMap();
		map.setStore(this);

	}

	public void oreButt() {
		Object[] options = {"Buy", "Sell", "Cancel"};
		int n = JOptionPane.showOptionDialog(null, "Would you like to buy or sell?",
				"Buy or sell Ore", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
				null, options, null);

		if (n == JOptionPane.YES_OPTION) { //buy ore

			int valInt = 0;
			boolean done = false;  

			while(!done) {			
				try { 			
					String valStr= JOptionPane.showInputDialog(null, "Please enter the amount of ORE you would like to buy.",
							"Buying Ore", JOptionPane.OK_CANCEL_OPTION);
					valInt = Integer.parseInt(valStr); 
					done = true;
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You should enter a number. Try again.");
				}
			}

			int totalCost = ORE_COST * valInt;
			//check if player has enough money
			if (player.getMoney() >= totalCost && invOre >= valInt){
				player.setMoney(player.getMoney() - totalCost);
				int totalOre = player.getOre() + valInt;
				player.setOre(totalOre);
				invOre = invOre-valInt;
			} else {
				if (player.getMoney() < totalCost){
					JOptionPane.showMessageDialog(null, player.getName() + ", you do not have enough money for this transaction."
							, "Insufficient Funds", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (invOre < valInt){
					JOptionPane.showMessageDialog(null, "Sorry, the store doesn't have that much in it's inventory. It only has:\n" +
							"Smithore: " + invOre +"\nEnergy: " + invEnergy + "\nFood: " + invFood + "\nMules: " + invMules,
							"Store Inventory Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

		else if (n == JOptionPane.NO_OPTION){ //sell ore

			int valInt = 0;
			boolean done = false;  

			while(!done) {			
				try { 
					String valStr= JOptionPane.showInputDialog(null, "Please enter the amount of ORE you would like to sell.",
							"Selling Ore", JOptionPane.OK_CANCEL_OPTION);
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
				invOre = invOre + valInt;
			}
			else {
				JOptionPane.showMessageDialog(null, player.getName() + ", you do not have enough smithore for this transaction."
						, "Insufficient Amount of Smithore", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		map.setPlayerPanel(town.getPlayers().length);
	}

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
					valInt = Integer.parseInt(valStr); 
					done = true;
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You should enter a number. Try again.");
				}
			}

			int totalCost = ENERGY_COST * valInt;
			//check if player has enough money
			if (player.getMoney() >= totalCost && invEnergy >= valInt){
				player.setMoney(player.getMoney() - totalCost);
				int totalEnergy = player.getEnergy() + valInt;
				player.setEnergy(totalEnergy);
				invEnergy = invEnergy-valInt;
			}
			else {
				if (player.getMoney() <totalCost){
					JOptionPane.showMessageDialog(null, player.getName() + ", you do not have enough money for this transaction."
							, "Insufficient Funds", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (invEnergy < valInt){
					JOptionPane.showMessageDialog(null, "Sorry, the store doesn't have that much in it's inventory. It only has:\n" +
							"Smithore: " + invOre +"\nEnergy: " + invEnergy + "\nFood: " + invFood + "\nMules: " + invMules,
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
				invEnergy = invEnergy + valInt;
			}
			else {
				JOptionPane.showMessageDialog(null, player.getName() + ", you do not have enough energy for this transaction."
						, "Insufficient Amount of Energy", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		map.setPlayerPanel(town.getPlayers().length);	
	}

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
					valInt = Integer.parseInt(valStr);
					done = true;
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You should enter a number. Try again.");
				}
			}

			int totalCost = FOOD_COST * valInt;
			//check if player has enough money
			if (player.getMoney() >= totalCost && invFood >= valInt){
				player.setMoney(player.getMoney() - totalCost);
				int totalFood = player.getFood() + valInt;
				player.setFood(totalFood);
				invFood = invFood-valInt;
			} else {
				if (player.getMoney() <totalCost){
					JOptionPane.showMessageDialog(null, player.getName() + ", you do not have enough money for this transaction."
							, "Insufficient Funds", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (invFood < valInt){
					JOptionPane.showMessageDialog(null, "Sorry, the store doesn't have that much in it's inventory. It only has:\n" +
							"Smithore: " + invOre +"\nEnergy: " + invEnergy + "\nFood: " + invFood + "\nMules: " + invMules,
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
				invFood = invFood + valInt;
			}
			else {
				JOptionPane.showMessageDialog(null, player.getName() + ", you do not have enough food for this transaction."
						, "Insufficient Amount of Food", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		map.setPlayerPanel(town.getPlayers().length);
	}


	public void muleButt() {
		System.out.println("Mules");
		Object[] options = {"Buy", "Sell", "Cancel"};
		int n = JOptionPane.showOptionDialog(null, "Would you like to buy or sell?",
				"Buy or sell Energy", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
				null, options, null);
		if (n == JOptionPane.YES_OPTION) { //buy mules
			Object[] types = {"Energy", "Ore", "Food"};
			int m = JOptionPane.showOptionDialog(null, "What kind of MULE would you like to purchase?",
					"Type of Mule", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, types, null);	

			int valInt = 0;
			boolean done = false;  

			while(!done) {			
				try { 
					String valStr= JOptionPane.showInputDialog(null, "Please enter the amount of MULES you would like to buy.",
							"Buying Mules", JOptionPane.OK_CANCEL_OPTION);
					valInt = Integer.parseInt(valStr); 
					done = true;
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You should enter a number. Try again.");
				}
			}

			int totalCost=0;
			if (m==1){
				totalCost = (MULE_ENERGY + MULE_COST) * valInt;
				mule = new PPlant();
				player.setCurrentMule(mule);
			}

			else if (m==2){
				totalCost = (MULE_ORE + MULE_COST) * valInt;
				mule = new Mine();
				player.setCurrentMule(mule);

			}

			else{
				totalCost = (MULE_FOOD + MULE_COST) * valInt;
				mule = new Farm();
				player.setCurrentMule(mule);

			}

			if (player.getMoney() >= totalCost && invMules >= valInt){
				player.setMoney(player.getMoney() - totalCost);
				for (int i=0; i==valInt; i++){
					player.getMules().add(mule);
				}					
				invMules = invMules-valInt;
			}
			else {
				if (player.getMoney() <totalCost){
					JOptionPane.showMessageDialog(null, player.getName() + ", you do not have enough money for this transaction."
							, "Insufficient Funds", JOptionPane.INFORMATION_MESSAGE);
				}
				if (invMules < valInt){
					JOptionPane.showMessageDialog(null, "Sorry, the store doesn't have that much in it's inventory. It only has:\n" +
							"Ore -" + invOre +"\n Energy -" + invEnergy + "\n Food -" + invFood + "\n Mules -" +invMules,
							"Store Inventory Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

		else if (n == JOptionPane.NO_OPTION){ //sell mules
			Object[] types = {"Energy", "Ore", "Food"};
			int m = JOptionPane.showOptionDialog(null, "What kind of MULE would you like to sell?",
					"Type of Mule", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, types, null);	

			int valInt = 0;
			boolean done = false;  

			while(!done) {			
				try { 
					String valStr=  JOptionPane.showInputDialog(null, "Please enter the amount of MULES you would like to sell.",
							"Selling MULES", JOptionPane.OK_CANCEL_OPTION);
					valInt = Integer.parseInt(valStr); // THIS NEEDS TRY CATCH IF NOT INT
					done = true;
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "You should enter a number. Try again.");
				}
			}

			int totalCost=0;
			if (m==1){
				totalCost = (MULE_ENERGY + MULE_COST) * valInt;
				//mule.setType(energy);
			}

			else if (m==2){
				totalCost = (MULE_ORE + MULE_COST) * valInt;
				//mule.setType(ore);
			}

			else{
				totalCost = (MULE_FOOD + MULE_COST) * valInt;
				//mule.setType(food);
			}

			if (player.getMoney() >= valInt){
				player.setMoney(player.getMoney() + totalCost);
				for (int i=0; i==valInt; i++){
					player.getMules().remove(mule);
				}					
				invMules = invMules+valInt;
			}
			else {
				JOptionPane.showMessageDialog(null, player.getName() + ", you do not have enough MULES for this transaction."
						, "Insufficient Funds", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public int getFoodInv() {
		return invFood;
	}

	public int getEnergyInv() {
		return invEnergy;
	}

	public int getOreInv() {
		return invOre;
	}

	public int getMuleInv() {
		return invMules;
	}

}
