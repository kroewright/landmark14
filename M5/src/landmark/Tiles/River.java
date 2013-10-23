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

public class River extends Tile {
	private String file;
	
	private boolean isOwned;
	private Player owner;
	private int location;

	private int cost;

	private int foodYield;
	private int energyYield;
	private int oreYield;

	private int tileType;
	
	/**
	 * Include for later phases of construction, along with getMuleOnTile() method
	 * private boolean hasMule;
	 * private Mule muleOnTile;
	 */
	
	//Constructor that sets the initial values of 
	//instance variables in River class
	public River(int location){
		this.isOwned = false;
		this.location = location;
		this.cost = 0;
		
		//this.hasMule = false;
		this.foodYield = 4;
		this.energyYield = 2;
		this.oreYield = 0;
		
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
	 * Method that sets river based on player color.
	 */
	protected void setImage(){
		String imgLink = "riverUnowned.jpg";
		if(isOwned){
			int color = getOwner().getColor();
			switch (color){
				case 0:
					imgLink = "riverGold.jpg";
					break;
				case 1:
					imgLink = "riverNavy.jpg";
					break;
				case 2:
					imgLink = "riverWhite.jpg";
					break;
				case 3:
					imgLink = "riverBlack.jpg";
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

}
