package landmark;

import java.awt.image.BufferedImage;

/**
 * 
 * @author landmark - Team 14
 *
 */

//Abstract class that represents the tiles on the map. 
public abstract class Tile {
	
	private String file;
	
	private boolean isOwned;
	private Player owner;
	private int location;
	private int cost;
	
	private int foodYield;
	private int energyYield;
	private int oreYield;
	
	/**
	 * Include for later phases of construction, along with getMuleOnTile() method
	 * private boolean hasMule;
	 * private Mule muleOnTile;
	 */
	
	protected abstract Player getOwner();
	protected abstract int getLocation();
	protected abstract String getImage();
	protected abstract void setOwner(Player p);
	
	protected abstract int getFYield();
	protected abstract int getEYield();
	protected abstract int getOYield();

	protected abstract void setImage();
}
