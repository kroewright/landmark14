package landmark.Tiles;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import landmark.Player;
import landmark.Tile;

/**
 * 
 * @author landmark - Team 14
 *
 */
public class Mountains extends Tile{
	private String file;
	
	private boolean isOwned;
	private Player owner;
	private int cost;
	private int location;
	private int foodYield;
	private int energyYield;
	private int oreYield;
	
	//Type of tile
	private int tileType;
	
	//Type of mountain
	private int type;
	
	/**
	 * Include for later phases of construction, along with getMuleOnTile() method
     * private boolean hasMule;
	 * private Mule muleOnTile;
	 */
	
	//Constructor that sets the initial values of 
	//instance variables in Mountains class
	public Mountains(int location, int type){
		this.isOwned = false;
		this.location = location;
		this.cost = 0;
		this.type = type;
		
		//this.hasMule = false;
		this.foodYield = 1;
		this.energyYield = 1;
		//NOTE: mountain types will be designated as (1,2,3), and
		//their corresponding ore values will be (2,3,4) yield per turn.
		this.oreYield = type+1;
		
		setImage();
	}
	
	/**
	 * Getter that returns the type of mountain
	 * @return type - type of mountain
	 */
	public int getType(){
		return this.type;
	}
	
	/**
	 * Getter that returns the owner of a tile
	 * @return owner - who owns the tile
	 */
	public Player getOwner(){
		if (isOwned) return this.owner;
		else return null;
	}
	
	/**
	 * Getter that returns the location of a tile
	 * @return location - location of the tile
	 */
	public int getLocation(){
		return this.location;
	}
	
	/**
	 * Getter that returns the image for a tile
	 * @return file - image file
	 */
	public String getImage(){
		return this.file;
	}
	
	/**
	 * Method that sets owners if a tile isn't already owned.
	 */
	protected void setOwner(Player p){
		if(!isOwned) {
			isOwned = true;
			this.owner = p;
			this.setImage();
		}
	}
	
	/**
	 * Returns the amount of food available.
	 * @return foodYield - food left
	 */
	public int getFYield(){
		return this.foodYield;
	}
	
	/**
	 * Returns the amount of energy available.
	 * @return EYield - energy left
	 */
	public int getEYield(){
		return this.energyYield;
	}
	
	/**
	 * Returns the amount of ore available.
	 * @return OYield - ore left
	 */
	public int getOYield(){
		return this.oreYield;
	}
	
	/**
	 * Method that sets mountain type based on player color.
	 */
	protected void setImage(){
		/*
		 * For this specific version of set image, the mountain type
		 * will be designated by the int type, and that will differentiate
		 * which picture to use.
		 */
		int type = this.getType();
		String imgLink = "mountains"+type+"Unowned.jpg";
		if(isOwned){
			int color = getOwner().getColor();
			switch (color){
				case 0:
					imgLink = "mountains"+type+"Gold.jpg";
					break;
				case 1:
					imgLink = "mountains"+type+"Navy.jpg";
					break;
				case 2:
					imgLink = "mountains"+type+"White.jpg";
					break;
				case 3:
					imgLink = "mountains"+type+"Black.jpg";
					break;
			}
		}
		
		
		this.file = imgLink;
		
	}

	@Override
	public boolean equals(Tile t) {
		if(this.getLocation() == t.getLocation()) return true;
		return false;
	}

	@Override
	public int getTileType() {
		return tileType;
	}

}
