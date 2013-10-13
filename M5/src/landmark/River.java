package landmark;

import java.awt.image.BufferedImage;

public class River extends Tile {
	private BufferedImage image;
	
	private boolean isOwned;
	private Player owner;
	private int index;
	private int cost;

	private int foodYield;
	private int energyYield;
	private int oreYield;
	/**
	 * Include for later phases of construction, along with getMuleOnTile() method
	private boolean hasMule;
	private Mule muleOnTile;
	*/
	
	
	public River(int ind){
		this.isOwned = false;
		this.index = ind;
		this.cost = 0;
		
		//this.hasMule = false;
		this.foodYield = 4;
		this.energyYield = 2;
		this.oreYield = 0;
	}

	
	
	private Player getOwner(){
		if (isOwned) return this.owner;
		else return null;
	}
	
	private int getLocation(){
		return this.index;
	}
	
	private BufferedImage getImage(){
		return this.image;
	}
	
	private void setOwner(Player p){
		if(!isOwned) isOwned = true;
		this.owner = p;
	}
	
	
	private int getFYield(){
		return this.foodYield;
	}
	
	private int getEYield(){
		return this.energyYield;
	}
	
	private int getOYield(){
		return this.oreYield;
	}
	
	
}
