package landmark;

import java.awt.image.BufferedImage;

public abstract class Tile {
	
	private BufferedImage image;
	
	private boolean isOwned;
	private Player owner;
	private int index;
	private int cost;
	
	/**
	 * Include for later phases of construction, along with getMuleOnTile() method
	private boolean hasMule;
	private Mule muleOnTile;
	*/
	
	public Tile(int ind){
		this.isOwned = false;
		this.index = ind;
		this.cost = 0;
		
		//this.hasMule = false;
	}
	
	private Player getOwner(){};
	private int getLocation(){};
	private BufferedImage getImage(){};
	
	
	

}
