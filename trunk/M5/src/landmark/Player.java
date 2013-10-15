package landmark;
import java.util.HashMap;

public class Player {
	private String name;
	private int money;
	private int score;
	private int color;
	private int difficulty;
	private int race;
	
	private HashMap<Integer, Tile> tilesOwned;
		
	private boolean inStore;
	
	
	public Player(String name, int color, int difficulty, int race) {
		this.name = name;
		this.color = color;
		this.difficulty = difficulty;
		this.tilesOwned = new HashMap<Integer,Tile>();
		
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
	 * Not sure why this has to be public, but if it 
	 * works it works I guess -Mason
	 */
	public int getColor(){
		return color;
	}
	
	
	
	private void addTileOwned(Tile tile){
		tilesOwned.put(tile.getLocation(), tile);
		tile.setOwner(this);
	}
	
	
	
	
	
	
	
	
	/*
	 * Here Be the getarrs and setarrs.
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
