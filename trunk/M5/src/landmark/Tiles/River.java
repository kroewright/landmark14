package landmark.Tiles;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import landmark.Player;
import landmark.Tile;

public class River extends Tile {
	private String image;
	
	private boolean isOwned;
	private Player owner;
	private int location;

	private int cost;

	private int foodYield;
	private int energyYield;
	private int oreYield;
	/**
	 * Include for later phases of construction, along with getMuleOnTile() method
	private boolean hasMule;
	private Mule muleOnTile;
	*/
	
	
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

	
	
	protected Player getOwner(){
		if (isOwned) return this.owner;
		else return null;
	}
	
	protected int getLocation(){
		return this.location;
	}
	
	public String getImage(){
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
		
		
		this.image = imgLink;

	}

}