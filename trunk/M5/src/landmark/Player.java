package landmark;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * 
 * @author landmark - team 14
 * 
 * Player class that keeps track of the players in a current game.
 * Handles their score, items owned, race, color, and game difficulty.
 *
 */
public class Player implements Serializable{
	private String name;
	private int money;
	private int score;
	private int color;
	private int difficulty;
	private int race;
	private ArrayList<Tile> ownedTiles;
	private ArrayList<Mule> plantedMules;
	private Mule currentMule;
	private boolean inStore;
	private boolean hasMule;

	private int food;
	private int energy;
	private int ore;

	private int oreYield;
	private int foodYield;
	private int energyYield;

	private Clock timer;

	/**
	 * Consturctor that contains the player's name, color, difficulty of the current game,
	 * and their race.
	 * 
	 * @param name
	 * @param color
	 * @param difficulty
	 * @param race
	 */
	public Player(String name, int color, int difficulty, int race) {
		this.name = name;
		this.color = color;
		this.difficulty = difficulty;
		this.race = race;
		plantedMules = new ArrayList<Mule>();
		ownedTiles = new ArrayList<Tile>();

		//Sets initial money based on race.
		if(race == 0) {
			money = 600;
		}
		else if(race == 1) {
			money = 1000;
		}
		else if(race == 2) {
			money = 1000;
		}
		else {
			money = 1600;
		}

		if(difficulty == 1) {
			food = 8;
			energy = 4;
			ore = 0;
		}
		else {
			food = 4;
			energy = 2;
			ore = 0;
		}

		this.setScore(money);

		this.foodYield = 0;
		this.energyYield = 0;
		this.oreYield = 0;
	}

	/**
	 * Method that returns the players color.
	 * 
	 * @return color, gold navy white or black
	 */
	public int getColor(){
		return color;
	}

	/**
	 * Method that converts the player color integer into a string.
	 * 
	 * @return color 
	 */
	public String getColorAsString(){
		switch(this.color){
		case 0:
			return "Gold";
		case 1: 
			return "Navy";
		case 2:
			return "White";
		case 3:
			return "Black";
		}
		return null;
	}


	/**
	 * Method that adds tiles to new owners and sets the new owner.
	 * 
	 * @param tile
	 */
	public void addTileOwned(Tile tile){
		ownedTiles.add(tile);
		tile.setOwner(this);
	}

	/**
	 * Getter for owned tiles per player.
	 * 
	 * @return tiles
	 */
	public ArrayList<Tile> getTilesOwned() {
		return ownedTiles;
	}

	/**
	 * Deducts money when land is purchased.
	 * 
	 * @param tile
	 */
	public void buyLandSelectionPhase(Tile tile) {
		if(money >= 300) {
			money -= 300;
			setScore(money);
		}
		addTileOwned(tile);
	}




	/**
	 * Method that returns the player's name
	 * 
	 * @return name
	 */
	public String getName(){
		return name;
	}

	/**
	 * Method that returns how much food a player has
	 * 
	 * @return food
	 */
	public int getFood() {
		return food;
	}

	/**
	 * Method that sets the new food total following production phase
	 * 
	 * @param newtotal
	 */
	public void setFood(int newtotal){
		food = newtotal;
	}

	/**
	 * Method that returns how much energy a player has
	 * 
	 * @return energy
	 */
	public int getEnergy() {
		return energy;
	}

	/**
	 * Method that sets the new energy total following production phase
	 * 
	 * @param newtotal
	 */
	public void setEnergy(int newtotal){
		energy = newtotal;
	}

	/**
	 * Method that returns how much ore a player has
	 * 
	 * @return ore
	 */
	public int getOre() {
		return ore;
	}

	/**
	 * Method that sets the new ore total following production phase
	 * 
	 * @param newtotal
	 */
	public void setOre(int newtotal){
		ore =  newtotal;
	}

	/**
	 * Method that returns how much money a player has
	 * 
	 * @return score
	 */
	public int getScore(){
		return score;
	}

	/**
	 * Method that sets the new money total following production phase
	 * 
	 * @param i
	 */
	private void setScore(int i){
		this.score = i;
	}

	/**
	 * Method that returns how much money a player has
	 * 
	 * @return money
	 */
	public int getMoney(){
		return money;
	}

	/**
	 * Method that sets the new money total following production phase
	 *	
	 * @param i
	 */
	public void setMoney(int i){
		this.money = i;
		this.score = i;
	}

	/**
	 * Method that return the difficulty of the current game being played
	 * 
	 * @return difficulty
	 */
	public int getDifficulty(){
		return difficulty;
	}

	/**
	 * Method that returns the timer for a player.
	 * 
	 * @return timer
	 */
	public Clock getTimer(){
		return timer;
	}

	/**
	 * Method that sets the timer for a player in the production phase
	 * 
	 * @param timer
	 */
	public void setTimer(Clock timer){
		this.timer = timer;
	}

