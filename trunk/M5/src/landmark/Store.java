package landmark;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * 
 * @author landmark - team 14
 * 
 */

public class Store {
	
	public Player player;
	public TownPanel panel;
	

	private int invFood;
	private int invEnergy;
	private int invOre;
	private int invMules;
	
	private final int foodCost = 30;
	private final int energyCost = 25;
	private final int oreCost = 50;
	private final int muleCost = 100;
	
	//private Tiles[] landForSale;
	
	
	public Store(Player player, TownPanel panel) {
		panel = panel.getTP();
		player = panel.getPlayer();	
	}
	
	//if player clicks on ore
	//ACTION LISTENER
	addOreBtnActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			JOptionPane.showOptionDialogue;

			//Ends the player's turn and activate the another player
			if(turn == (players.length - 1)) {
				turn = 0;
				//players = map.orderPlayersByScore(players);
			}
			else {
				turn += 1;
			}
}
