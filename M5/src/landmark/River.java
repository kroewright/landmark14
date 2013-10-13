package landmark;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

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
		
		this.image = river.jpg;
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
	
	private void setImage(){
		String imgLink = "riverUnowned.jpg";
		if(isOwned){
			int color = getOwner().getColor();
			switch (color){
				case 0:
					imgLink = "riverGold.jpg";
				case 1:
					imgLink = "riverNavy.jpg";
				case 2:
					imgLink = "riverWhite.jpg";
				case 3:
					imgLink = "riverBlack.jpg";
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