	/**
	 * Method that checks to see if a players owns a mule
	 * 
	 * @return hasMule
	 */
	public boolean hasMule(){
		return hasMule;
	}

	/**
	 * Method that changes the hasMule method based on whether or
	 * not a player owns a mule.
	 * 
	 * @param b
	 */
	public void setHasCurrentMule(boolean b){
		this.hasMule = b;
	}

	/**
	 * Method that returns an array of the mules planted on properties.
	 * 
	 * @return plantedMules
	 */
	public ArrayList<Mule> getMules(){
		return plantedMules;
	}

	/**
	 * Method that returns the amount of ore produced by the land and mules
	 * 
	 * @return oreYield
	 */
	public int getOreYield(){
		return this.oreYield;
	}

	/**
	 * Method that returns the amount of energy produced by the land and mules
	 * 
	 * @return energyYield
	 */
	public int getEnergyYield(){
		return this.energyYield;
	}

	/**
	 * Method that returns the amount of food produced by the land and mules
	 * 
	 * @return foodYield
	 */
	public int getFoodYield(){
		return this.foodYield;
	}

	/**
	 * Increases the ore yield by 1
	 * 
	 * @param amount
	 */
	public void increaseOreYield( int amount ){
		this.oreYield += amount;
	}

	/**
	 * Increases the energy yield by 1
	 * 
	 * @param amount
	 */
	public void increaseEnergyYield( int amount ){
		this.energyYield += amount;
	}

	/**
	 * Increases the food yield by 1
	 * 
	 * @param amount
	 */
	public void increaseFoodYield( int amount ){
		this.foodYield += amount;
	}

	/**
	 * Method that resets all yields back to 0.
	 * 
	 */
	public void resetYields() {
		this.oreYield = 0;
		this.foodYield = 0;
		this.energyYield = 0;
	}

	/**
	 * Method that sets the current mule
	 * 
	 * @param m
	 */
	public void setCurrentMule(Mule m){
		this.currentMule = m;
	}

	/**
	 * Method that returns the current mule owned
	 * 
	 * @return currentMule
	 */
	public Mule getCurrentMule(){
		return currentMule;
	}

	/**
	 * Method that plants mule after it is purchased by a player.
	 * @param t
	 */
	public void putMule(Tile t){
		Mule m = getCurrentMule();
		plantedMules.add(m);

		switch (m.getType() ){
		case "mine":
			increaseOreYield(t.getOYield());
			break;
		case "PPlant":
			increaseEnergyYield(t.getEYield());
			break;
		case "farm":
			increaseFoodYield(t.getFYield());
			break;
		}

		t.setHasMule(true);
		this.setHasCurrentMule(false);
	}



	/**
	 * Helper method that works with putMule to make sure the player owns
	 * the tile they are trying to place their mule on 
	 * 
	 * @param t
	 * @return
	 */
	public boolean hasTile(Tile t){
		for(Tile t1: this.ownedTiles){
			if(t.equals(t1)) return true;
		}
		return false;
	}

	/**
	 * Method that control the pub. The pub allows players to win money
	 * during the production phase based on how much time is left.
	 * 
	 * @param timeLeft
	 * @param round
	 * @return
	 */
	public int goToPub(int timeLeft, int round, int seed) {
		timer.stopTimer();
		final int bonus1 = 50;
		final int bonus2 = 100; 
		final int bonus3 = 150;
		final int bonus4 = 200;
		final int maxBonus = 250;
		Random randomGenerator;

		int roundBonus = 0;
		int timeBonus = 0;
		int moneyBonus = 0;
		if(0 == seed) 
			randomGenerator = new Random();
		else 
			randomGenerator = new Random(seed);
		//Out of bounds
		if (round > 12 || round < 1 
				|| timeLeft < 1 || timeLeft > 50)
			return 0;

		//Round 12
		if(round > 11) {
			roundBonus = bonus4;
		}

		//Rounds 8-11
		else if(round > 7) {
			roundBonus = bonus3;
		}

		//Rounds 4-7
		else if(round > 3) {
			roundBonus = bonus2;
		}

		//Rounds 1-3
		else if(round > 0) {
			roundBonus = bonus1;
		}

		//Time Frame: 38-50 seconds left
		if(timeLeft > 37) {                  
			timeBonus = bonus4;
		}

		//Time Frame: 26-37 seconds left
		else if(timeLeft > 25) {
			timeBonus = bonus3;
		}

		//Time Frame: 13-25 seconds left
		else if(timeLeft > 12) {
			timeBonus = bonus2;
		}		
		//Time Frame: 1-12 seconds left
		else if(timeLeft > 0) {                     
			timeBonus = bonus1;
		}	

		int random = Math.abs((randomGenerator.nextInt() % (timeBonus+1)));
		moneyBonus = roundBonus + random;        

		if(moneyBonus > maxBonus)
			moneyBonus = maxBonus;

		money += moneyBonus;
		setScore(money);
		//System.out.println("moneyBonus from method = " + moneyBonus);
		return moneyBonus;
	}
}