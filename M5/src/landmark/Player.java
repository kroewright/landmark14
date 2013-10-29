package landmark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 
 * @author k_wright0510
 *
 */
public class Player {
	private String name;
	private int money;
	private int score;
	private int color;
	private int difficulty;
	private int race;
	private ArrayList<Tile> ownedTiles;
	private ArrayList<Mule> plantedMules;
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
	 * Contains the player's name, color, difficulty of the current game,
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

	/*
	 * Getter for player color.
	 */
	public int getColor(){
		return color;
	}


	/**
	 * Method that adds tiles to new owners and sets the new owner.
	 * @param tile
	 */
	public void addTileOwned(Tile tile){
		ownedTiles.add(tile);
		tile.setOwner(this);
	}

	/**
	 * Getter for owner tiles.
	 * @return tiles
	 */
	public ArrayList<Tile> getTilesOwned() {
		return ownedTiles;
	}

	/**
	 * Deducts money when land is purchased.
	 * @param tile
	 */
	public void buyLandSelectionPhase(Tile tile) {
		if(money >= 300) {
			money -= 300;
			setScore(money);
		}
		addTileOwned(tile);
	}




	/*
	 * Getters and setters for each player parameter.
	 * Also getters and setters for scores and money.
	 * 
	 */
	public String getName(){
		return name;
	}
	
	public int getFood() {
		return food;
	}
	
	public void setFood(int newtotal){
		food = newtotal;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public void setEnergy(int newtotal){
		energy = newtotal;
	}
	
	public int getOre() {
		return ore;
	}

	public void setOre(int newtotal){
		ore =  newtotal;
	}
	public int getScore(){
		return score;
	}

	private void setScore(int i){
		this.score = i;
	}

	public int getMoney(){
		return money;
	}
	
	public int getDifficulty(){
		return difficulty;
	}


	public void setMoney(int i){
		this.money = i;
	}

	public void setTimer(Clock timer){
		this.timer = timer;
	}

	public Clock getTimer(){
		return timer;
	}
	public boolean hasMule(){
		return hasMule;
	}
	
	public ArrayList<Mule> getMules(){
		return plantedMules;
	}
	
	public int getOreYield(){
		return this.oreYield;
	}
	public int getEnergyYield(){
		return this.energyYield;
	}
	public int getFoodYield(){
		return this.foodYield;
	}
	
	public void increaseOreYield( int amount ){
		this.oreYield += amount;
	}
	public void increaseEnergyYield( int amount ){
		this.energyYield += amount;
	}
	public void increaseFoodYield( int amount ){
		this.foodYield += amount;
	}
	
	
	
	
	
	  /*
	   * Incomplete method, needs to have exception functionality altered (Irina)
	   * and then addition of graphics changing when successful.
	   */
	  public boolean putMule(Mule m, Tile t){
	  		if(!hasTile(t) || !hasMule() || t.hasMule()){
	  			// throw new IllegalPlantException( e );
	  			return false;
	  		}
	  		plantedMules.add(m);
	  
	  		switch (m.getType() ){
	  			case "ore":
	  				increaseOreYield(t.getOYield());
	  				break;
	  			case "energy":
	  				increaseEnergyYield(t.getEYield());
	  				break;
	  			case "food":
	  				increaseFoodYield(t.getFYield());
	  				break;
	  		}
	  
	  		// Now need some functionality for showing the Mule Image
	  		//overworld.getTileAt(t.getLocation().addLabel( new JLabel(m.getImage) ) );
	  		//overworld.refresh();
	  		
	  		
	  		t.setHasMule(true);
	  		this.hasMule = false;
	  		
	 		return true;
	  
	  }
	
	
	/*
	 * Helper method for putMule
	 */
	public boolean hasTile(Tile t){
		for(Tile t1: this.ownedTiles){
			if(t.equals(t1)) return true;
		}
		return false;
	}
	
	public int goToPub(int timeLeft, int round) {

		timer.stopTimer();
		final int bonus1 = 50;
		final int bonus2 = 100; 
		final int bonus3 = 150;
		final int bonus4 = 200;
		final int maxBonus = 250;

		int roundBonus = 0;
		int timeBonus = 0;
		int moneyBonus = 0;

		Random randomGenerator = new Random();

		//Round 12
		if(round > 11) {
			roundBonus = bonus4;
		}

		//Rounds 8-11
		else if(round > 7) {
			roundBonus = bonus3;
		}

		//Rounds 4-17
		else if(round > 3) {
			roundBonus = bonus2;
		}

		//Rounds 1-3
		else if(round > 0) {
			roundBonus = bonus1;
		}

		//Time Frame: 38-50 seconds left
		if(timeLeft > 37) {                  // && timeLeft < 51) ???
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
		else if(timeLeft > 0) {                     // include 0?
			timeBonus = bonus1;
		}	

		int random = randomGenerator.nextInt(timeBonus+1);
		moneyBonus = roundBonus + random;        //randomGenerator.nextInt(timeBonus+1);
		
		if(moneyBonus > maxBonus)
			moneyBonus = maxBonus;
		
		money += moneyBonus;
		setScore(money);
		
		return moneyBonus;
	}
	
	
	
	
}
