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
 */

public class Store implements Serializable {

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
					if (valStr == null) break;       // Exit loop on Cancel/close box.
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
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int n = JOptionPane.showConfirmDialog(town, "Would you like to buy a mule?",
				"Buy a Mule", dialogButton);

		if (n == JOptionPane.YES_OPTION && invMules != 0 && player.hasMule() == false) { //buy mules
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
				player.getMules().add(mule);
				/*
				for (int i=0; i==valInt; i++){
					player.getMules().add(mule);	
				}
				 */					
				invMules = invMules - 1;
			}
			else {
				JOptionPane.showMessageDialog(town, player.getName() + ", you do not have enough money for this transaction."
						, "Insufficient Funds", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(n == JOptionPane.YES_OPTION && invMules == 0) {
			JOptionPane.showMessageDialog(town, "Sorry, the store doesn't have anymore mules!",
					"Store Inventory Error", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(player.hasMule() == true) {
			JOptionPane.showMessageDialog(town, "You already bought a mule!",
					"Mule Already Purchased", JOptionPane.INFORMATION_MESSAGE);
		}
		map.setPlayerPanel(town.getPlayers().length);
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

	
	
    private static Logger myLogger = Logger.getLogger("landmark.Store");

	/**
     * Save this object via serialization
     * 
     * @param filename the name of the file to save to
     */
    public void save(String filename) {
        try {
            /*
             * Create the object output stream for serialization.
             * We are wrapping a FileOutputStream since we
             * want to save to disk.  You can also save to socket
             * streams or any other kind of stream.
             */
           ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
           
           /*
            * The only real call we need.  The stream buffers the output and reuses
            * data, so if you are serializing very frequently, then the object values might
            * not actually change because the old serialized object is being reused.
            * 
            * To fix this you can try writeUnshared() or you can reset the stream.
            * out.reset();
            */
           out.writeObject(this);
       } catch (FileNotFoundException e) {
           myLogger.log(Level.SEVERE, "Save file not found: " + filename, e);
       } catch (IOException e) {
           myLogger.log(Level.SEVERE, "General IO Error on saving: " + filename, e);
       }
        
    }
    
    /**
     * This is an example of a factory method
     * We call this static method to create an
     * instance of Company from a serialized file.
     * 
     * @param filename the name of the file to use
     * @return an instance of Company initialized from a file.
     */
     public static Store getFromFile(String filename) {
         Store c = null;
         try {
             /*
              * Create the input stream.  Since we want to read from the disk, 
              * we wrap a file stream.
              */
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            /*
             * Now we can read the entire company in with only one call
             */
            c = (Store) in.readObject();
            
        } catch (FileNotFoundException e) {
            myLogger.log(Level.SEVERE, "Load file not found: " + filename, e);
        } catch (IOException e) {
            myLogger.log(Level.SEVERE, "General IO Error on loading: " + filename, e);
        } catch (ClassNotFoundException e) {
            myLogger.log(Level.SEVERE, "Company class not found on loading: " + filename, e);
        }
        return c;
     }
	
	
}
