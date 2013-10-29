package landmark;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JOptionPane;

/**
 * 
 * @author landmark - team 14
 * 
 */

public class Store {
	
	public Player player;
	public TownPanel town;
	

	private int invFood;
	private int invEnergy;
	private int invOre;
	private int invMules;
	private int difficulty;
	
	private final int FOOD_COST = 30;
	private final int ENRGY_COST = 25;
	private final int ORE_COST = 50;
	private final int MULE_COST = 100;
	
	//private Tiles[] landForSale;
	
	
	public Store(Player player, TownPanel town) {
		town = town.getTP();
		player = town.getPlayer();
		difficulty = player.getDifficulty();
		if (difficulty== 1){
			invFood= 16;
			invEnergy= 16;
			invOre=0;
			invMules=25;
		}
		else{
			invFood= 8;
			invEnergy= 8;
			invOre=0;
			invMules=14;			
		}
		
	}
	
	//if player clicks on ore
	//ACTION LISTENER
	public void setPub(final Clock timer) {
		@addOreBtnActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Buy", "Sell", "Cancel"};
				int n= JOptionPane.showOptionDialog(null, "Would you like to buy or sell?",
						"Buy or sell Ore", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
						null, options, null);
				if(n == JOptionPane.YES_OPTION){ //buy ore
					String valStr= JOptionPane.showInputDialog(null, "Please enter the amount of ORE you would like to buy.",
							"Buying Ore", JOptionPane.OK_CANCEL_OPTION);
					int valInt= Integer.parseInt(valStr); // THIS NEEDS TRY CATCH IF NOT INT
					int totalCost = ORE_COST * valInt;
					//check if player has enough money
					if (player.getMoney() >= totalCost && invOre >= valInt){
						player.setMoney(player.getMoney() - totalCost);
						player.setOre(player.getOre() + valInt);
						invOre= invOre-valInt;
					}
					else{
					}
				}
				else if (n== JOptionPane.NO_OPTION){ //sell ore
					String valStr= JOptionPane.showInputDialog(null, "Please enter the amount of ORE you would like to sell.",
							"Selling Ore", JOptionPane.OK_CANCEL_OPTION);
					int valInt= Integer.parseInt(valStr);
					int moneyGiven = ORE_COST * valInt;
					//check if player has enough money
					if (player.getOre() >= valInt){
						player.setMoney(player.getMoney() + moneyGiven);
						player.setOre(player.getOre() - valInt);
						invOre= invOre+valInt;
					}
					else{
						
					}
				}
				else{ //cancel
					
				}
			}
		}
	}
				
}
