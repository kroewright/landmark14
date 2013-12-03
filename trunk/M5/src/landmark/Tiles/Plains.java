package landmark.Tiles;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

import landmark.Player;
import landmark.Tile;

/**
 * 
 * @author landmark - Team 14
 *
 */

public class Plains extends Tile implements Serializable{
	private String file;
	
	private boolean isOwned;
	private Player owner;
	private int location;
	private int cost;

	private int foodYield;
	private int energyYield;
	private int oreYield;

	private int tileType;
	
	private String muleType;

	
	/**
	 * Include for later phases of construction, along with getMuleOnTile() method
	 * private boolean hasMule;
	 * private Mule muleOnTile;
	 */
	
	//Constructor that sets the initial values of 
	//instance variables in Plains class
	public Plains(int location){
		this.isOwned = false;
		this.location = location;
		this.cost = 0;
		this.foodYield = 2;
		this.energyYield = 3;
		this.oreYield = 1;
		this.tileType = 1;
		setImage();
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
		else{
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
	 * Method that sets plain based on player color.
	 */
	protected void setImage(){
		String imgLink = "plainsUnowned.jpg";
		if(isOwned){
			int color = getOwner().getColor();
			switch (color){
				case 0:
					imgLink = "plainsGold.jpg";
					break;
				case 1:
					imgLink = "plainsNavy.jpg";
					break;
				case 2:
					imgLink = "plainsWhite.jpg";
					break;
				case 3:
					imgLink = "plainsBlack.jpg";
					break;
			}
		}
		
		this.file = imgLink;
	}

	@Override
	public int getTileType() {
		return tileType;
	}
	

	@Override
	public boolean equals(Tile t) {
		if(this.getLocation() == t.getLocation()) return true;
		return false;
	}
	

	private boolean hasMule;
	public boolean hasMule(){
		return hasMule;
	}
	public void setHasMule(boolean b, String type){
		muleType = type;
		hasMule = b;
	}
	public String getMuleType() {
		return muleType;
	}
}
