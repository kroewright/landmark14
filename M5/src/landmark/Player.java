package landmark;

import java.util.ArrayList;
import java.util.HashMap;

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
	private boolean inStore;
	
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
	public Tile getTile() {
		return ownedTiles.get(0);
	}
	
	/**
	 * Deducts money when land is purchased.
	 * @param tile
	 */
	public void buyLandSelectionPhase(Tile tile) {
		if(money >= 300) {
			money -= 300;
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
	
	private int getScore(){
		return score;
	}
	
	private void setScore(int i){
		this.score = i;
	}
	
	public int getMoney(){
		return money;
	}
	
	private void setMoney(int i){
		this.money = i;
	}
}
