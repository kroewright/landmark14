package landmark.Mules;


import java.awt.Graphics;

import landmark.Mule;

public class Mine extends Mule {


	private String type;
	private Graphics image;
	
	
	public Mine(){
		this.type = "mine";
		//this.image = "Mine.jpg";
	}
	
	@Override
	public String getType() {
		return type;
	}

	@Override
	public Graphics getImage() {
		return image;
	}

}
