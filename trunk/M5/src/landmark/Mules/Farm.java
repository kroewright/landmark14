package landmark.Mules;


import java.awt.Graphics;

import landmark.Mule;

public class Farm extends Mule {


	private String type;
	private Graphics image;
	
	
	public Farm(){
		this.type = "farm";
		//this.image = "Farm.jpg";
		
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
