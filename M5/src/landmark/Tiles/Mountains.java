package landmark.Tiles;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import landmark.Player;
import landmark.Tile;

public class Mountains extends Tile{
private BufferedImage image;
	
	private boolean isOwned;
	private Player owner;
	private int index;
	private int cost;

	private int foodYield;
	private int energyYield;
	private int oreYield;
	private int type;
	/**
	 * Include for later phases of construction, along with getMuleOnTile() method
	private boolean hasMule;
	private Mule muleOnTile;
	*/
	
	public Mountains(int ind, int type){
		this.isOwned = false;
		this.index = ind;
		this.cost = 0;
		
		//this.hasMule = false;
		this.foodYield = 1;
		this.energyYield = 1;
		//NOTE: mountain types will be designated as (1,2,3), and
		//their corresponding ore values will be (2,3,4) yield per turn.
		this.oreYield = type+1;
		
		setImage();
	}
	
	private int getType(){
		return this.type;
	}
	
	protected Player getOwner(){
		if (isOwned) return this.owner;
		else return null;
	}
	
	protected int getLocation(){
		return this.index;
	}
	
	protected BufferedImage getImage(){
		return this.image;
	}
	
	protected void setOwner(Player p){
		if(!isOwned) isOwned = true;
		this.owner = p;
		this.setImage();
	}
	
	
	protected int getFYield(){
		return this.foodYield;
	}
	
	protected int getEYield(){
		return this.energyYield;
	}
	
	protected int getOYield(){
		return this.oreYield;
	}
	
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
				case 1:
					imgLink = "mountains"+type+"Navy.jpg";
				case 2:
					imgLink = "mountains"+type+"White.jpg";
				case 3:
					imgLink = "mountains"+type+"Black.jpg";
			}
		}
		
		
		BufferedImage myPicture = null;
		//Try-catch for image for selection screen
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream(   imgLink   );
			myPicture = ImageIO.read(input);
		} catch (IOException e) {
			System.out.println("Image Not Found!");
		}
		
		
	}

}