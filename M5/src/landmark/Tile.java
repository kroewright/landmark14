package landmark;

import java.awt.image.BufferedImage;

public abstract class Tile {
	
	private BufferedImage image;
	
	private boolean isOwned;
	private Player owner;
	private int i;
	private int j;
	private int cost;
	
	private int foodYield;
	private int energyYield;
	private int oreYield;
	
	/**
	 * Include for later phases of construction, along with getMuleOnTile() method
	private boolean hasMule;
	private Mule muleOnTile;
	*/
	
	
	
	protected abstract Player getOwner();
	protected abstract int getR();
	protected abstract int getC();
	protected abstract BufferedImage getImage();
	protected abstract void setOwner(Player p);
	
	protected abstract int getFYield();
	protected abstract int getEYield();
	protected abstract int getOYield();

	protected abstract void setImage();
}
