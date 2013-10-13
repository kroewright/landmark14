package landmark;
import java.util.HashMap;

public class Player {
	private String name;
	private int money;
	private int score;
	private int color;
	private int difficulty;
	
	private HashMap tilesOwned;
	
	private boolean inStore;
	
	
	public Player(String name, int color, int difficulty){
		this.name = name;
		this.color = color;
		this.difficulty = difficulty;
		this.tilesOwned = new HashMap<Integer,Tile>();
		
		//TODO
		/**
		 * IMPLEMENT AT A LATER TIME
		 * 		Change starting money based on difficulty
		 */
	}
	public int getColor(){
		return color;
	}
	
	private void addTileOwned(Tile tile){
		tilesOwned.put(tile., value)
	}
	
	
}
