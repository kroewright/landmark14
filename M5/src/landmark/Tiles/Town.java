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
	
	
	public Town(){
		setImage();
	}
	
	//Returns null, no one owns the town
	@Override
	protected Player getOwner() {
		return null;
	}

	//Returns the location of the town on the map
	@Override
	protected int getLocation(){
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
	protected int getFYield() {
		// TODO Auto-generated method stub
		return 0;
	}

	//Energy yield is 0 at the town
	@Override
	protected int getEYield() {
		// TODO Auto-generated method stub
		return 0;
	}

	//Ore yield is 0 at the town
	@Override
	protected int getOYield() {
		// TODO Auto-generated method stub
		return 0;
	}

	//Sets the image for the town on  the map	
	@Override
	protected void setImage() {
		file = "town.jpg";
		
	}

}
