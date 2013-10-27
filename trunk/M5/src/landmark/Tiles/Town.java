package landmark.Tiles;

import java.awt.image.BufferedImage;

import landmark.Player;
import landmark.Tile;
/**
 * 
 * @author landmark - Team 14
 *
 */

public class Town extends Tile{
	private String file;
	private int tileType;
	
	
	public Town(){
		setImage();
	}
	
	//Returns null, no one owns the town
	@Override
	public Player getOwner() {
		return null;
	}

	//Returns the location of the town on the map
	@Override
	public int getLocation(){
		return 14;
	}

	//Returns the image of the town
	@Override
	public String getImage() {
		return file;
	}

	@Override
	protected void setOwner(Player p) {
		// TODO Auto-generated method stub
		
	}

	//Food yield is 0 at the town
	@Override
	public int getFYield() {
		// TODO Auto-generated method stub
		return 0;
	}

	//Energy yield is 0 at the town
	@Override
	public int getEYield() {
		// TODO Auto-generated method stub
		return 0;
	}

	//Ore yield is 0 at the town
	@Override
	public int getOYield() {
		// TODO Auto-generated method stub
		return 0;
	}

	//Sets the image for the town on  the map	
	@Override
	protected void setImage() {
		file = "town.jpg";
		
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
		//So that MULE can never be planted
		return true;
	}
}
