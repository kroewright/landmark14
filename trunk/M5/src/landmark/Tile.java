package landmark;

import java.awt.image.BufferedImage;

/**
 * 
 * @author landmark - Team 14
 * 
 * Abstract class that represents the tiles on the map.
 *
 */

 
public abstract class Tile {
	
	private String file;
	
	private boolean isOwned;
	private Player owner;
	private int location;
	private int cost;
	
	private int foodYield;
	private int energyYield;
	private int oreYield;
	
	
	
	 //Include for later phases of construction, along with getMuleOnTile() method
	 //private boolean hasMule;
	 //private Mule muleOnTile;
	 
	
	public abstract Player getOwner();
	public abstract int getLocation();
	protected abstract String getImage();
	protected abstract void setOwner(Player p);
	
	public abstract int getFYield();
	public abstract int getEYield();
	public abstract int getOYield();

	protected abstract void setImage();
	public abstract boolean equals(Tile t);
	//0 for mountains 1 for plains 2 for river 3 for town
	public abstract int getTileType();
	
	
	private boolean hasMule;
	public abstract boolean hasMule();
	public abstract void setHasMule(boolean b);
}
